
package oracle.iam.ws.sap.ac10.lookup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsLuOpBusSprocWrap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsLuOpBusSprocWrap">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BusSubProc" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracTWsLuOpBsubproc"/>
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
@XmlType(name = "GracSWsLuOpBusSprocWrap", propOrder = {
    "busSubProc",
    "msgReturn"
})
public class GracSWsLuOpBusSprocWrap {

    @XmlElement(name = "BusSubProc", required = true)
    protected GracTWsLuOpBsubproc busSubProc;
    @XmlElement(name = "MsgReturn", required = true)
    protected GracSWsApiMessage msgReturn;

    /**
     * Gets the value of the busSubProc property.
     * 
     * @return
     *     possible object is
     *     {@link GracTWsLuOpBsubproc }
     *     
     */
    public GracTWsLuOpBsubproc getBusSubProc() {
        return busSubProc;
    }

    /**
     * Sets the value of the busSubProc property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracTWsLuOpBsubproc }
     *     
     */
    public void setBusSubProc(GracTWsLuOpBsubproc value) {
        this.busSubProc = value;
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
