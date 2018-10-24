
package oracle.iam.ws.sap.ac53.ejbutil.selectsystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfSystemDatas complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfSystemDatas">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="systemData" type="{urn:com.virsa.ae.ejbutil.selectsystem}ArrayOfSystemData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSystemDatas", propOrder = {
    "systemData"
})
public class ArrayOfSystemDatas {

    @XmlElement(nillable = true)
    protected ArrayOfSystemData systemData;

    /**
     * Gets the value of the systemData property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSystemData }
     *     
     */
    public ArrayOfSystemData getSystemData() {
        return systemData;
    }

    /**
     * Sets the value of the systemData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSystemData }
     *     
     */
    public void setSystemData(ArrayOfSystemData value) {
        this.systemData = value;
    }

}
