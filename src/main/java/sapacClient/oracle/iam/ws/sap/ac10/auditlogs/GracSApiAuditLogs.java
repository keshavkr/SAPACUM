
package oracle.iam.ws.sap.ac10.auditlogs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSApiAuditLogs complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSApiAuditLogs">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Requestnumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Requestedby" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Submittedby" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Createdate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Priority" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Itauditdata" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracTApiAuditlogData"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GracSApiAuditLogs", propOrder = {
    "requestnumber",
    "requestedby",
    "submittedby",
    "status",
    "createdate",
    "priority",
    "itauditdata"
})
public class GracSApiAuditLogs {

    @XmlElement(name = "Requestnumber", required = true)
    protected String requestnumber;
    @XmlElement(name = "Requestedby", required = true)
    protected String requestedby;
    @XmlElement(name = "Submittedby", required = true)
    protected String submittedby;
    @XmlElement(name = "Status", required = true)
    protected String status;
    @XmlElement(name = "Createdate", required = true)
    protected String createdate;
    @XmlElement(name = "Priority", required = true)
    protected String priority;
    @XmlElement(name = "Itauditdata", required = true)
    protected GracTApiAuditlogData itauditdata;

    /**
     * Gets the value of the requestnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestnumber() {
        return requestnumber;
    }

    /**
     * Sets the value of the requestnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestnumber(String value) {
        this.requestnumber = value;
    }

    /**
     * Gets the value of the requestedby property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestedby() {
        return requestedby;
    }

    /**
     * Sets the value of the requestedby property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestedby(String value) {
        this.requestedby = value;
    }

    /**
     * Gets the value of the submittedby property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubmittedby() {
        return submittedby;
    }

    /**
     * Sets the value of the submittedby property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubmittedby(String value) {
        this.submittedby = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the createdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatedate() {
        return createdate;
    }

    /**
     * Sets the value of the createdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatedate(String value) {
        this.createdate = value;
    }

    /**
     * Gets the value of the priority property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriority(String value) {
        this.priority = value;
    }

    /**
     * Gets the value of the itauditdata property.
     * 
     * @return
     *     possible object is
     *     {@link GracTApiAuditlogData }
     *     
     */
    public GracTApiAuditlogData getItauditdata() {
        return itauditdata;
    }

    /**
     * Sets the value of the itauditdata property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracTApiAuditlogData }
     *     
     */
    public void setItauditdata(GracTApiAuditlogData value) {
        this.itauditdata = value;
    }

}
