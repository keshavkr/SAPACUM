
package oracle.iam.ws.sap.ac10.lookup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsLuOpBusProcWrap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsLuOpBusProcWrap">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BusProcess" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracTWsLuOpBproc"/>
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
@XmlType(name = "GracSWsLuOpBusProcWrap", propOrder = {
    "busProcess",
    "msgReturn"
})
public class GracSWsLuOpBusProcWrap {

    @XmlElement(name = "BusProcess", required = true)
    protected GracTWsLuOpBproc busProcess;
    @XmlElement(name = "MsgReturn", required = true)
    protected GracSWsApiMessage msgReturn;

    /**
     * Gets the value of the busProcess property.
     * 
     * @return
     *     possible object is
     *     {@link GracTWsLuOpBproc }
     *     
     */
    public GracTWsLuOpBproc getBusProcess() {
        return busProcess;
    }

    /**
     * Sets the value of the busProcess property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracTWsLuOpBproc }
     *     
     */
    public void setBusProcess(GracTWsLuOpBproc value) {
        this.busProcess = value;
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
