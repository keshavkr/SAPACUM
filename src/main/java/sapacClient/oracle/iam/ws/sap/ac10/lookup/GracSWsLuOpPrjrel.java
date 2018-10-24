
package oracle.iam.ws.sap.ac10.lookup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsLuOpPrjrel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsLuOpPrjrel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Prjrel" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "GracSWsLuOpPrjrel", propOrder = {
    "prjrel",
    "descn"
})
public class GracSWsLuOpPrjrel {

    @XmlElement(name = "Prjrel", required = true)
    protected String prjrel;
    @XmlElement(name = "Descn", required = true)
    protected String descn;

    /**
     * Gets the value of the prjrel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrjrel() {
        return prjrel;
    }

    /**
     * Sets the value of the prjrel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrjrel(String value) {
        this.prjrel = value;
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
