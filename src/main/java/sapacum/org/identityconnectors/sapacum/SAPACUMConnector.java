/**
 * 
 */
package org.identityconnectors.sapacum;

import static org.identityconnectors.sapacum.SAPACUMConstants.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.identityconnectors.common.logging.Log;
import org.identityconnectors.framework.common.exceptions.ConnectorException;
import org.identityconnectors.framework.common.objects.Attribute;
import org.identityconnectors.framework.common.objects.AttributeBuilder;
import org.identityconnectors.framework.common.objects.AttributeUtil;
import org.identityconnectors.framework.common.objects.ConnectorObject;
import org.identityconnectors.framework.common.objects.ConnectorObjectBuilder;
import org.identityconnectors.framework.common.objects.EmbeddedObject;
import org.identityconnectors.framework.common.objects.EmbeddedObjectBuilder;
import org.identityconnectors.framework.common.objects.Name;
import org.identityconnectors.framework.common.objects.ObjectClass;
import org.identityconnectors.framework.common.objects.OperationOptions;
import org.identityconnectors.framework.common.objects.OperationOptionsBuilder;
import org.identityconnectors.framework.common.objects.OperationalAttributes;
import org.identityconnectors.framework.common.objects.ResultsHandler;
import org.identityconnectors.framework.common.objects.Schema;
import org.identityconnectors.framework.common.objects.SyncDelta;
import org.identityconnectors.framework.common.objects.SyncDeltaBuilder;
import org.identityconnectors.framework.common.objects.SyncResultsHandler;
import org.identityconnectors.framework.common.objects.SyncToken;
import org.identityconnectors.framework.common.objects.Uid;
import org.identityconnectors.framework.common.objects.filter.FilterTranslator;
import org.identityconnectors.framework.spi.Configuration;
import org.identityconnectors.framework.spi.Connector;
import org.identityconnectors.framework.spi.ConnectorClass;
import org.identityconnectors.framework.spi.operations.CreateOp;
import org.identityconnectors.framework.spi.operations.SchemaOp;
import org.identityconnectors.framework.spi.operations.SearchOp;
import org.identityconnectors.framework.spi.operations.SyncOp;
import org.identityconnectors.framework.spi.operations.TestOp;
import org.identityconnectors.framework.spi.operations.UpdateAttributeValuesOp;
import org.identityconnectors.framework.spi.operations.UpdateOp;
import org.identityconnectors.sap.SAPConnector;
import org.identityconnectors.sap.SAPCreateUpdateBase;

/******************************* History of changes *********************************
 * Version		Date				Author					Description		
 ************************************************************************************
 * 1			Apr/2012				Ranjith		class created and methods added
 * 2			19/Jun/2012				Ranjith		doUpdate() method updated for Bug 14214721 
 * 3			27/Jun/2012				Ranjith		made changes to close code review comments 
 * 4			28/Jun/2012				Ranjith 	Updated getOtherLookups() method for Bug 14254657 
 * 5			18/Jul/2012				Ranjith		Updated for grc5.3 remove role issue 
 * 6			1/jul/2015				Sandeep 	Code enhanced for SAPACUM 11.1.1.7.0 patchset
 ************************************************************************************/


/**
 * @author ranjith.kumar
 *
 */
@ConnectorClass(displayNameKey = "SAPACUM", configurationClass = SAPACUMConfiguration.class, messageCatalogPaths={"org/identityconnectors/sapacum/Messages", "org/identityconnectors/sap/Messages"})
public class SAPACUMConnector  implements Connector, TestOp, SyncOp,
SearchOp<String>, UpdateOp, CreateOp, SchemaOp, UpdateAttributeValuesOp  {

	private static final Log log = Log.getLog(SAPACUMConnector.class);

	private SAPACUMConfiguration configuration = null;
	private SAPACUMSchema acSchema = null;
	private Schema schema = null;
	private String requestTypeCode = null;
	private String requestTypeName = null;
	private String provAction = null;
	private String provItemAction = null;
	private String roleAction = null;
	private SAPConnector umConnector = null;
	Properties ac2umMapProps = null;
	
	/**
	 * It clears object references of the connector 
	 */
	public void dispose() {
		configuration = null;
		schema = null;
		umConnector=null;
		acSchema=null;
		ac2umMapProps=null;
	}

	/**
	 * Getter method for Configuration object of the connector 
	 * @return
	 */
	public Configuration getConfiguration() {
		return configuration;
	}


	/**
	 * Initializing the Configuration object of the connector
	 * @param config
	 */
	public void init(Configuration config) {
		umConnector = new SAPConnector();
		this.configuration = (SAPACUMConfiguration) config;
		umConnector.init(configuration);
		acSchema = new SAPACUMSchema(configuration, umConnector);
		schema = acSchema.getSchema();
		ac2umMapProps = acSchema.getUmACMapProperties();
	}

	/**
	 * Providing the FilterTranslator for the connector. 
	 * It will be used to construct query parameter of executeQuery()
	 * 
	 * @param objectClass
	 * @param options
	 * @return
	 */
	public FilterTranslator<String> createFilterTranslator(ObjectClass objectClass,OperationOptions options) {
		if(objectClass.is(STATUS)){
			return new SAPACUMFilterTranslator(true);
		}else if (objectClass.is(SYSTEM_RECON) || objectClass.is(BUSPROC_RECON)||objectClass.is(FUNCTIONAREA_RECON)||objectClass.is(ITEMPROVACTIONTYPE)||objectClass.is(PRIORITYTYPE_RECON)||objectClass.is(ATTR_REQTYPE)){
			return new SAPACUMFilterTranslator(false);
		}else{
			return  umConnector.createFilterTranslator(objectClass,options);
		}
	}

	/**
	 * Method executes the lookup operations with AC as part of SearchOp
	 * (1) If Object class is ACCOUNT it will invoke web service to retrieve request status 
	 * and update it in OIM
	 * (2) If Object class is ROLE, invokes web service to retrieve list of available roles in AC10
	 * (3) If Object class is SYSTEM, invokes web service to retrieve Application name from AC
	 * (4) Else it invokes web service to retrieve respective 
	 * lookup values based on ObjectClass value
	 * 
	 * @param objectClass
	 * @param query
	 * @param handler
	 * @param options
	 */

	public void executeQuery(ObjectClass objectClass, String query,
			final ResultsHandler handler, OperationOptions options) {
		log.info(configuration.getMessage("SAPACUM_INFO_EXECUTEQUERY",query, objectClass));
		log.error("Perf: Search Execute query Entered");
		Map<String, Object> getOptions = options.getOptions();
		try{
			if(objectClass.is(ROLE_RECON)){
				//call Role Lookup WS
				getRoles(objectClass, handler);
			} else if(objectClass.is(SYSTEM_RECON)){
				//call Application Lookup WS
				getSystem(objectClass, handler);
			}else if(objectClass.is(BUSPROC_RECON)||objectClass.is(FUNCTIONAREA_RECON)||objectClass.is(ITEMPROVACTIONTYPE)||objectClass.is(PRIORITYTYPE_RECON)||objectClass.is(ATTR_REQTYPE)){
				//call Lookup WS
				getOtherLookups(objectClass, handler);
			} else if(objectClass.is(STATUS)){
				//call Status Request WS - done
				getRequestStatus(query.toString(), handler, options);
			} else {
				String [] actualAttrsToGet = options.getAttributesToGet();
				final Set<String> actualAttrsToGetSet = new HashSet<String>(Arrays.asList(options.getAttributesToGet()));
				List<String> umAttrsToGet = new ArrayList<String>();
				OperationOptionsBuilder builder = new OperationOptionsBuilder();
				Set<String> acSet = configuration.getIsGRC53()?acSchema.getAc53attrSet():acSchema.getAc10attrSet();
				//Start : Bug 25748407 - AOB: SAP AC UM RECON IS NOT WORKING
				for(String attr: actualAttrsToGet){
					if(acSet.contains(attr)){
						String umAttr = addAttributes(attr);
						if(umAttr != null)
						umAttrsToGet.add(umAttr);
					}else{
						umAttrsToGet.add(attr);
					}
				}
				//End : Bug 25748407 - AOB: SAP AC UM RECON IS NOT WORKING
				for (Map.Entry<String, Object> entry : getOptions.entrySet())
				{
					if (entry.getKey().equals(ATTRS_TO_GET)){
						builder.setAttributesToGet(umAttrsToGet);
					}else{
						builder.setOption(entry.getKey(), entry.getValue()); 
					}
				}
				OperationOptions newOptionswithoutACattrs=builder.build();

				if (query !=null  && query.contains(PATTERN_REQ_NO)){
					final String[] uidReqIdReqType = splitUid(new Uid(query.split(PATTERN_EQUALTO)[1]));
					final String qUid = query;

					ResultsHandler sapumResultsHandler =new ResultsHandler() {

						public boolean handle(ConnectorObject umCo) {
							String reqId = uidReqIdReqType[1];
							String status=null;
							try {
								status = getRequestStatusFromId(reqId);
							} catch (Exception e) {
								throw new ConnectorException(configuration.getMessage("SAPACUM_CE_REQSTATUS_FAIL"), e);
							}

							ConnectorObjectBuilder objectBuilder = addValidAttributes(actualAttrsToGetSet, umCo);

							objectBuilder.addAttribute(AttributeBuilder.build(REQUESTID, reqId));
							objectBuilder.addAttribute(AttributeBuilder.build(ATTR_AC_REQ_STATUS, status));
							objectBuilder.addAttribute(AttributeBuilder.build(ATTR_REQTYPE, uidReqIdReqType[2]));

							objectBuilder.setUid(qUid.split(PATTERN_EQUALTO)[1]);
							objectBuilder.setName(umCo.getName());
							objectBuilder.setObjectClass(umCo.getObjectClass());
							return handler.handle(objectBuilder.build());					
						}
					};

					//  For Writeback called during Create, Update or Delete flows, Need to check if
				    //	user is present before making a call to SAP UM's execute query
					SAPCreateUpdateBase umCreateUpdateBase = new SAPCreateUpdateBase(umConnector.getConnection(), configuration, null, null,null);
					if(umCreateUpdateBase.checkIfUserExists(uidReqIdReqType[0])){
					        umConnector.executeQuery(objectClass, uidReqIdReqType[0],sapumResultsHandler, newOptionswithoutACattrs);
					}else{
					        ConnectorObjectBuilder acConnObj = new ConnectorObjectBuilder();
					        acConnObj.setUid(uidReqIdReqType[0]);
					        acConnObj.setName(uidReqIdReqType[0]); 
					        acConnObj.setObjectClass(ObjectClass.ACCOUNT);
					        sapumResultsHandler.handle(acConnObj.build());
					}
				}else{
					ResultsHandler umResultsHandler =new ResultsHandler() {
						public boolean handle(ConnectorObject umCo) {
							if(!ObjectClass.ACCOUNT.equals(umCo.getObjectClass()))
								return handler.handle(umCo);
							ConnectorObjectBuilder objectBuilder = addValidAttributes(actualAttrsToGetSet, umCo);
							objectBuilder.setUid(umCo.getUid());
							objectBuilder.setName(umCo.getName());
							objectBuilder.setObjectClass(umCo.getObjectClass());
							return handler.handle(objectBuilder.build());					
						}
					};								
					umConnector.executeQuery(objectClass, query, umResultsHandler, newOptionswithoutACattrs);
				}
			}
		} catch (Exception e) {
			log.error(e, configuration.getMessage("SAPACUM_ERR_EXECUTE_FAILED"));
			throw new ConnectorException(e);
		}
		log.error("Perf: Search Execute query Exiting");
	}


	/**
	 * Method of UpdateOp. Invoked in modify flow of connector
	 * @param objectClass
	 * @param uid
	 * @param attrs
	 * @param options
	 * @return
	 */
	public Uid update(ObjectClass objectClass, Uid uid, Set<Attribute> attrs,
			OperationOptions options) {
		log.info(configuration.getMessage("SAPACUM_INFO_UID_OBJCLASS" ,uid.getUidValue(), objectClass));
		log.info(configuration.getMessage("SAPACUM_INFO_ATTRIBUTES_OP", attrs, options.getOptions()));
		log.error("Perf: Update Entered for user {0}", uid.getUidValue()); 

		// modified as part of AC redesign
		Uid rUid = null;
		Set<Attribute> acUpdateSet = null;
		Set<Attribute> umUpdateSet = null;
		Set<String>  ac10or53AttrSet = null;
		String reqTypeOption = null;

		if(configuration.getIsGRC53()){ 			
			ac10or53AttrSet = acSchema.getAc53attrSet();
		}else {
			ac10or53AttrSet = acSchema.getAc10attrSet();
		}
		for(Attribute attribute : attrs){
			if(attribute.getName().equals(OperationalAttributes.CURRENT_ATTRIBUTES) || attribute.getName().equals(OperationalAttributes.ENABLE_NAME)){
				if(acUpdateSet == null)
					acUpdateSet = new HashSet<Attribute>();
					acUpdateSet.add(attribute);
				continue;
			}

			if(ac10or53AttrSet.contains(attribute.getName())){
				if(acUpdateSet == null)
					acUpdateSet = new HashSet<Attribute>();
					acUpdateSet.add(attribute);
			}else {
				if(umUpdateSet == null)
					umUpdateSet = new HashSet<Attribute>();
					umUpdateSet.add(attribute);
			}
		}
		if(options!=null){
			reqTypeOption = (String)options.getOptions().get(REQTYPE);
		}
		String str[] = splitUid(uid);
		String requestId = str[1];
		String requestType = str[2];
		Uid userId = new Uid(str[0]);
		
		if(DELETE_REQ_TYPE.equalsIgnoreCase(reqTypeOption)){
			return doUpdate(acUpdateSet, null, options, requestId);
		}
		if ((AttributeUtil.getCurrentAttributes(acUpdateSet)!=null && acUpdateSet.size() > 1)) {
			rUid = doUpdate(acUpdateSet, null, options,requestId);		
		}
		if(umUpdateSet!=null && !umUpdateSet.isEmpty()){
			Uid umUid = umConnector.update(objectClass, userId, umUpdateSet, options);
			if(requestId == null || requestType == null)
				return umUid;
			if(rUid == null)
				rUid = new Uid(umUid.getUidValue()+PATTERN_REQ_NO+requestId+PATTERN_REQ_TYPE+requestType);
		}
		log.error("Perf: Update Exiting for user {0}", uid.getUidValue());
		return rUid;
	}

	/**
	 * Method of CreateOp. Invoked during AC user provisioning
	 * Also mapped to process Delete/Enable/Disable user flows of connector
	 * 
	 * @param objectClass
	 * @param attrs
	 * @param options
	 * 
	 */
	public Uid create(ObjectClass objectClass, Set<Attribute> attrs,
			OperationOptions options) {
		//Start : Bug 25748407 - AOB: SAP AC UM RECON IS NOT WORKING
		String userId =AttributeUtil.getAsStringValue(AttributeUtil.getNameFromAttributes(attrs));
		//End : Bug 25748407 - AOB: SAP AC UM RECON IS NOT WORKING
		//String userId =getUserIdValue(attrs);
		log.info(configuration.getMessage("SAPACUM_INFO_UID_OBJCLASS" ,userId, objectClass));
		log.info(configuration.getMessage("SAPACUM_INFO_ATTRIBUTES_OP", attrs, options.getOptions()));
		log.error("Perf: Create Entered for user {0}", userId);
		Uid uid = null;
		//Note: attrs doesn't support to add new attributes so using new Map object		
		Map<String, Attribute> createAttrMap = new HashMap<String, Attribute>(AttributeUtil.toMap(attrs));
		splitReqType(configuration.getCreateUserReqType());				
		Attribute reqTypeAttr = AttributeBuilder.build(configuration.getRequestTypeAttrName(), requestTypeCode);
		createAttrMap.put(configuration.getRequestTypeAttrName(), reqTypeAttr);
		if(provAction != null){
			Attribute provActionAttr = AttributeBuilder.build(configuration.getProvActionAttrName(), provAction);
			createAttrMap.put(configuration.getProvActionAttrName(), provActionAttr);
		}
		if(provItemAction != null){
			Attribute provItemActionAttr = AttributeBuilder.build(configuration.getProvItemActionAttrName(),provItemAction);
			createAttrMap.put(configuration.getProvItemActionAttrName(), provItemActionAttr);
		}
		
		//Start : Bug 25748407 - AOB: SAP AC UM RECON IS NOT WORKING
		Attribute userIdUserInfo = AttributeBuilder.build(ATTR_UI_USER_ID, userId);
		createAttrMap.put(ATTR_UI_USER_ID, userIdUserInfo);
		//End : Bug 25748407 - AOB: SAP AC UM RECON IS NOT WORKING
				
		uid = initRequest(createAttrMap);
		log.error("Perf: Create Exiting for user {0}", uid.getUidValue());
		return uid;
	}

	/**
	 * Initializing connector schema
	 * @return
	 */	
	public Schema schema() {	
		if(schema==null){
			acSchema = new SAPACUMSchema(configuration,umConnector);
			schema = acSchema.getSchema();
		}
		return schema;
	}


	/**
	 * Method initializing user provisioning request to Access Control web service
	 * @param attrMap
	 * @return
	 */
	private Uid initRequest(Map<String, Attribute> attrMap){
		Map<String, Object> outputMap = null; 
		Uid uidReqId  = null;
		Map<String, Object> inputDataMap = populateInputData(attrMap);
		try{
			Class<? extends Object> submitReqClientClazz = Class.forName(configuration.getUserAccessWS());
			Object serviceInstance = submitReqClientClazz.newInstance();
			Method subReqMethod = submitReqClientClazz.getMethod(SERVICE_METHODNAME, Map.class);
			outputMap = (Map<String, Object>)subReqMethod.invoke(serviceInstance, inputDataMap);

			String requestId = validateStatus(outputMap);

			//add a config parameter as mapToUID
			String userIdValue = getUserIdValue(attrMap.values());
			uidReqId  = new Uid(userIdValue+ PATTERN_REQ_NO +requestId+ PATTERN_REQ_TYPE +requestTypeName);
			log.info(configuration.getMessage("SAPACUM_INFO_UID",uidReqId ));	

		} catch (Exception e) {
			log.error(e,configuration.getMessage("SAPACUM_ERR_INITREQ_FAILED"));
			throw new ConnectorException(e);
		}
		return uidReqId;
	}

	/**
	 * Method validating the status from web service.
	 * Method do validation based on the status string starting character.
	 * If 0, web service call is success
	 * If 4, web service fails to execute the request
	 * If 1, web service Client fails to execute the web service call
	 * 
	 * @param outputMap
	 * @return
	 */
	private String validateStatus(Map<String, Object> outputMap){
		ConnectorException ce = null;
		String requestNumber = null;
		String status = outputMap.get(STATUS).toString();
		log.info(configuration.getMessage("SAPACUM_INFO_WEBSERVICES",status));
		if(status.startsWith(DIGIT_ZERO)){
			//Return Request number returned from submit request web service client
			log.info(configuration.getMessage("SAPACUM_INFO_CALL_SUCCESSFUL")); 
			if(outputMap.get(REQUESTNO)!= null){
				requestNumber = (String)outputMap.get(REQUESTNO);
			}
		} else if(status.startsWith(DIGIT_ONE)){
			//Log the exception and Return failure response
			ce = new ConnectorException(outputMap.get(STATUS).toString()+configuration.getMessage("SAPACUM_ERR_1"));
			log.error(ce, outputMap.get(STATUS).toString()+configuration.getMessage("SAPACUM_ERR_1"));
			throw ce;
		} else if(status.startsWith(DIGIT_FOUR)){
			//If 'Log Audit Trial' = 'Yes' in Configuration, 
			//then log the complete audit trial of the request in log file.
			//no requestno if request failed in target system. 
			//if(VALUE_YES.equalsIgnoreCase(configuration.getLogAuditTrial())){
			//logAuditTrial(resultMap.get(REQUESTNO));	
			//}
			ce = new ConnectorException(outputMap.get(STATUS).toString()+configuration.getMessage("SAPACUM_ERR_1"));
			log.error(ce, outputMap.get(STATUS).toString()+configuration.getMessage("SAPACUM_ERR_4"));
			throw ce;
		} else {
			//unexpected case
			ce = new ConnectorException(configuration.getMessage("SAPACUM_CE_CALLSERVICE"));
			log.error(ce.getMessage());
			throw ce;
		}
		return requestNumber;
	}

	/**
	 * Method populating the Form data in input data of web service
	 * @param attrMap
	 * @return
	 */
	private Map<String, Object> populateInputData(Map<String, Attribute> attrMap) {
		Map<String, Object> inputDataMap = new HashMap<String, Object>(10, 0.75f);
		inputDataMap.putAll(getConfigurationMap());
		inputDataMap.put(FORMDATA, attrMap);
		return inputDataMap;
	}

	/**
	 * Method populating request number in input data
	 * @param requestNo
	 * @return
	 */
	private Map<String, Object> populateReqStatusInputData(String requestNo) {
		Map<String, Object> inputDataMap = new HashMap<String, Object>(10, 0.75f);
		inputDataMap.putAll(getConfigurationMap());
		inputDataMap.put(REQUESTNO, requestNo);
		return inputDataMap;
	}	

	/**
	 * Method provide a map with details in connector configuration object
	 * @return
	 */
	private Map<String, Object> getConfigurationMap(){
		Map<String, Object> configMap = new HashMap<String, Object>(5, 0.75f);
		configMap.put(CONFIGURATION,configuration.toMap());
		log.info(configuration.getMessage("SAPACUM_INFO_CONFIGMAP", configMap));
		return configMap;
	}


	/**
	 * Method updates lookups 
	 * @param attrsToGet
	 * @param objClass
	 * @param allObjects
	 * @param handler
	 */
	private void createConnectorObject(List<String> attrsToGet,ObjectClass objClass, Map allObjects, ResultsHandler handler) {
		ConnectorObjectBuilder objectBuilder = new ConnectorObjectBuilder();
		String codekey = attrsToGet.get(0);
		String decodekey = attrsToGet.get(1);
		Set<String> keySet = allObjects.keySet();
		for(String key : keySet){
			objectBuilder.addAttribute(AttributeBuilder.build(codekey, key));
			if (allObjects.get(key) == null) {
				objectBuilder.addAttribute(AttributeBuilder.build(decodekey, key));
			}else {
				objectBuilder.addAttribute(AttributeBuilder.build(decodekey,allObjects.get(key).toString()));
			}
			objectBuilder.setUid(key.toString());
			objectBuilder.setName(key.toString());			
			objectBuilder.setObjectClass(objClass);
			handler.handle(objectBuilder.build());
		}
	}

	/**
	 * Method filtering request type from configuration lookup
	 * @param reqType
	 */
	private void splitReqType(String reqType){
		log.info(configuration.getMessage("SAPACUM_INFO_REQTYPE", reqType));
		String[] type = reqType.split(PATTERN_REQ_TYPE);
		if(type.length == 1){//for grc5.3
			String[] actionNtype = null;
			if(type[0].contains(PATTERN_SEMI_COLON)){
				actionNtype = type[0].split(PATTERN_SEMI_COLON);
				requestTypeCode = actionNtype[0];
				requestTypeName = actionNtype[0];
				roleAction = actionNtype[1];
			} else {
				requestTypeCode = type[0];
				requestTypeName = type[0];
			}
		} else if(type.length > 1){//for grc10
			requestTypeCode = type[0];
			requestTypeName = type[1];
			provAction = type[2];
			if(type.length > 3){
				provItemAction = type[3];
			}
		}
	}

	/**
	 * Method invokes request status web service for Request Status Recon job of OIM
	 * @param query
	 * @param handler
	 * @param options
	 * @throws Exception
	 */
	private void getRequestStatus(String query, ResultsHandler handler,OperationOptions options) throws Exception {
		ConnectorObjectBuilder objectBuilder = new ConnectorObjectBuilder();
		String reqNo = null;
		String userIDRecon = null;
		String reqstatus = null;
		String reqType = null;

		if (query.contains(PATTERN_AND)) {
			log.info(configuration.getMessage("SAPACUM_INFO_STATUS_RECON_JOB"));
			String[] qArray = null;
			String[] parameterArray = query.split(PATTERN_AND);
			for (String parameter : parameterArray) {
				if (parameter.contains(PATTERN_EQUALTO)) {
					qArray = parameter.split(PATTERN_EQUALTO);
					if( qArray.length == 2)
					{
						if( USERID.equalsIgnoreCase(qArray[0].trim()))
						{
							userIDRecon = qArray[qArray.length - 1].trim();
						} else if(LOGONNAME.equalsIgnoreCase(qArray[0].trim())){
							userIDRecon = qArray[qArray.length - 1].trim();
						}else if(Uid.NAME.equalsIgnoreCase(qArray[0].trim())) {
							reqNo = qArray[qArray.length - 1].trim();
						}else if(REQUESTTYPE.equalsIgnoreCase(qArray[0].trim())){
							reqType = qArray[qArray.length-1].trim();
						}
					}
				}else{
					reqNo = parameter.trim();
				}		
			}				

			if (reqNo != null) {
				reqstatus = getRequestStatusFromId(reqNo);
				if (reqstatus != null) {
					for (String attrToGet : options.getAttributesToGet()) {
						if (attrToGet.equalsIgnoreCase(ATTR_AC_REQ_STATUS)) {
							objectBuilder.addAttribute(ATTR_AC_REQ_STATUS,
									reqstatus);
						}else if (attrToGet.equalsIgnoreCase(USERID)) {
							objectBuilder.addAttribute(USERID, userIDRecon);
						}else if (attrToGet.equalsIgnoreCase(LOGONNAME)) {
							objectBuilder.addAttribute(LOGONNAME,
									userIDRecon);
						}else if (attrToGet.equalsIgnoreCase(REQUESTID)) {
							objectBuilder.addAttribute(REQUESTID, reqNo);
						}else if (attrToGet.equalsIgnoreCase(ATTR_REQTYPE)) {
							objectBuilder.addAttribute(ATTR_REQTYPE, reqType);
						}
					}
					objectBuilder.setUid(reqNo);
					objectBuilder.setName(userIDRecon);
					objectBuilder.setObjectClass(new ObjectClass(STATUS));
					ConnectorObject co = objectBuilder.build();

					if (co != null) {
						log.info(configuration.getMessage("SAPACUM_INFO_INVOKING_HANDLER"));
						handler.handle(co);
					}
				}
			}
		}	
		
	}		


	/**
	 * 
	 * @param objectClass
	 * @param handler
	 * @throws Exception
	 */
	private void getRoles(ObjectClass objectClass, ResultsHandler handler)throws Exception{
		List<String> valuesToGet = new ArrayList<String>(); 
		valuesToGet.add(roleCodeKeyDecode[0]);
		valuesToGet.add(roleCodeKeyDecode[1]);
		Map<String, Object> inputMap = new HashMap<String, Object>();
		inputMap.putAll(getConfigurationMap());
		Map<String, Object> outputMap = invokeCallService(configuration.getRoleLookupWS(), inputMap);
		validateStatus(outputMap);
		createConnectorObject(valuesToGet, objectClass,(Map)outputMap.get(RESULT), handler);
	}

	/**
	 * 
	 * @param objectClass
	 * @param handler
	 * @throws Exception
	 */
	private void getSystem(ObjectClass objectClass, ResultsHandler handler)throws Exception {
		List<String> valuesToGet = new ArrayList<String>(); 
		valuesToGet.add(applCodeKeyDecode[0]);
		valuesToGet.add(applCodeKeyDecode[1]);
		Map<String, Object> inputMap = new HashMap<String, Object>();
		inputMap.putAll(getConfigurationMap());
		Map<String, Object> outputMap = invokeCallService(configuration.getAppLookupWS(), inputMap);
		validateStatus(outputMap);
		createConnectorObject(valuesToGet,objectClass,(Map)outputMap.get(RESULT), handler);
	}

	/**
	 * Method invokes other lookup web service to retrieve values with respect to ObjectClass
	 * This is used only in AC10 lookups
	 *  
	 * @param objectClass
	 * @param handler
	 * @throws Exception
	 */
	private void getOtherLookups(ObjectClass objectClass, ResultsHandler handler)throws Exception{
		List<String> valuesToGet = new ArrayList<String>(); 
		valuesToGet.add(lookupCodeKeyDecode[0]);
		valuesToGet.add(lookupCodeKeyDecode[1]);
		Map<String, Object> outputMap = null;
		Map<String, Object> inputMap = new HashMap<String, Object>();
		inputMap.putAll(getConfigurationMap());

		if(ITEMPROVACTIONTYPE.equalsIgnoreCase(
				objectClass.getObjectClassValue())){
			outputMap = getOtherLookups(ITEMPROVTYPE,inputMap);
			Map<String, String> itemProvTypeMap = (Map)outputMap.get(RESULT);

			if(itemProvTypeMap != null){
				outputMap = new HashMap<String, Object>(5, 0.75f);
				Map<String, Object> resultMap = new HashMap<String, Object>(10, 0.75f);
				for(String itemProvType : itemProvTypeMap.keySet()){
					inputMap.put(ITEMTYPE, itemProvType);
					resultMap.putAll((Map)getOtherLookups(objectClass.getObjectClassValue(),inputMap).get(RESULT));
				}
				outputMap.put(RESULT, resultMap);
			}
		} else {
			outputMap = getOtherLookups(objectClass.getObjectClassValue(),inputMap);
		}
		createConnectorObject(valuesToGet, objectClass,(Map)outputMap.get(RESULT), handler);
	}

	/**
	 * 
	 * @param objectClassName
	 * @param inputMap
	 * @return
	 * @throws Exception
	 */
	private Map<String, Object> getOtherLookups(String objectClassName, Map<String, Object> inputMap) throws Exception{
		Map<String, Object> outputMap = null;
		inputMap.put("ObjectClass",objectClassName);
		outputMap = invokeCallService(configuration.getOtherLookupWS(), inputMap);
		validateStatus(outputMap);
		return outputMap;
	}

	/**
	 * Generic method to invoke web service 
	 * @param className
	 * @param inputDataMap
	 * @return
	 * @throws Exception
	 */
	private Map<String, Object> invokeCallService(String className, Map<String, Object> inputDataMap ) throws Exception {
		Map<String, Object> resultMap = null;
		Class<?> statusReqClientClazz = Class.forName(className);
		Object serviceInstance = statusReqClientClazz.newInstance();
		Method statusReqMethod = statusReqClientClazz.getMethod(SERVICE_METHODNAME, Map.class);
		resultMap = (Map<String, Object>)statusReqMethod.invoke(serviceInstance,inputDataMap);
		return resultMap;
	}

	/**
	 * Method returns validthru date as mill seconds.
	 * For Enable user, It returns maximum date "31/12/9999".
	 * For Disable user, It returns Current date. 
	 * @param isEnable
	 * @return
	 */
	private Long getValidThru(Boolean isEnable){
		Long milliSec = null;
		Date dtValidThro = null;
		DateUtil dtUtil = new DateUtil();
		try {
			if(isEnable){
				dtValidThro = dtUtil.returnDate("9999-12-31", "yyyy-MM-dd");
				String sDate = dtUtil.parseTime(dtValidThro, "yyyy-MM-dd");
				dtValidThro = dtUtil.returnDate(sDate, "yyyy-MM-dd");
				milliSec = dtValidThro.getTime();
			}else{
				dtValidThro = new Date();				
				milliSec = dtValidThro.getTime();
			}
		} catch (ConnectorException eException) {
			log.error(eException, configuration.getMessage("SAPACUM_ERR_GETVALIDTHRU_FAILED"));
			throw ConnectorException.wrap(eException);
		}
		return milliSec;
	}


	/**
	 * Method returns false if the previous request is in 
	 * pending status when configuration parameter IgnoreOpenStatus is NO
	 *  
	 * @param attrMap
	 * @return
	 */
	private Boolean canProcessRequestId(String requestId){
		Boolean canProcessRequest = true;
		String requestStatus = null;
		//grc10=OK
		//grc53=CLOSED

		try {
			if(requestId!=null){
				requestStatus =  getRequestStatusFromId(requestId);
				if(VALUE_NO.equalsIgnoreCase(configuration.getIgnoreOpenStatus()) 
						&& !(VALUE_OK.equalsIgnoreCase(requestStatus) || CLOSED.equalsIgnoreCase(requestStatus))){
					canProcessRequest = false;
				}
			}else {
				log.warn(configuration.getMessage("SAPACUM_WARN_ATTR_NT_FOUND"));
			}
		} catch (Exception e) {
			throw new ConnectorException(configuration.getMessage("SAPACUM_CE_REQSTATUS_FAIL"), e);
		}
		return canProcessRequest;
	} 



	/**
	 * Getting Audit trail from GRC 
	 * @param reqNo
	 */
	private void logAuditTrial(String reqNo) {
		//call audit trial WS
		Map<String, Object> resultMap = null;
		//Class<?> auditTrialClazz = null;
		Map<String, Object> inputDataMap = new HashMap<String, Object>(3, 0.75f);
		inputDataMap.putAll(getConfigurationMap());
		inputDataMap.put(REQUESTNO, reqNo);
		try {
			resultMap = invokeCallService(configuration.getAuditLogsWS(),inputDataMap);
			log.info(configuration.getMessage("SAPACUM_INFO_RESULT_AUDITTRAIL",resultMap.get(RESULT)));
			log.info(configuration.getMessage("SAPACUM_INFO_AUDITTRAIL",resultMap.toString()));
		} catch (Exception e) {
			log.error(e, configuration.getMessage("SAPACUM_ERR_LOGAUDITTRAIL_FAILED"));
			throw new ConnectorException(e);
		}
	}

	/**
	 * Method includes logic for update flow
	 * Extracting required data from Attribute set and initiating the request to web service client 
	 * @param attrs
	 * @return
	 */
	private Uid doUpdate(Set<Attribute> attrs, String flowType, OperationOptions options, String requestid){
		Uid rUid = null;
		//boolean
		Map<String, Attribute> modifiedAttrValMap = new HashMap<String, Attribute>(AttributeUtil.toMap(attrs));
		if(!canProcessRequestId(requestid)){
			throw new ConnectorException(configuration.getMessage("SAPACUM_CE_PREVIOUS_REQ_NOTAPPROVED"));
		}

		if(modifiedAttrValMap.keySet().contains(DECODE_USERLOCK)){
			if(modifiedAttrValMap.get(DECODE_USERLOCK).getValue().contains(DIGIT_ONE)){
				splitReqType(configuration.getLockUserReqType());
			} else {
				splitReqType(configuration.getUnlockUserReqType());
			}
			//Start : Bug 26442572 - AOB: SAP AC UM CHILD ATTRIBUTERS RECON IS NOT WORKING
		} else if(modifiedAttrValMap.containsKey(ROLES) || modifiedAttrValMap.containsKey(PROFILES)){
			//End : Bug 26442572 - AOB: SAP AC UM CHILD ATTRIBUTERS RECON IS NOT WORKING
			if(ADD_CHILD.equals(flowType)){
				splitReqType(configuration.getAssignRoleReqType());
			} else if(REMOVE_CHILD.equals(flowType)){
				splitReqType(configuration.getRemoveRoleReqType());
			}
		} else {
			splitReqType(configuration.getModifyUserReqType());
		}

		Set<Attribute> currentAttrSet = new HashSet<Attribute>(AttributeUtil.getCurrentAttributes(attrs));

		//Note: attrs doesn't support to add new attributes so using new Set object
		Map<String, Attribute> updateAttrMap = new HashMap<String, Attribute>(AttributeUtil.toMap(currentAttrSet));

		modifiedAttrValMap.remove(OperationalAttributes.CURRENT_ATTRIBUTES);
		// modified as part of AC redesign
		String reqTypeOption = (String)options.getOptions().get(REQTYPE);
		//String reqTypeOption = DELETE; 
		if (DELETE_REQ_TYPE.equalsIgnoreCase(reqTypeOption)){
			splitReqType(configuration.getDeleteUserReqType());

		}
		//Note: replace with new value
		for(String attrName: modifiedAttrValMap.keySet()){
			updateAttrMap.put(attrName, modifiedAttrValMap.get(attrName));
		}
		// modified as part of AC redesign

		if(modifiedAttrValMap.keySet().contains(OperationalAttributes.ENABLE_NAME)){

			splitReqType(configuration.getModifyUserReqType());
			Long validToTimestamp = null;
			Attribute validToAttr = null;

			boolean isEnabled = AttributeUtil.getBooleanValue(modifiedAttrValMap.get(OperationalAttributes.ENABLE_NAME));
			validToTimestamp = getValidThru(isEnabled);
			validToAttr = AttributeBuilder.build(ATTR_UI_VALID_TO,validToTimestamp);
			updateAttrMap.put(ATTR_UI_VALID_TO, validToAttr);
			validToAttr = AttributeBuilder.build(VALIDTO, validToTimestamp);
			updateAttrMap.put(VALIDTO, validToAttr);
		}
		Attribute reqTypeAttr = AttributeBuilder.build(configuration.getRequestTypeAttrName(),requestTypeCode); 
		updateAttrMap.put(configuration.getRequestTypeAttrName(), reqTypeAttr);

		if(provAction != null){
			Attribute provActionAttr = AttributeBuilder.build(configuration.getProvActionAttrName(), provAction);
			updateAttrMap.put(configuration.getProvActionAttrName(), provActionAttr);
		}

		if(provItemAction != null){
			Attribute provItemActionAttr = AttributeBuilder.build(configuration.getProvItemActionAttrName(), provItemAction);
			updateAttrMap.put(configuration.getProvItemActionAttrName(), provItemActionAttr);
		}

		if(roleAction != null){//for grc5.3
			Attribute actionAttr = AttributeBuilder.build(ACTION, roleAction);
			updateAttrMap.put(ACTION,actionAttr);
		}
		//Start : Bug 26201073 WE ARE FACING AN ERROR, WHEN WE ARE TRYING TO ADD A ROLE TO THE UMAC USER. 
		String userId = AttributeUtil.getAsStringValue(updateAttrMap.get(Name.NAME));
		Attribute userIdUserInfo = AttributeBuilder.build(ATTR_UI_USER_ID, userId);
		updateAttrMap.put(ATTR_UI_USER_ID, userIdUserInfo);
		//End : Bug 26201073 WE ARE FACING AN ERROR, WHEN WE ARE TRYING TO ADD A ROLE TO THE UMAC USER. 

		rUid = initRequest(updateAttrMap);
		return rUid; 
	}

	/**
	 * Method to handle add child table, It invokes update flow with child details 
	 * @param objectClass
	 * @param uid
	 * @param attrs
	 * @param options
	 * @return
	 */
	public Uid addAttributeValues(ObjectClass objectClass, Uid uid,Set<Attribute> attrs, OperationOptions options) {
		log.error("Perf: addAttributeValues Entered for user {0}", uid.getUidValue());  
		log.info(configuration.getMessage("SAPACUM_INFO_UID_OBJCLASS" ,uid, objectClass));
		log.info(configuration.getMessage("SAPACUM_INFO_ATTRIBUTES_OP", attrs, options.getOptions()));
		String str[] = splitUid(uid);
		String requestId = str[1];
		Uid rUid = doUpdate(attrs, ADD_CHILD, options, requestId);
		log.error("Perf: addAttributeValues Exiting for user {0}", uid.getUidValue()); 
		return rUid;
	}


	/**
	 * Method to handle remove child table, It invokes update flow with child details 
	 * @param objectClass
	 * @param uid
	 * @param attrs
	 * @param options
	 * @return
	 * 
	 */
	public Uid removeAttributeValues(ObjectClass objectClass, Uid uid,Set<Attribute> attrs, OperationOptions options) {
		log.error("Perf: removeAttributeValues Entered for user {0}", uid.getUidValue());   
		log.info(configuration.getMessage("SAPACUM_INFO_UID_OBJCLASS" ,uid, objectClass));
		log.info(configuration.getMessage("SAPACUM_INFO_ATTRIBUTES_OP", attrs, options.getOptions()));
		String str[] = splitUid(uid);
		String requestId = str[1];
		Uid rUid = doUpdate(attrs, REMOVE_CHILD, options, requestId);
		log.error("Perf: removeAttributeValues Exiting for user {0}", uid.getUidValue());     
		return rUid;
	}

	/**
	 * Method parsing userid from given collection
	 * @param createAttrMap
	 * @return
	 */
	private String getUserIdValue(Collection<Attribute> attributes) {
		String userIdValue = null; 
		String userIdName = configuration.getIsGRC53()?ATTR_UI_USER_ID_53:ATTR_UI_USER_ID;
		for(Attribute attr : attributes){
			if(attr.getName().equalsIgnoreCase(userIdName)){
				userIdValue = AttributeUtil.getAsStringValue(attr);
				break;
			}
		}
		return userIdValue;
	}

	/**
	 * Method invokes request status web service to get request status
	 * @param query
	 * @param handler
	 * @param options
	 * @throws Exception
	 */
	public String getRequestStatusFromId( String requestId ) throws Exception {
		Map<String, Object> resultMap = null;
		Map<String, Object> inputDataMap = populateReqStatusInputData(requestId);
		logAuditTrial(requestId);
		resultMap = invokeCallService(configuration.getRequestStatusWS(), inputDataMap);
		return (String) resultMap.get(ATTR_AC_REQ_STATUS);
	}


	/**
	 * Fetching userid, request id and request type from the UID
	 * @param uid
	 * @return userid, request id and request type in string array
	 */
	public String[] splitUid(Uid uid){

		if(uid.getUidValue().contains(PATTERN_REQ_NO)){
			String[] uidReqId = uid.getUidValue().split("\\~\\*\\~");
			String[] ReqIdReqType = uidReqId[1].split("\\~");
			String[] uidReqIdReqType = {uidReqId[0],ReqIdReqType[0],ReqIdReqType[1]};
			return uidReqIdReqType;
		}else{
			String[] uidReqIdReqType = {uid.getUidValue(),null,null};
			return uidReqIdReqType;
		}
	}


	public void test() {
		try {
			Map<String, Object> inputMap = new HashMap<String, Object>();
			inputMap.putAll(getConfigurationMap());
			Map<String, Object> outputMap = invokeCallService(configuration.getRoleLookupWS(), inputMap);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ConnectorException(configuration.getMessage("SAPACUM_CE_CONN_FAILED"), e);
		}
	}


	public SyncToken getLatestSyncToken(ObjectClass objClass) {
		throw new ConnectorException(configuration.getMessage("SAPACUM_CE_SYNC_NOSUPPORT")); 
	}


	public void sync(ObjectClass objClass, SyncToken token, final SyncResultsHandler handler,OperationOptions options) {	
		log.error("Perf: Sync Entered");
		String [] actualAttrsToGet = options.getAttributesToGet();
		Map<String, Object> getOptions = options.getOptions();		
		final Set<String> actualAttrsToGetSet = new HashSet<String>(Arrays.asList(options.getAttributesToGet()));
		OperationOptionsBuilder builder = new OperationOptionsBuilder();
		List<String> umAttrsToGet = new ArrayList<String>();
		Set<String> acSet = configuration.getIsGRC53()?acSchema.getAc53attrSet():acSchema.getAc10attrSet();
		for(String attr: actualAttrsToGet){
			if(!acSet.contains(attr)){
				umAttrsToGet.add(attr);
			}
		}

		for (Map.Entry<String, Object> entry : getOptions.entrySet())
		{
			if (entry.getKey().equals(ATTRS_TO_GET)){ 
				builder.setAttributesToGet(umAttrsToGet);
			}else{
				builder.setOption(entry.getKey(), entry.getValue());	
			}
		}
		OperationOptions newOptionswithoutACattrs=builder.build();

		SyncResultsHandler sapumSyncHandler =new SyncResultsHandler() {

			public boolean handle(SyncDelta umCo) {
				ConnectorObjectBuilder objectBuilder = new ConnectorObjectBuilder();
				SyncDeltaBuilder sdb = new SyncDeltaBuilder();
				for(Attribute attribute : umCo.getObject().getAttributes()){
					String umAttrName = attribute.getName();
					String acAttrname = ac2umMapProps.getProperty(umAttrName);							
					if(acAttrname!=null && actualAttrsToGetSet.contains(acAttrname))
						objectBuilder.addAttribute(AttributeBuilder.build(acAttrname, attribute.getValue()));
					if(umAttrName!=null && actualAttrsToGetSet.contains(umAttrName))
						objectBuilder.addAttribute(attribute);
				}
				objectBuilder.setName(umCo.getObject().getName());
				ConnectorObject co = objectBuilder.build();							
				if (co != null) {								
					sdb.setObject(co);
					sdb.setToken(umCo.getToken());
					sdb.setDeltaType(umCo.getDeltaType());
					sdb.setUid(AttributeUtil.getUidAttribute(co.getAttributes()));
				}
				return handler.handle(sdb.build());		
			}
		};	
		umConnector.sync(objClass, token, sapumSyncHandler, newOptionswithoutACattrs);	
		log.error("Perf: Sync Exiting");
	}

	/**
	 * @param actualAttrsToGetSet
	 * @param umCo
	 * @return 
	 */
	
	//Start : Bug 25748407 - AOB: SAP AC UM RECON IS NOT WORKING
		private String addAttributes(String acAttrs) {
			
				String backendAcAttrname = ac2umMapProps.getProperty(acAttrs);					
				if(backendAcAttrname!=null){
					return backendAcAttrname;
				}
			return null;
		}
		//End : Bug 25748407 - AOB: SAP AC UM RECON IS NOT WORKING
		
	private ConnectorObjectBuilder addValidAttributes(Set<String> actualAttrsToGetSet,ConnectorObject umCo) {
		ConnectorObjectBuilder objectBuilder = new ConnectorObjectBuilder();
		for(Attribute attribute : umCo.getAttributes()){
			String umAttrName = attribute.getName();
			String acAttrname = ac2umMapProps.getProperty(umAttrName);
			
			//Start : Bug 26442572 - AOB: SAP AC UM CHILD ATTRIBUTERS RECON IS NOT WORKING
			if(umAttrName != null && ((umAttrName.equalsIgnoreCase(ATTR_ROLES_EMBEDED) 
					|| (umAttrName.equalsIgnoreCase(ATTR_PROFILES_EMBEDED))
					|| (umAttrName.equalsIgnoreCase(ATTR_PARAMETERS_EMBEDED))))){
				Attribute childAttr = addValidEmbeddedAttributes(attribute, umAttrName);
				objectBuilder.addAttribute(childAttr);	
			}
			//End : Bug 26442572 - AOB: SAP AC UM CHILD ATTRIBUTERS RECON IS NOT WORKING
			
			else if(acAttrname!=null && actualAttrsToGetSet.contains(acAttrname))
				objectBuilder.addAttribute(AttributeBuilder.build(acAttrname, attribute.getValue()));
			else if(umAttrName!=null && actualAttrsToGetSet.contains(umAttrName))
				objectBuilder.addAttribute(attribute);											
		}
		return objectBuilder;
	}

	//Start : Bug 26442572 - AOB: SAP AC UM CHILD ATTRIBUTERS RECON IS NOT WORKING
	/**
	 * Replacing backend child attributes name with corresponding name in the GRC
	 * @param attribute
	 * @param attrName
	 * @return EmbeddedObject
	 */
	private Attribute addValidEmbeddedAttributes(Attribute attribute, String attrName) {
		List childAttrs = attribute.getValue();
		ListIterator namesIterator = childAttrs.listIterator();
		AttributeBuilder roleBuilder = new AttributeBuilder();
		roleBuilder.setName(attrName);
		EmbeddedObjectBuilder acActivityGrpBuilder = new EmbeddedObjectBuilder();


		while(namesIterator.hasNext()){
			EmbeddedObject embObject = (EmbeddedObject) namesIterator.next();
			Set<Attribute> embSet = embObject.getAttributes();
			acActivityGrpBuilder.setObjectClass(embObject.getObjectClass());
			Iterator iter = embSet.iterator();
			while (iter.hasNext()) {
				Attribute embAttr = (Attribute) iter.next();
				String acAttrname = ac2umMapProps.getProperty(embAttr.getName());
				if(acAttrname != null)
				acActivityGrpBuilder.addAttribute(acAttrname, embAttr.getValue());
			}
			roleBuilder.addValue(acActivityGrpBuilder.build());
		}	
		return roleBuilder.build();
	}
		//End : Bug 26442572 - AOB: SAP AC UM CHILD ATTRIBUTERS RECON IS NOT WORKING





}

