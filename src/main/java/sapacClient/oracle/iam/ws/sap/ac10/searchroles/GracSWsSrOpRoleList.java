
package oracle.iam.ws.sap.ac10.searchroles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsSrOpRoleList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsSrOpRoleList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RoleName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RoleDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="System" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RoleType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RoleTypeDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Landscape" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LandscapeDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RoleOwner" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GracSWsSrOpRoleList", propOrder = {
    "roleName",
    "roleDesc",
    "system",
    "roleType",
    "roleTypeDesc",
    "landscape",
    "landscapeDesc",
    "roleOwner"
})
public class GracSWsSrOpRoleList {

    @XmlElement(name = "RoleName", required = true)
    protected String roleName;
    @XmlElement(name = "RoleDesc", required = true)
    protected String roleDesc;
    @XmlElement(name = "System", required = true)
    protected String system;
    @XmlElement(name = "RoleType", required = true)
    protected String roleType;
    @XmlElement(name = "RoleTypeDesc", required = true)
    protected String roleTypeDesc;
    @XmlElement(name = "Landscape", required = true)
    protected String landscape;
    @XmlElement(name = "LandscapeDesc", required = true)
    protected String landscapeDesc;
    @XmlElement(name = "RoleOwner", required = true)
    protected String roleOwner;

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
     * Gets the value of the roleTypeDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoleTypeDesc() {
        return roleTypeDesc;
    }

    /**
     * Sets the value of the roleTypeDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleTypeDesc(String value) {
        this.roleTypeDesc = value;
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
     * Gets the value of the landscapeDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLandscapeDesc() {
        return landscapeDesc;
    }

    /**
     * Sets the value of the landscapeDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLandscapeDesc(String value) {
        this.landscapeDesc = value;
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

}
