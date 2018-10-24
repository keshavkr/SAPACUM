
package oracle.iam.ws.sap.ac10.lookup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsLuOpPrjRelsWrap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsLuOpPrjRelsWrap">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProjectRelease" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracTWsLuOpPrjrel"/>
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
@XmlType(name = "GracSWsLuOpPrjRelsWrap", propOrder = {
    "projectRelease",
    "msgReturn"
})
public class GracSWsLuOpPrjRelsWrap {

    @XmlElement(name = "ProjectRelease", required = true)
    protected GracTWsLuOpPrjrel projectRelease;
    @XmlElement(name = "MsgReturn", required = true)
    protected GracSWsApiMessage msgReturn;

    /**
     * Gets the value of the projectRelease property.
     * 
     * @return
     *     possible object is
     *     {@link GracTWsLuOpPrjrel }
     *     
     */
    public GracTWsLuOpPrjrel getProjectRelease() {
        return projectRelease;
    }

    /**
     * Sets the value of the projectRelease property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracTWsLuOpPrjrel }
     *     
     */
    public void setProjectRelease(GracTWsLuOpPrjrel value) {
        this.projectRelease = value;
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
