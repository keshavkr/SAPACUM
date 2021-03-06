
package oracle.iam.ws.sap.ac53.searchroles;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "SAPGRC_AC_IDM_SEARCHROLES", targetNamespace = "urn:SAPGRC_AC_IDM_SEARCHROLESWsd", wsdlLocation = "file:/D:/ant_grctest_19JUL2012/wsdl/grc53/SAPGRC_AC_IDM_SEARCHROLES/main.wsdl")
public class SAPGRCACIDMSEARCHROLES
    extends Service
{

    private final static URL SAPGRCACIDMSEARCHROLES_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(oracle.iam.ws.sap.ac53.searchroles.SAPGRCACIDMSEARCHROLES.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = oracle.iam.ws.sap.ac53.searchroles.SAPGRCACIDMSEARCHROLES.class.getResource(".");
            url = new URL(baseUrl, "file:/D:/ant_grctest_19JUL2012/wsdl/grc53/SAPGRC_AC_IDM_SEARCHROLES/main.wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'file:/D:/ant_grctest_19JUL2012/wsdl/grc53/SAPGRC_AC_IDM_SEARCHROLES/main.wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        SAPGRCACIDMSEARCHROLES_WSDL_LOCATION = url;
    }

    public SAPGRCACIDMSEARCHROLES(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SAPGRCACIDMSEARCHROLES() {
        super(SAPGRCACIDMSEARCHROLES_WSDL_LOCATION, new QName("urn:SAPGRC_AC_IDM_SEARCHROLESWsd", "SAPGRC_AC_IDM_SEARCHROLES"));
    }

    /**
     * 
     * @return
     *     returns SAPGRCACIDMSEARCHROLESViDocument
     */
    @WebEndpoint(name = "Config1Port_Document")
    public SAPGRCACIDMSEARCHROLESViDocument getConfig1PortDocument() {
        return super.getPort(new QName("urn:SAPGRC_AC_IDM_SEARCHROLESWsd", "Config1Port_Document"), SAPGRCACIDMSEARCHROLESViDocument.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SAPGRCACIDMSEARCHROLESViDocument
     */
    @WebEndpoint(name = "Config1Port_Document")
    public SAPGRCACIDMSEARCHROLESViDocument getConfig1PortDocument(WebServiceFeature... features) {
        return super.getPort(new QName("urn:SAPGRC_AC_IDM_SEARCHROLESWsd", "Config1Port_Document"), SAPGRCACIDMSEARCHROLESViDocument.class, features);
    }

}
