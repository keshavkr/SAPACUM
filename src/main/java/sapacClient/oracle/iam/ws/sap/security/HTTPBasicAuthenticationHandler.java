package oracle.iam.ws.sap.security;

import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.LogicalMessage;
import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;

import org.identityconnectors.common.logging.Log;
import org.identityconnectors.common.security.GuardedString;

/**
 * @author ranjith.kumar
 *
 */
public class HTTPBasicAuthenticationHandler implements
		LogicalHandler<LogicalMessageContext> {
	/**
	 * Instance of Log
	 */
	private static final Log LOG = Log.getLog(HTTPBasicAuthenticationHandler.class);
	
    public final static String USER_ATTR = "user";
    public final static String PASSWORD_ATTR = "password";
    
    private Object _userName;
    private String _userPassword;
	
    /**
     * Constructor of the class 
     * @param args
     */
    public HTTPBasicAuthenticationHandler(Map<String, ? super Object> args){
        final String METHOD = "HTTPBasicAuthenticationHandler";
        LOG.info(METHOD);
        if (args != null) {
            if (args.containsKey(USER_ATTR)) {
                _userName = args.get(USER_ATTR);
            } // if user
            if (args.containsKey(PASSWORD_ATTR)) {
                Object pwd = args.get(PASSWORD_ATTR);
                if(GuardedString.class.getName().equalsIgnoreCase(
                		pwd.getClass().getName())){
                	GuardedStringAccessor stringAccessor = new GuardedStringAccessor();
                	((GuardedString)pwd).access(stringAccessor);
                	_userPassword = new String(stringAccessor.getArray());
            		stringAccessor.clear();
                } else if(String.class.getName().equalsIgnoreCase(
                		pwd.getClass().getName())) {
                    _userPassword = (String)pwd;
                } else {
                    _userPassword = pwd.toString();
                }
                pwd = null;
            } // if user
        } // if options
    }


    /**
     * 
     * @param context
     */
	public void close(MessageContext context) {
		// nothing to do here
	}

	/**
	 * Method to process fault message
	 * @param logicalMsgContext
	 */
	public boolean handleFault(LogicalMessageContext logicalMsgContext) {
        final String METHOD = "handleFault";

        // shortcut if we're not tracing
        /*if (!TRACE.level1(METHOD)) {
            return true;
        }*/
        boolean outbound = (Boolean)logicalMsgContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        String msg = null;
        Object reqMethod = logicalMsgContext.get(MessageContext.HTTP_REQUEST_METHOD);
        LogicalMessage message = logicalMsgContext.getMessage();
        // no need to for i18N this: it should not happen that often and will only be traced
        if (outbound) {
            msg = "("+reqMethod+") Outbound message error: ";
        } else {
            msg = "("+reqMethod+") Inbound message error: ";
        }
        //if (TRACE.level1(METHOD)) TRACE.info(METHOD, msg + message.toString());
        LOG.info("@ "+METHOD+" ===> "+msg+message.toString());
        return true;
	}

	/**
	 * Method setting user Credentials in context
	 * @param logicalMsgContext
	 */
	public boolean handleMessage(LogicalMessageContext logicalMsgContext) {
        final String METHOD = "handleMessage";
        LOG.info(METHOD);
        boolean ret = true;
        if (logicalMsgContext != null) {
            boolean outbound = (Boolean)logicalMsgContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
            if (outbound) {
                logicalMsgContext.put(BindingProvider.USERNAME_PROPERTY, _userName);
                logicalMsgContext.put(BindingProvider.PASSWORD_PROPERTY, _userPassword);
            }
        } else {
            // empty context just return
            ret = false;
        }
        return ret;
	}

}