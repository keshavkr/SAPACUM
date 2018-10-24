package oracle.iam.ws.sap.ac53;

import static oracle.iam.ws.sap.util.WsClientUtil.KEY_AC_URL;
import static oracle.iam.ws.sap.util.WsClientUtil.KEY_CONFIG_DATA;
import static oracle.iam.ws.sap.util.WsClientUtil.KEY_LANGUAGE;
import static oracle.iam.ws.sap.util.WsClientUtil.KEY_PASSWORD;
import static oracle.iam.ws.sap.util.WsClientUtil.KEY_USER_NAME;
import static oracle.iam.ws.sap.util.WsClientUtil.RESULT;
import static oracle.iam.ws.sap.util.WsClientUtil.STATUS;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import org.identityconnectors.common.logging.Log;

import oracle.iam.ws.sap.ac53.audittrail.SAPGRCACIDMAUDITTRAIL;
import oracle.iam.ws.sap.ac53.audittrail.SAPGRCACIDMAUDITTRAILViDocument;
import oracle.iam.ws.sap.ac53.audittrail.ejbutil.ServiceStatusDTO;
import oracle.iam.ws.sap.ac53.ejbutil.auditlogs.ArrayOfAuditLogDTO;
import oracle.iam.ws.sap.ac53.ejbutil.auditlogs.AuditLogDTO;
import oracle.iam.ws.sap.ac53.ejbutil.auditlogs.AuditLogResult;
import oracle.iam.ws.sap.ac53.ejbutil.auditlogs.RequestHistoryDTO;
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
public class AuditTrail {
	
	/**
	 * Instance of Log
	 */
	private static final Log LOG = Log.getLog(AuditTrail.class);

	/**
	 * Instance variable of Web service proxy
	 */
	private SAPGRCACIDMAUDITTRAILViDocument _port = null;
	
	private String requestId = null; 
	private String userFirstName = null;
	private String userLastName = null;
	private String fromDate = null;
	private String toDate = null;
	private String action = null;
	private String locale = null;
	
	/**
	 * Instance of util class
	 */
	private WsClientUtil util = null;
	

	
	/**
	 * Method invoking AuditTrail web service to retrieve audit logs 
	 * @param inputDataMap
	 * @return
	 */
	public Map<String, Object> callService(Map<String, Object> inputDataMap) {
		Map<String, Object> returnMap = new HashMap<String, Object>(4, 0.75f);
		StringBuffer statusMsg = null;
		util = new WsClientUtil();
		LOG.info("callService - AuditTrail input:[{0}]", inputDataMap);
		try {
			marshalInputData(inputDataMap);
			Map<String, Object> configMap = (Map)inputDataMap.get(KEY_CONFIG_DATA);
			//Start :: BUG 17288932
//			configMap.put(KEY_AC_URL, 
//					util.buildURL((String)configMap.get("server"),
//							(String)configMap.get("port"),"SAPGRC_AC_IDM_AUDITTRAIL/Config1?wsdl"));
			LOG.info("Audit Trail WSDL Path:[{0}]"+configMap.get("auditTrailWSDLPath"));
			configMap.put(KEY_AC_URL,configMap.get("auditTrailWSDLPath"));
			//End :: BUG 17288932
			URL url = new URL((String)configMap.get(KEY_AC_URL));
			QName qName = new QName("urn:SAPGRC_AC_IDM_AUDITTRAILWsd", 
					"SAPGRC_AC_IDM_AUDITTRAIL");
			
			SAPGRCACIDMAUDITTRAIL service = new SAPGRCACIDMAUDITTRAIL(url, qName);
			_port = service.getConfig1PortDocument();
			
			
			util.setCredentials((BindingProvider)_port, configMap, false);
			LOG.error("Perf: callService-AuditTrail entered");		
			AuditLogResult result = _port.getAuditLogs(requestId, userFirstName, userLastName, 
					fromDate, toDate, action, locale);
			LOG.error("Perf: callService-AuditTrail exited");
			statusMsg = new StringBuffer();
			List<String> logList = new ArrayList<String>();
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
				ArrayOfAuditLogDTO arrayOfAuditLogDto = result.getAuditLogDTO().getAuditLogDTO();
				StringBuffer logMsg = null;
				for(AuditLogDTO auditLogDto : arrayOfAuditLogDto.getAuditLogDTO()){
					logMsg = new StringBuffer();
					logMsg.append("-->RequestId:");
					logMsg.append(auditLogDto.getRequestId());
					logMsg.append(",RequestedBy:");
					logMsg.append(auditLogDto.getRequestedBy());
					logMsg.append(",SubmittedBy");
					logMsg.append(auditLogDto.getSubmittedBy());
					logMsg.append(",CreateDate");
					logMsg.append(auditLogDto.getCreateDate());
					logMsg.append(",Priority");
					logMsg.append(auditLogDto.getPriority());
					logMsg.append(",Status");
					logMsg.append(auditLogDto.getStatus());
					logMsg.append(",LogDetails");
					logMsg.append(auditLogDto.getLogDetails());
					logMsg.append(",RequestHistory{");
					for(RequestHistoryDTO requestHistoryDto : 
						auditLogDto.getRequestHst().getRequestHistoryDTO()){
						logMsg.append("  ActionValue:");
						logMsg.append(requestHistoryDto.getActionValue());
						logMsg.append(",DependentId:");
						logMsg.append(requestHistoryDto.getDependentId());
						logMsg.append(",Description:");
						logMsg.append(requestHistoryDto.getDescription());
						logMsg.append(",Id:");
						logMsg.append(requestHistoryDto.getId());
						logMsg.append(",Path:");
						logMsg.append(requestHistoryDto.getPath());
						logMsg.append(",ReqNo:");
						logMsg.append(requestHistoryDto.getReqNo());
						logMsg.append(",Stage:");
						logMsg.append(requestHistoryDto.getStage());
						logMsg.append(",UserId:");
						logMsg.append(requestHistoryDto.getUserId());
						logMsg.append(",ActionDate:");
						logMsg.append(requestHistoryDto.getActionDate());
					}
					logMsg.append("}");
					logList.add(logMsg.toString());
				}
			} else {
				statusMsg.append("4_");
				statusMsg.append("No result and status message from webservice");
			}
			returnMap.put(STATUS,statusMsg.toString());
			returnMap.put(RESULT, logList);
		} catch(Exception e) {
			LOG.error(e, "AuditTrail failed");
			statusMsg = new StringBuffer("1_");
			statusMsg.append(e.getMessage());
			returnMap.put(STATUS, statusMsg.toString());
		}
		LOG.info("callService - AuditTrail output:[{0}]", returnMap);
		return returnMap;
	}

	/**
	 * Method setting web service input parameters using inputDataMap
	 * @param inputDataMap
	 */
	private void marshalInputData(Map<String, Object> inputDataMap) {
		requestId = (String) inputDataMap.get("RequestNo"); 
		userFirstName = (String) inputDataMap.get("FirstName");
		userLastName = (String) inputDataMap.get("LastName");
		fromDate = (String) inputDataMap.get("FromDate");
		toDate = (String) inputDataMap.get("ToDate");
		action = (String) inputDataMap.get("Action");
		locale = (String) inputDataMap.get(KEY_LANGUAGE);
	}

}
