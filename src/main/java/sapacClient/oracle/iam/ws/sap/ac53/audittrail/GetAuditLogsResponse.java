
package oracle.iam.ws.sap.ac53.audittrail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import oracle.iam.ws.sap.ac53.ejbutil.auditlogs.AuditLogResult;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Response" type="{urn:com.virsa.ae.ejbutil.auditlogs}AuditLogResult"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "response"
})
@XmlRootElement(name = "getAuditLogsResponse")
public class GetAuditLogsResponse {

    @XmlElement(name = "Response", required = true, nillable = true)
    protected AuditLogResult response;

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link AuditLogResult }
     *     
     */
    public AuditLogResult getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuditLogResult }
     *     
     */
    public void setResponse(AuditLogResult value) {
        this.response = value;
    }

}
