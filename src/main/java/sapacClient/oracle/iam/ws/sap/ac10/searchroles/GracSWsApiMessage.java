
package oracle.iam.ws.sap.ac10.searchroles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsApiMessage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsApiMessage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MsgNo" type="{urn:sap-com:document:sap:rfc:functions}char3"/>
 *         &lt;element name="MsgType" type="{urn:sap-com:document:sap:rfc:functions}char7"/>
 *         &lt;element name="MsgStatement" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GracSWsApiMessage", propOrder = {
    "msgNo",
    "msgType",
    "msgStatement"
})
public class GracSWsApiMessage {

    @XmlElement(name = "MsgNo", required = true)
    protected String msgNo;
    @XmlElement(name = "MsgType", required = true)
    protected String msgType;
    @XmlElement(name = "MsgStatement", required = true)
    protected String msgStatement;

    /**
     * Gets the value of the msgNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgNo() {
        return msgNo;
    }

    /**
     * Sets the value of the msgNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgNo(String value) {
        this.msgNo = value;
    }

    /**
     * Gets the value of the msgType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgType() {
        return msgType;
    }

    /**
     * Sets the value of the msgType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgType(String value) {
        this.msgType = value;
    }

    /**
     * Gets the value of the msgStatement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgStatement() {
        return msgStatement;
    }

    /**
     * Sets the value of the msgStatement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgStatement(String value) {
        this.msgStatement = value;
    }

}
