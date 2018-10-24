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
import org.identityconnectors.framework.common.exceptions.ConnectorException;
import org.identityconnectors.framework.common.objects.Attribute;
import org.identityconnectors.framework.common.objects.AttributeBuilder;
import org.identityconnectors.framework.common.objects.ConnectorObject;
import org.identityconnectors.framework.common.objects.EmbeddedObject;
import org.identityconnectors.framework.common.objects.Name;
import org.identityconnectors.framework.common.objects.ObjectClass;
import org.identityconnectors.framework.common.objects.OperationOptionsBuilder;
import org.identityconnectors.framework.common.objects.OperationalAttributes;
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
public class SAPACUMUpdateUserTest extends TestCase {

	private static ConnectorFacade facade=null;
	private SAPACUMTestUtil configUtil =  new SAPACUMTestUtil();
	List<String> attrToGet = new ArrayList<String>();	
	List<String> roleAttrs = new ArrayList<String>();
	List<String> profileAttrs = new ArrayList<String>();
	List<String> parameterAttrs = new ArrayList<String>();
	List<String> groupAttrs = new ArrayList<String>();
	private static final Log LOGGER = Log.getLog(SAPACUMUpdateUserTest.class);
	@Before
	public void setUp() throws Exception {

		//getting the facade object		
		facade =ICFTestHelper.getConnectorFacadeHelperImp();

		//calling schema
		facade.schema();
		UserSchema uschema = new UserSchema();
		SAPACUMSchema acschema = new SAPACUMSchema(new SAPACUMConfiguration(), new SAPConnector());
		// Get all account attributes from schema
		attrToGet.addAll(acschema.getAc10attrSet());
		attrToGet.addAll(uschema.getAccountAttributeNames());
		attrToGet.add(Uid.NAME);

		roleAttrs.add("ValidTo");
		roleAttrs.add("itemName");
		roleAttrs.add("connector");
		roleAttrs.add("validFrom");

		profileAttrs.add("connector");
		profileAttrs.add("itemName");

		parameterAttrs.addAll(uschema.getParamAttributeNames());

	}

	@After
	public void tearDown() {
		facade=null;
		configUtil=null;
		attrToGet=null;
		roleAttrs=null;
		parameterAttrs=null;
	}


	@Test
	public void test_AC_Update_User() throws Exception {
		LOGGER.info("BEGIN");
		Uid uid = null;
		try {
			Set<Attribute> replaceAttr = configUtil.toAttributeSet(34, attrToGet);
			replaceAttr.add(AttributeBuilder.buildCurrentAttributes(ObjectClass.ACCOUNT, replaceAttr));
			assertNotNull(replaceAttr);
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			for (Attribute attr : replaceAttr) {
				if (attr.getName().toString().equalsIgnoreCase(Uid.NAME))
					uid = new Uid(attr.getValue().get(0).toString());
			}
			assertNotNull(uid);
			replaceAttr.remove(AttributeBuilder.build(Uid.NAME, "SANDEEP~*~59~New Account" ));
			uid = facade.update(ObjectClass.ACCOUNT, uid, replaceAttr,builder.build());
			assertNotNull(uid);
			Assert.assertTrue(uid.getValue().contains("Change Account"));
			LOGGER.info("User '" + uid.getUidValue()+ "' updated successfully ");
		} catch(Exception e){
			LOGGER.error("test_AC_Update_User() failed "+e.getMessage());
			throw e;

		} finally {
			LOGGER.info("END");
		}
	}


	@Test(expected=ConnectorException.class)
	public void test_invalid_reqID_AC_Update_User() throws Exception {
		LOGGER.info("BEGIN");
		Uid uid = null;
		try {
			Set<Attribute> replaceAttr = configUtil.toAttributeSet(38, attrToGet);
			replaceAttr.add(AttributeBuilder.buildCurrentAttributes(ObjectClass.ACCOUNT, replaceAttr));
			assertNotNull(replaceAttr);
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			for (Attribute attr : replaceAttr) {
				if (attr.getName().toString().equalsIgnoreCase(Uid.NAME))
					uid = new Uid(attr.getValue().get(0).toString());
			}
			assertNotNull(uid);
			replaceAttr.remove(AttributeBuilder.build(Uid.NAME, "SANDEEP~*~sdsdfs~New Account" ));
			uid = facade.update(ObjectClass.ACCOUNT, uid, replaceAttr,builder.build());
			assertNotNull(uid);
			LOGGER.info("User '" + uid.getUidValue()+ "' updated successfully ");
		} catch(Exception e){
			LOGGER.error("test_invalid_reqID_AC_Update_User() failed "+e.getMessage());
		} finally {
			LOGGER.info("END");
		}
	}

	@Test
	public void testDelete_User_inAC() throws Exception {
		LOGGER.info("BEGIN");
		try{
			Uid uid = null;
			Set<Attribute> replaceAttr = configUtil.toAttributeSet(1, attrToGet);
			replaceAttr.add(AttributeBuilder.buildCurrentAttributes(ObjectClass.ACCOUNT, replaceAttr));
			TestCase.assertNotNull(replaceAttr);
			for (Attribute attr : replaceAttr) {
				if (attr.getName().toString().equalsIgnoreCase(Name.NAME) || attr.getName().toString().equalsIgnoreCase(Uid.NAME))
					uid = new Uid(attr.getValue().get(0).toString());
			}
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			replaceAttr.remove(AttributeBuilder.build(Uid.NAME, "SANDEEP~*~59~New Account" ));
			builder.setOption("ReqType", "delete");
			uid = facade.update(ObjectClass.ACCOUNT, uid, replaceAttr,builder.build());
			TestCase.assertNotNull(uid);
			Assert.assertTrue(uid.getValue().contains("Delete Account"));
			LOGGER.info(">>>>>Result::{0}::{1}", "testDelete_User_inAC", "Successful");
		} catch(Exception e){
			LOGGER.info(">>>>>Result::{0}::{1}", "testDelete_User_inAC", "Failed");
		} finally{
			LOGGER.info("END");
		}
	}


	@Test
	public void test_AC_Lock_User() throws Exception {
		LOGGER.info("BEGIN");
		Uid uid = null;
		try {
			Set<Attribute> replaceAttr = configUtil.toAttributeSet(34, attrToGet);
			replaceAttr.add(AttributeBuilder.build("userLock;None", "1"));
			replaceAttr.add(AttributeBuilder.buildCurrentAttributes(ObjectClass.ACCOUNT, replaceAttr));
			assertNotNull(replaceAttr);
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			for (Attribute attr : replaceAttr) {
				if (attr.getName().toString().equalsIgnoreCase(Uid.NAME))
					uid = new Uid(attr.getValue().get(0).toString());
			}
			assertNotNull(uid);
			replaceAttr.remove(AttributeBuilder.build(Uid.NAME, "SANDEEP~*~59~New Account" ));
			uid = facade.update(ObjectClass.ACCOUNT, uid, replaceAttr,builder.build());
			assertNotNull(uid);
			Assert.assertTrue(uid.getValue().contains("Lock Account"));
			LOGGER.info("User '" + uid.getUidValue()+ "' updated successfully ");

		} catch(Exception e){
			LOGGER.error("test_AC_Lock_User() failed "+e.getMessage());
			throw e;
		} finally {
			LOGGER.info("END");
		}
	}
	@Test
	public void test_AC_UnLock_User() throws Exception {
		LOGGER.info("BEGIN");
		Uid uid = null;
		try {
			Set<Attribute> replaceAttr = configUtil.toAttributeSet(34, attrToGet);
			replaceAttr.add(AttributeBuilder.build("userLock;None", "0"));
			replaceAttr.add(AttributeBuilder.buildCurrentAttributes(ObjectClass.ACCOUNT, replaceAttr));
			assertNotNull(replaceAttr);
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			for (Attribute attr : replaceAttr) {
				if (attr.getName().toString().equalsIgnoreCase(Uid.NAME))
					uid = new Uid(attr.getValue().get(0).toString());
			}
			assertNotNull(uid);
			replaceAttr.remove(AttributeBuilder.build(Uid.NAME, "SANDEEP~*~59~New Account" ));
			uid = facade.update(ObjectClass.ACCOUNT, uid, replaceAttr,builder.build());
			assertNotNull(uid);
			Assert.assertTrue(uid.getValue().contains("unlock user"));		
		} catch(Exception e){
			LOGGER.error("test_AC_UnLock_User() failed "+e.getMessage());
		} finally {
			LOGGER.info("END");
		}
	}

	@Test
	public void test_AC_Enable_User() throws Exception {
		LOGGER.info("BEGIN");
		Uid uid = null;
		try {
			Set<Attribute> replaceAttr = configUtil.toAttributeSet(34, attrToGet);
			replaceAttr.add(AttributeBuilder.build(OperationalAttributes.ENABLE_NAME, true));
			replaceAttr.add(AttributeBuilder.buildCurrentAttributes(ObjectClass.ACCOUNT, replaceAttr));
			assertNotNull(replaceAttr);
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			for (Attribute attr : replaceAttr) {
				if (attr.getName().toString().equalsIgnoreCase(Uid.NAME))
					uid = new Uid(attr.getValue().get(0).toString());
			}
			assertNotNull(uid);
			replaceAttr.remove(AttributeBuilder.build(Uid.NAME, "SANDEEP~*~59~New Account"));
			uid = facade.update(ObjectClass.ACCOUNT, uid, replaceAttr,builder.build());
			assertNotNull(uid);
			LOGGER.info("User '" + uid.getUidValue()+ "' updated successfully ");

		} catch(Exception e){
			LOGGER.error("test_AC_Enable_User() failed "+e.getMessage());
		} finally {
			LOGGER.info("END");
		}
	}

	@Test
	public void test_AC_Disable_User() throws Exception {
		LOGGER.info("BEGIN");
		Uid uid = null;
		try {
			Set<Attribute> replaceAttr = configUtil.toAttributeSet(34, attrToGet);
			replaceAttr.add(AttributeBuilder.build(OperationalAttributes.ENABLE_NAME, false));
			replaceAttr.add(AttributeBuilder.buildCurrentAttributes(ObjectClass.ACCOUNT, replaceAttr));
			assertNotNull(replaceAttr);
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			for (Attribute attr : replaceAttr) {
				if (attr.getName().toString().equalsIgnoreCase(Uid.NAME))
					uid = new Uid(attr.getValue().get(0).toString());
			}
			assertNotNull(uid);
			replaceAttr.remove(AttributeBuilder.build(Uid.NAME, "SANDEEP~*~59~New Account" ));
			uid = facade.update(ObjectClass.ACCOUNT, uid, replaceAttr,builder.build());
			assertNotNull(uid);
			LOGGER.info("User '" + uid.getUidValue()+ "' updated successfully ");

		} catch(Exception e){
			LOGGER.error("test_AC_Disable_User() failed "+e.getMessage());
		} finally {
			LOGGER.info("END");
		}
	}

	@Test
	public void testAdd_ChildData_OneRole() throws Exception {
		LOGGER.info("BEGIN");
		try{
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			builder.setAttributesToGet(attrToGet);
			Uid uid = null;
			Set<Attribute> replaceAttr = configUtil.toAttributeSet(36, attrToGet);
			assertNotNull(replaceAttr);

			for (Attribute attr : replaceAttr) {
				if (attr.getName().toString().equalsIgnoreCase(Uid.NAME))
					uid = new Uid(attr.getValue().get(0).toString());
			}
			assertNotNull(uid);
			replaceAttr.remove(AttributeBuilder.build(Uid.NAME, "MAY22HH1~*~59~New Account"));
			replaceAttr.add(configUtil.getChildTableAttr(36,roleAttrs, SAPACUMTestUtil.ROLE));
			replaceAttr.add(AttributeBuilder.buildCurrentAttributes(ObjectClass.ACCOUNT, replaceAttr));
			LOGGER.info("Input data set: {0}", replaceAttr);
			uid = facade.addAttributeValues(ObjectClass.ACCOUNT, uid, replaceAttr, builder.build());
			assertNotNull(uid);

			ConnectorObject co= facade.getObject(ObjectClass.ACCOUNT, new Uid("MAY22HH1"), builder.build());
			List<Object> list = co.getAttributeByName("roles").getValue();
			for(Object embeddedObject :list){
				EmbeddedObject embeddedObject2  = (EmbeddedObject)embeddedObject;
				String RoleName  = embeddedObject2.getAttributeByName("AGR_NAME").getValue().toString();
				if(RoleName.contains("MW_ADMIN")){
					Assert.assertTrue(RoleName.contains("MW_ADMIN"));
					LOGGER.info("testAdd_ChildData_OneRole: Role updated successfully ");
				}
			}
		} catch(Exception e){
			LOGGER.error("testAdd_ChildData_OneRole() failed "+e.getMessage());
		} finally{
			LOGGER.info("END");
		}
	}

	@Test(expected=ConnectorException.class)
	public void testAdd_InvalidChildData_OneRole() {
		LOGGER.info("BEGIN");
		try{
			Uid uid = null;
			Set<Attribute> replaceAttr = configUtil.toAttributeSet(39, attrToGet);
			assertNotNull(replaceAttr);
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			for (Attribute attr : replaceAttr) {
				if (attr.getName().toString().equalsIgnoreCase(Uid.NAME))
					uid = new Uid(attr.getValue().get(0).toString());
			}
			assertNotNull(uid);
			replaceAttr.remove(AttributeBuilder.build(Uid.NAME, "MAY22HH1~*~59~New Account"));
			replaceAttr.add(configUtil.getChildTableAttr(39,roleAttrs, SAPACUMTestUtil.ROLE));
			replaceAttr.add(AttributeBuilder.buildCurrentAttributes(ObjectClass.ACCOUNT, replaceAttr));
			LOGGER.info("Input data set: {0}", replaceAttr);
			uid = facade.addAttributeValues(ObjectClass.ACCOUNT, uid, replaceAttr, builder.build());
			assertNotNull(uid);
			LOGGER.info("testAdd_InvalidChildData_OneRole: User '" + uid.getUidValue()	+ "' updated with a role successfully ");
		} catch(Exception e){
			Assert.assertTrue(e.getMessage().contains("SAPACUM_ERR_4"));
			LOGGER.error("testAdd_InvalidChildData_OneRole() failed "+e.getMessage());
		}finally{
			LOGGER.info("END");
		}
	}

	@Test
	public void testRemove_ChildData_OneRole() throws Exception {
		LOGGER.info("BEGIN");
		try{
			Uid uid = null;
			Set<Attribute> replaceAttr = configUtil.toAttributeSet(36, attrToGet);
			assertNotNull(replaceAttr);
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			builder.setAttributesToGet(attrToGet);
			for (Attribute attr : replaceAttr) {
				if (attr.getName().toString().equalsIgnoreCase(Uid.NAME))
					uid = new Uid(attr.getValue().get(0).toString());
			}
			assertNotNull(uid);
			replaceAttr.remove(AttributeBuilder.build(Uid.NAME, "MAY22HH1~*~59~New Account"));
			replaceAttr.add(configUtil.getChildTableAttr(36,roleAttrs, SAPACUMTestUtil.ROLE));
			replaceAttr.add(AttributeBuilder.buildCurrentAttributes(ObjectClass.ACCOUNT, replaceAttr));
			LOGGER.info("Input data set: {0}", replaceAttr);
			uid = facade.removeAttributeValues(ObjectClass.ACCOUNT, uid, replaceAttr, builder.build());
			assertNotNull(uid);

			ConnectorObject co= facade.getObject(ObjectClass.ACCOUNT, new Uid("MAY22HH1"), builder.build());
			List<Object> list = co.getAttributeByName("roles").getValue();
			for(Object embeddedObject :list){
				EmbeddedObject embeddedObject2  = (EmbeddedObject)embeddedObject;
				String RoleName  = embeddedObject2.getAttributeByName("AGR_NAME").getValue().toString();
				Assert.assertFalse(RoleName.contains("MW_ADMIN"));
				LOGGER.info("testRemove_ChildData_OneRole: Role removed successfully ");
			}
		} catch(Exception e){
			LOGGER.error("testRemove_ChildData_OneRole() failed "+e.getMessage());
			throw e;

		} finally{
			LOGGER.info("END");
		}
	}

	@Test
	public void testAdd_ChildData_OneProfile() throws Exception {
		LOGGER.info("BEGIN");
		try{
			Uid uid = null;
			Set<Attribute> replaceAttr = configUtil.toAttributeSet(36, attrToGet);
			assertNotNull(replaceAttr);
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			builder.setAttributesToGet(attrToGet);
			for (Attribute attr : replaceAttr) {
				if (attr.getName().toString().equalsIgnoreCase(Uid.NAME))
					uid = new Uid(attr.getValue().get(0).toString());
			}
			assertNotNull(uid);
			replaceAttr.remove(AttributeBuilder.build(Uid.NAME, "MAY22HH1~*~59~New Account"));
			replaceAttr.add(configUtil.getChildTableAttr(37,profileAttrs, SAPACUMTestUtil.ROLE));
			replaceAttr.add(AttributeBuilder.buildCurrentAttributes(ObjectClass.ACCOUNT, replaceAttr));
			LOGGER.info("Input data set: {0}", replaceAttr);
			uid = facade.removeAttributeValues(ObjectClass.ACCOUNT, uid, replaceAttr, builder.build());
			assertNotNull(uid);

			ConnectorObject co= facade.getObject(ObjectClass.ACCOUNT, new Uid("MAY22HH1"), builder.build());
			List<Object> list = co.getAttributeByName("profiles").getValue();
			for(Object embeddedObject :list){
				EmbeddedObject embeddedObject2  = (EmbeddedObject)embeddedObject;
				String RoleName  = embeddedObject2.getAttributeByName("PROFILE").getValue().toString();
				if(RoleName.contains("MW_ADMIN")){
					Assert.assertTrue(RoleName.contains("MW_ADMIN"));
					LOGGER.info("testAdd_ChildData_OneProfile: profile updated successfully ");
				}
			}
			LOGGER.info("testAdd_ChildData_OneProfile: User '" + uid.getUidValue()	+ "' updated with a role successfully ");
		} catch(Exception e){
			LOGGER.error("testAdd_ChildData_OneProfile() failed "+e.getMessage());
		} finally{
			LOGGER.info("END");
		}
	}

	@Test
	public void testRemove_ChildData_OneProfile() throws Exception {
		LOGGER.info("BEGIN");
		try{
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			builder.setAttributesToGet(attrToGet);

			Uid uid = null;
			Set<Attribute> replaceAttr = configUtil.toAttributeSet(36, attrToGet);
			assertNotNull(replaceAttr);

			for (Attribute attr : replaceAttr) {
				if (attr.getName().toString().equalsIgnoreCase(Uid.NAME))
					uid = new Uid(attr.getValue().get(0).toString());
			}
			assertNotNull(uid);
			replaceAttr.remove(AttributeBuilder.build(Uid.NAME, "MAY22HH1~*~59~New Account"));
			replaceAttr.add(configUtil.getChildTableAttr(37,profileAttrs, SAPACUMTestUtil.ROLE));
			replaceAttr.add(AttributeBuilder.buildCurrentAttributes(ObjectClass.ACCOUNT, replaceAttr));
			LOGGER.info("Input data set: {0}", replaceAttr);

			uid = facade.removeAttributeValues(ObjectClass.ACCOUNT, uid, replaceAttr, builder.build());
			assertNotNull(uid);	

			ConnectorObject co= facade.getObject(ObjectClass.ACCOUNT, new Uid("MAY22HH1"), builder.build());
			List<Object> list = co.getAttributeByName("profiles").getValue();
			for(Object embeddedObject :list){
				EmbeddedObject embeddedObject2  = (EmbeddedObject)embeddedObject;
				String RoleName  = embeddedObject2.getAttributeByName("PROFILE").getValue().toString();
				Assert.assertFalse(RoleName.contains("MW_ADMIN"));
				LOGGER.info("testRemove_ChildData_OneProfile: profile removed successfully ");
			}
		} catch(Exception e){
			LOGGER.error("testRemove_ChildData_OneProfile() failed "+e.getMessage());
		} finally{
			LOGGER.info("END");
		}
	}
}
