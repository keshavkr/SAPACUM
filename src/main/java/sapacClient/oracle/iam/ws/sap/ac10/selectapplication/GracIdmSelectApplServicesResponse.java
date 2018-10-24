
package oracle.iam.ws.sap.ac10.selectapplication;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="ConnectorList" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracTWsSaConnectorLst"/>
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
@XmlType(name = "", propOrder = {
    "connectorList",
    "msgReturn"
})
@XmlRootElement(name = "GracIdmSelectApplServicesResponse")
public class GracIdmSelectApplServicesResponse {

    @XmlElement(name = "ConnectorList", required = true)
    protected GracTWsSaConnectorLst connectorList;
    @XmlElement(name = "MsgReturn", required = true)
    protected GracSWsApiMessage msgReturn;

    /**
     * Gets the value of the connectorList property.
     * 
     * @return
     *     possible object is
     *     {@link GracTWsSaConnectorLst }
     *     
     */
    public GracTWsSaConnectorLst getConnectorList() {
        return connectorList;
    }

    /**
     * Sets the value of the connectorList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracTWsSaConnectorLst }
     *     
     */
    public void setConnectorList(GracTWsSaConnectorLst value) {
        this.connectorList = value;
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
