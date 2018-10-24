/**
 * 
 */
package oracle.iam.ws.sap.ac10;


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
import javax.xml.ws.Holder;

import oracle.iam.ws.sap.ac10.auditlogs.GRACAUDITLOGSWS;
import oracle.iam.ws.sap.ac10.auditlogs.GracSApiAuditLogs;
import oracle.iam.ws.sap.ac10.auditlogs.GracSApiAuditlogData;
import oracle.iam.ws.sap.ac10.auditlogs.GracSWsApiMessage;
import oracle.iam.ws.sap.ac10.auditlogs.GracTApiAuditLogs;
import oracle.iam.ws.sap.ac10.auditlogs.Service;
import oracle.iam.ws.sap.util.WsClientUtil;

import org.identityconnectors.common.logging.Log;

/**
 * @author ranjith.kumar
 *
 * Web service client class to populate input and invoke SAP GRC AC10 web service
 *  GRAC_AUDIT_LOGS_WS for audit logs of given request number
 */
public class AuditLogs {

	/**
	 * Instance of log
	 */
	private static final Log LOG = Log.getLog(AuditLogs.class);
	
	/**
	 * Instance of web service proxy
	 */
	private GRACAUDITLOGSWS _port = null;
	
	/**
	 * Instance of util class
	 */
	private WsClientUtil util = null;
	
	
	/**
	 * Method invokes SAP GRC AC10 AuditLog web service to retrieve log details of a request  
	 * @param inputDataMap
	 * @return
	 */
	public Map<String, Object> callService(Map<String, Object> inputDataMap){
		LOG.info("callService-AuditLogs input:[{0}]",inputDataMap);
		Map<String, Object> outputMap = new HashMap<String, Object>(5, 0.75f);
		//Map<String, Object> resultMap = new HashMap<String, Object>(5, .075f);
		StringBuffer statusMsg = null;
		util = new WsClientUtil();
		try{
			Map<String, Object> configMap = (Map)inputDataMap.get(KEY_CONFIG_DATA);
			configMap.put(KEY_AC_URL, configMap.get("auditLogsAccessURL"));
			
			//URL url = getClass().getClassLoader().getResource("/wsdl/GRAC_AUDIT_LOGS_WS.WSDL");
			StringBuffer wsdlPath = new StringBuffer("file:/");
			wsdlPath.append(configMap.get("wsdlFilePath"));
			wsdlPath.append("/GRAC_AUDIT_LOGS_WS.WSDL");
			
			URL url = new URL(wsdlPath.toString());
		    QName qName = new QName("urn:sap-com:document:sap:soap:functions:mc-style", "service");
		    
			Service service = new Service(url, qName);
			_port = service.getBinding();
			
			util.setCredentials((BindingProvider)_port, configMap, true);
			
			//Date format:YYYYMMDD
			String dateFrom = (String)inputDataMap.get("FromDate"); 
			String dateTo = (String)inputDataMap.get("ToDate");; 
			String language = (String)inputDataMap.get(KEY_LANGUAGE);
			String requestNo= (String)inputDataMap.get("RequestNo");
			String requestorId= (String)inputDataMap.get("RequestId");
			Integer maxHits = (Integer)inputDataMap.get("MaxHits");
			
			Holder<GracTApiAuditLogs> auditLogs = new Holder<GracTApiAuditLogs>();
			Holder<GracSWsApiMessage> msgReturn = new Holder<GracSWsApiMessage>();
			LOG.error("Perf: callService-AuditLogs entered");			
			_port.gracIdmInboundAuditLogs(dateFrom, dateTo, language, 
					maxHits, requestNo, requestorId, 
					auditLogs, msgReturn);
			LOG.error("Perf: callService-AuditLogs exited");
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
			
			StringBuffer auditlogStr = null;
			List<String> auditLogList = new ArrayList<String>(10);
			for(GracSApiAuditLogs logs :auditLogs.value.getItem()){
				auditlogStr = new StringBuffer("Createdate:").append(logs.getCreatedate());
				auditlogStr.append(",Priority:").append(logs.getPriority());
				auditlogStr.append(",Requestedby:").append(logs.getRequestedby());
				auditlogStr.append(",Requestnumber:").append(logs.getRequestnumber());
				auditlogStr.append(",Status:").append(logs.getStatus());
				auditlogStr.append(",Submittedby:").append(logs.getSubmittedby());
				auditlogStr.append(",auditlogData:{");
				for (GracSApiAuditlogData auditlogData: logs.getItauditdata().getItem()){
					auditlogStr.append(",ID:").append(auditlogData.getId());
					auditlogStr.append(",Description:").append(auditlogData.getDescription());
					auditlogStr.append(",Display String:").append(auditlogData.getDisplaystring());
				}
				auditlogStr.append("}");
				LOG.info(auditlogStr.toString());
				auditLogList.add(auditlogStr.toString());
			}
			outputMap.put(RESULT, auditLogList);
		} catch(Exception e){
			LOG.error(e, "Audit Trial failed");
			statusMsg = new StringBuffer("1_");
			statusMsg.append(e.getMessage());
			outputMap.put(STATUS, statusMsg.toString());
		}
		LOG.info("AuditLogs output:[{0}]",outputMap);
		return outputMap;
	}

}
