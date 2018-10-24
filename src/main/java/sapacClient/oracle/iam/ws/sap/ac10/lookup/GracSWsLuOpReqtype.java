
package oracle.iam.ws.sap.ac10.lookup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsLuOpReqtype complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsLuOpReqtype">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Reqtype" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Reqtypename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GracSWsLuOpReqtype", propOrder = {
    "reqtype",
    "reqtypename"
})
public class GracSWsLuOpReqtype {

    @XmlElement(name = "Reqtype", required = true)
    protected String reqtype;
    @XmlElement(name = "Reqtypename", required = true)
    protected String reqtypename;

    /**
     * Gets the value of the reqtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReqtype() {
        return reqtype;
    }

    /**
     * Sets the value of the reqtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReqtype(String value) {
        this.reqtype = value;
    }

    /**
     * Gets the value of the reqtypename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReqtypename() {
        return reqtypename;
    }

    /**
     * Sets the value of the reqtypename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReqtypename(String value) {
        this.reqtypename = value;
    }

}
