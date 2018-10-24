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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;

import org.identityconnectors.common.logging.Log;

import oracle.iam.ws.sap.ac10.selectapplication.GRACSELECTAPPLWS;
import oracle.iam.ws.sap.ac10.selectapplication.GracSWsApiConnector;
import oracle.iam.ws.sap.ac10.selectapplication.GracSWsApiMessage;
import oracle.iam.ws.sap.ac10.selectapplication.GracTWsSaConnectorLst;
import oracle.iam.ws.sap.ac10.selectapplication.Service;
import oracle.iam.ws.sap.util.WsClientUtil;



/**
 * @author ranjith.kumar
 * 
 * Web service client class to populate input and invoke SAP GRC AC10 web service
 * GRAC_SELECT_APPL_WS to retrieve application details
 */
public class SelectApplication {

	/**
	 * Instance of Log
	 */
	private static final Log LOG = Log.getLog(SelectApplication.class);
	
	public static final String CONNECTIONTYPE = "connectiontype";
	public static final String CONNECTORCATEGORY = "connectorcategory";
	public static final String CONNECTORID = "connectorid";
	
	private GRACSELECTAPPLWS  _port = null;

	/**
	 * Instance of util class
	 */
	private WsClientUtil util = null;
	

	
	/**
	 * Method invokes GRC AC 10 web service to retrieve application details
	 * @param inputDataMap
	 * @return
	 */
	public Map<String, Object> callService(Map<String, Object> inputDataMap){
		Map<String, Object> outputMap = new HashMap<String, Object>(5, 0.75f);
		Map<String, Object> resultMap = new HashMap<String, Object>(5, 0.75f);
		StringBuffer statusMsg = null;
		util = new WsClientUtil();
		LOG.info("callService - SelectApplication input:[{0}]", inputDataMap);
		try {
			Map<String, Object> configMap = (Map)inputDataMap.get(KEY_CONFIG_DATA);
			configMap.put(KEY_AC_URL, configMap.get("appLookupAccessURL"));
			
			//URL url = getClass().getClassLoader().getResource("/wsdl/GRAC_SELECT_APPL_WS.WSDL");
			StringBuffer wsdlPath = new StringBuffer("file:/");
			wsdlPath.append(configMap.get("wsdlFilePath"));
			wsdlPath.append("/GRAC_SELECT_APPL_WS.WSDL");
			URL url = new URL(wsdlPath.toString());
			
			
		    QName qName = new QName("urn:sap-com:document:sap:soap:functions:mc-style", "service");
		    
			Service service = new Service(url, qName);
			_port = service.getBinding();

			util.setCredentials((BindingProvider)_port, configMap, true);
		
			//output data objects
			Holder<GracTWsSaConnectorLst> connectorList = new Holder<GracTWsSaConnectorLst>();
			Holder<GracSWsApiMessage> msgReturn = new Holder<GracSWsApiMessage>();
			LOG.error("Perf: callService-SelectApplication entered");
			_port.gracIdmSelectApplServices((String)inputDataMap.get(CONNECTIONTYPE), 
					(String)inputDataMap.get(CONNECTORCATEGORY), 
					(String)inputDataMap.get(CONNECTORID), 
					(String)inputDataMap.get(KEY_LANGUAGE), connectorList, msgReturn);
			LOG.error("Perf: callService-SelectApplication exited");
			GracSWsApiMessage msg = msgReturn.value;
			statusMsg = new StringBuffer();
			statusMsg.append(msg.getMsgNo());
			statusMsg.append("_");
			statusMsg.append(msg.getMsgStatement());
			outputMap.put(STATUS, statusMsg.toString());
			
			
			StringBuffer logStr = new StringBuffer();
			logStr.append("MsgNo:"+msg.getMsgNo());
			logStr.append(",MsgType:"+msg.getMsgType());
			logStr.append(",MsgStatement:"+msg.getMsgStatement());
			LOG.info(logStr.toString());
			
			LOG.info("\nConnector details\n");
			GracTWsSaConnectorLst connectorLst = connectorList.value;
			List<GracSWsApiConnector> list = connectorLst.getItem();
			if(list != null && !list.isEmpty()) {
				LOG.info("No of connectors:"+list.size());
				logStr = new StringBuffer();
				for (GracSWsApiConnector connector: list){
					logStr.append(" Connector:"+connector.getConnector());
					logStr.append(",ConnectorDesc:"+connector.getConnectorDesc());
					logStr.append(",ConnectionType:"+connector.getConnectionType());
					logStr.append(",ConnectorCategory:"+connector.getConnectorCategory());
					logStr.append(",ConnectorCategoryDesc:"+connector.getConnectorCategoryDesc());
					resultMap.put(connector.getConnector(),connector.getConnectorDesc());
				}
				LOG.info(logStr.toString());
			} else {
				LOG.info("GracTWsSaConnectorLst.getItem() is null");
			}
			outputMap.put(RESULT, resultMap);
		} catch(Exception e) {
			LOG.error(e, "Select Application failed");
			statusMsg = new StringBuffer("1_");
			statusMsg.append(e.getMessage());
			outputMap.put(STATUS, statusMsg.toString());
		}
		LOG.info("callService - SelectApplication output:[{0}]", outputMap);
		return outputMap;
	}
}
