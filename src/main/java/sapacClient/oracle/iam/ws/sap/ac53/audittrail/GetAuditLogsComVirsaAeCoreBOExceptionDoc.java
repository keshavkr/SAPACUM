
package oracle.iam.ws.sap.ac53.audittrail;

import javax.xml.ws.WebFault;
import oracle.iam.ws.sap.ac53.audittrail.core.BOException;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "getAuditLogs_com.virsa.ae.core.BOException", targetNamespace = "urn:SAPGRC_AC_IDM_AUDITTRAILWsd/SAPGRC_AC_IDM_AUDITTRAILVi")
public class GetAuditLogsComVirsaAeCoreBOExceptionDoc
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private BOException faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public GetAuditLogsComVirsaAeCoreBOExceptionDoc(String message, BOException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public GetAuditLogsComVirsaAeCoreBOExceptionDoc(String message, BOException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: oracle.iam.ws.sap.ac53.audittrail.core.BOException
     */
    public BOException getFaultInfo() {
        return faultInfo;
    }

}
