package oracle.iam.ws.sap.ac53;

import static oracle.iam.ws.sap.util.WsClientUtil.KEY_CONFIG_DATA;
import static oracle.iam.ws.sap.util.WsClientUtil.KEY_LANGUAGE;
import static oracle.iam.ws.sap.util.WsClientUtil.KEY_PASSWORD;
import static oracle.iam.ws.sap.util.WsClientUtil.KEY_USER_NAME;
import static oracle.iam.ws.sap.util.WsClientUtil.KEY_AC_URL;
import static oracle.iam.ws.sap.util.WsClientUtil.RESULT;
import static oracle.iam.ws.sap.util.WsClientUtil.STATUS;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import org.identityconnectors.common.logging.Log;

import oracle.iam.ws.sap.ac53.ejbutil.searchroles.ArrayOfRolesDTO;
import oracle.iam.ws.sap.ac53.ejbutil.searchroles.RolesDTO;
import oracle.iam.ws.sap.ac53.ejbutil.searchroles.SearchRolesResult;
import oracle.iam.ws.sap.ac53.searchroles.SAPGRCACIDMSEARCHROLES;
import oracle.iam.ws.sap.ac53.searchroles.SAPGRCACIDMSEARCHROLESViDocument;
import oracle.iam.ws.sap.ac53.searchroles.ejbutil.ServiceStatusDTO;
import oracle.iam.ws.sap.util.WsClientUtil;

/**
 *	<br>Modification History:</br>
 *  S.No.                 Date                              Bug fix no.
 *  1. JAGADEESH        23 Oct 2013                     Bug 17288932 - oim to sap connection over ssl and lb with web dispatcher 
 */

/**
 * @author ranjith.kumar
 *
 */
public class SearchRoles {

	private SAPGRCACIDMSEARCHROLESViDocument _port = null;
	
	private String application = null;
	private String accessType = null;
	private String businessProcess = null;
	private String subProcess = null;
	private String role = null;
	private String roleDesc = null;
	private String functionalArea = null;
	private String company = null; 
	private String transactionCode = null;
	private String userId = null;
	private String locale = null;
	private int hitCount = 0;
	
	/**
	 * Instance of util class
	 */
	private WsClientUtil util = null;
	
	/**
	 * Instance of Log
	 */
	private static final Log LOG = Log.getLog(SearchRoles.class);

	/**
	 * 
	 * @param inputDataMap
	 * @return
	 */
	public Map<String, Object> callService(Map<String, Object> inputDataMap) {
		Map<String, Object> returnMap = new HashMap<String, Object>(4, 0.75f);
		Map<String, Object> resultMap = new HashMap<String, Object>(10, 0.75f);
		StringBuffer statusMsg = null;
		util = new WsClientUtil();
		try {
			marshalInputData(inputDataMap);
			Map<String, Object> configMap = (Map)inputDataMap.get(KEY_CONFIG_DATA);
			//Start :: BUG 17288932
//			configMap.put(KEY_AC_URL, 
//					util.buildURL((String)configMap.get("server"),
//							(String)configMap.get("port"),"SAPGRC_AC_IDM_SEARCHROLES/Config1?wsdl"));
			LOG.info("Request Status WSDL Path:[{0}]"+configMap.get("searchRolesWSDLPath"));
			configMap.put(KEY_AC_URL,configMap.get("searchRolesWSDLPath"));
			//End :: BUG 17288932
			URL url = new URL((String)configMap.get(KEY_AC_URL));
			QName qName = new QName("urn:SAPGRC_AC_IDM_SEARCHROLESWsd", 
					"SAPGRC_AC_IDM_SEARCHROLES");
			
			SAPGRCACIDMSEARCHROLES service = new SAPGRCACIDMSEARCHROLES(url, qName);
			_port = service.getConfig1PortDocument();
			
			util.setCredentials((BindingProvider)_port, configMap, false);
			LOG.error("Perf: callService-SearchRoles entered");
			SearchRolesResult result = _port.getRoles(application, accessType, 
					businessProcess, subProcess, role, roleDesc, functionalArea, 
					company, transactionCode, userId, locale, hitCount);
			LOG.error("Perf: callService-SearchRoles exited");
			statusMsg = new StringBuffer();
			if (result != null ) {
				ServiceStatusDTO serviceStatusDto = result.getStatus();
				if(serviceStatusDto != null) {
					if("SUCCESS".equalsIgnoreCase(serviceStatusDto.getMsgType())){
						statusMsg.append("0_");
						statusMsg.append(serviceStatusDto.getMsgType());
						statusMsg.append("_");
						statusMsg.append(serviceStatusDto.getMsgDesc());
					} else {
						statusMsg.append("4_");
						statusMsg.append(serviceStatusDto.getMsgType());
						statusMsg.append("_");
						statusMsg.append(serviceStatusDto.getMsgDesc());
					}
				} else {
					statusMsg.append("4_");
					statusMsg.append("No status message found");
				}
				ArrayOfRolesDTO arrayOfRolesDto = result.getRolesDTO().getRolesDTO();
				for(RolesDTO rolesDto : arrayOfRolesDto.getRolesDTO()){
					resultMap.put(rolesDto.getRoleName(),rolesDto.getRoleDescription());
				}
			} else {
				statusMsg.append("4_");
				statusMsg.append("No result and status message from webservice");
			}
			returnMap.put(STATUS,statusMsg.toString());
			returnMap.put(RESULT, resultMap);
		} catch(Exception e) {
			//LOG.error(e, "Search roles failed");
			statusMsg = new StringBuffer("1_");
			statusMsg.append(e.getMessage());
			returnMap.put(STATUS, statusMsg.toString());
		}
		return returnMap;
	}

	/**
	 * 
	 * @param inputDataMap
	 */
	private void marshalInputData(Map<String, Object> inputDataMap) {
		application = (String)inputDataMap.get("Application");
		accessType = (String)inputDataMap.get("AccessType");
		businessProcess = (String)inputDataMap.get("BusProc");
		subProcess = (String)inputDataMap.get("SubProc");
		role = (String)inputDataMap.get("Role");
		roleDesc = (String)inputDataMap.get("RoleDesc");
		functionalArea = (String)inputDataMap.get("FuncArea");
		company = (String)inputDataMap.get("Company");
		transactionCode = (String)inputDataMap.get("TransCode");
		userId = (String)inputDataMap.get("UserId");
		locale = (String)inputDataMap.get(KEY_LANGUAGE);
		if(inputDataMap.get("HitCount") != null) {
			hitCount = (Integer)inputDataMap.get("HitCount");
		}
	}
}
