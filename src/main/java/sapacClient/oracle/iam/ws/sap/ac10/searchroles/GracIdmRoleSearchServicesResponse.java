
package oracle.iam.ws.sap.ac10.searchroles;

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
 *         &lt;element name="MsgReturn" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracSWsApiMessage"/>
 *         &lt;element name="RolesList" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracTWsSrOpRoleList"/>
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
    "msgReturn",
    "rolesList"
})
@XmlRootElement(name = "GracIdmRoleSearchServicesResponse")
public class GracIdmRoleSearchServicesResponse {

    @XmlElement(name = "MsgReturn", required = true)
    protected GracSWsApiMessage msgReturn;
    @XmlElement(name = "RolesList", required = true)
    protected GracTWsSrOpRoleList rolesList;

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

    /**
     * Gets the value of the rolesList property.
     * 
     * @return
     *     possible object is
     *     {@link GracTWsSrOpRoleList }
     *     
     */
    public GracTWsSrOpRoleList getRolesList() {
        return rolesList;
    }

    /**
     * Sets the value of the rolesList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracTWsSrOpRoleList }
     *     
     */
    public void setRolesList(GracTWsSrOpRoleList value) {
        this.rolesList = value;
    }

}
