
package oracle.iam.ws.sap.ac53.searchroles;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import oracle.iam.ws.sap.ac53.searchroles.core.BOException;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oracle.iam.ws.sap.ac53.searchroles package. 
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

    private final static QName _GetRolesComVirsaAeCoreBOException_QNAME = new QName("urn:SAPGRC_AC_IDM_SEARCHROLESWsd/SAPGRC_AC_IDM_SEARCHROLESVi", "getRoles_com.virsa.ae.core.BOException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oracle.iam.ws.sap.ac53.searchroles
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetRolesResponse }
     * 
     */
    public GetRolesResponse createGetRolesResponse() {
        return new GetRolesResponse();
    }

    /**
     * Create an instance of {@link GetRoles }
     * 
     */
    public GetRoles createGetRoles() {
        return new GetRoles();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BOException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:SAPGRC_AC_IDM_SEARCHROLESWsd/SAPGRC_AC_IDM_SEARCHROLESVi", name = "getRoles_com.virsa.ae.core.BOException")
    public JAXBElement<BOException> createGetRolesComVirsaAeCoreBOException(BOException value) {
        return new JAXBElement<BOException>(_GetRolesComVirsaAeCoreBOException_QNAME, BOException.class, null, value);
    }

}
