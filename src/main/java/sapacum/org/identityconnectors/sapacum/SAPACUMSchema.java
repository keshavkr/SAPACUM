/**
 * 
 */
package org.identityconnectors.sapacum;

import java.io.IOException;
import java.io.InputStream;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.identityconnectors.common.IOUtil;
import org.identityconnectors.common.logging.Log;
import org.identityconnectors.framework.common.exceptions.ConnectorException;
import org.identityconnectors.framework.common.objects.AttributeInfo;
import org.identityconnectors.framework.common.objects.AttributeInfo.Flags;
import org.identityconnectors.framework.common.objects.AttributeInfoBuilder;
import org.identityconnectors.framework.common.objects.Name;
import org.identityconnectors.framework.common.objects.ObjectClass;
import org.identityconnectors.framework.common.objects.ObjectClassInfo;
import org.identityconnectors.framework.common.objects.ObjectClassInfoBuilder;
import org.identityconnectors.framework.common.objects.OperationalAttributeInfos;
import org.identityconnectors.framework.common.objects.Schema;
import org.identityconnectors.framework.common.objects.SchemaBuilder;
import org.identityconnectors.framework.spi.operations.CreateOp;
import org.identityconnectors.framework.spi.operations.SchemaOp;
import org.identityconnectors.framework.spi.operations.SearchOp;
import org.identityconnectors.framework.spi.operations.SyncOp;
import org.identityconnectors.framework.spi.operations.TestOp;
import org.identityconnectors.framework.spi.operations.UpdateAttributeValuesOp;
import org.identityconnectors.sap.SAPConnector;


/**
 * @author ranjith.kumar
 *
 */
public final class SAPACUMSchema implements SAPACUMConstants{

	private static final Log LOG = Log.getLog(SAPACUMSchema.class);
	private Schema schema;
	private SAPConnector sapumConnector;
	private SAPACUMConfiguration sapacConfiguration;
	//private Map<String, AttributeInfo> accountAttributeMap;
	private Set<String> ac10attrSet = new HashSet<String>();
	private Set<String> ac53attrSet = new HashSet<String>();
	private boolean isUMSchemaRequired;
	private boolean isGRC53 = false;
	private String fileName = "SapacToSapumFieldMappings.properties";
	//private Map<String, AttributeInfo> umAccountAttrMap;
	
	private String ac10Attributes[] = {ATTR_HDR_REQTR_ID,ATTR_HDR_REQTR_EMAIL,ATTR_HDR_PRIORITY,ATTR_HDR_SYSTEM,ATTR_HDR_REQ_DUEDATE,ATTR_HDR_REQ_REASON,
		ATTR_HDR_FUNC_AREA,ATTR_HDR_BPROCESS,ATTR_UI_USER_ID,ATTR_UI_TITLE,ATTR_UI_FNAME,ATTR_UI_LNAME,ATTR_UI_ACCNO,ATTR_AC_REQ_STATUS,ATTR_REQ_TYPE,
		ATTR_UI_USER_GROUP,ATTR_UI_VALID_FROM,ATTR_UI_VALID_TO,ATTR_UI_COMM_METHOD,ATTR_UI_FAX,ATTR_UI_EMAIL,ATTR_UI_TELEPHONE,
		ATTR_UI_COST_CENTER,ATTR_UI_START_MENU,ATTR_UI_LONGON_LANGUAGE,ATTR_UI_DECIMAL_NOTATION,ATTR_UI_DAYE_FORMAT,ATTR_UI_IS_LOCKED,
		ATTR_UI_ALIAS,ATTR_UI_USER_TYPE,ATTR_UI_AC_MANAGER,ATTR_UI_AC_MGR_EMAIL,ATTR_UI_AC_MGR_FNAME,ATTR_UI_AC_MGR_LNAME,ATTR_USER_GROUP
		/*ATTR_UI_DEPARTMENT,ATTR_UI_FORM_OF_ADDRESS,ATTR_UI_MOBILE,ATTR_UI_IS_LOCKED,ATTR_UI_POSITION,REQUEST_ID_10,
		REQUEST_TYPE_10,REQ_INIT_SYSTEM_10,ATTR_ROLE_OR_GROUP_NAME*/};
	
	private String ac53Attributes[] = {ATTR_HDR_REQTR_ID,ATTR_HDR_REQTR_EMAIL,ATTR_HDR_PRIORITY,ATTR_HDR_SYSTEM,ATTR_HDR_REQ_DUEDATE,ATTR_HDR_REQ_REASON,
		ATTR_HDR_FUNC_AREA,ATTR_HDR_BPROCESS,ATTR_UI_USER_ID,ATTR_UI_TITLE,ATTR_UI_FNAME,ATTR_UI_LNAME,ATTR_UI_ACCNO,
		ATTR_UI_USER_GROUP,ATTR_UI_VALID_FROM,ATTR_UI_VALID_TO,ATTR_UI_COMM_METHOD,ATTR_UI_FAX,ATTR_UI_EMAIL,ATTR_UI_TELEPHONE,
		ATTR_UI_COST_CENTER};
		
	public SAPACUMSchema(){

	}
	
	public SAPACUMSchema(SAPACUMConfiguration sapacConfiguration, SAPConnector sapumConnector){
		this.sapacConfiguration=sapacConfiguration;
		this.sapumConnector=sapumConnector;
		this.isUMSchemaRequired = true;
	}
	
	/*public Map<String, AttributeInfo> getAccountAttributeMap() {		
		initSchema();
		return accountAttributeMap;
	}*/
	
	public Schema getSchema() {
		initSchema();
		return schema;
	}
	public Schema getOnlyAcSchema(){
		isUMSchemaRequired=false;
		initSchema();
		isUMSchemaRequired=true;
		return schema;
	}

	private void initSchema() {
		final SchemaBuilder schemaBuilder = new SchemaBuilder(SAPACUMConnector.class);		
		Set<AttributeInfo> accountAttrs = new HashSet<AttributeInfo>();		
		Set<AttributeInfo> roleAttrs = new HashSet<AttributeInfo>();
		Set<AttributeInfo> profileAttrs = new HashSet<AttributeInfo>();
		Set<AttributeInfo> parameterAttrs = new HashSet<AttributeInfo>();
		isGRC53 = sapacConfiguration.getIsGRC53();

		if(isGRC53){
			//ac 53 schema attributes	
			for(String attribute :ac53Attributes){
				if(ATTR_USER_GROUP.equalsIgnoreCase(attribute)){					
					accountAttrs.add(AttributeInfoBuilder.build(ATTR_USER_GROUP,String.class, EnumSet.of(Flags.MULTIVALUED)));
				}else {
					//TODO - Need to set flags for 53 attrs
					accountAttrs.add(AttributeInfoBuilder.build(attribute, String.class));
				}
				ac53attrSet.add(attribute);
			}
			//roles AC 5.3
			roleAttrs.add(AttributeInfoBuilder.build(ATTR_ROLE_NAME53, String.class, EnumSet.of(Flags.REQUIRED)));
			roleAttrs.add(AttributeInfoBuilder.build(ATTR_ROLE_SYS_NAME53, String.class));
			roleAttrs.add(AttributeInfoBuilder.build(ATTR_ROLE_STARTDATE53, String.class));
			roleAttrs.add(AttributeInfoBuilder.build(ATTR_ROLE_ENDDATE53, String.class));
			//profiles AC 5.3	        
			profileAttrs.add(AttributeInfoBuilder.build(ATTR_PROFILE_NAME, String.class, EnumSet.of(Flags.REQUIRED)));
			profileAttrs.add(AttributeInfoBuilder.build(ATTR_PROFILE_SYS_NAME, String.class)); 
		}else{  
			for(String attribute :ac10Attributes){
				if(ATTR_USER_GROUP.equalsIgnoreCase(attribute)){
					accountAttrs.add(AttributeInfoBuilder.build(attribute,String.class, EnumSet.of(Flags.MULTIVALUED)));
				} else if (getNotReturnedByDefaultSet().contains(attribute)){
					accountAttrs.add(AttributeInfoBuilder.build(attribute,String.class, EnumSet.of(Flags.NOT_RETURNED_BY_DEFAULT, Flags.NOT_UPDATEABLE, Flags.NOT_READABLE)));
				} else if (ATTR_AC_REQ_STATUS.equalsIgnoreCase(attribute)
						|| ATTR_HDR_REQTR_ID.equalsIgnoreCase(attribute)
						|| ATTR_REQ_TYPE.equalsIgnoreCase(attribute)){
					accountAttrs.add(AttributeInfoBuilder.build(attribute,String.class, EnumSet.of(Flags.NOT_UPDATEABLE,Flags.NOT_CREATABLE)));
				}
				else {
					accountAttrs.add(AttributeInfoBuilder.build(attribute, String.class));
				}				
				ac10attrSet.add(attribute);
			} 
			//current attributes
			accountAttrs.add(AttributeInfoBuilder.buildCurrentAttributes(ObjectClass.ACCOUNT_NAME));
			//roles AC10
			roleAttrs.add(AttributeInfoBuilder.build(ATTR_ROLE_NAME, String.class, EnumSet.of(Flags.REQUIRED)));
			roleAttrs.add(AttributeInfoBuilder.build(ATTR_ROLE_SYS_NAME, String.class));
			roleAttrs.add(AttributeInfoBuilder.build(ATTR_ROLE_STARTDATE, String.class));
			roleAttrs.add(AttributeInfoBuilder.build(ATTR_ROLE_ENDDATE, String.class));
			//profiles AC 10	        
			profileAttrs.add(AttributeInfoBuilder.build(ATTR_PROFILE_NAME, String.class, EnumSet.of(Flags.REQUIRED)));
			profileAttrs.add(AttributeInfoBuilder.build(ATTR_PROFILE_SYS_NAME, String.class));        	        
			//parameter AC 10	        
			parameterAttrs.add(AttributeInfoBuilder.build(ATTR_PARA_NAME, String.class, EnumSet.of(Flags.REQUIRED)));
			parameterAttrs.add(AttributeInfoBuilder.build(ATTR_PARA_VALUE, String.class));
			}

		ObjectClassInfoBuilder ociAccountBuilder = new ObjectClassInfoBuilder();       	
		ObjectClassInfoBuilder ociRoleBuilder = new ObjectClassInfoBuilder();
		ObjectClassInfoBuilder ociProfileBuilder = new ObjectClassInfoBuilder();
		ObjectClassInfoBuilder ociParameterBuilder = new ObjectClassInfoBuilder();

		//Add UM schema attributes only if required
		if(isUMSchemaRequired){
			Schema schema = sapumConnector.schema();
			Set<ObjectClassInfo> set = schema.getObjectClassInfo();
			for(ObjectClassInfo objectClassInfo : set){
				if(objectClassInfo.getType().equalsIgnoreCase("__ACCOUNT__")){
					Set<AttributeInfo> attrInfoSet = objectClassInfo.getAttributeInfo();
					Set<String> ac2umeMappedSet = getUmMappedFields();
					for(AttributeInfo attrInfo : attrInfoSet){							
						//EnumSet<Flags> flagSet = (EnumSet<Flags>) attributeInfo.getFlags();
						if(!attrInfo.getType().getName().equals("org.identityconnectors.framework.common.objects.EmbeddedObject")){
							Set<AttributeInfo.Flags> flagSet =  new HashSet<AttributeInfo.Flags>();
							for(AttributeInfo.Flags aFlags : attrInfo.getFlags()){
								flagSet.add(aFlags);
							}
							flagSet.add(Flags.NOT_CREATABLE);	
							if(ac2umeMappedSet.contains(attrInfo.getName())){
								flagSet.add(Flags.NOT_UPDATEABLE);
								accountAttrs.add(AttributeInfoBuilder.build(attrInfo.getName(), attrInfo.getType(), flagSet));
							}else{
								accountAttrs.add(AttributeInfoBuilder.build(attrInfo.getName(), attrInfo.getType(), flagSet));
							}
						}else {
							accountAttrs.add(attrInfo);
						}									
					}												
				}else if(objectClassInfo.getType().equalsIgnoreCase("ACTIVITYGROUPS")){					
					ociRoleBuilder.addAllAttributeInfo(objectClassInfo.getAttributeInfo());					
				}else if(objectClassInfo.getType().equalsIgnoreCase("PROFILES")){					
					ociProfileBuilder.addAllAttributeInfo(objectClassInfo.getAttributeInfo());					
				}else if(objectClassInfo.getType().equalsIgnoreCase("parameter")){					
					ociParameterBuilder.addAllAttributeInfo(objectClassInfo.getAttributeInfo());					
				}
			}
		}else{
			//OPERATIONAL ATTRIBUTES
			accountAttrs.add(AttributeInfoBuilder.build(Name.NAME, String.class)); 			
			accountAttrs.add(OperationalAttributeInfos.ENABLE);	        	        
			accountAttrs.add(OperationalAttributeInfos.LOCK_OUT); 	
		}

		//Role Object builder
		ociRoleBuilder.addAllAttributeInfo(roleAttrs);
		ociRoleBuilder.setType("ACTIVITYGROUPS");	
		ociRoleBuilder.setEmbedded(true);
		ObjectClassInfo roleInfo = ociRoleBuilder.build();
		schemaBuilder.defineObjectClass(roleInfo);

		//Profile Object and its Info Builder	
		ociProfileBuilder.addAllAttributeInfo(profileAttrs);
		ociProfileBuilder.setType("PROFILES");	
		ociProfileBuilder.setEmbedded(true);
		ObjectClassInfo profileInfo = ociProfileBuilder.build();
		schemaBuilder.defineObjectClass(profileInfo);

		//Parameter Object and its Info Builder		
		ociParameterBuilder.addAllAttributeInfo(parameterAttrs);
		ociParameterBuilder.setType("PARAMETER");	
		ociParameterBuilder.setEmbedded(true);
		ObjectClassInfo parameterInfo = ociParameterBuilder.build();
		schemaBuilder.defineObjectClass(parameterInfo);

		//Account Object
		//accountAttributeMap = AttributeInfoUtil.toMap(accountAttrs);
		ociAccountBuilder.addAllAttributeInfo(accountAttrs);
		ociAccountBuilder.setType(ObjectClass.ACCOUNT_NAME);
		ObjectClassInfo accountInfo = ociAccountBuilder.build();
		schemaBuilder.defineObjectClass(accountInfo);				

		//build schema
		schemaBuilder.clearSupportedObjectClassesByOperation();
		schemaBuilder.addSupportedObjectClass(CreateOp.class, accountInfo);
		schemaBuilder.addSupportedObjectClass(SchemaOp.class, accountInfo);
		schemaBuilder.addSupportedObjectClass(TestOp.class, accountInfo);
		schemaBuilder.addSupportedObjectClass(UpdateAttributeValuesOp.class,accountInfo);
		schemaBuilder.addSupportedObjectClass(SearchOp.class, accountInfo);
		schemaBuilder.addSupportedObjectClass(SyncOp.class, accountInfo);	
		schemaBuilder.addSupportedObjectClass(TestOp.class, roleInfo);
		schemaBuilder.addSupportedObjectClass(TestOp.class, profileInfo);
		schemaBuilder.addSupportedObjectClass(TestOp.class, parameterInfo);
		schema = schemaBuilder.build();
	}
	
	
	private Set<String> getNotReturnedByDefaultSet(){
		HashSet<String> acNotReturnedSet = new HashSet<String>();
		if(isGRC53){
			//TODO - Add attributes for AC 53
		}else{
		    acNotReturnedSet.add(ATTR_HDR_BPROCESS);
			acNotReturnedSet.add(ATTR_UI_ACCNO);
			acNotReturnedSet.add(ATTR_HDR_FUNC_AREA);
			acNotReturnedSet.add(ATTR_UI_AC_MANAGER);
			acNotReturnedSet.add(ATTR_UI_AC_MGR_EMAIL);
			acNotReturnedSet.add(ATTR_UI_AC_MGR_FNAME);
			acNotReturnedSet.add(ATTR_UI_AC_MGR_FNAME);
			acNotReturnedSet.add(ATTR_UI_AC_MGR_LNAME);
			acNotReturnedSet.add(ATTR_HDR_PRIORITY);
			acNotReturnedSet.add(ATTR_HDR_REQ_DUEDATE);
			acNotReturnedSet.add(ATTR_HDR_REQTR_EMAIL);
			acNotReturnedSet.add(ATTR_HDR_REQ_REASON);
			acNotReturnedSet.add(ATTR_HDR_SYSTEM);
			//TODO - Remove all invalid entries from this set
		}
		return acNotReturnedSet;
	}
	

	public Set<String> getAc10attrSet() {
		if(ac10attrSet.size()<1)
			initSchema();
		return ac10attrSet;
	}

	
	public Set<String> getAc53attrSet() {
		if(ac53attrSet.size()<1)
			initSchema();
		return ac53attrSet;
	}	
	
	
	public Properties getUmACMapProperties(){
		if(isGRC53){
			//TODO - added temporarily
			fileName = "Sapac53ToSapum.properties";
		}
		InputStream inputStream = IOUtil.getResourceAsStream(SAPACUMConnector.class, fileName);
		Properties properties = new Properties();		
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			throw new ConnectorException("Could not load "+fileName+" file ", e);
		}				
		return properties;
	}
	
	
	private Set<String> getUmMappedFields(){
		Properties properties = getUmACMapProperties();
		Set<String> umMappedFields = new HashSet<String>();
		Set<Object> keySet = properties.keySet();
		for (Object key : keySet) {
			umMappedFields.add(key.toString());
		}		
		return umMappedFields;
	}
	
}

