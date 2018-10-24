/**
 * 
 */
package org.identityconnectors.sapacum.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.identityconnectors.common.logging.Log;
import org.identityconnectors.framework.api.ConnectorFacade;
import org.identityconnectors.framework.common.objects.Attribute;
import org.identityconnectors.framework.common.objects.AttributeBuilder;
import org.identityconnectors.framework.common.objects.ObjectClass;
import org.identityconnectors.framework.common.objects.OperationOptionInfoBuilder;
import org.identityconnectors.framework.common.objects.OperationOptionsBuilder;
import org.identityconnectors.framework.common.objects.Schema;
import org.identityconnectors.framework.common.objects.Uid;
import org.identityconnectors.sap.SAPConnector;
import org.identityconnectors.sap.UserSchema;
import org.identityconnectors.sapacum.SAPACUMConfiguration;
import org.identityconnectors.sapacum.SAPACUMSchema;
import org.identityconnectors.sapacum.test.util.ICFTestHelper;
import org.identityconnectors.sapacum.test.util.SAPACUMTestUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * @author Sandeep Melgiri
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SAPACUMCreateUserTest {

	List<String> attrToGet = new ArrayList<String>();
	List<String> roleAttrs = new ArrayList<String>();
	List<String> profileAttrs = new ArrayList<String>();
	List<String> parameterAttrs = new ArrayList<String>();
	List<String> groupAttrs = new ArrayList<String>();
	
	
	private static ConnectorFacade facade=null;	
	private static SAPACUMTestUtil configUtil =  new SAPACUMTestUtil();
	private static final Log LOGGER = Log.getLog(SAPACUMCreateUserTest.class);
	
	
	@Before
	public void setUp() throws Exception {
		
		//getting the facade object		
		 facade =ICFTestHelper.getConnectorFacadeHelperImp();
		 facade.test();
		 
		//calling schema
		 facade.schema();
		
		// Get all account attributes from schema
			UserSchema uschema = new UserSchema();
			
			SAPACUMSchema acschema = new SAPACUMSchema(new SAPACUMConfiguration(), new SAPConnector());
			// Get all account attributes from schema
			attrToGet.addAll(acschema.getAc10attrSet());
			// Get all account attributes from schema
			attrToGet.addAll(uschema.getAccountAttributeNames());	
		
		roleAttrs.add("ValidTo");
		roleAttrs.add("itemName");
		roleAttrs.add("connector");
		roleAttrs.add("validFrom");

		profileAttrs.add("connector");
		profileAttrs.add("itemName");

	}

	@After
	public void tearDown() {
		
		facade=null;
		configUtil=null;
		attrToGet=null;
		roleAttrs=null;
		profileAttrs=null;
		parameterAttrs=null;
		groupAttrs=null;
		
	}
	
	@Test
	public void testTestMethod(){		
		
		facade.test();
	}
	
	@Test
	public void testCreate_User_inAC() throws Exception {
		LOGGER.info("BEGIN");
		try{
			Uid uid = null;
			Set<Attribute> attrSet = configUtil.toAttributeSet(2, attrToGet);
			TestCase.assertNotNull(attrSet);
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			OperationOptionInfoBuilder infobuilder = new OperationOptionInfoBuilder();
			uid = facade.create(ObjectClass.ACCOUNT, attrSet, builder.build());
			TestCase.assertNotNull(uid);
			Assert.assertTrue(uid.getValue().contains("New Account"));
			LOGGER.info("testCreate_User: User '" + uid.getUidValue()	+ "' Created Successfully ");
			LOGGER.info(">>>>>Result::{0}::{1}", "testCreate_User", "Successful");
		} catch(Exception e){
			LOGGER.info(">>>>>Result::{0}::{1}", "testCreate_User", "Failed");
		} finally{
			LOGGER.info("END");
		}
	}
	

}
