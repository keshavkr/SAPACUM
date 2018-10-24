
package oracle.iam.ws.sap.ac10.lookup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsLuOpCritlvl complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsLuOpCritlvl">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Critlvl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Descn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GracSWsLuOpCritlvl", propOrder = {
    "critlvl",
    "descn"
})
public class GracSWsLuOpCritlvl {

    @XmlElement(name = "Critlvl", required = true)
    protected String critlvl;
    @XmlElement(name = "Descn", required = true)
    protected String descn;

    /**
     * Gets the value of the critlvl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCritlvl() {
        return critlvl;
    }

    /**
     * Sets the value of the critlvl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCritlvl(String value) {
        this.critlvl = value;
    }

    /**
     * Gets the value of the descn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescn() {
        return descn;
    }

    /**
     * Sets the value of the descn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescn(String value) {
        this.descn = value;
    }

}
