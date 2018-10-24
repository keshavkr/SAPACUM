
package oracle.iam.ws.sap.ac53.ejbutil.auditlogs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import oracle.iam.ws.sap.ac53.audittrail.core.BaseDTO;


/**
 * <p>Java class for RequestHistoryDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestHistoryDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:com.virsa.ae.core}BaseDTO">
 *       &lt;sequence>
 *         &lt;element name="actionDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="actionValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childDTOs" type="{urn:com.virsa.ae.ejbutil.auditlogs}ArrayOfRequestHistoryDTO" minOccurs="0"/>
 *         &lt;element name="dependentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="displayString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="path" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reqNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestHistoryDTO", propOrder = {
    "actionDate",
    "actionValue",
    "childDTOs",
    "dependentId",
    "description",
    "displayString",
    "id",
    "path",
    "reqNo",
    "stage",
    "userId"
})
public class RequestHistoryDTO
    extends BaseDTO
{

    @XmlElement(nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar actionDate;
    @XmlElement(nillable = true)
    protected String actionValue;
    @XmlElement(nillable = true)
    protected ArrayOfRequestHistoryDTO childDTOs;
    @XmlElement(nillable = true)
    protected String dependentId;
    @XmlElement(nillable = true)
    protected String description;
    @XmlElement(nillable = true)
    protected String displayString;
    @XmlElement(nillable = true)
    protected String id;
    @XmlElement(nillable = true)
    protected String path;
    @XmlElement(nillable = true)
    protected String reqNo;
    @XmlElement(nillable = true)
    protected String stage;
    @XmlElement(nillable = true)
    protected String userId;

    /**
     * Gets the value of the actionDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getActionDate() {
        return actionDate;
    }

    /**
     * Sets the value of the actionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setActionDate(XMLGregorianCalendar value) {
        this.actionDate = value;
    }

    /**
     * Gets the value of the actionValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionValue() {
        return actionValue;
    }

    /**
     * Sets the value of the actionValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionValue(String value) {
        this.actionValue = value;
    }

    /**
     * Gets the value of the childDTOs property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRequestHistoryDTO }
     *     
     */
    public ArrayOfRequestHistoryDTO getChildDTOs() {
        return childDTOs;
    }

    /**
     * Sets the value of the childDTOs property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRequestHistoryDTO }
     *     
     */
    public void setChildDTOs(ArrayOfRequestHistoryDTO value) {
        this.childDTOs = value;
    }

    /**
     * Gets the value of the dependentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDependentId() {
        return dependentId;
    }

    /**
     * Sets the value of the dependentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDependentId(String value) {
        this.dependentId = value;
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
     * Gets the value of the displayString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayString() {
        return displayString;
    }

    /**
     * Sets the value of the displayString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayString(String value) {
        this.displayString = value;
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
     * Gets the value of the reqNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReqNo() {
        return reqNo;
    }

    /**
     * Sets the value of the reqNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReqNo(String value) {
        this.reqNo = value;
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

}
