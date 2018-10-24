
package oracle.iam.ws.sap.ac10.lookup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsApiMthAction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsApiMthAction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MthAction" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "GracSWsApiMthAction", propOrder = {
    "mthAction",
    "descn"
})
public class GracSWsApiMthAction {

    @XmlElement(name = "MthAction", required = true)
    protected String mthAction;
    @XmlElement(name = "Descn", required = true)
    protected String descn;

    /**
     * Gets the value of the mthAction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMthAction() {
        return mthAction;
    }

    /**
     * Sets the value of the mthAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMthAction(String value) {
        this.mthAction = value;
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
