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

import oracle.iam.ws.sap.ac53.ejbutil.selectsystem.ArrayOfSystemData;
import oracle.iam.ws.sap.ac53.ejbutil.selectsystem.ArrayOfSystemDatas;
import oracle.iam.ws.sap.ac53.ejbutil.selectsystem.SystemData;
import oracle.iam.ws.sap.ac53.ejbutil.selectsystem.SystemSelectionResult;
import oracle.iam.ws.sap.ac53.selectsystem.SAPGRCACIDMSELECTAPPLICATION;
import oracle.iam.ws.sap.ac53.selectsystem.SAPGRCACIDMSELECTAPPLICATIONViDocument;
import oracle.iam.ws.sap.ac53.selectsystem.ejbutil.ServiceStatusDTO;
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
public class SelectApplication {

	/**
	 * Instance of Log
	 */
	private static final Log LOG = Log.getLog(SelectApplication.class);
	
	/**
	 * Instance of webservice proxy
	 */
	private SAPGRCACIDMSELECTAPPLICATIONViDocument _port = null;
	
	/**
	 * Instance of util class
	 */
	private WsClientUtil util = null;
	

	
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
		LOG.info("callService - SelectApplication input:[{0}]", inputDataMap);
		try {
			String systemType = (String) inputDataMap.get("SystemType");//"adm";
			String applicationType = (String) inputDataMap.get("ApplicationType");
			String locale = (String) inputDataMap.get(KEY_LANGUAGE);
			
			Map<String, Object> configMap = (Map)inputDataMap.get(KEY_CONFIG_DATA);
			//Start :: BUG 17288932
//			configMap.put(KEY_AC_URL, 
//					util.buildURL((String)configMap.get("server"),
//							(String)configMap.get("port"),"SAPGRC_AC_IDM_SELECTAPPLICATION/Config1?wsdl"));
			LOG.info("Request Status WSDL Path:[{0}]"+configMap.get("selectApplicationWSDLPath"));
			configMap.put(KEY_AC_URL,configMap.get("selectApplicationWSDLPath"));
			//End :: BUG 17288932
			URL url = new URL(configMap.get(KEY_AC_URL).toString());
			QName qName = new QName("urn:SAPGRC_AC_IDM_SELECTAPPLICATIONWsd", 
					"SAPGRC_AC_IDM_SELECTAPPLICATION");
			SAPGRCACIDMSELECTAPPLICATION service = new SAPGRCACIDMSELECTAPPLICATION(url,qName);
			_port = service.getConfig1PortDocument();

			util.setCredentials((BindingProvider)_port, configMap, false);
			LOG.error("Perf: callService-SelectApplication entered");
			SystemSelectionResult result = _port.getSystems(systemType, applicationType, locale);
			LOG.error("Perf: callService-SelectApplication exited");
			statusMsg = new StringBuffer();
			if (result != null ) {
				ServiceStatusDTO  serviceStatusDto = result.getStatus();
				if(serviceStatusDto != null){
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
				ArrayOfSystemDatas arrayOfSystemDatas = result.getSystems();
				ArrayOfSystemData arrayOfSystemData = arrayOfSystemDatas.getSystemData();
				for (SystemData systemData : arrayOfSystemData.getSystemData()){
					resultMap.put(systemData.getSystemId(),  systemData.getDescription());
				}
			} else {
				statusMsg.append("4_");
				statusMsg.append("No result and status message from webservice");
			}
			returnMap.put(STATUS,statusMsg.toString());
			returnMap.put(RESULT, resultMap);
		} catch(Exception e) {
			LOG.error(e, "Select Application failed");
			statusMsg = new StringBuffer("1_");
			statusMsg.append(e.getMessage());
			returnMap.put(STATUS, statusMsg.toString());
		}
		LOG.info("callService - SelectApplication output:[{0}]", returnMap);
		return returnMap;
	}

}
