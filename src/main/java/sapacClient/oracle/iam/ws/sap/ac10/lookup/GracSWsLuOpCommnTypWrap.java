
package oracle.iam.ws.sap.ac10.lookup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsLuOpCommnTypWrap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsLuOpCommnTypWrap">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CommunicationType" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracTWsApiCommType"/>
 *         &lt;element name="MsgReturn" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracSWsApiMessage"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GracSWsLuOpCommnTypWrap", propOrder = {
    "communicationType",
    "msgReturn"
})
public class GracSWsLuOpCommnTypWrap {

    @XmlElement(name = "CommunicationType", required = true)
    protected GracTWsApiCommType communicationType;
    @XmlElement(name = "MsgReturn", required = true)
    protected GracSWsApiMessage msgReturn;

    /**
     * Gets the value of the communicationType property.
     * 
     * @return
     *     possible object is
     *     {@link GracTWsApiCommType }
     *     
     */
    public GracTWsApiCommType getCommunicationType() {
        return communicationType;
    }

    /**
     * Sets the value of the communicationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracTWsApiCommType }
     *     
     */
    public void setCommunicationType(GracTWsApiCommType value) {
        this.communicationType = value;
    }

    /**
     * Gets the value of the msgReturn property.
     * 
     * @return
     *     possible object is
     *     {@link GracSWsApiMessage }
     *     
     */
    public GracSWsApiMessage getMsgReturn() {
        return msgReturn;
    }

    /**
     * Sets the value of the msgReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracSWsApiMessage }
     *     
     */
    public void setMsgReturn(GracSWsApiMessage value) {
        this.msgReturn = value;
    }

}
