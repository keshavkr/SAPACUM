
package oracle.iam.ws.sap.ac10.lookup;

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
 *         &lt;element name="BusProc" type="{urn:sap-com:document:sap:rfc:functions}char1" minOccurs="0"/>
 *         &lt;element name="BusSubProc" type="{urn:sap-com:document:sap:rfc:functions}char1" minOccurs="0"/>
 *         &lt;element name="CommunicationType" type="{urn:sap-com:document:sap:rfc:functions}char1" minOccurs="0"/>
 *         &lt;element name="CriticalLevel" type="{urn:sap-com:document:sap:rfc:functions}char1" minOccurs="0"/>
 *         &lt;element name="CustomFieldValues" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracSWsLuIpCustFldVal" minOccurs="0"/>
 *         &lt;element name="EmployeeType" type="{urn:sap-com:document:sap:rfc:functions}char1" minOccurs="0"/>
 *         &lt;element name="FunctionArea" type="{urn:sap-com:document:sap:rfc:functions}char1" minOccurs="0"/>
 *         &lt;element name="ItemProvActionType" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracSWsLuIpItmPrvActns" minOccurs="0"/>
 *         &lt;element name="ItemProvType" type="{urn:sap-com:document:sap:rfc:functions}char1" minOccurs="0"/>
 *         &lt;element name="Landscape" type="{urn:sap-com:document:sap:rfc:functions}char1" minOccurs="0"/>
 *         &lt;element name="Language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OmObjectType" type="{urn:sap-com:document:sap:rfc:functions}char1" minOccurs="0"/>
 *         &lt;element name="OmObjectValue" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracSWsLuIpOmObjectVal" minOccurs="0"/>
 *         &lt;element name="Phase" type="{urn:sap-com:document:sap:rfc:functions}char1" minOccurs="0"/>
 *         &lt;element name="PriorityType" type="{urn:sap-com:document:sap:rfc:functions}char1" minOccurs="0"/>
 *         &lt;element name="ProjectRelease" type="{urn:sap-com:document:sap:rfc:functions}char1" minOccurs="0"/>
 *         &lt;element name="RequestCustomFields" type="{urn:sap-com:document:sap:rfc:functions}char1" minOccurs="0"/>
 *         &lt;element name="RequestType" type="{urn:sap-com:document:sap:rfc:functions}char1" minOccurs="0"/>
 *         &lt;element name="RoleCustomFields" type="{urn:sap-com:document:sap:rfc:functions}char1" minOccurs="0"/>
 *         &lt;element name="RoleSensitivity" type="{urn:sap-com:document:sap:rfc:functions}char1" minOccurs="0"/>
 *         &lt;element name="RoleStatus" type="{urn:sap-com:document:sap:rfc:functions}char1" minOccurs="0"/>
 *         &lt;element name="RoleType" type="{urn:sap-com:document:sap:rfc:functions}char1" minOccurs="0"/>
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
    "busProc",
    "busSubProc",
    "communicationType",
    "criticalLevel",
    "customFieldValues",
    "employeeType",
    "functionArea",
    "itemProvActionType",
    "itemProvType",
    "landscape",
    "language",
    "omObjectType",
    "omObjectValue",
    "phase",
    "priorityType",
    "projectRelease",
    "requestCustomFields",
    "requestType",
    "roleCustomFields",
    "roleSensitivity",
    "roleStatus",
    "roleType"
})
@XmlRootElement(name = "GracIdmLookupServices")
public class GracIdmLookupServices {

    @XmlElement(name = "BusProc")
    protected String busProc;
    @XmlElement(name = "BusSubProc")
    protected String busSubProc;
    @XmlElement(name = "CommunicationType")
    protected String communicationType;
    @XmlElement(name = "CriticalLevel")
    protected String criticalLevel;
    @XmlElement(name = "CustomFieldValues")
    protected GracSWsLuIpCustFldVal customFieldValues;
    @XmlElement(name = "EmployeeType")
    protected String employeeType;
    @XmlElement(name = "FunctionArea")
    protected String functionArea;
    @XmlElement(name = "ItemProvActionType")
    protected GracSWsLuIpItmPrvActns itemProvActionType;
    @XmlElement(name = "ItemProvType")
    protected String itemProvType;
    @XmlElement(name = "Landscape")
    protected String landscape;
    @XmlElement(name = "Language")
    protected String language;
    @XmlElement(name = "OmObjectType")
    protected String omObjectType;
    @XmlElement(name = "OmObjectValue")
    protected GracSWsLuIpOmObjectVal omObjectValue;
    @XmlElement(name = "Phase")
    protected String phase;
    @XmlElement(name = "PriorityType")
    protected String priorityType;
    @XmlElement(name = "ProjectRelease")
    protected String projectRelease;
    @XmlElement(name = "RequestCustomFields")
    protected String requestCustomFields;
    @XmlElement(name = "RequestType")
    protected String requestType;
    @XmlElement(name = "RoleCustomFields")
    protected String roleCustomFields;
    @XmlElement(name = "RoleSensitivity")
    protected String roleSensitivity;
    @XmlElement(name = "RoleStatus")
    protected String roleStatus;
    @XmlElement(name = "RoleType")
    protected String roleType;

    /**
     * Gets the value of the busProc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusProc() {
        return busProc;
    }

    /**
     * Sets the value of the busProc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusProc(String value) {
        this.busProc = value;
    }

    /**
     * Gets the value of the busSubProc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusSubProc() {
        return busSubProc;
    }

    /**
     * Sets the value of the busSubProc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusSubProc(String value) {
        this.busSubProc = value;
    }

    /**
     * Gets the value of the communicationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommunicationType() {
        return communicationType;
    }

    /**
     * Sets the value of the communicationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommunicationType(String value) {
        this.communicationType = value;
    }

    /**
     * Gets the value of the criticalLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCriticalLevel() {
        return criticalLevel;
    }

    /**
     * Sets the value of the criticalLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCriticalLevel(String value) {
        this.criticalLevel = value;
    }

    /**
     * Gets the value of the customFieldValues property.
     * 
     * @return
     *     possible object is
     *     {@link GracSWsLuIpCustFldVal }
     *     
     */
    public GracSWsLuIpCustFldVal getCustomFieldValues() {
        return customFieldValues;
    }

    /**
     * Sets the value of the customFieldValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracSWsLuIpCustFldVal }
     *     
     */
    public void setCustomFieldValues(GracSWsLuIpCustFldVal value) {
        this.customFieldValues = value;
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
     * Gets the value of the functionArea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFunctionArea() {
        return functionArea;
    }

    /**
     * Sets the value of the functionArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFunctionArea(String value) {
        this.functionArea = value;
    }

    /**
     * Gets the value of the itemProvActionType property.
     * 
     * @return
     *     possible object is
     *     {@link GracSWsLuIpItmPrvActns }
     *     
     */
    public GracSWsLuIpItmPrvActns getItemProvActionType() {
        return itemProvActionType;
    }

    /**
     * Sets the value of the itemProvActionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracSWsLuIpItmPrvActns }
     *     
     */
    public void setItemProvActionType(GracSWsLuIpItmPrvActns value) {
        this.itemProvActionType = value;
    }

    /**
     * Gets the value of the itemProvType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemProvType() {
        return itemProvType;
    }

    /**
     * Sets the value of the itemProvType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemProvType(String value) {
        this.itemProvType = value;
    }

    /**
     * Gets the value of the landscape property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLandscape() {
        return landscape;
    }

    /**
     * Sets the value of the landscape property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLandscape(String value) {
        this.landscape = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the omObjectType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOmObjectType() {
        return omObjectType;
    }

    /**
     * Sets the value of the omObjectType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOmObjectType(String value) {
        this.omObjectType = value;
    }

    /**
     * Gets the value of the omObjectValue property.
     * 
     * @return
     *     possible object is
     *     {@link GracSWsLuIpOmObjectVal }
     *     
     */
    public GracSWsLuIpOmObjectVal getOmObjectValue() {
        return omObjectValue;
    }

    /**
     * Sets the value of the omObjectValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracSWsLuIpOmObjectVal }
     *     
     */
    public void setOmObjectValue(GracSWsLuIpOmObjectVal value) {
        this.omObjectValue = value;
    }

    /**
     * Gets the value of the phase property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhase() {
        return phase;
    }

    /**
     * Sets the value of the phase property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhase(String value) {
        this.phase = value;
    }

    /**
     * Gets the value of the priorityType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPriorityType() {
        return priorityType;
    }

    /**
     * Sets the value of the priorityType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriorityType(String value) {
        this.priorityType = value;
    }

    /**
     * Gets the value of the projectRelease property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProjectRelease() {
        return projectRelease;
    }

    /**
     * Sets the value of the projectRelease property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProjectRelease(String value) {
        this.projectRelease = value;
    }

    /**
     * Gets the value of the requestCustomFields property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestCustomFields() {
        return requestCustomFields;
    }

    /**
     * Sets the value of the requestCustomFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestCustomFields(String value) {
        this.requestCustomFields = value;
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
     * Gets the value of the roleCustomFields property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoleCustomFields() {
        return roleCustomFields;
    }

    /**
     * Sets the value of the roleCustomFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleCustomFields(String value) {
        this.roleCustomFields = value;
    }

    /**
     * Gets the value of the roleSensitivity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoleSensitivity() {
        return roleSensitivity;
    }

    /**
     * Sets the value of the roleSensitivity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleSensitivity(String value) {
        this.roleSensitivity = value;
    }

    /**
     * Gets the value of the roleStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoleStatus() {
        return roleStatus;
    }

    /**
     * Sets the value of the roleStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleStatus(String value) {
        this.roleStatus = value;
    }

    /**
     * Gets the value of the roleType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoleType() {
        return roleType;
    }

    /**
     * Sets the value of the roleType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleType(String value) {
        this.roleType = value;
    }

}
