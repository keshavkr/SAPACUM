
package oracle.iam.ws.sap.ac10.requeststatus;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oracle.iam.ws.sap.ac10.requeststatus package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GracIdmRequestStatServicesException_QNAME = new QName("urn:sap-com:document:sap:soap:functions:mc-style", "GracIdmRequestStatServices.Exception");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oracle.iam.ws.sap.ac10.requeststatus
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RfcExceptionMessage }
     * 
     */
    public RfcExceptionMessage createRfcExceptionMessage() {
        return new RfcExceptionMessage();
    }

    /**
     * Create an instance of {@link GracIdmRequestStatServices }
     * 
     */
    public GracIdmRequestStatServices createGracIdmRequestStatServices() {
        return new GracIdmRequestStatServices();
    }

    /**
     * Create an instance of {@link GracIdmRequestStatServicesRfcException }
     * 
     */
    public GracIdmRequestStatServicesRfcException createGracIdmRequestStatServicesRfcException() {
        return new GracIdmRequestStatServicesRfcException();
    }

    /**
     * Create an instance of {@link GracSWsApiMessage }
     * 
     */
    public GracSWsApiMessage createGracSWsApiMessage() {
        return new GracSWsApiMessage();
    }

    /**
     * Create an instance of {@link GracSApiApprover }
     * 
     */
    public GracSApiApprover createGracSApiApprover() {
        return new GracSApiApprover();
    }

    /**
     * Create an instance of {@link GracWsRsOpApprover }
     * 
     */
    public GracWsRsOpApprover createGracWsRsOpApprover() {
        return new GracWsRsOpApprover();
    }

    /**
     * Create an instance of {@link GracSWsRsOpRequestList }
     * 
     */
    public GracSWsRsOpRequestList createGracSWsRsOpRequestList() {
        return new GracSWsRsOpRequestList();
    }

    /**
     * Create an instance of {@link GracIdmRequestStatServicesResponse }
     * 
     */
    public GracIdmRequestStatServicesResponse createGracIdmRequestStatServicesResponse() {
        return new GracIdmRequestStatServicesResponse();
    }

    /**
     * Create an instance of {@link GracTApiReqUserInfo }
     * 
     */
    public GracTApiReqUserInfo createGracTApiReqUserInfo() {
        return new GracTApiReqUserInfo();
    }

    /**
     * Create an instance of {@link GracSApiReqUserInfo }
     * 
     */
    public GracSApiReqUserInfo createGracSApiReqUserInfo() {
        return new GracSApiReqUserInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GracIdmRequestStatServicesRfcException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sap-com:document:sap:soap:functions:mc-style", name = "GracIdmRequestStatServices.Exception")
    public JAXBElement<GracIdmRequestStatServicesRfcException> createGracIdmRequestStatServicesException(GracIdmRequestStatServicesRfcException value) {
        return new JAXBElement<GracIdmRequestStatServicesRfcException>(_GracIdmRequestStatServicesException_QNAME, GracIdmRequestStatServicesRfcException.class, null, value);
    }

}
