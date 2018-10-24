
package oracle.iam.ws.sap.ac53.ejbutil.auditlogs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oracle.iam.ws.sap.ac53.audittrail.ejbutil.ServiceStatusDTO;


/**
 * <p>Java class for AuditLogResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuditLogResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="auditLogDTO" type="{urn:com.virsa.ae.ejbutil.auditlogs}ArrayOfAuditLogDTO1" minOccurs="0"/>
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
@XmlType(name = "AuditLogResult", propOrder = {
    "auditLogDTO",
    "status"
})
public class AuditLogResult {

    @XmlElement(nillable = true)
    protected ArrayOfAuditLogDTO1 auditLogDTO;
    @XmlElement(nillable = true)
    protected ServiceStatusDTO status;

    /**
     * Gets the value of the auditLogDTO property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAuditLogDTO1 }
     *     
     */
    public ArrayOfAuditLogDTO1 getAuditLogDTO() {
        return auditLogDTO;
    }

    /**
     * Sets the value of the auditLogDTO property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAuditLogDTO1 }
     *     
     */
    public void setAuditLogDTO(ArrayOfAuditLogDTO1 value) {
        this.auditLogDTO = value;
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
