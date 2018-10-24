
package oracle.iam.ws.sap.ac10.lookup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsLuIpCustFldVal complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsLuIpCustFldVal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CustomFieldList" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracTWsLuIpCstmFldNam"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GracSWsLuIpCustFldVal", propOrder = {
    "customFieldList"
})
public class GracSWsLuIpCustFldVal {

    @XmlElement(name = "CustomFieldList", required = true)
    protected GracTWsLuIpCstmFldNam customFieldList;

    /**
     * Gets the value of the customFieldList property.
     * 
     * @return
     *     possible object is
     *     {@link GracTWsLuIpCstmFldNam }
     *     
     */
    public GracTWsLuIpCstmFldNam getCustomFieldList() {
        return customFieldList;
    }

    /**
     * Sets the value of the customFieldList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracTWsLuIpCstmFldNam }
     *     
     */
    public void setCustomFieldList(GracTWsLuIpCstmFldNam value) {
        this.customFieldList = value;
    }

}
