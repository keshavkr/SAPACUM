
package oracle.iam.ws.sap.ac53.selectsystem;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import oracle.iam.ws.sap.ac53.ejbutil.selectsystem.ConfigurationException;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oracle.iam.ws.sap.ac53.selectsystem package. 
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

    private final static QName _GetSystemsComVirsaAeEjbutilSelectsystemConfigurationException_QNAME = new QName("urn:SAPGRC_AC_IDM_SELECTAPPLICATIONWsd/SAPGRC_AC_IDM_SELECTAPPLICATIONVi", "getSystems_com.virsa.ae.ejbutil.selectsystem.ConfigurationException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oracle.iam.ws.sap.ac53.selectsystem
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetSystemsResponse }
     * 
     */
    public GetSystemsResponse createGetSystemsResponse() {
        return new GetSystemsResponse();
    }

    /**
     * Create an instance of {@link GetSystems }
     * 
     */
    public GetSystems createGetSystems() {
        return new GetSystems();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfigurationException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:SAPGRC_AC_IDM_SELECTAPPLICATIONWsd/SAPGRC_AC_IDM_SELECTAPPLICATIONVi", name = "getSystems_com.virsa.ae.ejbutil.selectsystem.ConfigurationException")
    public JAXBElement<ConfigurationException> createGetSystemsComVirsaAeEjbutilSelectsystemConfigurationException(ConfigurationException value) {
        return new JAXBElement<ConfigurationException>(_GetSystemsComVirsaAeEjbutilSelectsystemConfigurationException_QNAME, ConfigurationException.class, null, value);
    }

}
