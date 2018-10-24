
package oracle.iam.ws.sap.ac10.useraccess;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracIdmUsrAccsReqServices.RfcExceptions.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GracIdmUsrAccsReqServices.RfcExceptions">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CxGracIdmException"/>
 *     &lt;enumeration value="CxGrfnException"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "GracIdmUsrAccsReqServices.RfcExceptions")
@XmlEnum
public enum GracIdmUsrAccsReqServicesRfcExceptions {

    @XmlEnumValue("CxGracIdmException")
    CX_GRAC_IDM_EXCEPTION("CxGracIdmException"),
    @XmlEnumValue("CxGrfnException")
    CX_GRFN_EXCEPTION("CxGrfnException");
    private final String value;

    GracIdmUsrAccsReqServicesRfcExceptions(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GracIdmUsrAccsReqServicesRfcExceptions fromValue(String v) {
        for (GracIdmUsrAccsReqServicesRfcExceptions c: GracIdmUsrAccsReqServicesRfcExceptions.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
