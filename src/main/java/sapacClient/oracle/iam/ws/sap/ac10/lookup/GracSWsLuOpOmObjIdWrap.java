
package oracle.iam.ws.sap.ac10.lookup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsLuOpOmObjIdWrap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsLuOpOmObjIdWrap">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OmObjectIdList" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracTOmObjectId"/>
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
@XmlType(name = "GracSWsLuOpOmObjIdWrap", propOrder = {
    "omObjectIdList",
    "msgReturn"
})
public class GracSWsLuOpOmObjIdWrap {

    @XmlElement(name = "OmObjectIdList", required = true)
    protected GracTOmObjectId omObjectIdList;
    @XmlElement(name = "MsgReturn", required = true)
    protected GracSWsApiMessage msgReturn;

    /**
     * Gets the value of the omObjectIdList property.
     * 
     * @return
     *     possible object is
     *     {@link GracTOmObjectId }
     *     
     */
    public GracTOmObjectId getOmObjectIdList() {
        return omObjectIdList;
    }

    /**
     * Sets the value of the omObjectIdList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracTOmObjectId }
     *     
     */
    public void setOmObjectIdList(GracTOmObjectId value) {
        this.omObjectIdList = value;
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
