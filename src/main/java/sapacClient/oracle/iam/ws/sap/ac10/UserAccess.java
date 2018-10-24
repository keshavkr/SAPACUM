/**
 * 
 */
package oracle.iam.ws.sap.ac10;

import static oracle.iam.ws.sap.util.WsClientUtil.KEY_AC_URL;
import static oracle.iam.ws.sap.util.WsClientUtil.KEY_CONFIG_DATA;
import static oracle.iam.ws.sap.util.WsClientUtil.KEY_FORM_DATA;
import static oracle.iam.ws.sap.util.WsClientUtil.KEY_LANGUAGE;
import static oracle.iam.ws.sap.util.WsClientUtil.STATUS;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;

import oracle.iam.ws.sap.ac10.useraccess.GRACUSERACCESWS;
import oracle.iam.ws.sap.ac10.useraccess.GracSWsApiMessage;
import oracle.iam.ws.sap.ac10.useraccess.GracSWsApiUserInfo;
import oracle.iam.ws.sap.ac10.useraccess.GracSWsReqhdr;
import oracle.iam.ws.sap.ac10.useraccess.GracSWsUaIpCustfldVal;
import oracle.iam.ws.sap.ac10.useraccess.GracSWsUaIpPrameterList;
import oracle.iam.ws.sap.ac10.useraccess.GracSWsUaIpReqlineitem;
import oracle.iam.ws.sap.ac10.useraccess.GracSWsUaIpUserGroup;
import oracle.iam.ws.sap.ac10.useraccess.GracTWsUaIpCustfldVal;
import oracle.iam.ws.sap.ac10.useraccess.GracTWsUaIpPrameterList;
import oracle.iam.ws.sap.ac10.useraccess.GracTWsUaIpReqlineitem;
import oracle.iam.ws.sap.ac10.useraccess.GracTWsUaIpUserGroup;
import oracle.iam.ws.sap.ac10.useraccess.GracTWsUserInfo;
import oracle.iam.ws.sap.ac10.useraccess.Service;
import oracle.iam.ws.sap.util.WsClientUtil;

import org.identityconnectors.common.logging.Log;
import org.identityconnectors.framework.common.objects.Attribute;
import org.identityconnectors.framework.common.objects.EmbeddedObject;

/**
 * @author ranjith.kumar
 * 
 * Web service client class to populate input and invoke SAP GRC AC10 web service
 * GRAC_USER_ACCESS_WS to create a request for user provision and add/remove child details
 *
 */
public class UserAccess {

	private static final Log LOG = Log.getLog(UserAccess.class);
	
	public static final String REQHEADER_IDENTIFIER =";Header";
	public static final String USERINFO_IDENTIFIER =";UserInfo";
	public static final String USERGROUP_IDENTIFIER =";UserGroup";
	public static final String REQLINEITEM_IDENTIFIER =";ReqLineItem";
	public static final String PRAMETERLIST_IDENTIFIER =";Parameter";
	public static final String CUSTFLDVAL_IDENTIFIER =";Custom";
	
	//Start : Bug 26442572 - AOB: SAP AC UM CHILD ATTRIBUTERS RECON IS NOT WORKING
	public static final String PROFILE_NAME = "profiles";
	//End : Bug 26442572 - AOB: SAP AC UM CHILD ATTRIBUTERS RECON IS NOT WORKING
	public static final String ROLES_NAME = "roles";
	public static final String PARAMETER_NAME = "Parameter";
	public static final String USERGROUP_NAME = "userGroup";
	
	// UME Request line items
	// Start Bug 23743186- SAP UME: ROLE REQUEST IS NOT Generating Request ID IN GRC
	public static final String UMEROLE = "umerole";
	public static final String UMEGROUP = "umegroup";
	// End Bug 23743186- SAP UME: ROLE REQUEST IS NOT Generating Request ID IN GRC
	
	private GracTWsUserInfo _gracTWsUserInfo = null;
	private GracSWsReqhdr _gracSWsReqhdr = null;
	private GracTWsUaIpReqlineitem _gracTWsUaIpReqlineitem = null;
	private GracTWsUaIpPrameterList _gracTWsUaIpPrameterList = null;
	private GracTWsUaIpUserGroup _gracTWsUaIpUserGroup = null;
	private GracTWsUaIpCustfldVal _gracTWsUaIpCustfldVal = null;
	
	private WsClientUtil util = null;
	private GRACUSERACCESWS  _port = null;
	private static final String WS_DATEFORMAT_STRING = "yyyyMMdd";
	private static final SimpleDateFormat WS_DATEFORMAT = new SimpleDateFormat(
			WS_DATEFORMAT_STRING);



	/**
	 * Method invokes SAP GRC AC10 web service to create request for provisioning 
	 * @param inputDataMap
	 * @return
	 */
	public Map<String, Object> callService(Map<String, Object> inputDataMap) {
		Map<String, Object> resultMap = new HashMap<String, Object>(10, .075f);
		StringBuffer statusMsg = null;
		LOG.info("callService - UserAccess input:[{0}]", inputDataMap);

		//output parameters
		Holder<GracSWsApiMessage> msgReturn = new Holder<GracSWsApiMessage>();
		Holder<String> requestId = new Holder<String>();
		Holder<String> requestNo = new Holder<String>();
		Map<String, Attribute> attrMap = (Map<String, Attribute>)inputDataMap.get(KEY_FORM_DATA);
		util = new WsClientUtil();
		try {
			marshalInputData(attrMap);
			
			Map<String, Object> configMap = (Map)inputDataMap.get(KEY_CONFIG_DATA);
			configMap.put(KEY_AC_URL, configMap.get("userAccessAccessURL"));
			
			String language = (String)inputDataMap.get(KEY_LANGUAGE);
			
			//URL url = getClass().getClassLoader().getResource("/wsdl/GRAC_USER_ACCESS_WS.WSDL");
			StringBuffer wsdlPath = new StringBuffer("file:/");
			wsdlPath.append(configMap.get("wsdlFilePath"));
			wsdlPath.append("/GRAC_USER_ACCESS_WS.WSDL");
			URL url = new URL(wsdlPath.toString());
			
			
		    QName qName = new QName("urn:sap-com:document:sap:soap:functions:mc-style", "service");

			Service service = new Service(url, qName);
			_port = service.getBinding();
			util.setCredentials((BindingProvider)_port, configMap, true);
			LOG.error("Perf: Call service Entered for user {0}", attrMap.get("userId;UserInfo").getValue());
			_port.gracIdmUsrAccsReqServices(_gracTWsUaIpCustfldVal, language, _gracTWsUaIpPrameterList, 
					_gracSWsReqhdr, _gracTWsUaIpReqlineitem, _gracTWsUaIpUserGroup, _gracTWsUserInfo, 
					msgReturn, requestId, requestNo);
			LOG.error("Perf: Call service Exited for user {0}", attrMap.get("userId;UserInfo").getValue());
			GracSWsApiMessage msg = msgReturn.value;
			String reqNoString = requestNo.value;
			String msgString = msg.getMsgStatement();
			statusMsg = new StringBuffer();
			//setting output map - parameter 1
			if(reqNoString.length()!=0){
				resultMap.put("RequestNo", reqNoString);
			}
			statusMsg.append(msg.getMsgNo());
			statusMsg.append("_"); // success/failure case - 1
			
			if(msgString != null) {
				statusMsg.append(msgString);
			} else {
				statusMsg.append("GracSWsApiMessage.getMsgStatement() is null");
			}
			
			//setting output map - parameter 2
			resultMap.put(STATUS, statusMsg.toString());
			
		}catch(Exception e) {
			LOG.error(e, "Submit Request failed");
			//Exception suppressed!
			statusMsg = new StringBuffer("1_");
			statusMsg.append(e.getMessage());
			//setting output map - parameter 2 - exception case - 1
			resultMap.put(STATUS, statusMsg.toString());
		}
		LOG.info("callService - UserAccess output:[{0}]", resultMap);
		return resultMap;
	}


	/**
	 * Method populating input data
	 * @param attrMap
	 * @throws Exception
	 */
	private void marshalInputData(Map<String, Attribute> attrMap) throws Exception {
		Set<Attribute> reqHeaderAttrSet = new HashSet<Attribute>(15, 0.75f);
		Set<Attribute> custfldValAttrSet = new HashSet<Attribute>(10, 0.75f);
		Set<Attribute> parameterAttrSet = new HashSet<Attribute>(10, 0.75f);
		Set<Attribute> userGroupAttrSet = new HashSet<Attribute>(15, 0.75f);
		Set<Attribute> reqLineItemAttrSet = new HashSet<Attribute>(10, 0.75f);
		Set<Attribute> userInfoAttrSet = new HashSet<Attribute>(15, 0.75f);
		Set<Attribute> otherReqLineItemAttrSet = new HashSet<Attribute>(10, 0.75f);
		String attrName = null;
		for(Attribute attr : attrMap.values()){
			attrName = attr.getName();
			if(attrName != null){
				if(attrName.endsWith(USERINFO_IDENTIFIER)){
					userInfoAttrSet.add(attr);
				} else if(attrName.endsWith(REQHEADER_IDENTIFIER)){
					reqHeaderAttrSet.add(attr);
				} else if(attrName.equals(PROFILE_NAME) || attrName.equals(ROLES_NAME)){
					reqLineItemAttrSet.add(attr);
				} else if(attrName.endsWith(USERGROUP_IDENTIFIER)){
					userGroupAttrSet.add(attr);
				} else if(attrName.equals(PARAMETER_NAME)){
					parameterAttrSet.add(attr);
				} else if(attrName.endsWith(CUSTFLDVAL_IDENTIFIER)){
					custfldValAttrSet.add(attr);
				// Start Bug 23743186- SAP UME: ROLE REQUEST IS NOT Generating Request ID IN GRC
				// Below condition is added to support SAP UME -- Jagadeesh	
				} else if (attrName.startsWith(UMEROLE)|| attrName.startsWith(UMEGROUP)){
					reqLineItemAttrSet.add(attr);
				// END Bug 23743186- SAP UME: ROLE REQUEST IS NOT Generating Request ID IN GRC
				} else if (attrName.endsWith(REQLINEITEM_IDENTIFIER)){
					otherReqLineItemAttrSet.add(attr);
				} else{
					//TODO: handle the attributes __UID__, Requeststatus, ReqType
					LOG.info("Unknown category of attribute:"+attrName);
				}
			} else {
				LOG.info("Attribute.getName() is null");
			}
		}
		_gracTWsUserInfo = populateUserInfo(userInfoAttrSet);//done
		_gracSWsReqhdr = populateReqHeader(reqHeaderAttrSet);//done
		_gracTWsUaIpReqlineitem = populateReqLineItem(reqLineItemAttrSet, 
				otherReqLineItemAttrSet);//done-multi value
		_gracTWsUaIpPrameterList = populateParameter(parameterAttrSet);//done-multi value
		_gracTWsUaIpUserGroup = populateUserGroup(userGroupAttrSet);//done-multi value
		_gracTWsUaIpCustfldVal = populateCustomField(custfldValAttrSet);//Pending
	}

	/**
	 * Method setting user info details
	 * @param userInfoAttrSet
	 * @return
	 * @throws Exception 
	 */
	private GracTWsUserInfo populateUserInfo(Set<Attribute> userInfoAttrSet) throws Exception {
		GracTWsUserInfo gracTWsUserInfo = new GracTWsUserInfo();
		List<GracSWsApiUserInfo> apiUserInfoList = gracTWsUserInfo.getItem();
		GracSWsApiUserInfo gracSWsApiUserInfo = new GracSWsApiUserInfo();
		Class<? extends GracSWsApiUserInfo> clazz = gracSWsApiUserInfo.getClass();
		String attrName = null;
		List<Object> valueList = null;
		String value = null;
		for(Attribute attribute : userInfoAttrSet){
			attrName = util.splitAttrName(attribute.getName());
			valueList = attribute.getValue();
			LOG.info("No. of values with attribute {0} : {1}",attribute.getName(),valueList.size());
			if(valueList.size() > 1) {
				LOG.warn("More than 1 values found with attribute {0}", attribute.getName());
			}
			value = util.filterAttrValue(valueList.get(0).toString());
			util.getMethod(clazz, util.getMethodName(
					clazz, attrName, "set"), String.class).invoke(gracSWsApiUserInfo,	value);
		}
		String vFrom = gracSWsApiUserInfo.getValidFrom();
		if(vFrom != null ){
			long vFromLong = Long.valueOf(vFrom);
			if(vFromLong>0){
				gracSWsApiUserInfo.setValidFrom(WS_DATEFORMAT.format(new Date(vFromLong)));
			} else {
				gracSWsApiUserInfo.setValidFrom(null);
			}
		}
		String vTo = gracSWsApiUserInfo.getValidTo();
		if(vTo != null ){
			long vToLong = Long.valueOf(vTo);
			if(vToLong>0){
				gracSWsApiUserInfo.setValidTo(WS_DATEFORMAT.format(new Date(vToLong)));
			} else {
				gracSWsApiUserInfo.setValidTo(null);
			}
		}
		apiUserInfoList.add(gracSWsApiUserInfo);
		return gracTWsUserInfo;
	}
	
	/**
	 * Method setting request header object data
	 * @param reqHeaderAttrSet
	 * @return
	 * @throws Exception 
	 */
	private GracSWsReqhdr populateReqHeader(Set<Attribute> reqHeaderAttrSet) throws Exception {
		GracSWsReqhdr gracSWsReqhdr = new GracSWsReqhdr();
		Class<? extends GracSWsReqhdr> clazz = gracSWsReqhdr.getClass();
		String attrName = null;
		String value = null;
		List<Object> valueList = null;
		for(Attribute attribute : reqHeaderAttrSet){
			attrName = util.splitAttrName(attribute.getName());
			valueList = attribute.getValue();
			LOG.info("No. of values with attribute {0} : {1}",attribute.getName(),valueList.size());
			if(valueList.size() > 1) {
				LOG.warn("More than 1 values found with attribute {0}", attribute.getName());
			}
			value = util.filterAttrValue(valueList.get(0).toString());
			util.getMethod(clazz, util.getMethodName(
					clazz, attrName, "set"), String.class).invoke(gracSWsReqhdr, value);
		}
		/*if(gracSWsReqhdr.getReqDueDate() != null){
			gracSWsReqhdr.setReqDueDate(util.dateFormatConversion(
					gracSWsReqhdr.getReqDueDate(),"yyyy-MM-dd", WS_DATEFORMAT_STRING));
		}*/
		
		// **start** Bug 16083554 - ACCESS REQUEST MANAGEMENT ,CREATE USER EXCEPTION ON GRC 10		
		String reqDuteDate = gracSWsReqhdr.getReqDueDate();
		if(reqDuteDate != null){
				long reqDuedt = Long.valueOf(reqDuteDate);
				if(reqDuedt>0){
					gracSWsReqhdr.setReqDueDate(WS_DATEFORMAT.format(new Date(reqDuedt)));
				} else {
					gracSWsReqhdr.setReqDueDate(null);
				}
			}
		//**END**
		return gracSWsReqhdr;
	}

	/**
	 * Method constructing request line item object
	 * @param reqLineItemAttrSet
	 * @return
	 * @throws Exception 
	 */
	private GracTWsUaIpReqlineitem populateReqLineItem(
			Set<Attribute> reqLineItemAttrSet,
			Set<Attribute> otherReqLineItemAttrSet) throws Exception {
		GracTWsUaIpReqlineitem gracTWsUaIpReqlineitem = new GracTWsUaIpReqlineitem();
		List<GracSWsUaIpReqlineitem> reqlineitemList = gracTWsUaIpReqlineitem.getItem();
		GracSWsUaIpReqlineitem gracSWsUaIpReqlineitem = null;
		Class<? extends GracSWsUaIpReqlineitem> clazz = GracSWsUaIpReqlineitem.class;;
		String attrName = null;
		String value = null;
		List<Object> valueList = null;
		EmbeddedObject embeddedObject = null;
		String provItemType = null;
		//String provItemAction = null;
		String roleType = null;
		long vFromLong = 0;
		long vToLong = 0;
		String[] itemNameValues = null;
		//initializing System,--start
		gracSWsUaIpReqlineitem = new GracSWsUaIpReqlineitem();
		gracSWsUaIpReqlineitem.setConnector(_gracSWsReqhdr.getReqInitSystem());
		gracSWsUaIpReqlineitem.setItemName(gracSWsUaIpReqlineitem.getConnector());
		gracSWsUaIpReqlineitem.setProvAction(getAttrValue(otherReqLineItemAttrSet, "provAction"));
		//gracSWsUaIpReqlineitem.setProvAction(_gracSWsReqhdr.getReqtype());
		gracSWsUaIpReqlineitem.setProvItemType("SYS");
		gracSWsUaIpReqlineitem.setValidFrom(_gracTWsUserInfo.getItem().get(0).getValidFrom());
		gracSWsUaIpReqlineitem.setValidTo(_gracTWsUserInfo.getItem().get(0).getValidTo());
		reqlineitemList.add(gracSWsUaIpReqlineitem);
		//--end
		for(Attribute attr :reqLineItemAttrSet){
			if(attr.getName().equals(ROLES_NAME)){
				/*
				 * ProvAction-->ActionDescn-->ItemProvType-->ItemProvTypDesc
				 * 006-->Assign--ROL-->Role
				 * 009-->Remove--ROL-->Role
				 * 010-->Retain--ROL-->Role
				 */
				provItemType = "ROL";
				//provItemAction = "006";
				roleType = "SIN";
			} else if(attr.getName().equals(PROFILE_NAME)){
				/*
				 * ProvAction-->ActionDescn-->ItemProvType-->ItemProvTypDesc
				 * 
				 */
				provItemType = "PRF";
				//provItemAction = "";
				roleType = null;
			}// Below condition is added to support SAP UME -- Jagadeesh	
			// Bug 23743186- SAP UME: ROLE REQUEST IS NOT Generating Request ID IN GRC
			// condition modified to fix the issue.
			else if(attr.getName().contains(UMEGROUP)){
				provItemType = "ROL";
				//provItemAction = "006";
				roleType = "GRP";
			}else{
				provItemType = "ROL";
				//provItemAction = "006";
				roleType = "SIN";
			}
			if(attr.getValue()== null){
				continue;
			}
			// Condition to switch proper code depends on the request to 
			// support both SAP UM and SAP UME -- Jagadeesh	
			if(attr.getName().equals(ROLES_NAME) || attr.getName().equals(PROFILE_NAME)){
				for(Object obj : attr.getValue()){
					embeddedObject = (EmbeddedObject)obj;
					gracSWsUaIpReqlineitem = new GracSWsUaIpReqlineitem();
					for(Attribute attribute : embeddedObject.getAttributes()){
						attrName = util.splitAttrName(attribute.getName());
						valueList = attribute.getValue();
						LOG.info("No. of values with attribute {0} : {1}",attribute.getName(),
								valueList.size());
						if(valueList.size() > 1) {
							LOG.warn("More than 1 values found with attribute {0}", 
									attribute.getName());
						}
						LOG.info("value of attribute:[{0}]",valueList);
						if(valueList.get(0) != null){
							value = valueList.get(0).toString();
							value = util.filterAttrValue(value);
							util.getMethod(clazz, util.getMethodName(
									clazz, attrName, "set"), String.class).invoke(
									gracSWsUaIpReqlineitem, value);
							if("itemName".equalsIgnoreCase(attrName)){
								itemNameValues = util.getValues(valueList.get(0).toString(),"~");
							}
						}
					}
					gracSWsUaIpReqlineitem.setProvItemType(provItemType);
					gracSWsUaIpReqlineitem.setProvAction(
							getAttrValue(otherReqLineItemAttrSet, "provItemAction"));
					//gracSWsUaIpReqlineitem.setProvAction(provItemAction);
					gracSWsUaIpReqlineitem.setRoleType(roleType);
					if(gracSWsUaIpReqlineitem.getValidFrom() != null 
							&& gracSWsUaIpReqlineitem.getValidFrom().equals("0")){
						gracSWsUaIpReqlineitem.setValidFrom(null);
					} else if(gracSWsUaIpReqlineitem.getValidFrom() != null){
						vFromLong = Long.valueOf(gracSWsUaIpReqlineitem.getValidFrom());
						if(vFromLong>0){
							gracSWsUaIpReqlineitem.setValidFrom(
									WS_DATEFORMAT.format(new Date(vFromLong)));
						}
					}
					if(gracSWsUaIpReqlineitem.getValidTo() != null 
							&& gracSWsUaIpReqlineitem.getValidTo().equals("0")){
						gracSWsUaIpReqlineitem.setValidTo(null);
					} else if(gracSWsUaIpReqlineitem.getValidTo() != null){
						vToLong = Long.valueOf(gracSWsUaIpReqlineitem.getValidTo());
						if(vToLong>0){
							gracSWsUaIpReqlineitem.setValidTo(
									WS_DATEFORMAT.format(new Date(vToLong)));
						}
					}
					//to handle OIM-R2 add/remove entitlement without system id
					if(gracSWsUaIpReqlineitem.getConnector()== null 
							|| gracSWsUaIpReqlineitem.getConnector().trim().length()==0){
						LOG.info("SysID not exist so using sysID which is prefixed with role name");
						if(itemNameValues != null){
							LOG.info("-->Sys ID:[{0}]", itemNameValues[0]);
							LOG.info("-->Item Name:[{0}]", itemNameValues[1]);
							gracSWsUaIpReqlineitem.setConnector(itemNameValues[0]);
						} else{
							LOG.info("itemNameValues object is null, setConnector failed");
						}
					}
					reqlineitemList.add(gracSWsUaIpReqlineitem);
				}
			}else{
				// Code to handle SAP UME Child Data -- Jagadeesh
				for(Object obj : attr.getValue()){
					gracSWsUaIpReqlineitem = new GracSWsUaIpReqlineitem();					
					// Start Bug 23743186- SAP UME: ROLE REQUEST IS NOT Generating Request ID IN GRC
					String attributeName[] = attr.getName().split(";");
					attrName = attributeName[1];
					// End Bug 23743186- SAP UME: ROLE REQUEST IS NOT Generating Request ID IN GRC											
						valueList = attr.getValue();
						LOG.info("No. of values with attribute {0} : {1}",attr.getName(),
								valueList.size());
						if(valueList.size() > 1) {
							LOG.warn("More than 1 values found with attribute {0}", 
									attr.getName());
						}
						LOG.info("value of attribute:[{0}]",valueList);
						if(valueList.get(0) != null){
							value = valueList.get(0).toString();
							util.getMethod(clazz, util.getMethodName(
									clazz, attrName, "set"), String.class).invoke(
									gracSWsUaIpReqlineitem, value);
					}
					gracSWsUaIpReqlineitem.setProvItemType(provItemType);
					gracSWsUaIpReqlineitem.setProvAction(
					getAttrValue(otherReqLineItemAttrSet, "provItemAction"));
					//gracSWsUaIpReqlineitem.setProvAction(provItemAction);
					gracSWsUaIpReqlineitem.setRoleType(roleType);
					gracSWsUaIpReqlineitem.setConnector(_gracSWsReqhdr.getReqInitSystem());
					
					if(gracSWsUaIpReqlineitem.getValidFrom() != null 
							&& gracSWsUaIpReqlineitem.getValidFrom().equals("0")){
						gracSWsUaIpReqlineitem.setValidFrom(null);
					} else if(gracSWsUaIpReqlineitem.getValidFrom() != null){
						vFromLong = Long.valueOf(gracSWsUaIpReqlineitem.getValidFrom());
						if(vFromLong>0){
							gracSWsUaIpReqlineitem.setValidFrom(
									WS_DATEFORMAT.format(new Date(vFromLong)));
						}
					}
					if(gracSWsUaIpReqlineitem.getValidTo() != null 
							&& gracSWsUaIpReqlineitem.getValidTo().equals("0")){
						gracSWsUaIpReqlineitem.setValidTo(null);
					} else if(gracSWsUaIpReqlineitem.getValidTo() != null){
						vToLong = Long.valueOf(gracSWsUaIpReqlineitem.getValidTo());
						if(vToLong>0){
							gracSWsUaIpReqlineitem.setValidTo(
									WS_DATEFORMAT.format(new Date(vToLong)));
						}
					}
					reqlineitemList.add(gracSWsUaIpReqlineitem);
				}			
			}
		}
		return gracTWsUaIpReqlineitem;
	}

	/**
	 * Method constructing parameter object
	 * @param parameterAttrSet
	 * @return
	 * @throws Exception 
	 */
	private GracTWsUaIpPrameterList populateParameter(
			Set<Attribute> parameterAttrSet) throws Exception {
		GracTWsUaIpPrameterList gracTWsUaIpPrameterList = new GracTWsUaIpPrameterList();
		List<GracSWsUaIpPrameterList> ipPrameterLists = gracTWsUaIpPrameterList.getItem();
		GracSWsUaIpPrameterList ipPrameterList = null;
		Class<? extends GracSWsUaIpPrameterList> clazz = GracSWsUaIpPrameterList.class;
		String attrName = null;
		String value = null;
		List<Object> valueList = null;
		EmbeddedObject embeddedObject = null;
		for(Attribute attr :parameterAttrSet){
			for(Object obj : attr.getValue()){
				embeddedObject = (EmbeddedObject)obj;
				ipPrameterList = new GracSWsUaIpPrameterList();
				for(Attribute attribute : embeddedObject.getAttributes()){
					attrName = util.splitAttrName(attribute.getName());
					valueList = attribute.getValue();
					LOG.info("No. of values with attribute {0} : {1}",attribute.getName(),
							valueList.size());
					if(valueList.size() > 1) {
						LOG.warn("More than 1 values found with attribute {0}", 
								attribute.getName());
					}
					value = util.filterAttrValue(valueList.get(0).toString());
					util.getMethod(clazz, util.getMethodName(
							clazz, attrName, "set"), String.class).invoke(ipPrameterList, value);
				}
				ipPrameterLists.add(ipPrameterList);
			}
		}
		return gracTWsUaIpPrameterList;
	}	
	

	/**
	 * Method constructing user group object
	 * @param userGroupAttrSet
	 * @return
	 * @throws Exception
	 */
	private GracTWsUaIpUserGroup populateUserGroup(
			Set<Attribute> userGroupAttrSet) throws Exception {
		
		GracTWsUaIpUserGroup gracTWsUaIpUserGroup  = new GracTWsUaIpUserGroup();
		List<GracSWsUaIpUserGroup> gracSWsUaIpUserGroupList = gracTWsUaIpUserGroup.getItem();
		GracSWsUaIpUserGroup gracSWsUaIpUserGroup = null;
		Class<? extends GracSWsUaIpUserGroup> clazz = GracSWsUaIpUserGroup.class;
		String attrName = null;
		String value = null;
		List<Object> valueList = null;
		for(Attribute attribute :userGroupAttrSet){
			attrName = util.splitAttrName(attribute.getName());
			valueList = attribute.getValue();
			for(Object valObject: valueList){
				value = util.filterAttrValue(valObject.toString());
				gracSWsUaIpUserGroup = new GracSWsUaIpUserGroup();
				util.getMethod(clazz, util.getMethodName(
						clazz, attrName, "set"), String.class).invoke(gracSWsUaIpUserGroup, value);
				gracSWsUaIpUserGroupList.add(gracSWsUaIpUserGroup);
			}
		}
		return gracTWsUaIpUserGroup;
	}

	/**
	 * Method constructing custom field value object 
	 * @param custfldValAttrSet
	 * @return
	 */
	private GracTWsUaIpCustfldVal populateCustomField(
			Set<Attribute> custfldValAttrSet) {
		GracTWsUaIpCustfldVal gracTWsUaIpCustfldVal = new GracTWsUaIpCustfldVal();
		List<GracSWsUaIpCustfldVal> custfldValList = gracTWsUaIpCustfldVal.getItem();
		GracSWsUaIpCustfldVal gracSWsUaIpCustfldVal = null;
		String attrName = null;
		String value = null;
		List<Object> valueList = null;
		for(Attribute attribute : custfldValAttrSet){
			gracSWsUaIpCustfldVal = new GracSWsUaIpCustfldVal();
			attrName = util.splitAttrName(attribute.getName());
			valueList = attribute.getValue();
			LOG.info("No. of values with attribute {0} : {1}",attribute.getName(),valueList.size());
			if(valueList.size() > 1) {
				LOG.warn("More than 1 values found with attribute {0}", attribute.getName());
			}
			value = util.filterAttrValue(valueList.get(0).toString());
			gracSWsUaIpCustfldVal.setFieldname(attrName);
			gracSWsUaIpCustfldVal.setValue(value);
			custfldValList.add(gracSWsUaIpCustfldVal);
		}
		return gracTWsUaIpCustfldVal;
	}

	/**
	 * Method retrieves 1st object as String of ValueList
	 * @param attrSet
	 * @param attrbuteName
	 * @return
	 */
	private String getAttrValue(Set<Attribute> attrSet, String attrbuteName){
		String attrName = null;
		List<Object> valueList = null;
		for(Attribute otherReqAttr :attrSet){
			attrName = util.splitAttrName(otherReqAttr.getName());
			if(attrbuteName.equalsIgnoreCase(attrName)){
				valueList = otherReqAttr.getValue();
				return valueList.get(0).toString();
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param mName
	 * @return
	 */
	/*private String toFirstLetterCaps(String mName){
		if(mName == null){
			return mName;
		}
		StringBuffer methodName = new StringBuffer(); 
		methodName.append(mName.substring(0, 1).toUpperCase());
		methodName.append(mName.substring(1));
		return methodName.toString();
	}*/
}

