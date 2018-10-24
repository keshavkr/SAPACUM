/**
 * 
 */
package oracle.iam.ws.sap.ac10;

import static oracle.iam.ws.sap.util.WsClientUtil.KEY_AC_URL;
import static oracle.iam.ws.sap.util.WsClientUtil.KEY_CONFIG_DATA;
import static oracle.iam.ws.sap.util.WsClientUtil.KEY_PASSWORD;
import static oracle.iam.ws.sap.util.WsClientUtil.KEY_USER_NAME;
import static oracle.iam.ws.sap.util.WsClientUtil.RESULT;
import static oracle.iam.ws.sap.util.WsClientUtil.STATUS;
import static oracle.iam.ws.sap.util.WsClientUtil.KEY_LANGUAGE;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;

import org.identityconnectors.common.logging.Log;

import oracle.iam.ws.sap.ac10.searchroles.GRACSEARCHROLESWS;
import oracle.iam.ws.sap.ac10.searchroles.GracSWsApiMessage;
import oracle.iam.ws.sap.ac10.searchroles.GracSWsSrOpRoleList;
import oracle.iam.ws.sap.ac10.searchroles.GracTWsSrOpRoleList;
import oracle.iam.ws.sap.ac10.searchroles.Service;
import oracle.iam.ws.sap.util.WsClientUtil;



/**
 * @author ranjith.kumar
 *
 */
public class SearchRoles {

	private static final Log LOG = Log.getLog(SearchRoles.class);
	//input params
	private String action = null;
	private String applicationType = null; 
	private String approver= null;
	private String associatedRole = null; 
	private String businessProcess = null; 
	private String connectorGroup = null;
	private String criticalLevel= null;
	private String functionalArea = null; 
	private String landscape = null; 
	private String language = null;
	private String lastReaffirmDt = null; 
	private String orgLvl= null;
	private String orgVal = null; 
	private String permission = null; 
	private String profile = null;
	private String reaffirmPeriod = null; 
	private String roleDesc = null;
	private String roleName= null;
	private String roleOwner = null; 
	private String roleSensitivity = null; 
	private String roleStatus = null; 
	private String roleType = null;
	private String subProcess = null; 
	private String system= null;
	
	private GRACSEARCHROLESWS _port = null;
	
	/**
	 * Instance of util class
	 */
	private WsClientUtil util = null;
	

	
	/**
	 * Method invokes GRC AC10 web service to retrieve role details
	 * @param inputDataMap
	 * @return
	 */
	public Map<String, Object> callService(Map<String, Object> inputDataMap){
		Map<String, Object> outputMap = new HashMap<String, Object>(5, 0.75f);
		Map<String, Object> resultMap = new HashMap<String, Object>(10, .075f);
		StringBuffer statusMsg = null;
		//output params
		Holder<GracSWsApiMessage> msgReturn = new Holder<GracSWsApiMessage>();
		Holder<GracTWsSrOpRoleList> rolesList = new Holder<GracTWsSrOpRoleList>();
		util = new WsClientUtil();
		try{
			marshalInputData(inputDataMap);
			Map<String, Object> configMap = (Map)inputDataMap.get(KEY_CONFIG_DATA);
			configMap.put(KEY_AC_URL, configMap.get("roleLookupAccessURL"));
			
			//URL url = getClass().getClassLoader().getResource("/wsdl/GRAC_SEARCH_ROLES_WS.WSDL");
			StringBuffer wsdlPath = new StringBuffer("file:/");
			wsdlPath.append(configMap.get("wsdlFilePath"));
			wsdlPath.append("/GRAC_SEARCH_ROLES_WS.WSDL");
			URL url = new URL(wsdlPath.toString());
			
			
		    QName qName = new QName("urn:sap-com:document:sap:soap:functions:mc-style", "service");
			Service service = new Service(url, qName);
			_port = service.getBinding();
			
			util.setCredentials((BindingProvider)_port, configMap, true);
			LOG.error("Perf: callService-SearchRoles entered");
			_port.gracIdmRoleSearchServices(action, applicationType, approver, 
					associatedRole, businessProcess, connectorGroup, criticalLevel, 
					functionalArea, landscape, language, lastReaffirmDt, orgLvl, 
					orgVal, permission, profile, reaffirmPeriod, roleDesc, roleName, 
					roleOwner, roleSensitivity, roleStatus, roleType, subProcess, system, 
					msgReturn, rolesList);
			LOG.error("Perf: callService-SearchRoles exited");
			GracSWsApiMessage msg= msgReturn.value;
			StringBuffer logStr = new StringBuffer();
			logStr.append("MsgNo:"+msg.getMsgNo());
			logStr.append(",MsgType:"+msg.getMsgType());
			logStr.append(",MsgStatement:"+msg.getMsgStatement());	
			LOG.info(logStr.toString());
			
			statusMsg = new StringBuffer();
			statusMsg.append(msg.getMsgNo());
			statusMsg.append("_");
			statusMsg.append(msg.getMsgStatement());
			outputMap.put(STATUS, statusMsg.toString());
			
			StringBuilder strbuild = null;
			for (GracSWsSrOpRoleList roleList :rolesList.value.getItem()){
				strbuild = new StringBuilder("RoleName:");
				strbuild.append(roleList.getRoleName());
				strbuild.append(", RoleDesc:");
				strbuild.append(roleList.getRoleDesc());
				strbuild.append(", RoleOwner:");
				strbuild.append(roleList.getRoleOwner());
				strbuild.append(", RoleType:");
				strbuild.append(roleList.getRoleType());
				strbuild.append(", RoleTypeDesc:");
				strbuild.append(roleList.getRoleTypeDesc());
				strbuild.append(", System:");
				strbuild.append(roleList.getSystem());
				strbuild.append(", Landscape:");
				strbuild.append(roleList.getLandscape());
				strbuild.append(", LandscapeDesc:");
				strbuild.append(roleList.getLandscapeDesc());
				LOG.info(strbuild.toString());
				resultMap.put(roleList.getRoleName(), roleList.getRoleDesc());
			}
			outputMap.put(RESULT, resultMap);
		} catch(Exception e){
			LOG.error(e,"Search Roles failed");
			statusMsg = new StringBuffer("1_");
			statusMsg.append(e.getMessage());
			outputMap.put(STATUS, statusMsg.toString());
		}
		return outputMap;
	}

	/**
	 * Method populating web service input data  
	 * @param inputDataMap
	 */
	private void marshalInputData(Map<String, Object> inputDataMap) {
		action = (String)inputDataMap.get("Action");
		applicationType = (String)inputDataMap.get("ApplicationType");
		approver = (String)inputDataMap.get("Approver");
		associatedRole = (String)inputDataMap.get("AssociatedRole");
		businessProcess = (String)inputDataMap.get("BusProc");
		connectorGroup = (String)inputDataMap.get("ConnectorGroup");
		criticalLevel = (String)inputDataMap.get("Level");
		functionalArea = (String)inputDataMap.get("FuncArea");
		landscape = (String)inputDataMap.get("Landscape");
		language = (String)inputDataMap.get(KEY_LANGUAGE);
		lastReaffirmDt = (String)inputDataMap.get("LastReaffirmDt");
		orgLvl = (String)inputDataMap.get("OrgLevel");
		orgVal = (String)inputDataMap.get("OrgVal");
		permission = (String)inputDataMap.get("Permission");
		profile = (String)inputDataMap.get("Profile");
		reaffirmPeriod = (String)inputDataMap.get("ReaffirmPeriod");
		roleDesc = (String)inputDataMap.get("RoleDesc");
		roleName = (String)inputDataMap.get("Role");
		roleOwner = (String)inputDataMap.get("RoleOwner");
		roleSensitivity = (String)inputDataMap.get("RoleSensitivity");
		roleStatus = (String)inputDataMap.get("RoleStatus");
		roleType = (String)inputDataMap.get("RoleType");
		subProcess = (String)inputDataMap.get("SubProc");
		system = (String)inputDataMap.get("Application");
	}
}
