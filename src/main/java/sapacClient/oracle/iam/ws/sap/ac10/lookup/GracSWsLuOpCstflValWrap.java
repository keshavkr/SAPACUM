
package oracle.iam.ws.sap.ac10.lookup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsLuOpCstflValWrap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsLuOpCstflValWrap">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CustomFieldValueList" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracTWsLuOpCustomFldVal"/>
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
@XmlType(name = "GracSWsLuOpCstflValWrap", propOrder = {
    "customFieldValueList",
    "msgReturn"
})
public class GracSWsLuOpCstflValWrap {

    @XmlElement(name = "CustomFieldValueList", required = true)
    protected GracTWsLuOpCustomFldVal customFieldValueList;
    @XmlElement(name = "MsgReturn", required = true)
    protected GracSWsApiMessage msgReturn;

    /**
     * Gets the value of the customFieldValueList property.
     * 
     * @return
     *     possible object is
     *     {@link GracTWsLuOpCustomFldVal }
     *     
     */
    public GracTWsLuOpCustomFldVal getCustomFieldValueList() {
        return customFieldValueList;
    }

    /**
     * Sets the value of the customFieldValueList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracTWsLuOpCustomFldVal }
     *     
     */
    public void setCustomFieldValueList(GracTWsLuOpCustomFldVal value) {
        this.customFieldValueList = value;
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
