
package oracle.iam.ws.sap.ac10.lookup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsLuOpLandscapeWrap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsLuOpLandscapeWrap">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Landscape" type="{urn:sap-com:document:sap:soap:functions:mc-style}GrfnTWsLuOpContrGrp"/>
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
@XmlType(name = "GracSWsLuOpLandscapeWrap", propOrder = {
    "landscape",
    "msgReturn"
})
public class GracSWsLuOpLandscapeWrap {

    @XmlElement(name = "Landscape", required = true)
    protected GrfnTWsLuOpContrGrp landscape;
    @XmlElement(name = "MsgReturn", required = true)
    protected GracSWsApiMessage msgReturn;

    /**
     * Gets the value of the landscape property.
     * 
     * @return
     *     possible object is
     *     {@link GrfnTWsLuOpContrGrp }
     *     
     */
    public GrfnTWsLuOpContrGrp getLandscape() {
        return landscape;
    }

    /**
     * Sets the value of the landscape property.
     * 
     * @param value
     *     allowed object is
     *     {@link GrfnTWsLuOpContrGrp }
     *     
     */
    public void setLandscape(GrfnTWsLuOpContrGrp value) {
        this.landscape = value;
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
