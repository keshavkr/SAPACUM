
package oracle.iam.ws.sap.ac53.ejbutil.selectsystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oracle.iam.ws.sap.ac53.selectsystem.ejbutil.ServiceStatusDTO;


/**
 * <p>Java class for SystemSelectionResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SystemSelectionResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="status" type="{urn:com.virsa.ae.ejbutil}ServiceStatusDTO" minOccurs="0"/>
 *         &lt;element name="systems" type="{urn:com.virsa.ae.ejbutil.selectsystem}ArrayOfSystemDatas" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SystemSelectionResult", propOrder = {
    "status",
    "systems"
})
public class SystemSelectionResult {

    @XmlElement(nillable = true)
    protected ServiceStatusDTO status;
    @XmlElement(nillable = true)
    protected ArrayOfSystemDatas systems;

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

    /**
     * Gets the value of the systems property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSystemDatas }
     *     
     */
    public ArrayOfSystemDatas getSystems() {
        return systems;
    }

    /**
     * Sets the value of the systems property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSystemDatas }
     *     
     */
    public void setSystems(ArrayOfSystemDatas value) {
        this.systems = value;
    }

}
