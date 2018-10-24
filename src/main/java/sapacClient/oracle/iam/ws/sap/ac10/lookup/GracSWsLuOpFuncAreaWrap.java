
package oracle.iam.ws.sap.ac10.lookup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsLuOpFuncAreaWrap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsLuOpFuncAreaWrap">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FunctionArea" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracTWsLuOpFuncArea"/>
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
@XmlType(name = "GracSWsLuOpFuncAreaWrap", propOrder = {
    "functionArea",
    "msgReturn"
})
public class GracSWsLuOpFuncAreaWrap {

    @XmlElement(name = "FunctionArea", required = true)
    protected GracTWsLuOpFuncArea functionArea;
    @XmlElement(name = "MsgReturn", required = true)
    protected GracSWsApiMessage msgReturn;

    /**
     * Gets the value of the functionArea property.
     * 
     * @return
     *     possible object is
     *     {@link GracTWsLuOpFuncArea }
     *     
     */
    public GracTWsLuOpFuncArea getFunctionArea() {
        return functionArea;
    }

    /**
     * Sets the value of the functionArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracTWsLuOpFuncArea }
     *     
     */
    public void setFunctionArea(GracTWsLuOpFuncArea value) {
        this.functionArea = value;
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
