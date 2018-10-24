/**
 * 
 */
package oracle.iam.ws.sap.ac10;

import static oracle.iam.ws.sap.util.WsClientUtil.KEY_AC_URL;
import static oracle.iam.ws.sap.util.WsClientUtil.KEY_CONFIG_DATA;
import static oracle.iam.ws.sap.util.WsClientUtil.KEY_LANGUAGE;
import static oracle.iam.ws.sap.util.WsClientUtil.STATUS;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;

import oracle.iam.ws.sap.ac10.requeststatus.GRACREQUESTSTATUSWS;
import oracle.iam.ws.sap.ac10.requeststatus.GracSWsApiMessage;
import oracle.iam.ws.sap.ac10.requeststatus.GracSWsRsOpRequestList;
import oracle.iam.ws.sap.ac10.requeststatus.Service;
import oracle.iam.ws.sap.util.WsClientUtil;

import org.identityconnectors.common.logging.Log;

/**
 * @author ranjith.kumar
 *
 * Web service client class to populate input data and 
 * invoke SAP GRC AC10 web service GRAC_REQUEST_STATUS_WS for request status for given request no.
 */
public class RequestStatus {

	/**
	 * Instance of Log
	 */
	private static final Log LOG = Log.getLog(RequestStatus.class);
	
	/**
	 * Instance of web service proxy
	 */
	private GRACREQUESTSTATUSWS	_port = null;
	/**
	 * Instance of util class
	 */
	private WsClientUtil util = null;
	

	
	/**
	 * Method invokes SAP GRC AC10 Request status web service 
	 * to collect the status of given request number 
	 * @param inputDataMap
	 * @return
	 */
	public Map<String, Object> callService(Map<String, Object> inputDataMap){
		Map<String, Object> resultMap = new HashMap<String, Object>(10, .075f);
		StringBuffer statusMsg = null;
		util = new WsClientUtil();
		LOG.info("callService - RequestStatus input :[{0}]", inputDataMap);
		try{
			Map<String, Object> configMap = (Map)inputDataMap.get(KEY_CONFIG_DATA);
			configMap.put(KEY_AC_URL, configMap.get("requestStatusAccessURL"));
			
			//URL url = getClass().getClassLoader().getResource("/wsdl/GRAC_REQUEST_STATUS_WS.WSDL");
			StringBuffer wsdlPath = new StringBuffer("file:/");
			wsdlPath.append(configMap.get("wsdlFilePath"));
			wsdlPath.append("/GRAC_REQUEST_STATUS_WS.WSDL");
			URL url = new URL(wsdlPath.toString());
			
			QName qName = new QName("urn:sap-com:document:sap:soap:functions:mc-style", "service");
		    Service service = new Service(url, qName);
			_port = service.getBinding();
			
			util.setCredentials((BindingProvider)_port, configMap, true);
			
			String language = (String)inputDataMap.get(KEY_LANGUAGE); 
			String reqNo = (String)inputDataMap.get("RequestNo");
			
			Holder<GracSWsApiMessage> msgReturn = new Holder<GracSWsApiMessage>();
			Holder<GracSWsRsOpRequestList> reqStatus = new Holder<GracSWsRsOpRequestList>();
			LOG.error("Perf: callService-RequestStatus entered");
			_port.gracIdmRequestStatServices(language, reqNo, msgReturn, reqStatus);
			LOG.error("Perf: callService-RequestStatus exited");
			GracSWsApiMessage msg= msgReturn.value;
			GracSWsRsOpRequestList rsOpRequestList = reqStatus.value;
			if(rsOpRequestList != null) {
				//setting output map - parameter 1
				resultMap.put("RequestStatus", rsOpRequestList.getReqstatus());
			}
			
			statusMsg = new StringBuffer();
			statusMsg.append(msg.getMsgNo());
			statusMsg.append("_");
			statusMsg.append(msg.getMsgStatement());
			resultMap.put(STATUS, statusMsg.toString());
		} catch(Exception e){
			LOG.error(e, "Status Request failed");
			statusMsg = new StringBuffer("1_");
			statusMsg.append(e.getMessage());
			resultMap.put(STATUS, statusMsg.toString());
		}
		LOG.info("callService - RequestStatus output :[{0}]",resultMap);
		return resultMap;
	}
	
}
