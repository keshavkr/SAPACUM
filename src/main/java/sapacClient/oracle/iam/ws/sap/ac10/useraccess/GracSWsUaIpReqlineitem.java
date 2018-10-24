
package oracle.iam.ws.sap.ac10.useraccess;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsUaIpReqlineitem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsUaIpReqlineitem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ItemName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Connector" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProvItemType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProvType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AssignmentType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProvStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ValidFrom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ValidTo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FfOwner" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Comments" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProvAction" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RoleType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GracSWsUaIpReqlineitem", propOrder = {
    "itemName",
    "connector",
    "provItemType",
    "provType",
    "assignmentType",
    "provStatus",
    "validFrom",
    "validTo",
    "ffOwner",
    "comments",
    "provAction",
    "roleType"
})
public class GracSWsUaIpReqlineitem {

    @XmlElement(name = "ItemName", required = true)
    protected String itemName;
    @XmlElement(name = "Connector", required = true)
    protected String connector;
    @XmlElement(name = "ProvItemType", required = true)
    protected String provItemType;
    @XmlElement(name = "ProvType", required = true)
    protected String provType;
    @XmlElement(name = "AssignmentType", required = true)
    protected String assignmentType;
    @XmlElement(name = "ProvStatus", required = true)
    protected String provStatus;
    @XmlElement(name = "ValidFrom", required = true)
    protected String validFrom;
    @XmlElement(name = "ValidTo", required = true)
    protected String validTo;
    @XmlElement(name = "FfOwner", required = true)
    protected String ffOwner;
    @XmlElement(name = "Comments", required = true)
    protected String comments;
    @XmlElement(name = "ProvAction", required = true)
    protected String provAction;
    @XmlElement(name = "RoleType", required = true)
    protected String roleType;

    /**
     * Gets the value of the itemName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Sets the value of the itemName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemName(String value) {
        this.itemName = value;
    }

    /**
     * Gets the value of the connector property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConnector() {
        return connector;
    }

    /**
     * Sets the value of the connector property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConnector(String value) {
        this.connector = value;
    }

    /**
     * Gets the value of the provItemType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvItemType() {
        return provItemType;
    }

    /**
     * Sets the value of the provItemType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvItemType(String value) {
        this.provItemType = value;
    }

    /**
     * Gets the value of the provType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvType() {
        return provType;
    }

    /**
     * Sets the value of the provType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvType(String value) {
        this.provType = value;
    }

    /**
     * Gets the value of the assignmentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssignmentType() {
        return assignmentType;
    }

    /**
     * Sets the value of the assignmentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssignmentType(String value) {
        this.assignmentType = value;
    }

    /**
     * Gets the value of the provStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvStatus() {
        return provStatus;
    }

    /**
     * Sets the value of the provStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvStatus(String value) {
        this.provStatus = value;
    }

    /**
     * Gets the value of the validFrom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidFrom() {
        return validFrom;
    }

    /**
     * Sets the value of the validFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidFrom(String value) {
        this.validFrom = value;
    }

    /**
     * Gets the value of the validTo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidTo() {
        return validTo;
    }

    /**
     * Sets the value of the validTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidTo(String value) {
        this.validTo = value;
    }

    /**
     * Gets the value of the ffOwner property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFfOwner() {
        return ffOwner;
    }

    /**
     * Sets the value of the ffOwner property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFfOwner(String value) {
        this.ffOwner = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComments(String value) {
        this.comments = value;
    }

    /**
     * Gets the value of the provAction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvAction() {
        return provAction;
    }

    /**
     * Sets the value of the provAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvAction(String value) {
        this.provAction = value;
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
