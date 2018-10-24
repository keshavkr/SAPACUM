
package oracle.iam.ws.sap.ac10.lookup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsLuOpItemActnWrap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsLuOpItemActnWrap">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ItemAction" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracTWsLuOpItemActn"/>
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
@XmlType(name = "GracSWsLuOpItemActnWrap", propOrder = {
    "itemAction",
    "msgReturn"
})
public class GracSWsLuOpItemActnWrap {

    @XmlElement(name = "ItemAction", required = true)
    protected GracTWsLuOpItemActn itemAction;
    @XmlElement(name = "MsgReturn", required = true)
    protected GracSWsApiMessage msgReturn;

    /**
     * Gets the value of the itemAction property.
     * 
     * @return
     *     possible object is
     *     {@link GracTWsLuOpItemActn }
     *     
     */
    public GracTWsLuOpItemActn getItemAction() {
        return itemAction;
    }

    /**
     * Sets the value of the itemAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracTWsLuOpItemActn }
     *     
     */
    public void setItemAction(GracTWsLuOpItemActn value) {
        this.itemAction = value;
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
