
package oracle.iam.ws.sap.ac10.lookup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsLuOpEmptype complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsLuOpEmptype">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Emptypeid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Emptypename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GracSWsLuOpEmptype", propOrder = {
    "emptypeid",
    "emptypename"
})
public class GracSWsLuOpEmptype {

    @XmlElement(name = "Emptypeid", required = true)
    protected String emptypeid;
    @XmlElement(name = "Emptypename", required = true)
    protected String emptypename;

    /**
     * Gets the value of the emptypeid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmptypeid() {
        return emptypeid;
    }

    /**
     * Sets the value of the emptypeid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmptypeid(String value) {
        this.emptypeid = value;
    }

    /**
     * Gets the value of the emptypename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmptypename() {
        return emptypename;
    }

    /**
     * Sets the value of the emptypename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmptypename(String value) {
        this.emptypename = value;
    }

}
