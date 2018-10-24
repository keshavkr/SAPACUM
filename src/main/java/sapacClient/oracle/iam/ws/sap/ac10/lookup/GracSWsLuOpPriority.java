
package oracle.iam.ws.sap.ac10.lookup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsLuOpPriority complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsLuOpPriority">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Prioritype" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Prioritypename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GracSWsLuOpPriority", propOrder = {
    "prioritype",
    "prioritypename"
})
public class GracSWsLuOpPriority {

    @XmlElement(name = "Prioritype", required = true)
    protected String prioritype;
    @XmlElement(name = "Prioritypename", required = true)
    protected String prioritypename;

    /**
     * Gets the value of the prioritype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrioritype() {
        return prioritype;
    }

    /**
     * Sets the value of the prioritype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrioritype(String value) {
        this.prioritype = value;
    }

    /**
     * Gets the value of the prioritypename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrioritypename() {
        return prioritypename;
    }

    /**
     * Sets the value of the prioritypename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrioritypename(String value) {
        this.prioritypename = value;
    }

}
