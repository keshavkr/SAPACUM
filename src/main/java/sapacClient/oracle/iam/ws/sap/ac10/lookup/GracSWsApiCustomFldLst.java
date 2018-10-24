
package oracle.iam.ws.sap.ac10.lookup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsApiCustomFldLst complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsApiCustomFldLst">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Fieldname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Fieldtext" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GracSWsApiCustomFldLst", propOrder = {
    "fieldname",
    "fieldtext"
})
public class GracSWsApiCustomFldLst {

    @XmlElement(name = "Fieldname", required = true)
    protected String fieldname;
    @XmlElement(name = "Fieldtext", required = true)
    protected String fieldtext;

    /**
     * Gets the value of the fieldname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldname() {
        return fieldname;
    }

    /**
     * Sets the value of the fieldname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldname(String value) {
        this.fieldname = value;
    }

    /**
     * Gets the value of the fieldtext property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldtext() {
        return fieldtext;
    }

    /**
     * Sets the value of the fieldtext property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldtext(String value) {
        this.fieldtext = value;
    }

}
