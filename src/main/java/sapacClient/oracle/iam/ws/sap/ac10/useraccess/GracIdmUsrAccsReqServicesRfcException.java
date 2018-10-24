
package oracle.iam.ws.sap.ac10.useraccess;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracIdmUsrAccsReqServices.RfcException complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracIdmUsrAccsReqServices.RfcException">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracIdmUsrAccsReqServices.RfcExceptions"/>
 *         &lt;element name="Text" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Message" type="{urn:sap-com:document:sap:soap:functions:mc-style}RfcException.Message" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GracIdmUsrAccsReqServices.RfcException", propOrder = {
    "name",
    "text",
    "message"
})
public class GracIdmUsrAccsReqServicesRfcException {

    @XmlElement(name = "Name", required = true)
    protected GracIdmUsrAccsReqServicesRfcExceptions name;
    @XmlElement(name = "Text")
    protected String text;
    @XmlElement(name = "Message")
    protected RfcExceptionMessage message;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link GracIdmUsrAccsReqServicesRfcExceptions }
     *     
     */
    public GracIdmUsrAccsReqServicesRfcExceptions getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracIdmUsrAccsReqServicesRfcExceptions }
     *     
     */
    public void setName(GracIdmUsrAccsReqServicesRfcExceptions value) {
        this.name = value;
    }

    /**
     * Gets the value of the text property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText(String value) {
        this.text = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link RfcExceptionMessage }
     *     
     */
    public RfcExceptionMessage getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link RfcExceptionMessage }
     *     
     */
    public void setMessage(RfcExceptionMessage value) {
        this.message = value;
    }

}
