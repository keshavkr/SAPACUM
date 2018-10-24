
package oracle.iam.ws.sap.ac10.lookup;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracIdmLookupServices.RfcExceptions.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GracIdmLookupServices.RfcExceptions">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CxGrfnException"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "GracIdmLookupServices.RfcExceptions")
@XmlEnum
public enum GracIdmLookupServicesRfcExceptions {

    @XmlEnumValue("CxGrfnException")
    CX_GRFN_EXCEPTION("CxGrfnException");
    private final String value;

    GracIdmLookupServicesRfcExceptions(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GracIdmLookupServicesRfcExceptions fromValue(String v) {
        for (GracIdmLookupServicesRfcExceptions c: GracIdmLookupServicesRfcExceptions.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
