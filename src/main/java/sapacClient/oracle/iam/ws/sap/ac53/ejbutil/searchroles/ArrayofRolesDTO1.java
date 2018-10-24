
package oracle.iam.ws.sap.ac53.ejbutil.searchroles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayofRolesDTO1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayofRolesDTO1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rolesDTO" type="{urn:com.virsa.ae.ejbutil.searchroles}ArrayOfRolesDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayofRolesDTO1", propOrder = {
    "rolesDTO"
})
public class ArrayofRolesDTO1 {

    @XmlElement(nillable = true)
    protected ArrayOfRolesDTO rolesDTO;

    /**
     * Gets the value of the rolesDTO property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRolesDTO }
     *     
     */
    public ArrayOfRolesDTO getRolesDTO() {
        return rolesDTO;
    }

    /**
     * Sets the value of the rolesDTO property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRolesDTO }
     *     
     */
    public void setRolesDTO(ArrayOfRolesDTO value) {
        this.rolesDTO = value;
    }

}
