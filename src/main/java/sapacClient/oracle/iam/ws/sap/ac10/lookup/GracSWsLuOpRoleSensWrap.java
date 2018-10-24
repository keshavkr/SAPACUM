
package oracle.iam.ws.sap.ac10.lookup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsLuOpRoleSensWrap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsLuOpRoleSensWrap">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RoleSensitivity" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracTWsLuOpRlsens"/>
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
@XmlType(name = "GracSWsLuOpRoleSensWrap", propOrder = {
    "roleSensitivity",
    "msgReturn"
})
public class GracSWsLuOpRoleSensWrap {

    @XmlElement(name = "RoleSensitivity", required = true)
    protected GracTWsLuOpRlsens roleSensitivity;
    @XmlElement(name = "MsgReturn", required = true)
    protected GracSWsApiMessage msgReturn;

    /**
     * Gets the value of the roleSensitivity property.
     * 
     * @return
     *     possible object is
     *     {@link GracTWsLuOpRlsens }
     *     
     */
    public GracTWsLuOpRlsens getRoleSensitivity() {
        return roleSensitivity;
    }

    /**
     * Sets the value of the roleSensitivity property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracTWsLuOpRlsens }
     *     
     */
    public void setRoleSensitivity(GracTWsLuOpRlsens value) {
        this.roleSensitivity = value;
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
