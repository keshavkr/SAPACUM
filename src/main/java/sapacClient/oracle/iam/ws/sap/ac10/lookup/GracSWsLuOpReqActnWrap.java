
package oracle.iam.ws.sap.ac10.lookup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsLuOpReqActnWrap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsLuOpReqActnWrap">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RequestAction" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracTWsLuOpReqActnDtls"/>
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
@XmlType(name = "GracSWsLuOpReqActnWrap", propOrder = {
    "requestAction",
    "msgReturn"
})
public class GracSWsLuOpReqActnWrap {

    @XmlElement(name = "RequestAction", required = true)
    protected GracTWsLuOpReqActnDtls requestAction;
    @XmlElement(name = "MsgReturn", required = true)
    protected GracSWsApiMessage msgReturn;

    /**
     * Gets the value of the requestAction property.
     * 
     * @return
     *     possible object is
     *     {@link GracTWsLuOpReqActnDtls }
     *     
     */
    public GracTWsLuOpReqActnDtls getRequestAction() {
        return requestAction;
    }

    /**
     * Sets the value of the requestAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracTWsLuOpReqActnDtls }
     *     
     */
    public void setRequestAction(GracTWsLuOpReqActnDtls value) {
        this.requestAction = value;
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
