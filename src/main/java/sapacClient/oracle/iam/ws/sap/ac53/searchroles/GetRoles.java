
package oracle.iam.ws.sap.ac53.searchroles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="application" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="accessType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="businessProcess" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="subProcess" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="role" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="roleDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="functionalArea" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="company" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="transactionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="locale" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hitCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "application",
    "accessType",
    "businessProcess",
    "subProcess",
    "role",
    "roleDesc",
    "functionalArea",
    "company",
    "transactionCode",
    "userId",
    "locale",
    "hitCount"
})
@XmlRootElement(name = "getRoles")
public class GetRoles {

    @XmlElement(required = true, nillable = true)
    protected String application;
    @XmlElement(required = true, nillable = true)
    protected String accessType;
    @XmlElement(required = true, nillable = true)
    protected String businessProcess;
    @XmlElement(required = true, nillable = true)
    protected String subProcess;
    @XmlElement(required = true, nillable = true)
    protected String role;
    @XmlElement(required = true, nillable = true)
    protected String roleDesc;
    @XmlElement(required = true, nillable = true)
    protected String functionalArea;
    @XmlElement(required = true, nillable = true)
    protected String company;
    @XmlElement(required = true, nillable = true)
    protected String transactionCode;
    @XmlElement(required = true, nillable = true)
    protected String userId;
    @XmlElement(required = true, nillable = true)
    protected String locale;
    protected int hitCount;

    /**
     * Gets the value of the application property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplication() {
        return application;
    }

    /**
     * Sets the value of the application property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplication(String value) {
        this.application = value;
    }

    /**
     * Gets the value of the accessType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessType() {
        return accessType;
    }

    /**
     * Sets the value of the accessType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessType(String value) {
        this.accessType = value;
    }

    /**
     * Gets the value of the businessProcess property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessProcess() {
        return businessProcess;
    }

    /**
     * Sets the value of the businessProcess property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessProcess(String value) {
        this.businessProcess = value;
    }

    /**
     * Gets the value of the subProcess property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubProcess() {
        return subProcess;
    }

    /**
     * Sets the value of the subProcess property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubProcess(String value) {
        this.subProcess = value;
    }

    /**
     * Gets the value of the role property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the value of the role property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRole(String value) {
        this.role = value;
    }

    /**
     * Gets the value of the roleDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoleDesc() {
        return roleDesc;
    }

    /**
     * Sets the value of the roleDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleDesc(String value) {
        this.roleDesc = value;
    }

    /**
     * Gets the value of the functionalArea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFunctionalArea() {
        return functionalArea;
    }

    /**
     * Sets the value of the functionalArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFunctionalArea(String value) {
        this.functionalArea = value;
    }

    /**
     * Gets the value of the company property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets the value of the company property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompany(String value) {
        this.company = value;
    }

    /**
     * Gets the value of the transactionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionCode() {
        return transactionCode;
    }

    /**
     * Sets the value of the transactionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionCode(String value) {
        this.transactionCode = value;
    }

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

    /**
     * Gets the value of the locale property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocale() {
        return locale;
    }

    /**
     * Sets the value of the locale property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocale(String value) {
        this.locale = value;
    }

    /**
     * Gets the value of the hitCount property.
     * 
     */
    public int getHitCount() {
        return hitCount;
    }

    /**
     * Sets the value of the hitCount property.
     * 
     */
    public void setHitCount(int value) {
        this.hitCount = value;
    }

}
