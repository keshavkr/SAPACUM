
package oracle.iam.ws.sap.ac10.useraccess;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oracle.iam.ws.sap.ac10.useraccess package. 
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

    private final static QName _GracIdmUsrAccsReqServicesException_QNAME = new QName("urn:sap-com:document:sap:soap:functions:mc-style", "GracIdmUsrAccsReqServices.Exception");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oracle.iam.ws.sap.ac10.useraccess
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GracTWsUaIpPrameterList }
     * 
     */
    public GracTWsUaIpPrameterList createGracTWsUaIpPrameterList() {
        return new GracTWsUaIpPrameterList();
    }

    /**
     * Create an instance of {@link GracSWsApiMessage }
     * 
     */
    public GracSWsApiMessage createGracSWsApiMessage() {
        return new GracSWsApiMessage();
    }

    /**
     * Create an instance of {@link GracTWsUaIpCustfldVal }
     * 
     */
    public GracTWsUaIpCustfldVal createGracTWsUaIpCustfldVal() {
        return new GracTWsUaIpCustfldVal();
    }

    /**
     * Create an instance of {@link GracIdmUsrAccsReqServicesRfcException }
     * 
     */
    public GracIdmUsrAccsReqServicesRfcException createGracIdmUsrAccsReqServicesRfcException() {
        return new GracIdmUsrAccsReqServicesRfcException();
    }

    /**
     * Create an instance of {@link GracIdmUsrAccsReqServicesResponse }
     * 
     */
    public GracIdmUsrAccsReqServicesResponse createGracIdmUsrAccsReqServicesResponse() {
        return new GracIdmUsrAccsReqServicesResponse();
    }

    /**
     * Create an instance of {@link GracTWsUaIpReqlineitem }
     * 
     */
    public GracTWsUaIpReqlineitem createGracTWsUaIpReqlineitem() {
        return new GracTWsUaIpReqlineitem();
    }

    /**
     * Create an instance of {@link GracTWsUaIpUserGroup }
     * 
     */
    public GracTWsUaIpUserGroup createGracTWsUaIpUserGroup() {
        return new GracTWsUaIpUserGroup();
    }

    /**
     * Create an instance of {@link GracSWsReqhdr }
     * 
     */
    public GracSWsReqhdr createGracSWsReqhdr() {
        return new GracSWsReqhdr();
    }

    /**
     * Create an instance of {@link GracTWsUserInfo }
     * 
     */
    public GracTWsUserInfo createGracTWsUserInfo() {
        return new GracTWsUserInfo();
    }

    /**
     * Create an instance of {@link GracIdmUsrAccsReqServices }
     * 
     */
    public GracIdmUsrAccsReqServices createGracIdmUsrAccsReqServices() {
        return new GracIdmUsrAccsReqServices();
    }

    /**
     * Create an instance of {@link GracSWsApiUserInfo }
     * 
     */
    public GracSWsApiUserInfo createGracSWsApiUserInfo() {
        return new GracSWsApiUserInfo();
    }

    /**
     * Create an instance of {@link RfcExceptionMessage }
     * 
     */
    public RfcExceptionMessage createRfcExceptionMessage() {
        return new RfcExceptionMessage();
    }

    /**
     * Create an instance of {@link GracSWsUaIpUserGroup }
     * 
     */
    public GracSWsUaIpUserGroup createGracSWsUaIpUserGroup() {
        return new GracSWsUaIpUserGroup();
    }

    /**
     * Create an instance of {@link GracSWsUaIpPrameterList }
     * 
     */
    public GracSWsUaIpPrameterList createGracSWsUaIpPrameterList() {
        return new GracSWsUaIpPrameterList();
    }

    /**
     * Create an instance of {@link GracSWsUaIpReqlineitem }
     * 
     */
    public GracSWsUaIpReqlineitem createGracSWsUaIpReqlineitem() {
        return new GracSWsUaIpReqlineitem();
    }

    /**
     * Create an instance of {@link GracSWsUaIpCustfldVal }
     * 
     */
    public GracSWsUaIpCustfldVal createGracSWsUaIpCustfldVal() {
        return new GracSWsUaIpCustfldVal();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GracIdmUsrAccsReqServicesRfcException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sap-com:document:sap:soap:functions:mc-style", name = "GracIdmUsrAccsReqServices.Exception")
    public JAXBElement<GracIdmUsrAccsReqServicesRfcException> createGracIdmUsrAccsReqServicesException(GracIdmUsrAccsReqServicesRfcException value) {
        return new JAXBElement<GracIdmUsrAccsReqServicesRfcException>(_GracIdmUsrAccsReqServicesException_QNAME, GracIdmUsrAccsReqServicesRfcException.class, null, value);
    }

}
