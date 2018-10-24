
package oracle.iam.ws.sap.ac53.ejbutil.searchroles;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfRolesDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfRolesDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RolesDTO" type="{urn:com.virsa.ae.ejbutil.searchroles}RolesDTO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfRolesDTO", propOrder = {
    "rolesDTO"
})
public class ArrayOfRolesDTO {

    @XmlElement(name = "RolesDTO", nillable = true)
    protected List<RolesDTO> rolesDTO;

    /**
     * Gets the value of the rolesDTO property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rolesDTO property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRolesDTO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RolesDTO }
     * 
     * 
     */
    public List<RolesDTO> getRolesDTO() {
        if (rolesDTO == null) {
            rolesDTO = new ArrayList<RolesDTO>();
        }
        return this.rolesDTO;
    }

}
