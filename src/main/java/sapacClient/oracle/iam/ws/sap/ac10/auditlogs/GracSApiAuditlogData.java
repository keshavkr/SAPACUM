
package oracle.iam.ws.sap.ac10.auditlogs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSApiAuditlogData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSApiAuditlogData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Actiondate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Actionvalue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Dependantid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Displaystring" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Path" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Stage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Userid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Itauditdatachild" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracTApiAuditlogDataChild"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GracSApiAuditlogData", propOrder = {
    "actiondate",
    "actionvalue",
    "dependantid",
    "description",
    "displaystring",
    "id",
    "path",
    "stage",
    "userid",
    "itauditdatachild"
})
public class GracSApiAuditlogData {

    @XmlElement(name = "Actiondate", required = true)
    protected String actiondate;
    @XmlElement(name = "Actionvalue", required = true)
    protected String actionvalue;
    @XmlElement(name = "Dependantid", required = true)
    protected String dependantid;
    @XmlElement(name = "Description", required = true)
    protected String description;
    @XmlElement(name = "Displaystring", required = true)
    protected String displaystring;
    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "Path", required = true)
    protected String path;
    @XmlElement(name = "Stage", required = true)
    protected String stage;
    @XmlElement(name = "Userid", required = true)
    protected String userid;
    @XmlElement(name = "Itauditdatachild", required = true)
    protected GracTApiAuditlogDataChild itauditdatachild;

    /**
     * Gets the value of the actiondate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActiondate() {
        return actiondate;
    }

    /**
     * Sets the value of the actiondate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActiondate(String value) {
        this.actiondate = value;
    }

    /**
     * Gets the value of the actionvalue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionvalue() {
        return actionvalue;
    }

    /**
     * Sets the value of the actionvalue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionvalue(String value) {
        this.actionvalue = value;
    }

    /**
     * Gets the value of the dependantid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDependantid() {
        return dependantid;
    }

    /**
     * Sets the value of the dependantid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDependantid(String value) {
        this.dependantid = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the displaystring property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplaystring() {
        return displaystring;
    }

    /**
     * Sets the value of the displaystring property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplaystring(String value) {
        this.displaystring = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the path property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the value of the path property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPath(String value) {
        this.path = value;
    }

    /**
     * Gets the value of the stage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStage() {
        return stage;
    }

    /**
     * Sets the value of the stage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStage(String value) {
        this.stage = value;
    }

    /**
     * Gets the value of the userid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserid() {
        return userid;
    }

    /**
     * Sets the value of the userid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserid(String value) {
        this.userid = value;
    }

    /**
     * Gets the value of the itauditdatachild property.
     * 
     * @return
     *     possible object is
     *     {@link GracTApiAuditlogDataChild }
     *     
     */
    public GracTApiAuditlogDataChild getItauditdatachild() {
        return itauditdatachild;
    }

    /**
     * Sets the value of the itauditdatachild property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracTApiAuditlogDataChild }
     *     
     */
    public void setItauditdatachild(GracTApiAuditlogDataChild value) {
        this.itauditdatachild = value;
    }

}
