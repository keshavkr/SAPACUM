
package oracle.iam.ws.sap.ac10.useraccess;

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
@WebService(name = "GRAC_USER_ACCES_WS", targetNamespace = "urn:sap-com:document:sap:soap:functions:mc-style")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface GRACUSERACCESWS {


    /**
     * 
     * @param requestedLineItem
     * @param parameter
     * @param requestNo
     * @param requestId
     * @param userGroup
     * @param customFieldsVal
     * @param msgReturn
     * @param language
     * @param userInfo
     * @param requestHeaderData
     * @throws GracIdmUsrAccsReqServicesException
     */
    @WebMethod(operationName = "GracIdmUsrAccsReqServices")
    @RequestWrapper(localName = "GracIdmUsrAccsReqServices", targetNamespace = "urn:sap-com:document:sap:soap:functions:mc-style", className = "oracle.iam.ws.sap.ac10.useraccess.GracIdmUsrAccsReqServices")
    @ResponseWrapper(localName = "GracIdmUsrAccsReqServicesResponse", targetNamespace = "urn:sap-com:document:sap:soap:functions:mc-style", className = "oracle.iam.ws.sap.ac10.useraccess.GracIdmUsrAccsReqServicesResponse")
    public void gracIdmUsrAccsReqServices(
        @WebParam(name = "CustomFieldsVal", targetNamespace = "")
        GracTWsUaIpCustfldVal customFieldsVal,
        @WebParam(name = "Language", targetNamespace = "")
        String language,
        @WebParam(name = "Parameter", targetNamespace = "")
        GracTWsUaIpPrameterList parameter,
        @WebParam(name = "RequestHeaderData", targetNamespace = "")
        GracSWsReqhdr requestHeaderData,
        @WebParam(name = "RequestedLineItem", targetNamespace = "")
        GracTWsUaIpReqlineitem requestedLineItem,
        @WebParam(name = "UserGroup", targetNamespace = "")
        GracTWsUaIpUserGroup userGroup,
        @WebParam(name = "UserInfo", targetNamespace = "")
        GracTWsUserInfo userInfo,
        @WebParam(name = "MsgReturn", targetNamespace = "", mode = WebParam.Mode.OUT)
        Holder<GracSWsApiMessage> msgReturn,
        @WebParam(name = "RequestId", targetNamespace = "", mode = WebParam.Mode.OUT)
        Holder<String> requestId,
        @WebParam(name = "RequestNo", targetNamespace = "", mode = WebParam.Mode.OUT)
        Holder<String> requestNo)
        throws GracIdmUsrAccsReqServicesException
    ;

}
