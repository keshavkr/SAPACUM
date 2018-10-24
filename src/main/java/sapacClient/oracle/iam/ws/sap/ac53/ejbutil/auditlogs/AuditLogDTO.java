
package oracle.iam.ws.sap.ac53.ejbutil.auditlogs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for AuditLogDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuditLogDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="logDetails" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="priority" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="requestHst" type="{urn:com.virsa.ae.ejbutil.auditlogs}ArrayOfRequestHistoryDTO" minOccurs="0"/>
 *         &lt;element name="requestId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="requestedBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="submittedBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuditLogDTO", propOrder = {
    "createDate",
    "logDetails",
    "priority",
    "requestHst",
    "requestId",
    "requestedBy",
    "status",
    "submittedBy"
})
public class AuditLogDTO {

    @XmlElement(nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createDate;
    @XmlElement(nillable = true)
    protected String logDetails;
    @XmlElement(nillable = true)
    protected String priority;
    @XmlElement(nillable = true)
    protected ArrayOfRequestHistoryDTO requestHst;
    @XmlElement(nillable = true)
    protected String requestId;
    @XmlElement(nillable = true)
    protected String requestedBy;
    @XmlElement(nillable = true)
    protected String status;
    @XmlElement(nillable = true)
    protected String submittedBy;

    /**
     * Gets the value of the createDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreateDate() {
        return createDate;
    }

    /**
     * Sets the value of the createDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreateDate(XMLGregorianCalendar value) {
        this.createDate = value;
    }

    /**
     * Gets the value of the logDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogDetails() {
        return logDetails;
    }

    /**
     * Sets the value of the logDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogDetails(String value) {
        this.logDetails = value;
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
     * Gets the value of the requestHst property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRequestHistoryDTO }
     *     
     */
    public ArrayOfRequestHistoryDTO getRequestHst() {
        return requestHst;
    }

    /**
     * Sets the value of the requestHst property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRequestHistoryDTO }
     *     
     */
    public void setRequestHst(ArrayOfRequestHistoryDTO value) {
        this.requestHst = value;
    }

    /**
     * Gets the value of the requestId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * Sets the value of the requestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestId(String value) {
        this.requestId = value;
    }

    /**
     * Gets the value of the requestedBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestedBy() {
        return requestedBy;
    }

    /**
     * Sets the value of the requestedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestedBy(String value) {
        this.requestedBy = value;
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
     * Gets the value of the submittedBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubmittedBy() {
        return submittedBy;
    }

    /**
     * Sets the value of the submittedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubmittedBy(String value) {
        this.submittedBy = value;
    }

}
