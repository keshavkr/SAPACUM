package oracle.iam.ws.sap.ac53;

import static oracle.iam.ws.sap.util.WsClientUtil.KEY_AC_URL;
import static oracle.iam.ws.sap.util.WsClientUtil.*;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import org.identityconnectors.common.logging.Log;

import oracle.iam.ws.sap.ac53.ejbutil.requeststatus.RequestStatusDTO;
import oracle.iam.ws.sap.ac53.requeststatus.SAPGRCACIDMREQUESTSTATUS;
import oracle.iam.ws.sap.ac53.requeststatus.SAPGRCACIDMREQUESTSTATUSViDocument;
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
public class RequestStatus {
	
	/**
	 * Instance of Log
	 */
	private static final Log LOG = Log.getLog(RequestStatus.class);

	private SAPGRCACIDMREQUESTSTATUSViDocument _port = null;
	
	/**
	 * Instance of util class
	 */
	private WsClientUtil util = null;
	

	
	/**
	 * Method invoking web service to retrieve request status
	 * @param inputDataMap
	 * @return
	 */
	public Map<String, Object> callService(Map<String, Object> inputDataMap) {
		Map<String, Object> returnMap = new HashMap<String, Object>(4, 0.75f);
		StringBuffer statusMsg = null;
		util = new WsClientUtil();
		LOG.info("callService - RequestStatus input:[{0}]", inputDataMap);
		try {
			String requestId = (String)inputDataMap.get("RequestNo");
			String language = (String)inputDataMap.get(KEY_LANGUAGE);
			Map<String, Object> configMap = (Map)inputDataMap.get(KEY_CONFIG_DATA);
			//Start :: BUG 17288932
//			configMap.put(KEY_AC_URL, 
//					util.buildURL((String)configMap.get("server"),
//							(String)configMap.get("port"),"SAPGRC_AC_IDM_REQUESTSTATUS/Config1?wsdl"));
			LOG.info("Request Status WSDL Path:[{0}]"+configMap.get("requestStatusWSDLPath"));
			configMap.put(KEY_AC_URL,configMap.get("requestStatusWSDLPath"));
			//End :: BUG 17288932
			URL url = new URL((String)configMap.get(KEY_AC_URL));
			QName qName = new QName("urn:SAPGRC_AC_IDM_REQUESTSTATUSWsd", 
					"SAPGRC_AC_IDM_REQUESTSTATUS");
			SAPGRCACIDMREQUESTSTATUS service  = new SAPGRCACIDMREQUESTSTATUS(url, qName);
			_port = service.getConfig1PortDocument();
			
			util.setCredentials((BindingProvider)_port, configMap, false);
			LOG.error("Perf: callService-RequestStatus entered");
			RequestStatusDTO requestStatusDto = _port.getStatus(requestId, language);
			LOG.error("Perf: callService-RequestStatus exited");
			statusMsg = new StringBuffer();
			if(requestStatusDto != null ){
				if("SUCCESS".equalsIgnoreCase(requestStatusDto.getMsgType())){
					statusMsg.append("0_");
					statusMsg.append(requestStatusDto.getMsgType());
					statusMsg.append("_");
					statusMsg.append(requestStatusDto.getMsgDesc());
				} else {
					statusMsg.append("4_");
					statusMsg.append(requestStatusDto.getMsgType());
					statusMsg.append("_");
					statusMsg.append(requestStatusDto.getMsgDesc());
				}
			} else {
				statusMsg.append("4_");
				statusMsg.append("No result and status message from webservice");
			}
			returnMap.put("RequestStatus", requestStatusDto.getStatus());
			returnMap.put(STATUS,statusMsg.toString());
		} catch(Exception e) {
			LOG.error(e, "Request status failed");
			statusMsg = new StringBuffer("1_");
			statusMsg.append(e.getMessage());
			returnMap.put(STATUS, statusMsg.toString());
		}
		LOG.info("callService - RequestStatus output:[{0}]", returnMap);
		return returnMap;
	}

}
