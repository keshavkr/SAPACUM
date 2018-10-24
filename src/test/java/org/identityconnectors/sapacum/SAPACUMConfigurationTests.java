package org.identityconnectors.sapacum.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;

import org.identityconnectors.framework.spi.ConfigurationProperty;
import org.identityconnectors.sapacum.SAPACUMConfiguration;
import org.identityconnectors.sapacum.test.util.SAPACUMTestUtil;
import org.junit.Assert;
import org.junit.Test;
/**
 * @author Sandeep Melgiri
 *
 */
public class SAPACUMConfigurationTests{
	
	@Test
	public void defaults() {		
		SAPACUMConfiguration config = new SAPACUMConfiguration();
		SAPACUMConfiguration acConfiguration = new SAPACUMConfiguration(config);
			
		Assert.assertNull(acConfiguration.getUser());
		Assert.assertNull(acConfiguration.getHost());	
		Assert.assertNull(acConfiguration.getPassword());
		Assert.assertNull(acConfiguration.getdummyPassword());			
		Assert.assertNull(acConfiguration.getDestination());
		Assert.assertNull(acConfiguration.getmasterSystem());		
		Assert.assertNull(acConfiguration.getchangePasswordAtNextLogon());		
		
		Assert.assertNull(acConfiguration.getJcoGroup());
		Assert.assertNull(acConfiguration.getJcoSAPRouter());
		Assert.assertNull(acConfiguration.getJcoTraceDir());
		Assert.assertNotNull(acConfiguration.getJcoTrace());
		
		Assert.assertNull(acConfiguration.getGatewayHost());
		Assert.assertNull(acConfiguration.getGatewayService());
		
		Assert.assertNull(acConfiguration.getDsr());
		Assert.assertNull(acConfiguration.getMsHost());
		Assert.assertNull(acConfiguration.getMsServ());	
		Assert.assertNull(acConfiguration.getAliasUser());
		Assert.assertNull(acConfiguration.getType());		
		
		Assert.assertNull(acConfiguration.getSncLib());
		Assert.assertNull(acConfiguration.getSncName());
		Assert.assertNull(acConfiguration.getSncPartnerName());
		Assert.assertNull(acConfiguration.getSncProtectionLevel());
		Assert.assertNull(acConfiguration.getSncX509Cert());			
		
		Assert.assertNotNull(acConfiguration.getSystemNumber());		
		Assert.assertNotNull( acConfiguration.getBatchSize());
		Assert.assertNotNull(acConfiguration.getClient());
		Assert.assertNotNull(acConfiguration.getLanguage());		
		Assert.assertNotNull(acConfiguration.getFilteredAccounts());
		Assert.assertNotNull(acConfiguration.getMaxBAPIRetries());
		Assert.assertNotNull(acConfiguration.getRetryWaitTime());
		Assert.assertNull(acConfiguration.getGrcLanguage());
		
		Assert.assertEquals(new String("10"), acConfiguration.getBatchSize());
		Assert.assertEquals(new String("00"), acConfiguration.getSystemNumber());
		Assert.assertEquals(new String("5"), Integer.toString(acConfiguration.getMaxBAPIRetries()));
		Assert.assertEquals(new String("EN"), acConfiguration.getLanguage());
		Assert.assertEquals(new String("000"), acConfiguration.getClient());
		Assert.assertEquals(new String("500"), Integer.toString(acConfiguration.getRetryWaitTime()));
		
		Assert.assertNotNull(acConfiguration.getConnectionMaxGetTime());
		Assert.assertNotNull(acConfiguration.getConnectionPoolActiveLimit());
		Assert.assertNotNull(acConfiguration.getConnectionPoolCapacity());
		Assert.assertNotNull(acConfiguration.getConnectionPoolExpirationPeriod());
		Assert.assertNotNull(acConfiguration.getConnectionPoolExpirationTime());		
		
		Assert.assertFalse(acConfiguration.getUseSNC());
		Assert.assertFalse(acConfiguration.getEnableCUA());
		Assert.assertFalse(acConfiguration.getLoadBalance());		
		Assert.assertFalse(acConfiguration.getUpperCasePwd());
		Assert.assertFalse(acConfiguration.getUseSAPTempPwd());	
		
		Assert.assertNotNull(acConfiguration.getIsGRC53());
		Assert.assertNull(acConfiguration.getGrcUsername());

		Assert.assertNull(acConfiguration.getAuditTrailWSDLPath());
		Assert.assertNull(acConfiguration.getRequestStatusWSDLPath());
		Assert.assertNull(acConfiguration.getSubmitRequestWSDLPath());
		Assert.assertNull(acConfiguration.getSelectApplicationWSDLPath());
		Assert.assertNull(acConfiguration.getSearchRolesWSDLPath());
		Assert.assertNull(acConfiguration.getRoleLookupAccessURL());
		Assert.assertNull(acConfiguration.getAppLookupAccessURL());
		Assert.assertNull(acConfiguration.getUserAccessAccessURL ());
		Assert.assertNull(acConfiguration.getRequestStatusAccessURL());
		Assert.assertNull(acConfiguration.getAuditLogsAccessURL());
		Assert.assertNull(acConfiguration.getEntitlementRiskAnalysisAccessURL());
		Assert.assertNull(acConfiguration.getOtherLookupAccessURL());
		Assert.assertNull(acConfiguration.getModifyUserReqType());
		Assert.assertNull(acConfiguration.getIgnoreOpenStatus());
		Assert.assertNull(acConfiguration.getRequestStatusWS());
		Assert.assertNotNull(acConfiguration);
		Assert.assertNull(acConfiguration.getCreateUserReqType());
		Assert.assertNull(acConfiguration.getEntitlementRiskAnalysisWS());
		Assert.assertNull(acConfiguration.getLockUserReqType());
		Assert.assertNull(acConfiguration.getRemoveRoleReqType());
		Assert.assertNull(acConfiguration.getProvItemActionAttrName());

		Assert.assertNull(acConfiguration.getDeleteUserReqType());
		Assert.assertNull(acConfiguration.getAssignRoleReqType());
		Assert.assertNull(acConfiguration.getAuditLogsWS());
		Assert.assertNull(acConfiguration.getProvActionAttrName());

		Assert.assertNull(acConfiguration.getLogAuditTrial());

		Assert.assertNull(acConfiguration.getRequestTypeAttrName());
		Assert.assertNull(acConfiguration.getRoleLookupWS());

		Assert.assertNull(acConfiguration.getAppLookupWS());
		Assert.assertNull(acConfiguration.getOtherLookupWS());
		Assert.assertNull(acConfiguration.getWsdlFilePath());
		Assert.assertNull(acConfiguration.getUserAccessWS());
		
		
				
	}
	
	@Test
	public void setters() {

		// Init config parameters
		
		SAPACUMTestUtil configUtil = new SAPACUMTestUtil();
		SAPACUMConfiguration config = configUtil.newacConfiguration();	
				
		Assert.assertNotNull(config.getUser());
		Assert.assertNotNull(config.getHost());	
		Assert.assertNotNull(config.getPassword());
		Assert.assertNotNull(config.getdummyPassword());			
		Assert.assertNotNull(config.getDestination());
		Assert.assertNotNull(config.getmasterSystem());		
		Assert.assertNotNull(config.getchangePasswordAtNextLogon());		
		
		Assert.assertNotNull(config.getJcoGroup());
		Assert.assertNotNull(config.getJcoSAPRouter());
		Assert.assertNotNull(config.getJcoTraceDir());
		Assert.assertNotNull(config.getJcoTrace());		
		Assert.assertNotNull(config.getGatewayHost());
		Assert.assertNotNull(config.getGatewayService());		
		Assert.assertNotNull(config.getMsHost());
		Assert.assertNotNull(config.getMsServ());	
		Assert.assertNotNull(config.getAliasUser());
		Assert.assertNotNull(config.getType());		
		
		Assert.assertNotNull(config.getSncLib());
		Assert.assertNotNull(config.getSncName());
		Assert.assertNotNull(config.getSncPartnerName());
		Assert.assertNotNull(config.getSncProtectionLevel());
		Assert.assertNotNull(config.getSncX509Cert());	
		
		config.setBatchSize("20");
		config.setSystemNumber("20");
		config.setMaxBAPIRetries(20);
		config.setLanguage("DE");
		config.setClient("600");
		config.setRetryWaitTime(100);		
		
		Assert.assertEquals(new String("20"), config.getBatchSize());
		Assert.assertEquals(new String("20"), config.getSystemNumber());
		Assert.assertEquals(new String("20"), Integer.toString(config.getMaxBAPIRetries()));
		Assert.assertEquals(new String("DE"), config.getLanguage());
		Assert.assertEquals(new String("600"), config.getClient());
		Assert.assertEquals(new String("100"),Integer.toString(config.getRetryWaitTime()));
		
		config.setConnectionMaxGetTime(20);
		config.setConnectionPoolActiveLimit(20);
		config.setConnectionPoolCapacity(20);
		config.setConnectionPoolExpirationPeriod(20);
		config.setConnectionPoolExpirationTime(20);
		config.setConnectionPoolExpirationTime(20);
		
		Assert.assertEquals(new String("20"),Integer.toString(config.getConnectionMaxGetTime()));
		Assert.assertEquals(new String("20"),Integer.toString(config.getConnectionPoolActiveLimit()));
		Assert.assertEquals(new String("20"),Integer.toString(config.getConnectionPoolCapacity()));
		Assert.assertEquals(new String("20"),Integer.toString(config.getConnectionPoolExpirationPeriod()));
		Assert.assertEquals(new String("20"),Integer.toString(config.getConnectionPoolExpirationTime()));
		
		
		Assert.assertNotNull(config.getAuditTrailWSDLPath());
		Assert.assertNotNull(config.getRequestStatusWSDLPath());
		Assert.assertNotNull(config.getSubmitRequestWSDLPath());
		Assert.assertNotNull(config.getSelectApplicationWSDLPath());
		Assert.assertNotNull(config.getSearchRolesWSDLPath());
		Assert.assertNotNull(config.getRoleLookupAccessURL());
		Assert.assertNotNull(config.getAppLookupAccessURL());
		Assert.assertNotNull(config.getUserAccessAccessURL ());
		Assert.assertNotNull(config.getRequestStatusAccessURL());
		Assert.assertNotNull(config.getAuditLogsAccessURL());
		Assert.assertNotNull(config.getEntitlementRiskAnalysisAccessURL());
		Assert.assertNotNull(config.getOtherLookupAccessURL());
		Assert.assertNotNull(config.getModifyUserReqType());
		Assert.assertNotNull(config.getIgnoreOpenStatus());
		Assert.assertNotNull(config.getRequestStatusWS());
		Assert.assertNotNull(config);
		Assert.assertNotNull(config.getCreateUserReqType());
		Assert.assertNotNull(config.getEntitlementRiskAnalysisWS());
		Assert.assertNotNull(config.getLockUserReqType());
		Assert.assertNotNull(config.getRemoveRoleReqType());
		Assert.assertNotNull(config.getProvItemActionAttrName());

		Assert.assertNotNull(config.getDeleteUserReqType());
		Assert.assertNotNull(config.getAssignRoleReqType());
		Assert.assertNotNull(config.getAuditLogsWS());
		Assert.assertNotNull(config.getProvActionAttrName());

		Assert.assertNotNull(config.getLogAuditTrial());

		Assert.assertNotNull(config.getRequestTypeAttrName());
		Assert.assertNotNull(config.getRoleLookupWS());

		Assert.assertNotNull(config.getAppLookupWS());
		Assert.assertNotNull(config.getOtherLookupWS());
		Assert.assertNotNull(config.getWsdlFilePath());
		Assert.assertNotNull(config.getUserAccessWS());
		
		
	}
	
	
	@Test
	public void testConfigurationalPropsAnnotations() {	
	
		SAPACUMConfiguration cfg = new SAPACUMConfiguration();
		
		Method[] md = cfg.getClass().getMethods();
		int gettersCounter = 0;
		
		Collection<String> confidentialmethodSet = Arrays.asList("getPassword","getdummyPassword","getTempPassword","getGrcPassword");
		Collection<String> requiredMethodSet =  Arrays.asList("getDestination","getClient","getPassword", "getUser", "getHost","getLanguage", "getSystemNumber", "getGrcUsername", "getGrcLanguage");

		Collection<String> objclassesmethodSet = Arrays.asList("getGroups","getRoles","getProfiles","getParameters","getIsGRC53","getFilteredAccounts","getSingleRoles","getCompositeRoles","getAuditTrailWSDLPath",
				"getUserAccessWS" ,"getRequestStatusWS", "getAuditLogsWS", "getEntitlementRiskAnalysisWS", "getRoleLookupWS", "getAppLookupWS" ,"getOtherLookupWS" ,"getCreateUserReqType", "getModifyUserReqType" ,"getLockUserReqType" 
				,"getUnlockUserReqType"  ,"getDeleteUserReqType" ,"getAssignRoleReqType" ,"getIgnoreOpenStatus",  "getLogAuditTrial", "getUserAccessAccessURL", "getRequestStatusAccessURL" ,"getAuditLogsAccessURL" ,"getEntitlementRiskAnalysisAccessURL",
				"getRoleLookupAccessURL" ,"getAppLookupAccessURL" , "getOtherLookupAccessURL" ,"getRequestTypeAttrName" ,"getProvActionAttrName" ,"getProvItemActionAttrName" ,"getRemoveRoleReqType" , "getWsdlFilePath", "getAuditTrailWSDLPath" ,
				"getSubmitRequestWSDLPath","getSelectApplicationWSDLPath" ,"getSearchRolesWSDLPath");
		
		for (Method method : md) {
			try {
				
				 Annotation[] annotations = method.getDeclaredAnnotations();
				
				
				for (Annotation annotation : annotations) {
					
					if (annotation instanceof ConfigurationProperty) {
						ConfigurationProperty myAnnotation = (ConfigurationProperty) annotation;
						gettersCounter++;
						// check for Object Classes
						if (objclassesmethodSet.contains(method.getName()))
							Assert.assertEquals(myAnnotation.objectClasses().length, 1);
						else
							 Assert.assertNotEquals(myAnnotation.objectClasses().length, 1); 
						// check for Confidential Tags
						if (confidentialmethodSet.contains(method.getName()))
							Assert.assertTrue(myAnnotation.confidential());
						else
							Assert.assertFalse(myAnnotation.confidential());

						// Check for Required Tags
						if (requiredMethodSet.contains(method.getName()))
							Assert.assertTrue(myAnnotation.required());
						else
							Assert.assertFalse(myAnnotation.required());
					}
				}
				
				
			} catch (AssertionError ae) {
				throw new AssertionError(ae + " : Error while asserting  "+ method.getName());
			}
			
		}
		//check for getter methods counts
		Assert.assertTrue(gettersCounter == 109);
	}	
}