
package oracle.iam.ws.sap.ac53.audittrail;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import oracle.iam.ws.sap.ac53.ejbutil.auditlogs.AuditLogResult;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "SAPGRC_AC_IDM_AUDITTRAILVi_Document", targetNamespace = "urn:SAPGRC_AC_IDM_AUDITTRAILWsd/SAPGRC_AC_IDM_AUDITTRAILVi/document")
@XmlSeeAlso({
    oracle.iam.ws.sap.ac53.audittrail.ejbutil.ObjectFactory.class,
    oracle.iam.ws.sap.ac53.ejbutil.auditlogs.ObjectFactory.class,
    oracle.iam.ws.sap.ac53.audittrail.core.ObjectFactory.class,
    oracle.iam.ws.sap.ac53.audittrail.ObjectFactory.class
})
public interface SAPGRCACIDMAUDITTRAILViDocument {


    /**
     * 
     * @param fromDate
     * @param userFirstName
     * @param requestId
     * @param locale
     * @param action
     * @param toDate
     * @param userLastName
     * @return
     *     returns oracle.iam.ws.sap.ac53.ejbutil.auditlogs.AuditLogResult
     * @throws GetAuditLogsComVirsaAeCoreBOExceptionDoc
     */
    @WebMethod
    @WebResult(name = "Response", targetNamespace = "urn:SAPGRC_AC_IDM_AUDITTRAILVi")
    @RequestWrapper(localName = "getAuditLogs", targetNamespace = "urn:SAPGRC_AC_IDM_AUDITTRAILVi", className = "oracle.iam.ws.sap.ac53.audittrail.GetAuditLogs")
    @ResponseWrapper(localName = "getAuditLogsResponse", targetNamespace = "urn:SAPGRC_AC_IDM_AUDITTRAILVi", className = "oracle.iam.ws.sap.ac53.audittrail.GetAuditLogsResponse")
    public AuditLogResult getAuditLogs(
        @WebParam(name = "requestId", targetNamespace = "urn:SAPGRC_AC_IDM_AUDITTRAILVi")
        String requestId,
        @WebParam(name = "userFirstName", targetNamespace = "urn:SAPGRC_AC_IDM_AUDITTRAILVi")
        String userFirstName,
        @WebParam(name = "userLastName", targetNamespace = "urn:SAPGRC_AC_IDM_AUDITTRAILVi")
        String userLastName,
        @WebParam(name = "fromDate", targetNamespace = "urn:SAPGRC_AC_IDM_AUDITTRAILVi")
        String fromDate,
        @WebParam(name = "toDate", targetNamespace = "urn:SAPGRC_AC_IDM_AUDITTRAILVi")
        String toDate,
        @WebParam(name = "action", targetNamespace = "urn:SAPGRC_AC_IDM_AUDITTRAILVi")
        String action,
        @WebParam(name = "locale", targetNamespace = "urn:SAPGRC_AC_IDM_AUDITTRAILVi")
        String locale)
        throws GetAuditLogsComVirsaAeCoreBOExceptionDoc
    ;

}
