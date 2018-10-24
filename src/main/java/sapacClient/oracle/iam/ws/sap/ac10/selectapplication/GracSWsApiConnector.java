
package oracle.iam.ws.sap.ac10.selectapplication;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsApiConnector complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsApiConnector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Connector" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ConnectorDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ConnectionType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ConnectorCategory" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ConnectorCategoryDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GracSWsApiConnector", propOrder = {
    "connector",
    "connectorDesc",
    "connectionType",
    "connectorCategory",
    "connectorCategoryDesc"
})
public class GracSWsApiConnector {

    @XmlElement(name = "Connector", required = true)
    protected String connector;
    @XmlElement(name = "ConnectorDesc", required = true)
    protected String connectorDesc;
    @XmlElement(name = "ConnectionType", required = true)
    protected String connectionType;
    @XmlElement(name = "ConnectorCategory", required = true)
    protected String connectorCategory;
    @XmlElement(name = "ConnectorCategoryDesc", required = true)
    protected String connectorCategoryDesc;

    /**
     * Gets the value of the connector property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConnector() {
        return connector;
    }

    /**
     * Sets the value of the connector property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConnector(String value) {
        this.connector = value;
    }

    /**
     * Gets the value of the connectorDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConnectorDesc() {
        return connectorDesc;
    }

    /**
     * Sets the value of the connectorDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConnectorDesc(String value) {
        this.connectorDesc = value;
    }

    /**
     * Gets the value of the connectionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConnectionType() {
        return connectionType;
    }

    /**
     * Sets the value of the connectionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConnectionType(String value) {
        this.connectionType = value;
    }

    /**
     * Gets the value of the connectorCategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConnectorCategory() {
        return connectorCategory;
    }

    /**
     * Sets the value of the connectorCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConnectorCategory(String value) {
        this.connectorCategory = value;
    }

    /**
     * Gets the value of the connectorCategoryDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConnectorCategoryDesc() {
        return connectorCategoryDesc;
    }

    /**
     * Sets the value of the connectorCategoryDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConnectorCategoryDesc(String value) {
        this.connectorCategoryDesc = value;
    }

}
