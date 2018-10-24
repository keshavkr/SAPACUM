
package oracle.iam.ws.sap.ac53.ejbutil.selectsystem;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfSystemData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfSystemData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SystemData" type="{urn:com.virsa.ae.ejbutil.selectsystem}SystemData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSystemData", propOrder = {
    "systemData"
})
public class ArrayOfSystemData {

    @XmlElement(name = "SystemData", nillable = true)
    protected List<SystemData> systemData;

    /**
     * Gets the value of the systemData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the systemData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSystemData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SystemData }
     * 
     * 
     */
    public List<SystemData> getSystemData() {
        if (systemData == null) {
            systemData = new ArrayList<SystemData>();
        }
        return this.systemData;
    }

}
