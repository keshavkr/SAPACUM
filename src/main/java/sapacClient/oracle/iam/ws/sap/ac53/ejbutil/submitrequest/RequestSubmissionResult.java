
package oracle.iam.ws.sap.ac53.ejbutil.submitrequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oracle.iam.ws.sap.ac53.submitrequest.ejbutil.ServiceStatusDTO;


/**
 * <p>Java class for RequestSubmissionResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestSubmissionResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "RequestSubmissionResult", propOrder = {
    "requestNo",
    "status"
})
public class RequestSubmissionResult {

    @XmlElement(nillable = true)
    protected String requestNo;
    @XmlElement(nillable = true)
    protected ServiceStatusDTO status;

    /**
     * Gets the value of the requestNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestNo() {
        return requestNo;
    }

    /**
     * Sets the value of the requestNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestNo(String value) {
        this.requestNo = value;
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
