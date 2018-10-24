
package oracle.iam.ws.sap.ac10.lookup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsLuOpBsubproc complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsLuOpBsubproc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bproc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Bsubproc" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "GracSWsLuOpBsubproc", propOrder = {
    "bproc",
    "bsubproc",
    "descn"
})
public class GracSWsLuOpBsubproc {

    @XmlElement(name = "Bproc", required = true)
    protected String bproc;
    @XmlElement(name = "Bsubproc", required = true)
    protected String bsubproc;
    @XmlElement(name = "Descn", required = true)
    protected String descn;

    /**
     * Gets the value of the bproc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBproc() {
        return bproc;
    }

    /**
     * Sets the value of the bproc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBproc(String value) {
        this.bproc = value;
    }

    /**
     * Gets the value of the bsubproc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBsubproc() {
        return bsubproc;
    }

    /**
     * Sets the value of the bsubproc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBsubproc(String value) {
        this.bsubproc = value;
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
