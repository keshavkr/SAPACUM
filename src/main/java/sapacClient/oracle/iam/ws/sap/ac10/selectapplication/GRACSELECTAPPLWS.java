
package oracle.iam.ws.sap.ac10.selectapplication;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "GRAC_SELECT_APPL_WS", targetNamespace = "urn:sap-com:document:sap:soap:functions:mc-style")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface GRACSELECTAPPLWS {


    /**
     * 
     * @param connectorId
     * @param connectorCategory
     * @param connectorList
     * @param connectionType
     * @param msgReturn
     * @param language
     */
    @WebMethod(operationName = "GracIdmSelectApplServices")
    @RequestWrapper(localName = "GracIdmSelectApplServices", targetNamespace = "urn:sap-com:document:sap:soap:functions:mc-style", className = "oracle.iam.ws.sap.ac10.selectapplication.GracIdmSelectApplServices")
    @ResponseWrapper(localName = "GracIdmSelectApplServicesResponse", targetNamespace = "urn:sap-com:document:sap:soap:functions:mc-style", className = "oracle.iam.ws.sap.ac10.selectapplication.GracIdmSelectApplServicesResponse")
    public void gracIdmSelectApplServices(
        @WebParam(name = "ConnectionType", targetNamespace = "")
        String connectionType,
        @WebParam(name = "ConnectorCategory", targetNamespace = "")
        String connectorCategory,
        @WebParam(name = "ConnectorId", targetNamespace = "")
        String connectorId,
        @WebParam(name = "Language", targetNamespace = "")
        String language,
        @WebParam(name = "ConnectorList", targetNamespace = "", mode = WebParam.Mode.OUT)
        Holder<GracTWsSaConnectorLst> connectorList,
        @WebParam(name = "MsgReturn", targetNamespace = "", mode = WebParam.Mode.OUT)
        Holder<GracSWsApiMessage> msgReturn);

}
