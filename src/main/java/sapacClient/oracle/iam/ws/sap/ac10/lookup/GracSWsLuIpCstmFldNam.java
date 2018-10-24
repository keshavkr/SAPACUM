
package oracle.iam.ws.sap.ac10.lookup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsLuIpCstmFldNam complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsLuIpCstmFldNam">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CustomFldName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GracSWsLuIpCstmFldNam", propOrder = {
    "customFldName"
})
public class GracSWsLuIpCstmFldNam {

    @XmlElement(name = "CustomFldName", required = true)
    protected String customFldName;

    /**
     * Gets the value of the customFldName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomFldName() {
        return customFldName;
    }

    /**
     * Sets the value of the customFldName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomFldName(String value) {
        this.customFldName = value;
    }

}
