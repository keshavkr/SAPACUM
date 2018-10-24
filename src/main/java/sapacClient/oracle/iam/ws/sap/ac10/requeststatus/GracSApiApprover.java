
package oracle.iam.ws.sap.ac10.requeststatus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSApiApprover complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSApiApprover">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ApproverId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GracSApiApprover", propOrder = {
    "approverId"
})
public class GracSApiApprover {

    @XmlElement(name = "ApproverId", required = true)
    protected String approverId;

    /**
     * Gets the value of the approverId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproverId() {
        return approverId;
    }

    /**
     * Sets the value of the approverId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproverId(String value) {
        this.approverId = value;
    }

}
