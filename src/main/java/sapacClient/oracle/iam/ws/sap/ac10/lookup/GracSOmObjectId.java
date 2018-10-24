
package oracle.iam.ws.sap.ac10.lookup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSOmObjectId complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSOmObjectId">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OmObjectId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OmObjectText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GracSOmObjectId", propOrder = {
    "omObjectId",
    "omObjectText"
})
public class GracSOmObjectId {

    @XmlElement(name = "OmObjectId", required = true)
    protected String omObjectId;
    @XmlElement(name = "OmObjectText", required = true)
    protected String omObjectText;

    /**
     * Gets the value of the omObjectId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOmObjectId() {
        return omObjectId;
    }

    /**
     * Sets the value of the omObjectId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOmObjectId(String value) {
        this.omObjectId = value;
    }

    /**
     * Gets the value of the omObjectText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOmObjectText() {
        return omObjectText;
    }

    /**
     * Sets the value of the omObjectText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOmObjectText(String value) {
        this.omObjectText = value;
    }

}
