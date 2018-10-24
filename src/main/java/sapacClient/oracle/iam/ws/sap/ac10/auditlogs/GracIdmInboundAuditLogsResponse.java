
package oracle.iam.ws.sap.ac10.auditlogs;

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
 *         &lt;element name="AuditLogs" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracTApiAuditLogs"/>
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
    "auditLogs",
    "msgReturn"
})
@XmlRootElement(name = "GracIdmInboundAuditLogsResponse")
public class GracIdmInboundAuditLogsResponse {

    @XmlElement(name = "AuditLogs", required = true)
    protected GracTApiAuditLogs auditLogs;
    @XmlElement(name = "MsgReturn", required = true)
    protected GracSWsApiMessage msgReturn;

    /**
     * Gets the value of the auditLogs property.
     * 
     * @return
     *     possible object is
     *     {@link GracTApiAuditLogs }
     *     
     */
    public GracTApiAuditLogs getAuditLogs() {
        return auditLogs;
    }

    /**
     * Sets the value of the auditLogs property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracTApiAuditLogs }
     *     
     */
    public void setAuditLogs(GracTApiAuditLogs value) {
        this.auditLogs = value;
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
