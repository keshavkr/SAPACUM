
package oracle.iam.ws.sap.ac10.useraccess;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsReqhdr complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsReqhdr">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Reqtype" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Priority" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReqDueDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReqInitSystem" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Requestorid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RequestReason" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Funcarea" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Bproc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GracSWsReqhdr", propOrder = {
    "reqtype",
    "priority",
    "reqDueDate",
    "reqInitSystem",
    "requestorid",
    "email",
    "requestReason",
    "funcarea",
    "bproc"
})
public class GracSWsReqhdr {

    @XmlElement(name = "Reqtype", required = true)
    protected String reqtype;
    @XmlElement(name = "Priority", required = true)
    protected String priority;
    @XmlElement(name = "ReqDueDate", required = true)
    protected String reqDueDate;
    @XmlElement(name = "ReqInitSystem", required = true)
    protected String reqInitSystem;
    @XmlElement(name = "Requestorid", required = true)
    protected String requestorid;
    @XmlElement(name = "Email", required = true)
    protected String email;
    @XmlElement(name = "RequestReason", required = true)
    protected String requestReason;
    @XmlElement(name = "Funcarea", required = true)
    protected String funcarea;
    @XmlElement(name = "Bproc", required = true)
    protected String bproc;

    /**
     * Gets the value of the reqtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReqtype() {
        return reqtype;
    }

    /**
     * Sets the value of the reqtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReqtype(String value) {
        this.reqtype = value;
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
     * Gets the value of the reqDueDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReqDueDate() {
        return reqDueDate;
    }

    /**
     * Sets the value of the reqDueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReqDueDate(String value) {
        this.reqDueDate = value;
    }

    /**
     * Gets the value of the reqInitSystem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReqInitSystem() {
        return reqInitSystem;
    }

    /**
     * Sets the value of the reqInitSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReqInitSystem(String value) {
        this.reqInitSystem = value;
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
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the requestReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestReason() {
        return requestReason;
    }

    /**
     * Sets the value of the requestReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestReason(String value) {
        this.requestReason = value;
    }

    /**
     * Gets the value of the funcarea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFuncarea() {
        return funcarea;
    }

    /**
     * Sets the value of the funcarea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFuncarea(String value) {
        this.funcarea = value;
    }

    /**
     * Gets the value of the bproc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBproc() {
        return bproc;
    }

    /**
     * Sets the value of the bproc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBproc(String value) {
        this.bproc = value;
    }

}
