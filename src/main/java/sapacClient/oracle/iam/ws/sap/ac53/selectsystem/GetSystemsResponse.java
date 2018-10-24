
package oracle.iam.ws.sap.ac53.selectsystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import oracle.iam.ws.sap.ac53.ejbutil.selectsystem.SystemSelectionResult;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Response" type="{urn:com.virsa.ae.ejbutil.selectsystem}SystemSelectionResult"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "response"
})
@XmlRootElement(name = "getSystemsResponse")
public class GetSystemsResponse {

    @XmlElement(name = "Response", required = true, nillable = true)
    protected SystemSelectionResult response;

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link SystemSelectionResult }
     *     
     */
    public SystemSelectionResult getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link SystemSelectionResult }
     *     
     */
    public void setResponse(SystemSelectionResult value) {
        this.response = value;
    }

}
