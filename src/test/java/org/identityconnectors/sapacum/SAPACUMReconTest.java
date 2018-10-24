/**
 * 
 */
package org.identityconnectors.sapacum.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.identityconnectors.common.logging.Log;
import org.identityconnectors.framework.api.ConnectorFacade;
import org.identityconnectors.framework.common.objects.Attribute;
import org.identityconnectors.framework.common.objects.AttributeBuilder;
import org.identityconnectors.framework.common.objects.ConnectorObject;
import org.identityconnectors.framework.common.objects.ObjectClass;
import org.identityconnectors.framework.common.objects.OperationOptionsBuilder;
import org.identityconnectors.framework.common.objects.SyncDelta;
import org.identityconnectors.framework.common.objects.SyncResultsHandler;
import org.identityconnectors.framework.common.objects.SyncToken;
import org.identityconnectors.framework.common.objects.Uid;
import org.identityconnectors.framework.common.objects.filter.Filter;
import org.identityconnectors.framework.common.objects.filter.FilterBuilder;
import org.identityconnectors.framework.impl.api.ConnectorMessagesImpl;
import org.identityconnectors.sap.SAPConfiguration;
import org.identityconnectors.sap.SAPConnector;
import org.identityconnectors.sapacum.SAPACUMConfiguration;
import org.identityconnectors.sapacum.SAPACUMSchema;
import org.identityconnectors.sapacum.test.util.DummyResultHandler;
import org.identityconnectors.sapacum.test.util.ICFTestHelper;
import org.identityconnectors.sapacum.test.util.SAPACUMTestUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * @author Sandeep Melgiri
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SAPACUMReconTest extends TestCase {
	
	List<String> attrToGet = new ArrayList<String>();
	private static final Log LOGGER = Log.getLog(SAPACUMReconTest.class);
	private SAPACUMTestUtil configUtil =  new SAPACUMTestUtil();
	private static ConnectorFacade facade=null;
	
	@Before
	public void setUp() throws Exception {
		SAPConfiguration config = configUtil.newacConfiguration();
		SAPACUMSchema acschema = new SAPACUMSchema(new SAPACUMConfiguration(), new SAPConnector());
		// Get all account attributes from schema
		attrToGet.addAll(acschema.getAc10attrSet());
		attrToGet.add("RequestStatus");
		attrToGet.add(Uid.NAME);
		attrToGet.add("UM IT Resource Name");
		attrToGet.add("RequestType");
		attrToGet.add("User ID");		 

		 facade =ICFTestHelper.getConnectorFacadeHelperImp();
		 
		//calling schema
		 facade.schema();
		
		config.setConnectorMessages(new ConnectorMessagesImpl());
	}
	
	@After
	public void tearDown() {
		// no-op as there are no consumed resources
	}
	
	@Test
	public void testFullRecon_User() throws Exception {
		LOGGER.info("BEGIN");
		DummyResultHandler handler = new DummyResultHandler();
		try{
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			builder.setAttributesToGet(attrToGet);

			facade.search(ObjectClass.ACCOUNT, null, handler, builder.build());
			LOGGER.info(">>>>>>>No of events handled: "+handler.getUserCount());
			assertTrue(handler.getUserCount()>0);
			LOGGER.ok("testFullRecon_User() excuted successfully");
		} catch(Exception e){
			LOGGER.error("testFullRecon_User() failed "+e.getMessage());
			throw e;
		} finally {
			handler = null;
			LOGGER.info("END");
		}
	}
	
	
	@Test
	public void testIncrementalRecon_User() throws Exception {
		LOGGER.info("BEGIN");
		DummyResultHandler handler = new DummyResultHandler();
		try{
			
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			builder.setAttributesToGet(attrToGet);
			Filter filter =FilterBuilder.greaterThan(AttributeBuilder.build("Last Updated","20150811000000"));

			facade.search(ObjectClass.ACCOUNT, filter, handler, builder.build());
			LOGGER.info(">>>>>>>No of events handled: "+handler.getUserCount());
			assertTrue(handler.getUserCount()>0);
			LOGGER.ok("testIncrementalRecon_User() excuted successfully");
		} catch(Exception e){
			LOGGER.error("testIncrementalRecon_User() failed "+e.getMessage());
			throw e;
		} finally {
			handler = null;
			LOGGER.info("END");
		}
		
	}


	@Test
	public void testIncrementalRecon_UserOrFilter() throws Exception {
		LOGGER.info("BEGIN");
		DummyResultHandler handler = new DummyResultHandler();
		try{

			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			builder.setAttributesToGet(attrToGet);
	        		Filter filter = FilterBuilder.or(
	        				FilterBuilder.equalTo(AttributeBuilder.build( "FIRSTNAME;ADDRESS;FIRSTNAME;ADDRESSX", "fname")), 
	        				FilterBuilder.equalTo(AttributeBuilder.build("LASTNAME;ADDRESS;LASTNAME;ADDRESSX", "lastname")));

			facade.search(ObjectClass.ACCOUNT, filter, handler, builder.build());
			LOGGER.info(">>>>>>>No of events handled: "+handler.getUserCount());
			assertTrue(handler.getUserCount()==1);
			LOGGER.ok("testIncrementalRecon_User() excuted successfully");
		} catch(Exception e){
			LOGGER.error("testIncrementalRecon_User() failed "+e.getMessage());
			throw e;
		} finally {
			handler = null;
			LOGGER.info("END");
		}
		
	}
	
	
	@Test
	public void testIncrementalRecon_UserANDFilter() throws Exception {
		LOGGER.info("BEGIN");
		DummyResultHandler handler = new DummyResultHandler();
		try{

			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			builder.setAttributesToGet(attrToGet);
				Filter filter = FilterBuilder.and(
	        				FilterBuilder.equalTo(AttributeBuilder.build( "FIRSTNAME;ADDRESS;FIRSTNAME;ADDRESSX", "fname")), 
	        				FilterBuilder.equalTo(AttributeBuilder.build("LASTNAME;ADDRESS;LASTNAME;ADDRESSX", "lastname")));

			facade.search(ObjectClass.ACCOUNT, filter, handler, builder.build());
			LOGGER.info(">>>>>>>No of events handled: "+handler.getUserCount());
			assertTrue(handler.getUserCount()==1);
			LOGGER.ok("testIncrementalRecon_User() excuted successfully");
		} catch(Exception e){
			LOGGER.error("testIncrementalRecon_User() failed "+e.getMessage());
			throw e;
		} finally {
			handler = null;
			LOGGER.info("END");
		}
		
	}
	
	@Test
	public void testAC_PriorityType_Recon() throws Exception {
		LOGGER.info("BEGIN");
		DummyResultHandler handler = new DummyResultHandler();
		try{
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			builder.setAttributesToGet(attrToGet);
			Filter filter = null;
			facade.search(new ObjectClass("PriorityType"), filter, handler, builder.build());
			assertTrue(handler.getUserCount()>0);			
			LOGGER.ok("testAC_PriorityType_Recon() excuted successfully");
		} catch(Exception e){
			LOGGER.error("testAC_PriorityType_Recon() failed "+e.getMessage());
			throw e;
		} finally {
			handler = null;
			LOGGER.info("END");
		}
	}
	
	@Test
	public void testAC_ReconStatus_Recon() throws Exception {
		LOGGER.info("BEGIN");
		try{
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			builder.setAttributesToGet(attrToGet);
			Uid uid = new Uid("493 & User ID=sandeep");
			builder.setOption("UM IT Resource Name", "SAP UM AC IT Resource");
			
			builder.setAttributesToGet(attrToGet);
			ConnectorObject co= facade.getObject(new ObjectClass("STATUS"), uid, builder.build());
			assertTrue(co!=null);
			LOGGER.ok("testAC_ReconStatus_Recon() excuted successfully");
		} catch(Exception e){
			LOGGER.error("testAC_ReconStatus_Recon() failed "+e.getMessage());
			throw e;
		} finally {
			LOGGER.info("END");
		}
	}
	
	
	@Test
	public void testAC_Roles_Recon() throws Exception {
		LOGGER.info("BEGIN");
		DummyResultHandler handler = new DummyResultHandler();
		try{
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			builder.setAttributesToGet(attrToGet);
			Filter filter = null;
			facade.search(new ObjectClass("ROLE"), filter, handler, builder.build());
			assertTrue(handler.getUserCount()>0);
			LOGGER.ok("testAC_ReconStatus_Recon() excuted successfully");
		} catch(Exception e){
			LOGGER.error("testAC_ReconStatus_Recon() failed "+e.getMessage());
			throw e;
		} finally {
			handler = null;
			LOGGER.info("END");
		}
	}
	
	
	@Test
	public void testAC_FunctionArea_Recon() throws Exception {
		LOGGER.info("BEGIN");
		DummyResultHandler handler = new DummyResultHandler();
		try{
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			builder.setAttributesToGet(attrToGet);
			
			Filter filter = null;
			facade.search(new ObjectClass("FunctionArea"), filter, handler, builder.build());
			assertTrue(handler.getUserCount()>0);
			LOGGER.ok("testAC_FunctionArea_Recon() excuted successfully");
		} catch(Exception e){
			LOGGER.error("testAC_FunctionArea_Recon() failed "+e.getMessage());
			throw e;
		} finally {
			handler = null;
			LOGGER.info("END");
		}
	}
	
	@Test
	public void testAC_ItemProvActionType_Recon() throws Exception {
		LOGGER.info("BEGIN");
		DummyResultHandler handler = new DummyResultHandler();
		try{
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			builder.setAttributesToGet(attrToGet);
			
			Filter filter = null;
			facade.search(new ObjectClass("ItemProvActionType"), filter, handler, builder.build());
			assertTrue(handler.getUserCount()>0);
			LOGGER.ok("testAC_ItemProvActionType_Recon() excuted successfully");
		} catch(Exception e){
			LOGGER.error("testAC_ItemProvActionType_Recon() failed "+e.getMessage());
			throw e;
		} finally {
			handler = null;
			LOGGER.info("END");
		}
	}
	
	@Test
	public void testAC_BusProc_Recon() throws Exception {
		LOGGER.info("BEGIN");
		DummyResultHandler handler = new DummyResultHandler();
		try{
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			builder.setAttributesToGet(attrToGet);
			
			Filter filter = null;
			facade.search(new ObjectClass("BusProc"), filter, handler, builder.build());
			assertTrue(handler.getUserCount()>0);
			LOGGER.ok("testAC_BusProc_Recon() excuted successfully");
		} catch(Exception e){
			LOGGER.error("testAC_BusProc_Recon() failed "+e.getMessage());
			throw e;
		} finally {
			handler = null;
			LOGGER.info("END");
		}
	}
	
	@Test
	public void testAC_ReqInitSystem_Recon() throws Exception {
		LOGGER.info("BEGIN");
		DummyResultHandler handler = new DummyResultHandler();
		try{
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			builder.setAttributesToGet(attrToGet);
			
			Filter filter = null;
			facade.search(new ObjectClass("SYSTEM"), filter, handler, builder.build());
			assertTrue(handler.getUserCount()>0);
			LOGGER.ok("testAC_ReqInitSystem_Recon() excuted successfully");
		} catch(Exception e){
			LOGGER.error("testAC_ReqInitSystem_Recon() failed "+e.getMessage());
			throw e;
		} finally {
			handler = null;
			LOGGER.info("END");
		}
	}
	
	@Test
	public void testAC_Role_Recon() throws Exception {
		LOGGER.info("BEGIN");
		DummyResultHandler handler = new DummyResultHandler();
		try{
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			builder.setAttributesToGet(attrToGet);
			
			Filter filter = null;
			facade.search(new ObjectClass("activityGroups"), filter, handler, builder.build());
			assertTrue(handler.getUserCount()>0);
			LOGGER.ok("testAC_Role_Recon() excuted successfully");
		} catch(Exception e){
			LOGGER.error("testAC_Role_Recon() failed "+e.getMessage());
			throw e;
		} finally {
			handler = null;
			LOGGER.info("END");
		}
	}
	
	@Test
	public void testAC_Profile_Recon() throws Exception {
		LOGGER.info("BEGIN");
		DummyResultHandler handler = new DummyResultHandler();
		try{
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			builder.setAttributesToGet(attrToGet);
			
			Filter filter = null;
			facade.search(new ObjectClass("profiles"), filter, handler, builder.build());
			assertTrue(handler.getUserCount()>0);
			LOGGER.ok("testAC_Profile_Recon() excuted successfully");
		} catch(Exception e){
			LOGGER.error("testAC_Profile_Recon() failed "+e.getMessage());
		} finally {
			handler = null;
			LOGGER.info("END");
		}
	}
	
	
	@Test
	public void testLatestSyncToken() {

		LOGGER.info("BEGIN");
		// run the test only if sync is supported by the tested object class
		OperationOptionsBuilder Builder = new OperationOptionsBuilder();
		try {
			// get latest sync token
			SyncToken latestToken = getLatestSyncToken();
			
			Uid uid = null;
			Set<Attribute> attrSet = configUtil.toAttributeSet(2, attrToGet);
			attrSet.add(AttributeBuilder.buildCurrentAttributes(ObjectClass.ACCOUNT, attrSet));
			TestCase.assertNotNull(attrSet);
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			uid = facade.create(ObjectClass.ACCOUNT, attrSet, builder.build());
			TestCase.assertNotNull(uid);
			Builder.setAttributesToGet(attrToGet);
			Builder.setOption("uid", Uid.NAME);

			// sync with latest sync token, should return nothing
			final LinkedList<SyncDelta> deltas = new LinkedList<SyncDelta>();
			facade.sync(ObjectClass.ACCOUNT, latestToken, new SyncResultsHandler() {
				public boolean handle(SyncDelta delta) {
					deltas.add(delta);
					return true;
				}
			}, Builder.build());
			
			final String MSG1 = "Sync with previously retrieved latest sync token should not return any deltas, but returned: %d.";
	        assertTrue(String.format(MSG1, deltas.size()), deltas.size() == 1);
		} finally {
		LOGGER.info("END");
		}
	}
	
	public SyncToken getLatestSyncToken(){
		String format = "yyyyMMddHHmmss";
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String formattedDate = formatter.format(new Date());
		SyncToken latestToken = new SyncToken(formattedDate);
		return latestToken;
	}
	
}
