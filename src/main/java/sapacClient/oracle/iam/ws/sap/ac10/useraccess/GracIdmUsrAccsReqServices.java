
package oracle.iam.ws.sap.ac10.useraccess;

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
 *         &lt;element name="CustomFieldsVal" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracTWsUaIpCustfldVal" minOccurs="0"/>
 *         &lt;element name="Language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Parameter" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracTWsUaIpPrameterList" minOccurs="0"/>
 *         &lt;element name="RequestHeaderData" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracSWsReqhdr"/>
 *         &lt;element name="RequestedLineItem" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracTWsUaIpReqlineitem"/>
 *         &lt;element name="UserGroup" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracTWsUaIpUserGroup" minOccurs="0"/>
 *         &lt;element name="UserInfo" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracTWsUserInfo"/>
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
    "customFieldsVal",
    "language",
    "parameter",
    "requestHeaderData",
    "requestedLineItem",
    "userGroup",
    "userInfo"
})
@XmlRootElement(name = "GracIdmUsrAccsReqServices")
public class GracIdmUsrAccsReqServices {

    @XmlElement(name = "CustomFieldsVal")
    protected GracTWsUaIpCustfldVal customFieldsVal;
    @XmlElement(name = "Language")
    protected String language;
    @XmlElement(name = "Parameter")
    protected GracTWsUaIpPrameterList parameter;
    @XmlElement(name = "RequestHeaderData", required = true)
    protected GracSWsReqhdr requestHeaderData;
    @XmlElement(name = "RequestedLineItem", required = true)
    protected GracTWsUaIpReqlineitem requestedLineItem;
    @XmlElement(name = "UserGroup")
    protected GracTWsUaIpUserGroup userGroup;
    @XmlElement(name = "UserInfo", required = true)
    protected GracTWsUserInfo userInfo;

    /**
     * Gets the value of the customFieldsVal property.
     * 
     * @return
     *     possible object is
     *     {@link GracTWsUaIpCustfldVal }
     *     
     */
    public GracTWsUaIpCustfldVal getCustomFieldsVal() {
        return customFieldsVal;
    }

    /**
     * Sets the value of the customFieldsVal property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracTWsUaIpCustfldVal }
     *     
     */
    public void setCustomFieldsVal(GracTWsUaIpCustfldVal value) {
        this.customFieldsVal = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the parameter property.
     * 
     * @return
     *     possible object is
     *     {@link GracTWsUaIpPrameterList }
     *     
     */
    public GracTWsUaIpPrameterList getParameter() {
        return parameter;
    }

    /**
     * Sets the value of the parameter property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracTWsUaIpPrameterList }
     *     
     */
    public void setParameter(GracTWsUaIpPrameterList value) {
        this.parameter = value;
    }

    /**
     * Gets the value of the requestHeaderData property.
     * 
     * @return
     *     possible object is
     *     {@link GracSWsReqhdr }
     *     
     */
    public GracSWsReqhdr getRequestHeaderData() {
        return requestHeaderData;
    }

    /**
     * Sets the value of the requestHeaderData property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracSWsReqhdr }
     *     
     */
    public void setRequestHeaderData(GracSWsReqhdr value) {
        this.requestHeaderData = value;
    }

    /**
     * Gets the value of the requestedLineItem property.
     * 
     * @return
     *     possible object is
     *     {@link GracTWsUaIpReqlineitem }
     *     
     */
    public GracTWsUaIpReqlineitem getRequestedLineItem() {
        return requestedLineItem;
    }

    /**
     * Sets the value of the requestedLineItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracTWsUaIpReqlineitem }
     *     
     */
    public void setRequestedLineItem(GracTWsUaIpReqlineitem value) {
        this.requestedLineItem = value;
    }

    /**
     * Gets the value of the userGroup property.
     * 
     * @return
     *     possible object is
     *     {@link GracTWsUaIpUserGroup }
     *     
     */
    public GracTWsUaIpUserGroup getUserGroup() {
        return userGroup;
    }

    /**
     * Sets the value of the userGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracTWsUaIpUserGroup }
     *     
     */
    public void setUserGroup(GracTWsUaIpUserGroup value) {
        this.userGroup = value;
    }

    /**
     * Gets the value of the userInfo property.
     * 
     * @return
     *     possible object is
     *     {@link GracTWsUserInfo }
     *     
     */
    public GracTWsUserInfo getUserInfo() {
        return userInfo;
    }

    /**
     * Sets the value of the userInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracTWsUserInfo }
     *     
     */
    public void setUserInfo(GracTWsUserInfo value) {
        this.userInfo = value;
    }

}
