
package oracle.iam.ws.sap.ac10.lookup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsLuOpCritLvlWrap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsLuOpCritLvlWrap">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CriticalLvl" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracTWsLuOpCritlvl"/>
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
@XmlType(name = "GracSWsLuOpCritLvlWrap", propOrder = {
    "criticalLvl",
    "msgReturn"
})
public class GracSWsLuOpCritLvlWrap {

    @XmlElement(name = "CriticalLvl", required = true)
    protected GracTWsLuOpCritlvl criticalLvl;
    @XmlElement(name = "MsgReturn", required = true)
    protected GracSWsApiMessage msgReturn;

    /**
     * Gets the value of the criticalLvl property.
     * 
     * @return
     *     possible object is
     *     {@link GracTWsLuOpCritlvl }
     *     
     */
    public GracTWsLuOpCritlvl getCriticalLvl() {
        return criticalLvl;
    }

    /**
     * Sets the value of the criticalLvl property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracTWsLuOpCritlvl }
     *     
     */
    public void setCriticalLvl(GracTWsLuOpCritlvl value) {
        this.criticalLvl = value;
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
