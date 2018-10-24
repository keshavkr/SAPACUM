
package oracle.iam.ws.sap.ac10.useraccess;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsUaIpPrameterList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsUaIpPrameterList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Parameter" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ParameterValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ParameterDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GracSWsUaIpPrameterList", propOrder = {
    "parameter",
    "parameterValue",
    "parameterDesc"
})
public class GracSWsUaIpPrameterList {

    @XmlElement(name = "Parameter", required = true)
    protected String parameter;
    @XmlElement(name = "ParameterValue", required = true)
    protected String parameterValue;
    @XmlElement(name = "ParameterDesc", required = true)
    protected String parameterDesc;

    /**
     * Gets the value of the parameter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParameter() {
        return parameter;
    }

    /**
     * Sets the value of the parameter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParameter(String value) {
        this.parameter = value;
    }

    /**
     * Gets the value of the parameterValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParameterValue() {
        return parameterValue;
    }

    /**
     * Sets the value of the parameterValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParameterValue(String value) {
        this.parameterValue = value;
    }

    /**
     * Gets the value of the parameterDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParameterDesc() {
        return parameterDesc;
    }

    /**
     * Sets the value of the parameterDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParameterDesc(String value) {
        this.parameterDesc = value;
    }

}
