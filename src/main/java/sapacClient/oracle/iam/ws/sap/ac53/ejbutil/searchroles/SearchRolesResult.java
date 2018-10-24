
package oracle.iam.ws.sap.ac53.ejbutil.searchroles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oracle.iam.ws.sap.ac53.searchroles.ejbutil.ServiceStatusDTO;


/**
 * <p>Java class for SearchRolesResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchRolesResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rolesDTO" type="{urn:com.virsa.ae.ejbutil.searchroles}ArrayofRolesDTO1" minOccurs="0"/>
 *         &lt;element name="status" type="{urn:com.virsa.ae.ejbutil}ServiceStatusDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchRolesResult", propOrder = {
    "rolesDTO",
    "status"
})
public class SearchRolesResult {

    @XmlElement(nillable = true)
    protected ArrayofRolesDTO1 rolesDTO;
    @XmlElement(nillable = true)
    protected ServiceStatusDTO status;

    /**
     * Gets the value of the rolesDTO property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayofRolesDTO1 }
     *     
     */
    public ArrayofRolesDTO1 getRolesDTO() {
        return rolesDTO;
    }

    /**
     * Sets the value of the rolesDTO property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayofRolesDTO1 }
     *     
     */
    public void setRolesDTO(ArrayofRolesDTO1 value) {
        this.rolesDTO = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceStatusDTO }
     *     
     */
    public ServiceStatusDTO getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceStatusDTO }
     *     
     */
    public void setStatus(ServiceStatusDTO value) {
        this.status = value;
    }

}
