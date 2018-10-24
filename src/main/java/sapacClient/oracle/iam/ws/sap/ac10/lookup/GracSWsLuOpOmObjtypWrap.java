
package oracle.iam.ws.sap.ac10.lookup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsLuOpOmObjtypWrap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsLuOpOmObjtypWrap">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OmObjTypList" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracTWsApiOmObjType"/>
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
@XmlType(name = "GracSWsLuOpOmObjtypWrap", propOrder = {
    "omObjTypList",
    "msgReturn"
})
public class GracSWsLuOpOmObjtypWrap {

    @XmlElement(name = "OmObjTypList", required = true)
    protected GracTWsApiOmObjType omObjTypList;
    @XmlElement(name = "MsgReturn", required = true)
    protected GracSWsApiMessage msgReturn;

    /**
     * Gets the value of the omObjTypList property.
     * 
     * @return
     *     possible object is
     *     {@link GracTWsApiOmObjType }
     *     
     */
    public GracTWsApiOmObjType getOmObjTypList() {
        return omObjTypList;
    }

    /**
     * Sets the value of the omObjTypList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracTWsApiOmObjType }
     *     
     */
    public void setOmObjTypList(GracTWsApiOmObjType value) {
        this.omObjTypList = value;
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
