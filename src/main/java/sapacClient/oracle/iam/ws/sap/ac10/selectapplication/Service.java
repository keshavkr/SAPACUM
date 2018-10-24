
package oracle.iam.ws.sap.ac10.selectapplication;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "service", targetNamespace = "urn:sap-com:document:sap:soap:functions:mc-style", wsdlLocation = "file:/D:/ant_grctest_19JUL2012/wsdl/grc10/GRAC_SELECT_APPL_WS/GRAC_SELECT_APPL_WS.WSDL")
public class Service
    extends javax.xml.ws.Service
{

    private final static URL SERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(oracle.iam.ws.sap.ac10.selectapplication.Service.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = oracle.iam.ws.sap.ac10.selectapplication.Service.class.getResource(".");
            url = new URL(baseUrl, "file:/D:/ant_grctest_19JUL2012/wsdl/grc10/GRAC_SELECT_APPL_WS/GRAC_SELECT_APPL_WS.WSDL");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'file:/D:/ant_grctest_19JUL2012/wsdl/grc10/GRAC_SELECT_APPL_WS/GRAC_SELECT_APPL_WS.WSDL', retrying as a local file");
            logger.warning(e.getMessage());
        }
        SERVICE_WSDL_LOCATION = url;
    }

    public Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Service() {
        super(SERVICE_WSDL_LOCATION, new QName("urn:sap-com:document:sap:soap:functions:mc-style", "service"));
    }

    /**
     * 
     * @return
     *     returns GRACSELECTAPPLWS
     */
    @WebEndpoint(name = "binding")
    public GRACSELECTAPPLWS getBinding() {
        return super.getPort(new QName("urn:sap-com:document:sap:soap:functions:mc-style", "binding"), GRACSELECTAPPLWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns GRACSELECTAPPLWS
     */
    @WebEndpoint(name = "binding")
    public GRACSELECTAPPLWS getBinding(WebServiceFeature... features) {
        return super.getPort(new QName("urn:sap-com:document:sap:soap:functions:mc-style", "binding"), GRACSELECTAPPLWS.class, features);
    }

}
