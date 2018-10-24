
package oracle.iam.ws.sap.ac53.submitrequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import oracle.iam.ws.sap.ac53.submitrequest.ejbutil.RequestDetailsData;


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
 *         &lt;element name="requestDetails" type="{urn:com.virsa.ae.ejbutil}RequestDetailsData"/>
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
    "requestDetails"
})
@XmlRootElement(name = "getSubmitRequest")
public class GetSubmitRequest {

    @XmlElement(required = true, nillable = true)
    protected RequestDetailsData requestDetails;

    /**
     * Gets the value of the requestDetails property.
     * 
     * @return
     *     possible object is
     *     {@link RequestDetailsData }
     *     
     */
    public RequestDetailsData getRequestDetails() {
        return requestDetails;
    }

    /**
     * Sets the value of the requestDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestDetailsData }
     *     
     */
    public void setRequestDetails(RequestDetailsData value) {
        this.requestDetails = value;
    }

}
