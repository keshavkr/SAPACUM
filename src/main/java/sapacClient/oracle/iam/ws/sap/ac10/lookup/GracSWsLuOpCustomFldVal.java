
package oracle.iam.ws.sap.ac10.lookup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsLuOpCustomFldVal complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsLuOpCustomFldVal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CustomFieldName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CustomFieldValueLow" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CustomFieldValueHigh" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CustomFieldText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GracSWsLuOpCustomFldVal", propOrder = {
    "customFieldName",
    "customFieldValueLow",
    "customFieldValueHigh",
    "customFieldText"
})
public class GracSWsLuOpCustomFldVal {

    @XmlElement(name = "CustomFieldName", required = true)
    protected String customFieldName;
    @XmlElement(name = "CustomFieldValueLow", required = true)
    protected String customFieldValueLow;
    @XmlElement(name = "CustomFieldValueHigh", required = true)
    protected String customFieldValueHigh;
    @XmlElement(name = "CustomFieldText", required = true)
    protected String customFieldText;

    /**
     * Gets the value of the customFieldName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomFieldName() {
        return customFieldName;
    }

    /**
     * Sets the value of the customFieldName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomFieldName(String value) {
        this.customFieldName = value;
    }

    /**
     * Gets the value of the customFieldValueLow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomFieldValueLow() {
        return customFieldValueLow;
    }

    /**
     * Sets the value of the customFieldValueLow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomFieldValueLow(String value) {
        this.customFieldValueLow = value;
    }

    /**
     * Gets the value of the customFieldValueHigh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomFieldValueHigh() {
        return customFieldValueHigh;
    }

    /**
     * Sets the value of the customFieldValueHigh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomFieldValueHigh(String value) {
        this.customFieldValueHigh = value;
    }

    /**
     * Gets the value of the customFieldText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomFieldText() {
        return customFieldText;
    }

    /**
     * Sets the value of the customFieldText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomFieldText(String value) {
        this.customFieldText = value;
    }

}
