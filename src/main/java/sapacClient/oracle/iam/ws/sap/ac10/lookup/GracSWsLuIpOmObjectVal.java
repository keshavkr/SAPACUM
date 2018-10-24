
package oracle.iam.ws.sap.ac10.lookup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsLuIpOmObjectVal complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsLuIpOmObjectVal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="System" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OmObjType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GracSWsLuIpOmObjectVal", propOrder = {
    "system",
    "omObjType"
})
public class GracSWsLuIpOmObjectVal {

    @XmlElement(name = "System", required = true)
    protected String system;
    @XmlElement(name = "OmObjType", required = true)
    protected String omObjType;

    /**
     * Gets the value of the system property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystem() {
        return system;
    }

    /**
     * Sets the value of the system property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystem(String value) {
        this.system = value;
    }

    /**
     * Gets the value of the omObjType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOmObjType() {
        return omObjType;
    }

    /**
     * Sets the value of the omObjType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOmObjType(String value) {
        this.omObjType = value;
    }

}
