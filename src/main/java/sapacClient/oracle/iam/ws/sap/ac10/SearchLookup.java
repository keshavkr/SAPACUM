/**
 * 
 */
package oracle.iam.ws.sap.ac10;

import static oracle.iam.ws.sap.util.WsClientUtil.KEY_AC_URL;
import static oracle.iam.ws.sap.util.WsClientUtil.KEY_CONFIG_DATA;
import static oracle.iam.ws.sap.util.WsClientUtil.RESULT;
import static oracle.iam.ws.sap.util.WsClientUtil.STATUS;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;

import oracle.iam.ws.sap.ac10.lookup.GRACLOOKUPWS;
import oracle.iam.ws.sap.ac10.lookup.GracSOmObjectId;
import oracle.iam.ws.sap.ac10.lookup.GracSWsApiCommType;
import oracle.iam.ws.sap.ac10.lookup.GracSWsApiCustomFldLst;
import oracle.iam.ws.sap.ac10.lookup.GracSWsApiMessage;
import oracle.iam.ws.sap.ac10.lookup.GracSWsApiMthAction;
import oracle.iam.ws.sap.ac10.lookup.GracSWsApiOmObjType;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuIpCstmFldNam;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuIpCustFldVal;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuIpItmPrvActns;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuIpOmObjectVal;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpBproc;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpBsubproc;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpBusProcWrap;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpBusSprocWrap;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpCommnTypWrap;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpCritLvlWrap;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpCritlvl;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpCstflValWrap;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpCustFldWrap;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpCustomFldVal;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpDdicDomain;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpEmptype;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpEmptypeWrap;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpFuncArea;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpFuncAreaWrap;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpItemActnWrap;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpLandscapeWrap;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpOmObjIdWrap;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpOmObjtypWrap;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpPhaseWrap;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpPriority;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpPriorityWrap;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpPrjRelsWrap;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpPrjrel;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpReqActnDtls;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpReqActnWrap;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpReqTypWrap;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpReqtype;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpRlsens;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpRlstat;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpRltype;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpRoleSensWrap;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpRoleStatWrap;
import oracle.iam.ws.sap.ac10.lookup.GracSWsLuOpRoleTypeWrap;
import oracle.iam.ws.sap.ac10.lookup.GrfnSWsLuOpContrGrp;
import oracle.iam.ws.sap.ac10.lookup.Service;
import oracle.iam.ws.sap.util.WsClientUtil;

import org.identityconnectors.common.logging.Log;


/**
 * @author ranjith.kumar
 *
 * Web service client class to populate input data and invoke SAP GRC AC10 web service 
 * GRAC_LOOKUP_WS for lookup data 
 */
public class SearchLookup {

	private static final Log LOG = Log.getLog(SearchLookup.class);
	private GRACLOOKUPWS _port = null;
	
	public static final String VALUE_T = "T";
	public static final String OBJECT_CLASS = "ObjectClass";
	
	public static final String KEY_BUS_PROC = "BusProc";
	public static final String KEY_BUS_SUBPROC = "BusSubProc";
	public static final String KEY_COMM_TYPE = "CommType";
	public static final String KEY_CRITICAL_LVL = "CriticalLevel";
	public static final String KEY_EMP_TYPE = "EmployeeType";
	public static final String KEY_FUNC_AREA = "FunctionArea";
	public static final String KEY_ITEM_PROVTYPE = "ItemProvType";
	public static final String KEY_LANDSCAPE = "Landscape";
	public static final String KEY_OMOBJ_TYPE = "OmObjectType";
	public static final String KEY_PHASE = "Phase";
	public static final String KEY_PRIORITY_TYPE = "PriorityType";
	public static final String KEY_PROJ_RELEASE = "ProjectRelease";
	public static final String KEY_REQ_CUSTFLDS = "ReqCustFlds";
	public static final String KEY_REQ_TYPE = "RequestType";
	public static final String KEY_ROLE_CUSTFLDS = "RoleCustFlds";
	public static final String KEY_ROLE_SENSITIVITY = "RoleSensitivity";
	public static final String KEY_ROLE_STATUS = "RoleStatus";
	public static final String KEY_ROLE_TYPE = "RoleType";
	
	public static final String KEY_CUSTFLD_VALUES = "CustomFieldVal";
	public static final String KEY_ITEMPROV_ACTIONTYPE = "ItemProvActionType";
	public static final String KEY_OMOBJECT_VALUE = "OmObjectValue";
	
	//input parameters of web service
	private String busProc = null;
	private String busSubProc = null;
	private String communicationType = null; 
	private String criticalLevel = null;
	private String employeeType = null;
	private String functionArea = null;
	private String itemProvType = null; 
	private String landscape = null;
	private String language = null ;
	private String omObjectType = null; 
	private String phase = null;
	private String priorityType = null;
	private String projectRelease = null;
	private String requestCustomFields = null;
	private String requestType = null; 
	private String roleCustomFields = null; 
	private String roleSensitivity = null; 
	private String roleStatus = null; 
	private String roleType = null;
	private GracSWsLuIpCustFldVal customFieldValues = null;
	private GracSWsLuIpItmPrvActns itemProvActionType = null;
	private GracSWsLuIpOmObjectVal omObjectValue = null;
	
	//output params
	private Holder<GracSWsLuOpBusProcWrap> busProcList = null;
	private Holder<GracSWsLuOpBusSprocWrap> busSubProcList = null;
	private Holder<GracSWsLuOpCommnTypWrap> communicationTypeList = null;
	private Holder<GracSWsLuOpCritLvlWrap> criticalLevelList = null;
	private Holder<GracSWsLuOpCstflValWrap> customFieldDetails = null;
	private Holder<GracSWsLuOpEmptypeWrap> employeeTypeList = null;
	private Holder<GracSWsLuOpFuncAreaWrap> functionAreaList = null;
	private Holder<GracSWsLuOpItemActnWrap> itemProvActionList = null;
	private Holder<GracSWsLuOpReqActnWrap> itemProvTypeList = null;
	private Holder<GracSWsLuOpLandscapeWrap> landscapeList = null;
	private Holder<GracSWsLuOpOmObjIdWrap> omObjectIdList = null;
	private Holder<GracSWsLuOpOmObjtypWrap> omObjectTypeList = null;
	private Holder<GracSWsLuOpPhaseWrap> phaseList = null;
	private Holder<GracSWsLuOpPriorityWrap> priorityTypeList = null;
	private Holder<GracSWsLuOpPrjRelsWrap> projectReleaseList = null;
	private Holder<GracSWsLuOpCustFldWrap> requestCustomFieldsList = null;
	private Holder<GracSWsLuOpReqTypWrap> requestTypeList = null;
	private Holder<GracSWsLuOpCustFldWrap> roleCustomFieldsList = null;
	private Holder<GracSWsLuOpRoleSensWrap> roleSensitivityList = null;
	private Holder<GracSWsLuOpRoleStatWrap> roleStatusList = null;
	private Holder<GracSWsLuOpRoleTypeWrap> roleTypeList = null;
	
	private StringBuffer statusMsg = null;
	
	/**
	 * Instance of util class
	 */
	private WsClientUtil util = null;
	


	/**
	 * Method invokes SAP GRC AC10 web service to retrieve lookup values 
	 * @param inputDataMap
	 * @return
	 */
	public Map<String, Object> callService(Map<String, Object> inputDataMap){
		Map<String, Object> outputMap = new HashMap<String, Object>(5, 0.75f);
		Map<String, String> resultMap = null;
		util = new WsClientUtil();
		LOG.info("callService - SearchLookup input:[{0}]", inputDataMap);
		try {
			marshalInputData(inputDataMap);
			
			Map<String, Object> configMap = (Map)inputDataMap.get(KEY_CONFIG_DATA);
			configMap.put(KEY_AC_URL, configMap.get("otherLookupAccessURL"));
			
			//URL url = getClass().getClassLoader().getResource("/wsdl/GRAC_LOOKUP_WS.WSDL");
			StringBuffer wsdlPath = new StringBuffer("file:/");
			wsdlPath.append(configMap.get("wsdlFilePath"));
			wsdlPath.append("/GRAC_LOOKUP_WS.WSDL");
			URL url = new URL(wsdlPath.toString());
			
			
		    QName qName = new QName("urn:sap-com:document:sap:soap:functions:mc-style", "service");
			Service service = new Service(url, qName);
			_port = service.getBinding();
	
			util.setCredentials((BindingProvider)_port, configMap, true);
			LOG.error("Perf: callService-SearchLookup entered");
			_port.gracIdmLookupServices(busProc, busSubProc, communicationType, 
					criticalLevel, customFieldValues, employeeType, functionArea, 
					itemProvActionType, itemProvType, landscape, language, omObjectType, 
					omObjectValue, phase, priorityType, projectRelease, requestCustomFields, 
					requestType, roleCustomFields, roleSensitivity, roleStatus, roleType, 
					
					busProcList, busSubProcList, communicationTypeList, criticalLevelList, 
					customFieldDetails, employeeTypeList, functionAreaList, itemProvActionList, 
					itemProvTypeList, landscapeList, omObjectIdList, omObjectTypeList, phaseList, 
					priorityTypeList, projectReleaseList, requestCustomFieldsList, requestTypeList, 
					roleCustomFieldsList, roleSensitivityList, roleStatusList, roleTypeList);
			LOG.error("Perf: callService-SearchLookup exited");	
			resultMap = marshalOutputData(inputDataMap);
			outputMap.put(STATUS, statusMsg.toString());
			outputMap.put(RESULT, resultMap);
		} catch(Exception e) {
			LOG.error(e, "Search Lookup failed");
			statusMsg = new StringBuffer("1_");
			statusMsg.append(e.getMessage());
			outputMap.put(STATUS, statusMsg.toString());
		}
		LOG.info("callService - SearchLookup output:[{0}]", outputMap);
		return outputMap;
	}
	
	

	/**
	 * 
	 * @param inputDataMap
	 * @return
	 */
	private Map<String, String> marshalOutputData(Map<String, Object> inputDataMap) {
		Map<String, String> resultMap = new HashMap<String, String>(10, 0.75f);
		if(KEY_BUS_PROC.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			resultMap = marshalOutputData(busProcList.value);
		} else if(KEY_BUS_SUBPROC.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			resultMap = marshalOutputData(busSubProcList.value);
		} else if(KEY_COMM_TYPE.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			resultMap = marshalOutputData(communicationTypeList.value);
		} else if(KEY_CRITICAL_LVL.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			resultMap = marshalOutputData(criticalLevelList.value);
		} else if(KEY_CUSTFLD_VALUES.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			resultMap = marshalOutputData(customFieldDetails.value);
		} else if(KEY_EMP_TYPE.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			resultMap = marshalOutputData(employeeTypeList.value);
		} else if(KEY_FUNC_AREA.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			resultMap = marshalOutputData(functionAreaList.value);
		} else if(KEY_ITEMPROV_ACTIONTYPE.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			resultMap = marshalOutputData(itemProvActionList.value);
		} else if(KEY_ITEM_PROVTYPE.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			resultMap = marshalOutputData(itemProvTypeList.value);
		} else if(KEY_LANDSCAPE.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			resultMap = marshalOutputData(landscapeList.value);
		} else if(KEY_OMOBJ_TYPE.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			resultMap = marshalOutputData(omObjectTypeList.value);
		} else if(KEY_OMOBJECT_VALUE.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			resultMap = marshalOutputData(omObjectIdList.value);
		} else if(KEY_PHASE.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			resultMap = marshalOutputData(phaseList.value);
		} else if(KEY_PRIORITY_TYPE.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			resultMap = marshalOutputData(priorityTypeList.value);
		} else if(KEY_PROJ_RELEASE.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			resultMap = marshalOutputData(projectReleaseList.value);
		} else if(KEY_REQ_CUSTFLDS.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			resultMap = marshalOutputData(requestCustomFieldsList.value);
		} else if(((String)inputDataMap.get("ObjectClass")).equalsIgnoreCase(KEY_REQ_TYPE)){
			resultMap = marshalOutputData(requestTypeList.value);
		} else if(KEY_ROLE_CUSTFLDS.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			resultMap = marshalOutputData(roleCustomFieldsList.value);
		} else if(KEY_ROLE_SENSITIVITY.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			resultMap = marshalOutputData(roleSensitivityList.value);
		} else if(KEY_ROLE_STATUS.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			resultMap = marshalOutputData(roleStatusList.value);
		} else if(KEY_ROLE_TYPE.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			resultMap = marshalOutputData(roleTypeList.value);
		}
		return resultMap;
	}

	/**
	 * 
	 * @param inputDataMap
	 */
	private void marshalInputData(Map<String, Object> inputDataMap) {
		if(inputDataMap.get(WsClientUtil.KEY_LANGUAGE)!= null){
			language = inputDataMap.get(WsClientUtil.KEY_LANGUAGE).toString();
		}
		
		if(KEY_BUS_PROC.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			busProc = VALUE_T;
			busProcList = new Holder<GracSWsLuOpBusProcWrap>();
		} else if(KEY_BUS_SUBPROC.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			busSubProc = VALUE_T;
			busSubProcList = new Holder<GracSWsLuOpBusSprocWrap>();
		} else if(KEY_COMM_TYPE.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			communicationType = VALUE_T;
			communicationTypeList = new Holder<GracSWsLuOpCommnTypWrap>();
		} else if(KEY_CRITICAL_LVL.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			criticalLevel = VALUE_T;
			criticalLevelList = new Holder<GracSWsLuOpCritLvlWrap>();
		} else if(KEY_CUSTFLD_VALUES.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			customFieldValues = new GracSWsLuIpCustFldVal();
			List<GracSWsLuIpCstmFldNam> itemList = customFieldValues.getCustomFieldList().getItem();
			GracSWsLuIpCstmFldNam fldNam = new GracSWsLuIpCstmFldNam();
			fldNam.setCustomFldName((String)inputDataMap.get("CustomFieldName"));
			itemList.add(fldNam);
			customFieldDetails = new Holder<GracSWsLuOpCstflValWrap>();
		} else if(KEY_EMP_TYPE.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			employeeType = VALUE_T;
			employeeTypeList = new Holder<GracSWsLuOpEmptypeWrap>();
		} else if(KEY_FUNC_AREA.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			functionArea = VALUE_T;
			functionAreaList = new  Holder<GracSWsLuOpFuncAreaWrap>();
		} else if(KEY_ITEMPROV_ACTIONTYPE.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			itemProvActionType = new GracSWsLuIpItmPrvActns();
			itemProvActionType.setItemType((String)inputDataMap.get("ItemType"));
			itemProvActionList = new Holder<GracSWsLuOpItemActnWrap>();
		} else if(KEY_ITEM_PROVTYPE.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			itemProvType = VALUE_T;
			itemProvTypeList = new Holder<GracSWsLuOpReqActnWrap>();
		} else if(KEY_LANDSCAPE.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			landscape = VALUE_T;
			landscapeList = new Holder<GracSWsLuOpLandscapeWrap>();
		} else if(KEY_OMOBJ_TYPE.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			omObjectType = VALUE_T;
			omObjectTypeList = new Holder<GracSWsLuOpOmObjtypWrap>();
		} else if(KEY_OMOBJECT_VALUE.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			omObjectValue = new GracSWsLuIpOmObjectVal();
			omObjectValue.setOmObjType((String)inputDataMap.get("OmObjType"));
			omObjectValue.setSystem((String)inputDataMap.get("System"));
			omObjectIdList = new Holder<GracSWsLuOpOmObjIdWrap>();
		} else if(KEY_PHASE.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			phase = VALUE_T;
			phaseList = new Holder<GracSWsLuOpPhaseWrap>();
		} else if(KEY_PRIORITY_TYPE.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			priorityType = VALUE_T;
			priorityTypeList = new Holder<GracSWsLuOpPriorityWrap>();
		} else if(KEY_PROJ_RELEASE.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			projectRelease = VALUE_T;
			projectReleaseList = new Holder<GracSWsLuOpPrjRelsWrap>();
		} else if(KEY_REQ_CUSTFLDS.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			requestCustomFields = VALUE_T;
			requestCustomFieldsList = new Holder<GracSWsLuOpCustFldWrap>();
		} else if(KEY_REQ_TYPE.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			requestType = VALUE_T;
			requestTypeList = new Holder<GracSWsLuOpReqTypWrap>();
		} else if(KEY_ROLE_CUSTFLDS.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			roleCustomFields = VALUE_T;
			roleCustomFieldsList = new Holder<GracSWsLuOpCustFldWrap>();
		} else if(KEY_ROLE_SENSITIVITY.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			roleSensitivity = VALUE_T;
			roleSensitivityList = new Holder<GracSWsLuOpRoleSensWrap>();
		} else if(KEY_ROLE_STATUS.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			roleStatus = VALUE_T;
			roleStatusList = new Holder<GracSWsLuOpRoleStatWrap>();
		} else if(KEY_ROLE_TYPE.equalsIgnoreCase((String)inputDataMap.get(OBJECT_CLASS))){
			roleType = VALUE_T;
			roleTypeList = new Holder<GracSWsLuOpRoleTypeWrap>();
		}
	}
	
	/**
	 * requestTypeList
	 * @param value
	 * @return
	 */
	private Map<String, String> marshalOutputData(GracSWsLuOpReqTypWrap value ) {
		setStatusMsg(value.getMsgReturn());
		List<GracSWsLuOpReqtype> list = value.getRequestType().getItem();
		Map<String, String> resultMap = new HashMap<String, String>(list.size());
		for(GracSWsLuOpReqtype reqtype : list){
			resultMap.put(reqtype.getReqtype(),reqtype.getReqtypename());
		}
		return resultMap;
	}
	
	/**
	 * busProcList
	 * @param value
	 * @return
	 */
	private Map<String, String> marshalOutputData(GracSWsLuOpBusProcWrap value) {
		setStatusMsg(value.getMsgReturn());
		List<GracSWsLuOpBproc> list = value.getBusProcess().getItem();
		Map<String, String> resultMap = new HashMap<String, String>(list.size());
		for(GracSWsLuOpBproc bproc : list){
			resultMap.put(bproc.getBproc(), bproc.getDescn());
		}
		return resultMap;
	}
	
	/**
	 * criticalLevelList
	 * @param value
	 * @return
	 */
	private Map<String, String> marshalOutputData(GracSWsLuOpCritLvlWrap value) {
		setStatusMsg(value.getMsgReturn());
		List<GracSWsLuOpCritlvl> list = value.getCriticalLvl().getItem();
		Map<String, String> resultMap = new HashMap<String, String>(list.size());
		for(GracSWsLuOpCritlvl critlvl: list){
			resultMap.put(critlvl.getCritlvl(),critlvl.getDescn());
		}
		return resultMap;
	}

	/**
	 * customFieldDetails
	 * @param value
	 * @return
	 */
	private Map<String, String> marshalOutputData(GracSWsLuOpCstflValWrap value) {
		setStatusMsg(value.getMsgReturn());
		List<GracSWsLuOpCustomFldVal> list = value.getCustomFieldValueList().getItem();
		Map<String, String> resultMap = new HashMap<String, String>(list.size());
		for(GracSWsLuOpCustomFldVal  customFldVal :	list){
			resultMap.put(customFldVal.getCustomFieldName(),customFldVal.getCustomFieldText());
		}
		return resultMap;
	}
	
	/**
	 * communicationTypeList
	 * @param value
	 * @return
	 */
	private Map<String, String> marshalOutputData(GracSWsLuOpCommnTypWrap value) {
		setStatusMsg(value.getMsgReturn());
		List<GracSWsApiCommType> list = value.getCommunicationType().getItem();
		Map<String, String> resultMap = new HashMap<String, String>(list.size());
		for(GracSWsApiCommType apiCommType : list){
			resultMap.put(apiCommType.getCommType(),apiCommType.getCommTypeText());
		}
		return resultMap;
	}

	/**
	 * busSubProcList
	 * @param value
	 * @return
	 */
	private Map<String, String> marshalOutputData(GracSWsLuOpBusSprocWrap value) {
		setStatusMsg(value.getMsgReturn());
		List<GracSWsLuOpBsubproc> list = value.getBusSubProc().getItem();
		Map<String, String> resultMap = new HashMap<String, String>(list.size());
		for(GracSWsLuOpBsubproc bsubproc: list){
			resultMap.put(bsubproc.getBsubproc(),bsubproc.getDescn());
		}
		return resultMap;
	}
	
	/**
	 * employeeTypeList
	 * @param value
	 * @return
	 */
	private Map<String, String> marshalOutputData(GracSWsLuOpEmptypeWrap value) {
		setStatusMsg(value.getMsgReturn());
		List<GracSWsLuOpEmptype> list = value.getEmployeeType().getItem();
		Map<String, String> resultMap = new HashMap<String, String>(list.size());
		for (GracSWsLuOpEmptype emptype : list){
			resultMap.put(emptype.getEmptypeid(),emptype.getEmptypename());
		}
		return resultMap;
	}

	/**
	 * functionAreaList
	 * @param value
	 * @return
	 */
	private Map<String, String> marshalOutputData(GracSWsLuOpFuncAreaWrap value) {
		setStatusMsg(value.getMsgReturn());
		List<GracSWsLuOpFuncArea> list = value.getFunctionArea().getItem();
		Map<String, String> resultMap = new HashMap<String, String>(list.size());
		for(GracSWsLuOpFuncArea funcArea : list){
			resultMap.put(funcArea.getFunarea() ,funcArea.getDescn());
		}
		return resultMap;
	}
	
	/**
	 * itemProvActionList
	 * @param value
	 * @return
	 */
	private Map<String, String> marshalOutputData(GracSWsLuOpItemActnWrap value) {
		setStatusMsg(value.getMsgReturn());
		List<GracSWsLuOpReqActnDtls> list = value.getItemAction().getItem();
		Map<String, String> resultMap = new HashMap<String, String>(list.size());
		StringBuilder strkey = null;
		StringBuilder strValue = null;
		for(GracSWsLuOpReqActnDtls actnDtls :list){
			strkey = new StringBuilder(actnDtls.getItemProvType());
			strkey.append("~");
			strkey.append(actnDtls.getProvAction());
			strValue = new StringBuilder(actnDtls.getItemProvType());
			strValue.append("~");
			strValue.append(actnDtls.getActionDescn());
			resultMap.put(strkey.toString(), strValue.toString());
		}
		return resultMap;
	}

	/**
	 * itemProvTypeList
	 * @param value
	 * @return
	 */
	private Map<String, String> marshalOutputData(GracSWsLuOpReqActnWrap value) {
		setStatusMsg(value.getMsgReturn());
		List<GracSWsLuOpDdicDomain> list = value.getRequestAction().getItem();
		Map<String, String> resultMap = new HashMap<String, String>(list.size());
		for(GracSWsLuOpDdicDomain domain: list){
			resultMap.put(domain.getVal(), domain.getText());
		}
		return resultMap;
	}
	
	/**
	 * landscapeList
	 * @param value
	 * @return
	 */
	private Map<String, String> marshalOutputData(GracSWsLuOpLandscapeWrap value) {
		setStatusMsg(value.getMsgReturn());
		List<GrfnSWsLuOpContrGrp>  list = value.getLandscape().getItem();
		Map<String, String> resultMap = new HashMap<String, String>(list.size());
		for(GrfnSWsLuOpContrGrp contrGrp : list){
			resultMap.put(contrGrp.getConnectionType(), contrGrp.getConnectorGrp());
		}
		return resultMap;
	}
	
	/**
	 * omObjectTypeList
	 * @param value
	 * @return
	 */
	private Map<String, String> marshalOutputData(GracSWsLuOpOmObjtypWrap value) {
		setStatusMsg(value.getMsgReturn());
		List<GracSWsApiOmObjType> list = value.getOmObjTypList().getItem();
		Map<String, String> resultMap = new HashMap<String, String>(list.size());
		for (GracSWsApiOmObjType objType : list){
			resultMap.put(objType.getValue(), objType.getText());
		}
		return resultMap;
	}
	
	/**
	 * omObjectIdList(value)
	 * @param value
	 * @return
	 */
	private Map<String, String> marshalOutputData(GracSWsLuOpOmObjIdWrap value) {
		setStatusMsg(value.getMsgReturn());
		List<GracSOmObjectId> list = value.getOmObjectIdList().getItem();
		Map<String, String> resultMap = new HashMap<String, String>(list.size());
		for (GracSOmObjectId objectId: list){
			resultMap.put(objectId.getOmObjectId(), objectId.getOmObjectText());
		}
		return resultMap;
	}
	
	/**
	 * phaseList
	 * @param value
	 * @return
	 */
	private Map<String, String> marshalOutputData(GracSWsLuOpPhaseWrap value) {
		setStatusMsg(value.getMsgReturn());
		List<GracSWsApiMthAction> list = value.getPhase().getItem();
		Map<String, String> resultMap = new HashMap<String, String>(list.size());
		for (GracSWsApiMthAction mthAction :list){
			resultMap.put(mthAction.getMthAction(),mthAction.getDescn());
		}
		return resultMap;
	}	

	private Map<String, String> marshalOutputData(GracSWsLuOpPriorityWrap value) {
		setStatusMsg(value.getMsgReturn());
		List<GracSWsLuOpPriority> list =  value.getPriority().getItem();
		Map<String, String> resultMap = new HashMap<String, String>(list.size());
		for (GracSWsLuOpPriority  priority : list)
			resultMap.put(priority.getPrioritype(),priority.getPrioritypename());
		return resultMap;
	}

	/**
	 * projectReleaseList
	 * @param value
	 * @return
	 */
	private Map<String, String> marshalOutputData(GracSWsLuOpPrjRelsWrap value) {
		setStatusMsg(value.getMsgReturn());
		List<GracSWsLuOpPrjrel> list = value.getProjectRelease().getItem();
		Map<String, String> resultMap = new HashMap<String, String>(list.size());
		for(GracSWsLuOpPrjrel prjrel : list){
			resultMap.put(prjrel.getPrjrel(), prjrel.getDescn());
		}
		return resultMap;
	}

	/**
	 * requestCustomFieldsList
	 * @param value
	 * @return
	 */
	private Map<String, String> marshalOutputData(GracSWsLuOpCustFldWrap value) {
		setStatusMsg(value.getMsgReturn());
		List<GracSWsApiCustomFldLst> list = value.getCustomFieldList().getItem();
		Map<String, String> resultMap = new HashMap<String, String>(list.size());
		for(GracSWsApiCustomFldLst customFldLst : list){
			resultMap.put(customFldLst.getFieldname(), customFldLst.getFieldtext());
		}
		return resultMap;
	}

	/**
	 * roleSensitivityList
	 * @param value
	 * @return
	 */
	private Map<String, String> marshalOutputData(GracSWsLuOpRoleSensWrap value) {
		setStatusMsg(value.getMsgReturn());
		List<GracSWsLuOpRlsens> list = value.getRoleSensitivity().getItem();
		Map<String, String> resultMap = new HashMap<String, String>(list.size());
		for(GracSWsLuOpRlsens opRlsens : value.getRoleSensitivity().getItem()){
			resultMap.put(opRlsens.getSensitivity(),opRlsens.getDescn());
		}
		return resultMap;
	}

	/**
	 * roleStatusList
	 * @param value
	 * @return
	 */
	private Map<String, String> marshalOutputData(GracSWsLuOpRoleStatWrap value) {
		setStatusMsg(value.getMsgReturn());
		List<GracSWsLuOpRlstat> list = value.getRoleStatus().getItem();
		Map<String, String> resultMap = new HashMap<String, String>(list.size());
		for (GracSWsLuOpRlstat rlstat: list){
			resultMap.put(rlstat.getRoleStatus(),rlstat.getDescn());
		}
		return resultMap;
	}

	/**
	 * roleTypeList
	 * @param value
	 * @return
	 */
	private Map<String, String> marshalOutputData(GracSWsLuOpRoleTypeWrap value) {
		setStatusMsg(value.getMsgReturn());
		List<GracSWsLuOpRltype> list = value.getRoleType().getItem();
		Map<String, String> resultMap = new HashMap<String, String>(list.size());
		for(GracSWsLuOpRltype rltype : list){
			resultMap.put(rltype.getRoleType(),rltype.getDescn());
		}
		return resultMap;
	}
	
	/**
	 * 
	 * @param msgReturn
	 */
	private void setStatusMsg(GracSWsApiMessage msg){
		statusMsg = new StringBuffer();
		statusMsg.append(msg.getMsgNo());
		statusMsg.append("_");
		statusMsg.append(msg.getMsgStatement());
	}
}
