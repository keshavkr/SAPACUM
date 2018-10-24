
package oracle.iam.ws.sap.ac10.requeststatus;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracIdmRequestStatServices.RfcExceptions.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GracIdmRequestStatServices.RfcExceptions">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CxGrfnException"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "GracIdmRequestStatServices.RfcExceptions")
@XmlEnum
public enum GracIdmRequestStatServicesRfcExceptions {

    @XmlEnumValue("CxGrfnException")
    CX_GRFN_EXCEPTION("CxGrfnException");
    private final String value;

    GracIdmRequestStatServicesRfcExceptions(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GracIdmRequestStatServicesRfcExceptions fromValue(String v) {
        for (GracIdmRequestStatServicesRfcExceptions c: GracIdmRequestStatServicesRfcExceptions.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
