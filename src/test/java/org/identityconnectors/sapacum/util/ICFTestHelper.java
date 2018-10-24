package org.identityconnectors.sapacum.test.util;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.List;

import org.identityconnectors.common.logging.Log;
import org.identityconnectors.framework.api.APIConfiguration;
import org.identityconnectors.framework.api.ConfigurationProperties;
import org.identityconnectors.framework.api.ConnectorFacade;
import org.identityconnectors.framework.api.ConnectorFacadeFactory;
import org.identityconnectors.framework.api.ConnectorInfo;
import org.identityconnectors.framework.api.ConnectorInfoManager;
import org.identityconnectors.framework.api.ConnectorInfoManagerFactory;
import org.identityconnectors.sap.SAPConfiguration;
import org.identityconnectors.sap.SAPConnector;
import org.identityconnectors.sapacum.SAPACUMConfiguration;
import org.identityconnectors.sapacum.SAPACUMConnector;
import org.identityconnectors.test.common.TestHelpers;
/**
 * @author Sandeep Melgiri
 *
 */

public final class ICFTestHelper {	
	
	private boolean connectionFailed = false;    
    private static SAPACUMConfiguration config=null;
    private static ConnectorFacade _facade = null;   
    private static ICFTestHelper icfTestHelper=null;
	private Log LOGGER = Log.getLog(getClass());
    private final static String _bundleLoc = "D:\\ADE_local\\idc\\bundles\\java\\sapac\\dist\\org.identityconnectors.sapacum-1.0.11170.jar";
       
   
    
    private ICFTestHelper() {
    }
    
    
    public static ICFTestHelper getInstance() {
    	if(icfTestHelper==null){
    		icfTestHelper=new ICFTestHelper();
    		}
    		return icfTestHelper;
    }
    
    
    public  ConnectorFacade newFacade() {
    	SAPACUMTestUtil sumtu = new SAPACUMTestUtil();
		SAPACUMConfiguration conf=sumtu.newacConfiguration();
		return newFacade(conf);	
		
	}
    
    
    static ConnectorFacade connectorFacadeBundle = null;
    public static  ConnectorFacade getConnectorFacadeHelperImp() {
    if( null != connectorFacadeBundle)
    return connectorFacadeBundle;
    SAPACUMConfiguration config = new SAPACUMConfiguration();
    setSapConfig(config, getConfig());
    ConnectorFacadeFactory factory = ConnectorFacadeFactory.getInstance();
    APIConfiguration impl = TestHelpers.createTestConfiguration(SAPACUMConnector.class, config);
    connectorFacadeBundle =factory.newInstance(impl); 
    return connectorFacadeBundle;
    }
    
    private static void setSapConfig(SAPACUMConfiguration acConfig,
    		SAPACUMConfiguration groovyConfig) {
               
        Object noparams[] = {};
        Method[] groovyConfigMethods = groovyConfig.getClass().getMethods();
        Method[] acConfigMethods = acConfig.getClass().getMethods();

        for (Method method: groovyConfigMethods) {
            if(method.getName().startsWith("get")) {                 
                String methodName=new String(method.getName().substring(3));
                for(Method acMethod: acConfigMethods){
                    if(acMethod.getName().startsWith("set")) {                 
                        String acMethodName=new String(acMethod.getName().substring(3));
                        if(methodName.equals(acMethodName)){
                            try {
                                System.out.println("Value from "+methodName+" getter will be passed to "+acMethodName+" setter");    
                                acMethod.invoke(acConfig, method.invoke(groovyConfig, noparams));
                            } catch (IllegalArgumentException e) {
                                e.printStackTrace();
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
      
     
    
    
	
	public ConnectorFacade newFacade(SAPACUMConfiguration cfg) {
		
		if (connectionFailed)
			throw new IllegalStateException("Connection to target failed");
		ICFTestHelper.config=null;
		ICFTestHelper._facade=null;
    	ICFTestHelper.icfTestHelper=null;  
		setConfig(cfg);
		initializeFacade();
		return _facade;
		
	}	
     
    public ConnectorFacade getFacade() {

        if (connectionFailed)
            throw new IllegalStateException("Connection to target failed");

        if (_facade == null) {
            initializeFacade();
        }
        return _facade;
    }        
    
    private void initializeFacade() {
    
    LOGGER.info("Loading the bundle " + _bundleLoc);
	File bundleJarFile = new File(_bundleLoc);	

	if (!bundleJarFile.exists()) {
	throw new IllegalArgumentException("Bundle jar doesn't exist at "
	+ _bundleLoc);
	}

	try {
	URL connectorBundle = bundleJarFile.toURI().toURL();
	LOGGER.info("Bundle location: " + _bundleLoc);
	ConnectorInfoManagerFactory infoManagerFactory = ConnectorInfoManagerFactory.getInstance();
	ConnectorInfoManager infoManager = infoManagerFactory.getLocalManager(connectorBundle);
	
	
	       // Only one bundle should be loaded
			List<ConnectorInfo> connectorInfos = infoManager
			.getConnectorInfos();
			if (connectorInfos.size() != 1) {
				LOGGER.error(
			"Connector cannot be loaded. Only one bundle should be present."
			+ " {0} bundles found", connectorInfos.size());
			throw new IllegalStateException("Improper bundle found");
			}
			 // Get configuration props
            APIConfiguration apiConfig = connectorInfos.get(0)
                    .createDefaultAPIConfiguration();

            // Set configuration props
            ConfigurationProperties configProps = apiConfig
                    .getConfigurationProperties();          
            
            setSapConfigProps(configProps, getConfig());
            
            _facade = ConnectorFacadeFactory.getInstance().newInstance(
                    apiConfig);
            LOGGER.info("Connector validated");           

        } catch (Exception e) {
        	LOGGER.error("Unable to initialize the bundle at {0}", _bundleLoc);
            connectionFailed = true;
            throw new IllegalStateException(e);
        }
    }
		
    private static void setSapConfigProps(ConfigurationProperties sapConfigProps, SAPConfiguration config) {
	   
	   Object propertyvalue = null;
	   String methodName=null;
	   String propertyName=null;
	   String firstchar=null;	 
	   Object noparams[] = {};	   
	   
	   
	   Method[] methods = config.getClass().getMethods();
	   
	   for (Method method: methods) {
		   if(method.getName().startsWith("get")) {
			   
			   methodName=new String(method.getName().substring(3));
			  
		   } else if(method.getName().startsWith("is")) {
			   methodName=new String(method.getName().substring(2));
			   	   
		   } else{
			   continue;
		   }
		   
		   if(methodName.equalsIgnoreCase("lcheck")){
			   propertyName=methodName;
		   } else {
			   firstchar= methodName.toLowerCase().substring(0, 1);
			   propertyName = firstchar.concat(methodName.substring(1)); 
		   }
		   
		   if(sapConfigProps.getPropertyNames().contains(propertyName)){
			   try{					  
				   propertyvalue= method.invoke(config, noparams);
				   sapConfigProps.setPropertyValue(propertyName, propertyvalue);
			   }catch(Exception e){
				   System.out.println(e.getMessage());
				   System.out.println("propertyName:"+propertyName);
				   System.out.println("propertyvalue:"+propertyvalue);
			   }
		   }
	  }		   
	 
   }      

    private static SAPACUMConfiguration getConfig() {
    	
    	if(config==null){
    	config=new SAPACUMTestUtil().newacConfiguration();
    	}
		return config;
	}

	private void setConfig(SAPACUMConfiguration config) {
		ICFTestHelper.config = config;
	}
  
}
