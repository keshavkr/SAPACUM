
package oracle.iam.ws.sap.ac53.submitrequest.ejbutil;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for RequestDetailsData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestDetailsData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="application" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="company" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customField" type="{urn:com.virsa.ae.ejbutil}ArrayOfCustomFieldsDTO" minOccurs="0"/>
 *         &lt;element name="department" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="emailAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="employeeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="functionalArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="locale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="managerTelephone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mgrEmailAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mgrFirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mgrId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mgrLastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="priority" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="requestReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="requestType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="requestorEmailAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="requestorFirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="requestorId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="requestorLastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="requestorTelephone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="roles" type="{urn:com.virsa.ae.ejbutil}ArrayOfRoleData" minOccurs="0"/>
 *         &lt;element name="sNCName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="telephone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unsecureLogon" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="validFrom" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="validTo" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestDetailsData", propOrder = {
    "application",
    "company",
    "customField",
    "department",
    "emailAddress",
    "employeeType",
    "firstName",
    "functionalArea",
    "lastName",
    "locale",
    "location",
    "managerTelephone",
    "mgrEmailAddress",
    "mgrFirstName",
    "mgrId",
    "mgrLastName",
    "priority",
    "requestReason",
    "requestType",
    "requestorEmailAddress",
    "requestorFirstName",
    "requestorId",
    "requestorLastName",
    "requestorTelephone",
    "roles",
    "sncName",
    "telephone",
    "unsecureLogon",
    "userId",
    "validFrom",
    "validTo"
})
public class RequestDetailsData {

    @XmlElement(nillable = true)
    protected String application;
    @XmlElement(nillable = true)
    protected String company;
    @XmlElement(nillable = true)
    protected ArrayOfCustomFieldsDTO customField;
    @XmlElement(nillable = true)
    protected String department;
    @XmlElement(nillable = true)
    protected String emailAddress;
    @XmlElement(nillable = true)
    protected String employeeType;
    @XmlElement(nillable = true)
    protected String firstName;
    @XmlElement(nillable = true)
    protected String functionalArea;
    @XmlElement(nillable = true)
    protected String lastName;
    @XmlElement(nillable = true)
    protected String locale;
    @XmlElement(nillable = true)
    protected String location;
    @XmlElement(nillable = true)
    protected String managerTelephone;
    @XmlElement(nillable = true)
    protected String mgrEmailAddress;
    @XmlElement(nillable = true)
    protected String mgrFirstName;
    @XmlElement(nillable = true)
    protected String mgrId;
    @XmlElement(nillable = true)
    protected String mgrLastName;
    @XmlElement(nillable = true)
    protected String priority;
    @XmlElement(nillable = true)
    protected String requestReason;
    @XmlElement(nillable = true)
    protected String requestType;
    @XmlElement(nillable = true)
    protected String requestorEmailAddress;
    @XmlElement(nillable = true)
    protected String requestorFirstName;
    @XmlElement(nillable = true)
    protected String requestorId;
    @XmlElement(nillable = true)
    protected String requestorLastName;
    @XmlElement(nillable = true)
    protected String requestorTelephone;
    @XmlElement(nillable = true)
    protected ArrayOfRoleData roles;
    @XmlElement(name = "sNCName", nillable = true)
    protected String sncName;
    @XmlElement(nillable = true)
    protected String telephone;
    @XmlElement(nillable = true)
    protected Boolean unsecureLogon;
    @XmlElement(nillable = true)
    protected String userId;
    @XmlElement(nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar validFrom;
    @XmlElement(nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar validTo;

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
     * Gets the value of the customField property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCustomFieldsDTO }
     *     
     */
    public ArrayOfCustomFieldsDTO getCustomField() {
        return customField;
    }

    /**
     * Sets the value of the customField property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCustomFieldsDTO }
     *     
     */
    public void setCustomField(ArrayOfCustomFieldsDTO value) {
        this.customField = value;
    }

    /**
     * Gets the value of the department property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the value of the department property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartment(String value) {
        this.department = value;
    }

    /**
     * Gets the value of the emailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the value of the emailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAddress(String value) {
        this.emailAddress = value;
    }

    /**
     * Gets the value of the employeeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmployeeType() {
        return employeeType;
    }

    /**
     * Sets the value of the employeeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmployeeType(String value) {
        this.employeeType = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
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
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
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
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Gets the value of the managerTelephone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManagerTelephone() {
        return managerTelephone;
    }

    /**
     * Sets the value of the managerTelephone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManagerTelephone(String value) {
        this.managerTelephone = value;
    }

    /**
     * Gets the value of the mgrEmailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMgrEmailAddress() {
        return mgrEmailAddress;
    }

    /**
     * Sets the value of the mgrEmailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMgrEmailAddress(String value) {
        this.mgrEmailAddress = value;
    }

    /**
     * Gets the value of the mgrFirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMgrFirstName() {
        return mgrFirstName;
    }

    /**
     * Sets the value of the mgrFirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMgrFirstName(String value) {
        this.mgrFirstName = value;
    }

    /**
     * Gets the value of the mgrId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMgrId() {
        return mgrId;
    }

    /**
     * Sets the value of the mgrId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMgrId(String value) {
        this.mgrId = value;
    }

    /**
     * Gets the value of the mgrLastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMgrLastName() {
        return mgrLastName;
    }

    /**
     * Sets the value of the mgrLastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMgrLastName(String value) {
        this.mgrLastName = value;
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
     * Gets the value of the requestType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestType() {
        return requestType;
    }

    /**
     * Sets the value of the requestType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestType(String value) {
        this.requestType = value;
    }

    /**
     * Gets the value of the requestorEmailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestorEmailAddress() {
        return requestorEmailAddress;
    }

    /**
     * Sets the value of the requestorEmailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestorEmailAddress(String value) {
        this.requestorEmailAddress = value;
    }

    /**
     * Gets the value of the requestorFirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestorFirstName() {
        return requestorFirstName;
    }

    /**
     * Sets the value of the requestorFirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestorFirstName(String value) {
        this.requestorFirstName = value;
    }

    /**
     * Gets the value of the requestorId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestorId() {
        return requestorId;
    }

    /**
     * Sets the value of the requestorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestorId(String value) {
        this.requestorId = value;
    }

    /**
     * Gets the value of the requestorLastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestorLastName() {
        return requestorLastName;
    }

    /**
     * Sets the value of the requestorLastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestorLastName(String value) {
        this.requestorLastName = value;
    }

    /**
     * Gets the value of the requestorTelephone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestorTelephone() {
        return requestorTelephone;
    }

    /**
     * Sets the value of the requestorTelephone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestorTelephone(String value) {
        this.requestorTelephone = value;
    }

    /**
     * Gets the value of the roles property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRoleData }
     *     
     */
    public ArrayOfRoleData getRoles() {
        return roles;
    }

    /**
     * Sets the value of the roles property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRoleData }
     *     
     */
    public void setRoles(ArrayOfRoleData value) {
        this.roles = value;
    }

    /**
     * Gets the value of the sncName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSNCName() {
        return sncName;
    }

    /**
     * Sets the value of the sncName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSNCName(String value) {
        this.sncName = value;
    }

    /**
     * Gets the value of the telephone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Sets the value of the telephone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelephone(String value) {
        this.telephone = value;
    }

    /**
     * Gets the value of the unsecureLogon property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUnsecureLogon() {
        return unsecureLogon;
    }

    /**
     * Sets the value of the unsecureLogon property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUnsecureLogon(Boolean value) {
        this.unsecureLogon = value;
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
     * Gets the value of the validFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidFrom() {
        return validFrom;
    }

    /**
     * Sets the value of the validFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidFrom(XMLGregorianCalendar value) {
        this.validFrom = value;
    }

    /**
     * Gets the value of the validTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidTo() {
        return validTo;
    }

    /**
     * Sets the value of the validTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidTo(XMLGregorianCalendar value) {
        this.validTo = value;
    }

}
