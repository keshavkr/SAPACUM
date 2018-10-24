package oracle.iam.ws.sap.util;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;

import org.identityconnectors.common.logging.Log;

import oracle.iam.ws.sap.security.HTTPBasicAuthenticationHandler;

/**
 * 
 * @author ranjith.kumar
 *
 */
public final class WsClientUtil {

	private static final Log LOG = Log.getLog(WsClientUtil.class);
	
	public static final String KEY_USER_NAME = "username";
	public static final String KEY_GRC_USER_NAME = "grcUsername";
	public static final String KEY_PASSWORD = "password";
	public static final String KEY_GRC_PASSWORD = "grcPassword";
	public static final String KEY_AC_URL = "AC_URL";
	public static final String KEY_LANGUAGE = "language";
	public static final String KEY_GRC_LANGUAGE = "grcLanguage";
	//public static final String KEY_WSDL_URL = "WSDL_URL";
	public static final String KEY_FORM_DATA = "FormData";
	public static final String KEY_CONFIG_DATA = "Configuration";	
	public static final String STATUS = "Status";
	public static final String RESULT = "Result";
	
	/**
	 * Method setting user credentials to port
	 * @param port
	 * @param dataMap
	 */
	public void setCredentials(BindingProvider port, Map dataMap, 
			Boolean canSetEndpoint){
		String userName=(String)(dataMap.get(KEY_GRC_USER_NAME)!=null?dataMap.get(KEY_GRC_USER_NAME):dataMap.get(KEY_USER_NAME));
		Object password=dataMap.get(KEY_GRC_PASSWORD)!=null?dataMap.get(KEY_GRC_PASSWORD):dataMap.get(KEY_PASSWORD);
		setSecurityContext(port, initSecurityContext(userName, password));
		if(canSetEndpoint){
			port.getRequestContext().put(
					BindingProvider.ENDPOINT_ADDRESS_PROPERTY, dataMap.get(KEY_AC_URL));
		}
	}
	/**
	 * Initializing a handler using HTTPBasicAuthenticationHandler instance
	 * @param user
	 * @param password
	 * @return
	 */
	public Handler<? extends MessageContext> initSecurityContext(
			String user, Object password){
		Map<String,? super Object> args = new HashMap<String,Object>();
        args.put(HTTPBasicAuthenticationHandler.USER_ATTR, user);
        args.put(HTTPBasicAuthenticationHandler.PASSWORD_ATTR,password);
        Handler<? extends MessageContext> handler = new HTTPBasicAuthenticationHandler(args);
        return handler;
	}
	

	/**
	 * Assigning HTTPBasicAuthenticationHandler to port
	 * @param port
	 * @param handler
	 */
    public void setSecurityContext(BindingProvider port, 
    		Handler<? extends MessageContext> handler) {
	    if (handler != null) {
	        Binding binding = port.getBinding();
	        List<Handler> chain = binding.getHandlerChain();
	        if (chain == null) {
	            chain = new ArrayList<Handler>();
	        }
	        chain.add(handler);
	        binding.setHandlerChain(chain);
	    }
	}

    /**
     * Description : Creates a method name to be invoked as a String and 
     * validates if the method exists in the class.
     * @param inputClass
     *                Class containing the required method.
     *                e.g. oracle.iam.connectors.sap.grc.ws.submitreq.RoleData
     * @param input
     *                Variable whose setter method needs to be created
     *                e.g. roleId
     * @param prefix
     *                Prefix 'set' used to create the method
     * @return
     */
    public String getMethodName(Class<?> inputClass, String input, 
    		String prefix) throws NoSuchMethodException {
          String retval = "";
          input = prefix + input;
          Method[] methods = inputClass.getDeclaredMethods();
          Method method;
          for (int i = 0; i < methods.length; i++) {
                method = methods[i];
                if (method.getName().compareToIgnoreCase(input) == 0) {
                      retval = method.getName();
                      break;
                }
          }
          //logger.setMethodFinishLog(className, sMethodName);
          if(retval.length()==0){
        	  throw new NoSuchMethodException("No such method name found:"+input);
          }
          return retval;
    }

	/**
	 * Creating Method instance using given class instance and method signature details  
	 * @param clazz
	 * @param methodName
	 * @return
	 * @throws Exception 
	 */
	public Method getMethod(Class<? extends Object> clazz, 
			String methodName, Class<? extends Object>... paramClazz) throws Exception {
		Method method = null;
		if(methodName.length()==0){
			LOG.warn("Method name is empty");
		}
		method = clazz.getMethod(methodName, paramClazz);
		return method;
	}
	
	/**
	 * Filtering Attribute name
	 * @param aName
	 * @return
	 */
	public String splitAttrName(String aName){
		if (aName == null){
			return aName;
		}
		String attr = aName;
		Integer idxSemicolon = aName.indexOf(";");
		Integer idxLastTilde = aName.lastIndexOf("~");
		if(idxSemicolon > -1){
			attr = aName.substring(0, idxSemicolon);
		}
		if (idxLastTilde > -1){
			attr = attr.substring(idxLastTilde+1);
		}
		return attr;
	}
    
	/**
	 * Filtering value
	 * @param value
	 * @return
	 */
	public String filterAttrValue(String value){
		if(value.contains("~")){
			String[] val = value.split("~");
			Integer size = val.length;
			value = val[size-1];
		}else if(value.contains(":")){
			String[] val = value.split(":");
			Integer size = val.length;
			value = val[size-1];
		}
		return value;
	}
	
	/**
	 * Filtering value
	 * @param value
	 * @return
	 */
	public String filterAttrValue1(String value){
		if(value.contains("~")){
			value = value.substring(value.lastIndexOf("~")+1);
		}else if(value.contains(":")){
			value = value.substring(value.lastIndexOf(":")+1);
		}else if(value.contains(".cn=")){
			String tmp = value.substring(value.indexOf("=")+1);
			value = tmp.substring(0,tmp.indexOf(","));
		}else{
			value = value.substring(value.lastIndexOf(".")+1);
		}
		return value;
	}
	/**
	 * Method which returns array of strings with given delimiter
	 * @param value
	 * @return
	 */
	public String[] getValues(String value, String delimiter){
		String[] val = null;
		if(value.contains(delimiter)){
			val = value.split(delimiter);
		} else {
			val = new String[]{value};
		}
		return val;
	}
	
	/**
	 * Building URL for AC 5.3 web service
	 * @param server
	 * @param port
	 * @param servicePart
	 * @return
	 */
	public String buildURL(String server, String port, String servicePart){
		LOG.info("buildURL - server:{0}, port={1}, servicepart:{2}", server, port, servicePart);
		StringBuilder urlString = new StringBuilder("http://");
		urlString.append(server);
		urlString.append(":");
		urlString.append(port);
		urlString.append("/");
		urlString.append(servicePart);
		return urlString.toString();
	}
	
    /**
     * Description: Converts one date format to another
     *
     * @param dateValue 
     * 			Date value to be converted to other format 			
     * @param sourceDateFormat 
     * 			Format of dateValue
     * @param targetDateFormat 
     * 			Targeted date format
     * @return String
     * 			String with converted date format
     * 
     * @throws ParseException
     */
   public String dateFormatConversion(String dateValue,
                                      String sourceDateFormat,
                                      String targetDateFormat)
                               throws ParseException {
       String date = null;
       DateFormat dateFormat = new SimpleDateFormat(sourceDateFormat);
       SimpleDateFormat outputDateFormat = new SimpleDateFormat(targetDateFormat);
       if (dateValue != null) {
           date = outputDateFormat.format((java.util.Date) (dateFormat.parse(dateValue)));
       }
       return date;
   }	
}
