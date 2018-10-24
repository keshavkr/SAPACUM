
package oracle.iam.ws.sap.ac10.requeststatus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsRsOpRequestList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsRsOpRequestList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Reqno" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReqCreated" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Priority" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Requestorid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Duedate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UserList" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracTApiReqUserInfo"/>
 *         &lt;element name="Reqstatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReqstatusTxt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Approver" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracWsRsOpApprover"/>
 *         &lt;element name="Reqcurrentstage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GracSWsRsOpRequestList", propOrder = {
    "reqno",
    "reqCreated",
    "priority",
    "requestorid",
    "duedate",
    "userList",
    "reqstatus",
    "reqstatusTxt",
    "approver",
    "reqcurrentstage"
})
public class GracSWsRsOpRequestList {

    @XmlElement(name = "Reqno", required = true)
    protected String reqno;
    @XmlElement(name = "ReqCreated", required = true)
    protected String reqCreated;
    @XmlElement(name = "Priority", required = true)
    protected String priority;
    @XmlElement(name = "Requestorid", required = true)
    protected String requestorid;
    @XmlElement(name = "Duedate", required = true)
    protected String duedate;
    @XmlElement(name = "UserList", required = true)
    protected GracTApiReqUserInfo userList;
    @XmlElement(name = "Reqstatus", required = true)
    protected String reqstatus;
    @XmlElement(name = "ReqstatusTxt", required = true)
    protected String reqstatusTxt;
    @XmlElement(name = "Approver", required = true)
    protected GracWsRsOpApprover approver;
    @XmlElement(name = "Reqcurrentstage", required = true)
    protected String reqcurrentstage;

    /**
     * Gets the value of the reqno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReqno() {
        return reqno;
    }

    /**
     * Sets the value of the reqno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReqno(String value) {
        this.reqno = value;
    }

    /**
     * Gets the value of the reqCreated property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReqCreated() {
        return reqCreated;
    }

    /**
     * Sets the value of the reqCreated property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReqCreated(String value) {
        this.reqCreated = value;
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
     * Gets the value of the requestorid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestorid() {
        return requestorid;
    }

    /**
     * Sets the value of the requestorid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestorid(String value) {
        this.requestorid = value;
    }

    /**
     * Gets the value of the duedate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDuedate() {
        return duedate;
    }

    /**
     * Sets the value of the duedate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDuedate(String value) {
        this.duedate = value;
    }

    /**
     * Gets the value of the userList property.
     * 
     * @return
     *     possible object is
     *     {@link GracTApiReqUserInfo }
     *     
     */
    public GracTApiReqUserInfo getUserList() {
        return userList;
    }

    /**
     * Sets the value of the userList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracTApiReqUserInfo }
     *     
     */
    public void setUserList(GracTApiReqUserInfo value) {
        this.userList = value;
    }

    /**
     * Gets the value of the reqstatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReqstatus() {
        return reqstatus;
    }

    /**
     * Sets the value of the reqstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReqstatus(String value) {
        this.reqstatus = value;
    }

    /**
     * Gets the value of the reqstatusTxt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReqstatusTxt() {
        return reqstatusTxt;
    }

    /**
     * Sets the value of the reqstatusTxt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReqstatusTxt(String value) {
        this.reqstatusTxt = value;
    }

    /**
     * Gets the value of the approver property.
     * 
     * @return
     *     possible object is
     *     {@link GracWsRsOpApprover }
     *     
     */
    public GracWsRsOpApprover getApprover() {
        return approver;
    }

    /**
     * Sets the value of the approver property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracWsRsOpApprover }
     *     
     */
    public void setApprover(GracWsRsOpApprover value) {
        this.approver = value;
    }

    /**
     * Gets the value of the reqcurrentstage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReqcurrentstage() {
        return reqcurrentstage;
    }

    /**
     * Sets the value of the reqcurrentstage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReqcurrentstage(String value) {
        this.reqcurrentstage = value;
    }

}
