
package oracle.iam.ws.sap.ac10.lookup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GrfnSWsLuOpContrGrp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GrfnSWsLuOpContrGrp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConnectorGrp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ConnectorGrpT" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ConnectionType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GrfnSWsLuOpContrGrp", propOrder = {
    "connectorGrp",
    "connectorGrpT",
    "connectionType"
})
public class GrfnSWsLuOpContrGrp {

    @XmlElement(name = "ConnectorGrp", required = true)
    protected String connectorGrp;
    @XmlElement(name = "ConnectorGrpT", required = true)
    protected String connectorGrpT;
    @XmlElement(name = "ConnectionType", required = true)
    protected String connectionType;

    /**
     * Gets the value of the connectorGrp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConnectorGrp() {
        return connectorGrp;
    }

    /**
     * Sets the value of the connectorGrp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConnectorGrp(String value) {
        this.connectorGrp = value;
    }

    /**
     * Gets the value of the connectorGrpT property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConnectorGrpT() {
        return connectorGrpT;
    }

    /**
     * Sets the value of the connectorGrpT property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConnectorGrpT(String value) {
        this.connectorGrpT = value;
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

}
