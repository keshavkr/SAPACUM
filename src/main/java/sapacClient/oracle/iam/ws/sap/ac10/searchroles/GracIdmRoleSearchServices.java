
package oracle.iam.ws.sap.ac10.searchroles;

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
 *         &lt;element name="Action" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ApplicationType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Approver" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AssociatedRole" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BusinessProcess" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConnectorGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CriticalLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FunctionalArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Landscape" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastReaffirmDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrgLvl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrgVal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Permission" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Profile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReaffirmPeriod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RoleDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RoleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RoleOwner" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RoleSensitivity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RoleStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RoleType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SubProcess" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="System" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "action",
    "applicationType",
    "approver",
    "associatedRole",
    "businessProcess",
    "connectorGroup",
    "criticalLevel",
    "functionalArea",
    "landscape",
    "language",
    "lastReaffirmDt",
    "orgLvl",
    "orgVal",
    "permission",
    "profile",
    "reaffirmPeriod",
    "roleDesc",
    "roleName",
    "roleOwner",
    "roleSensitivity",
    "roleStatus",
    "roleType",
    "subProcess",
    "system"
})
@XmlRootElement(name = "GracIdmRoleSearchServices")
public class GracIdmRoleSearchServices {

    @XmlElement(name = "Action")
    protected String action;
    @XmlElement(name = "ApplicationType")
    protected String applicationType;
    @XmlElement(name = "Approver")
    protected String approver;
    @XmlElement(name = "AssociatedRole")
    protected String associatedRole;
    @XmlElement(name = "BusinessProcess")
    protected String businessProcess;
    @XmlElement(name = "ConnectorGroup")
    protected String connectorGroup;
    @XmlElement(name = "CriticalLevel")
    protected String criticalLevel;
    @XmlElement(name = "FunctionalArea")
    protected String functionalArea;
    @XmlElement(name = "Landscape")
    protected String landscape;
    @XmlElement(name = "Language")
    protected String language;
    @XmlElement(name = "LastReaffirmDt")
    protected String lastReaffirmDt;
    @XmlElement(name = "OrgLvl")
    protected String orgLvl;
    @XmlElement(name = "OrgVal")
    protected String orgVal;
    @XmlElement(name = "Permission")
    protected String permission;
    @XmlElement(name = "Profile")
    protected String profile;
    @XmlElement(name = "ReaffirmPeriod")
    protected String reaffirmPeriod;
    @XmlElement(name = "RoleDesc")
    protected String roleDesc;
    @XmlElement(name = "RoleName")
    protected String roleName;
    @XmlElement(name = "RoleOwner")
    protected String roleOwner;
    @XmlElement(name = "RoleSensitivity")
    protected String roleSensitivity;
    @XmlElement(name = "RoleStatus")
    protected String roleStatus;
    @XmlElement(name = "RoleType")
    protected String roleType;
    @XmlElement(name = "SubProcess")
    protected String subProcess;
    @XmlElement(name = "System")
    protected String system;

    /**
     * Gets the value of the action property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAction(String value) {
        this.action = value;
    }

    /**
     * Gets the value of the applicationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationType() {
        return applicationType;
    }

    /**
     * Sets the value of the applicationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationType(String value) {
        this.applicationType = value;
    }

    /**
     * Gets the value of the approver property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApprover() {
        return approver;
    }

    /**
     * Sets the value of the approver property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApprover(String value) {
        this.approver = value;
    }

    /**
     * Gets the value of the associatedRole property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssociatedRole() {
        return associatedRole;
    }

    /**
     * Sets the value of the associatedRole property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssociatedRole(String value) {
        this.associatedRole = value;
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
     * Gets the value of the connectorGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConnectorGroup() {
        return connectorGroup;
    }

    /**
     * Sets the value of the connectorGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConnectorGroup(String value) {
        this.connectorGroup = value;
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
     * Gets the value of the lastReaffirmDt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastReaffirmDt() {
        return lastReaffirmDt;
    }

    /**
     * Sets the value of the lastReaffirmDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastReaffirmDt(String value) {
        this.lastReaffirmDt = value;
    }

    /**
     * Gets the value of the orgLvl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgLvl() {
        return orgLvl;
    }

    /**
     * Sets the value of the orgLvl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgLvl(String value) {
        this.orgLvl = value;
    }

    /**
     * Gets the value of the orgVal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgVal() {
        return orgVal;
    }

    /**
     * Sets the value of the orgVal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgVal(String value) {
        this.orgVal = value;
    }

    /**
     * Gets the value of the permission property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPermission() {
        return permission;
    }

    /**
     * Sets the value of the permission property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPermission(String value) {
        this.permission = value;
    }

    /**
     * Gets the value of the profile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProfile() {
        return profile;
    }

    /**
     * Sets the value of the profile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProfile(String value) {
        this.profile = value;
    }

    /**
     * Gets the value of the reaffirmPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReaffirmPeriod() {
        return reaffirmPeriod;
    }

    /**
     * Sets the value of the reaffirmPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReaffirmPeriod(String value) {
        this.reaffirmPeriod = value;
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
     * Gets the value of the roleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets the value of the roleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleName(String value) {
        this.roleName = value;
    }

    /**
     * Gets the value of the roleOwner property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoleOwner() {
        return roleOwner;
    }

    /**
     * Sets the value of the roleOwner property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleOwner(String value) {
        this.roleOwner = value;
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
     * Gets the value of the system property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystem() {
        return system;
    }

    /**
     * Sets the value of the system property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystem(String value) {
        this.system = value;
    }

}
