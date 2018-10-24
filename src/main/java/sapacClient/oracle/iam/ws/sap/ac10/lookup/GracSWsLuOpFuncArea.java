
package oracle.iam.ws.sap.ac10.lookup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsLuOpFuncArea complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsLuOpFuncArea">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Funarea" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Descn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Abbrv" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GracSWsLuOpFuncArea", propOrder = {
    "funarea",
    "descn",
    "abbrv"
})
public class GracSWsLuOpFuncArea {

    @XmlElement(name = "Funarea", required = true)
    protected String funarea;
    @XmlElement(name = "Descn", required = true)
    protected String descn;
    @XmlElement(name = "Abbrv", required = true)
    protected String abbrv;

    /**
     * Gets the value of the funarea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFunarea() {
        return funarea;
    }

    /**
     * Sets the value of the funarea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFunarea(String value) {
        this.funarea = value;
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

    /**
     * Gets the value of the abbrv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAbbrv() {
        return abbrv;
    }

    /**
     * Sets the value of the abbrv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAbbrv(String value) {
        this.abbrv = value;
    }

}
