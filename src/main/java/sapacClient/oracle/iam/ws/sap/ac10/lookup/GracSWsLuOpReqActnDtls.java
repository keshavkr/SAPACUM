
package oracle.iam.ws.sap.ac10.lookup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsLuOpReqActnDtls complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsLuOpReqActnDtls">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ItemProvType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ItemProvTypDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProvAction" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ActionDescn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GracSWsLuOpReqActnDtls", propOrder = {
    "itemProvType",
    "itemProvTypDesc",
    "provAction",
    "actionDescn"
})
public class GracSWsLuOpReqActnDtls {

    @XmlElement(name = "ItemProvType", required = true)
    protected String itemProvType;
    @XmlElement(name = "ItemProvTypDesc", required = true)
    protected String itemProvTypDesc;
    @XmlElement(name = "ProvAction", required = true)
    protected String provAction;
    @XmlElement(name = "ActionDescn", required = true)
    protected String actionDescn;

    /**
     * Gets the value of the itemProvType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemProvType() {
        return itemProvType;
    }

    /**
     * Sets the value of the itemProvType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemProvType(String value) {
        this.itemProvType = value;
    }

    /**
     * Gets the value of the itemProvTypDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemProvTypDesc() {
        return itemProvTypDesc;
    }

    /**
     * Sets the value of the itemProvTypDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemProvTypDesc(String value) {
        this.itemProvTypDesc = value;
    }

    /**
     * Gets the value of the provAction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvAction() {
        return provAction;
    }

    /**
     * Sets the value of the provAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvAction(String value) {
        this.provAction = value;
    }

    /**
     * Gets the value of the actionDescn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionDescn() {
        return actionDescn;
    }

    /**
     * Sets the value of the actionDescn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionDescn(String value) {
        this.actionDescn = value;
    }

}
