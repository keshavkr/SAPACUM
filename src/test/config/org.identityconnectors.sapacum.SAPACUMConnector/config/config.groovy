import org.identityconnectors.common.security.GuardedString
import org.identityconnectors.contract.exceptions.ObjectNotFoundException
import org.identityconnectors.contract.data.groovy.Lazy
import org.identityconnectors.framework.common.objects.EmbeddedObject
import org.identityconnectors.framework.common.objects.EmbeddedObjectBuilder
import org.identityconnectors.framework.common.objects.ObjectClass

import org.identityconnectors.framework.common.objects.EmbeddedObjectBuilder
import org.identityconnectors.framework.common.objects.ObjectClass



EmbeddedObject getEmbeddedObject(String title, String email, String fname, String lname, String Userid,
String telnumber, String Email, String Priority, String ReqInitSystem, String RequestReason,String Bproc) {

         EmbeddedObjectBuilder ObjBuilder = new EmbeddedObjectBuilder();
         ObjBuilder.setObjectClass(new ObjectClass("__CURRENT_ATTRIBUTES__"));
         ObjBuilder.addAttribute("title;UserInfo" , title);
		 ObjBuilder.addAttribute("email;UserInfo", email);
		 ObjBuilder.addAttribute("fname;UserInfo", fname);
	  	 ObjBuilder.addAttribute("lname;UserInfo", lname);
	 	 ObjBuilder.addAttribute("Userid;UserInfo", Userid);
		 ObjBuilder.addAttribute("telnumber;UserInfo", telnumber);
		 ObjBuilder.addAttribute("Email;Header", Email);
		 ObjBuilder.addAttribute("Priority;Header", Priority);
		 ObjBuilder.addAttribute("ReqInitSystem;Header", ReqInitSystem);
		 ObjBuilder.addAttribute("RequestReason;Header", RequestReason);
		 ObjBuilder.addAttribute("Bproc;Header", Bproc);
         return ObjBuilder.build();
  }
  
  		EmbeddedObject getEmbeddedRoleObject(String roleName, String systemName, String validFrom, String validTo) {
         EmbeddedObjectBuilder ObjBuilder = new EmbeddedObjectBuilder();
         ObjBuilder.setObjectClass(new ObjectClass("ACTIVITYGROUPS"));
         ObjBuilder.addAttribute("itemName;ReqLineItem", roleName);
         ObjBuilder.addAttribute("connector;ReqLineItem", systemName);
         ObjBuilder.addAttribute("validFrom;ReqLineItem", validFrom);
         ObjBuilder.addAttribute("Validto;ReqLineItem", validTo);
         return ObjBuilder.build();
}


connector.client="100"
connector.host="172.20.55.211"
//connector.host="10.20.30.40"
connector.destination="dest366"
connector.dummyPassword="Password12"
//connector.language="EN"
connector.masterSystem="ST1CLNT100"
connector.user="sapuser"
connector.password="Mphasis123"
connector.grcPassword="Mphasis12"
connector.systemNumber="00"
connector.configureConnectionTuning=false
connector.connectionMaxGetTime=0
connector.connectionPoolActiveLimit=0
connector.connectionPoolCapacity=0
connector.connectionPoolExpirationPeriod=0
connector.connectionPoolExpirationTime=0
connector.jcoGroup=""
connector.jcoSAPRouter=""
connector.jcoTrace=0
connector.jcoTraceDir=""
//connector.UseLoadBalance=false
connector.loadBalance=false
connector.maxBAPIRetries=5
connector.msHost=""
connector.msServ=""
connector.r3Name=""
connector.retryWaitTime=500
connector.sncLib=""
connector.sncName=""
connector.sncPartnerName=""
connector.sncProtectionLevel=""
connector.sncX509Cert=""
connector.useSNC=false
connector.batchSize="0"
connector.roles="ACTIVITYGROUPS~SUBSYSTEM;AGR_NAME;TO_DAT;FROM_DAT"
connector.groups="GROUPS~USERGROUP"
connector.language="EN"


//No setter method for this parameter
//connector.'SOD Configuration lookup'="Lookup.SAPABAP.AC10.Configuration"
//connector.'User Configuration Lookup'="Lookup.SAPABAP.UM.Configuration"

connector.compositeRoles="no"
connector.enableCUA="no"
connector.overwriteLink="no"
connector.passwordPropagateToChildSystem="no"
connector.validatePERNR="no"
connector.aliasUser="none"
connector.codePage="none"
connector.gatewayHost="none"
connector.gatewayService="none"
connector.getSSO2="none"
connector.lCheck="none"
connector.mySAPSSO2="none"
connector.repositoryDestination="none"
connector.repositoryPassword="none"
connector.repositorySNCMode="none"
connector.repositoryUser="none"
connector.tpHost="none"
connector.tpName="none"
connector.type="none"
connector.parameters="PARAMETER1~PARID;PARVA"
connector.profiles="PROFILES~SUBSYSTEM;PROFILE"
connector.sapSystemTimeZone="PST"
connector.reconcilefuturedatedroles="yes"
connector.reconcilepastdatedroles="yes"
connector.singleRoles="yes"
connector.cuaChildPasswordChangeFuncModule="ZXLCBAPI_ZXLCUSR_PASSWORDCHNGE"
connector.cuaChildInitialPasswordChangeFuncModule="ZXLCBAPI_ZXLCUSR_PW_CHANGE"
connector.disableLockStatus="64"
connector.changePasswordAtNextLogon="no"
//connector.cuachildpasswordcheckfuncmodule=
//connector.cuachildpasswordcheckdelay="
connector.isGRC53=false
connector.grcLanguage="EN"


connector.grcServer="172.20.55.147"
connector.grcUsername="basis"
connector.grcPort="8000"


connector.auditTrailWSDLPath="no"
connector.auditTrailWSDLPath="no"
connector.requestStatusWSDLPath="no"
connector.submitRequestWSDLPath="no"
connector.selectApplicationWSDLPath="no"
connector.searchRolesWSDLPath="no"
connector.server="172.20.55.147"
connector.username="basis"
connector.port="8000"
connector.roleLookupAccessURL="http://wksban04orstd.corp.mphasis.com:8000/sap/bc/srt/scs/sap/grac_search_roles_ws?sap-client=100"
connector.appLookupAccessURL="http://wksban04orstd.corp.mphasis.com:8000/sap/bc/srt/scs/sap/grac_select_appl_ws?sap-client=100"
connector.userAccessAccessURL ="http://wksban04orstd.corp.mphasis.com:8000/sap/bc/srt/scs/sap/grac_user_acces_ws?sap-client=100"
connector.requestStatusAccessURL="http://wksban04orstd.corp.mphasis.com:8000/sap/bc/srt/scs/sap/grac_request_status_ws?sap-client=100"
connector.auditLogsAccessURL="http://wksban04orstd.corp.mphasis.com:8000/sap/bc/srt/scs/sap/grac_audit_logs_ws?sap-client=100"
connector.entitlementRiskAnalysisAccessURL="http://wksban04orstd.corp.mphasis.com:8000/sap/bc/srt/scs/sap/grac_risk_analysis_wout_no_ws?sap-client=100"
connector.otherLookupAccessURL="http://wksban04orstd.corp.mphasis.com:8000/sap/bc/srt/scs/sap/grac_lookup_ws?sap-client=100"

connector.modifyUserReqType="002~Change Account~002"

connector.requestStatusValue="OK"
connector.ignoreOpenStatus="Yes"
connector.requestStatusWS="oracle.iam.ws.sap.ac10.RequestStatus"
//connector.riskLevel="High"
connector.unlockUserReqType="005~unlock user~005"
connector.createUserReqType="001~New Account~001~006"
connector.entitlementRiskAnalysisWS="oracle.iam.grc.sod.scomp.impl.grcsap.util.webservice.sap.ac10.RiskAnalysisWithoutNo"
connector.lockUserReqType="004~Lock Account~004"
connector.removeRoleReqType="002~Change Account~002~009"
connector.provItemActionAttrName="provItemAction;ReqLineItem"

connector.deleteUserReqType="003~Delete Account~003"
connector.assignRoleReqType="002~Change Account~002~006"
connector.auditLogsWS="oracle.iam.ws.sap.ac10.AuditLogs"
connector.provActionAttrName="provAction;ReqLineItem"

connector.logAuditTrial="Yes"





connector.requestTypeAttrName="Reqtype;Header"
connector.roleLookupWS="oracle.iam.ws.sap.ac10.SearchRoles"
//connector.Role form names="UD_SPUMRC_P;UD_SAPRL"
//connector.Profile attribute name=	"USERPROFILE"

//connector.RoleAttributeLabel=	"Role Name"
connector.appLookupWS="oracle.iam.ws.sap.ac10.SelectApplication"
connector.otherLookupWS="oracle.iam.ws.sap.ac10.SearchLookup"
connector.wsdlFilePath=	"C:\\Users\\sandeep.melgiri\\Documents\\wsdl"
connector.userAccessWS="oracle.iam.ws.sap.ac10.UserAccess"


//----------------------------------------------------
//Input test data - case 1
//----------------------------------------------------
account1.__NAME__="JU3mk1"
account1.'fname;UserInfo'="sandeep"
account1.'lname;UserInfo'="mk"
account1.'Userid;UserInfo'="SANDEEP"
account1.'email;UserInfo'="kadiyala@email.com"
account1.'RequestReason;Header'="kadiyala"
account1.'Bproc;Header'="basis"
account1.'Email;Header'="kadiyala@email.com"
account1.'ReqInitSystem;Header'="ST1CLNT100"
account1.'Priority;Header'="006"
account1.'__UID__'="SANDEEP~*~59~New Account"

//----------------------------------------------------
//Input test data - case 2
//----------------------------------------------------
account2.__NAME__="JU3mk1"
account2.'fname;UserInfo'="sandeep"
account2.'lname;UserInfo'="mk"
account2.'Userid;UserInfo'="SANDEEP"
account2.'email;UserInfo'="kadiyala@email.com"
account2.'RequestReason;Header'="kadiyala"
account2.'Bproc;Header'="basis"
account2.'Email;Header'="kadiyala@email.com"
account2.'ReqInitSystem;Header'="ST1CLNT100"
account2.'Priority;Header'="006"

//----------------------------------------------------
//Input test data - case 34
//----------------------------------------------------
account34.__UID__="SANDEEP~*~59~New Account"
account34.__NAME__="SANDEEP"

account34.'fname;UserInfo'="sandeep"
account34.'lname;UserInfo'="mk"
account34.'Userid;UserInfo'="SANDEEP"
account34.'email;UserInfo'="kadiyala@email.com"
account34.'RequestReason;Header'="kadiyala"
account34.'Bproc;Header'="basis"
account34.'Email;Header'="kadiyala@email.com"
account34.'ReqInitSystem;Header'="ST1CLNT100"
account34.'Priority;Header'="006"

//----------------------------------------------------
//Input test data - case 35
//----------------------------------------------------
account35.__UID__="SANDEEP~666"
account35.__NAME__="SANDEEP~666"


//----------------------------------------------------
//Input test data - case 36
//----------------------------------------------------
account36.'fname;UserInfo'="sandeep"
account36.'lname;UserInfo'="mk"
account36.'Userid;UserInfo'="SANDEEP"
account36.'email;UserInfo'="kadiyala@email.com"
account36.'RequestReason;Header'="kadiyala"
account36.'Bproc;Header'="basis"
account36.'Email;Header'="kadiyala@email.com"
account36.'ReqInitSystem;Header'="ST1CLNT100"
account36.'Priority;Header'="006"
account36.__UID__="MAY22HH1~*~59~New Account"

account36{
	role1{
		ValidTo="0"
		itemName="MW_ADMIN"
		connector="ST1CLNT100"
		validFrom="0"
		
	}
}

//----------------------------------------------------
//Input test data - case 37
//----------------------------------------------------
account37{
	role1{
		itemName="MW_ADMIN"
		connector="ST1CLNT100"		
	}
}


//----------------------------------------------------
//Input test data - case 38
//----------------------------------------------------
account38.__UID__="SANDEEP~*~sdsdfs~New Account"
account38.__NAME__="SANDEEP"

account38.'fname;UserInfo'="sandeep"
account38.'lname;UserInfo'="mk"
account38.'Userid;UserInfo'="SANDEEP"
account38.'email;UserInfo'="kadiyala@email.com"
account38.'RequestReason;Header'="kadiyala"
account38.'Bproc;Header'="basis"
account38.'Email;Header'="kadiyala@email.com"
account38.'ReqInitSystem;Header'="ST1CLNT100"
account38.'Priority;Header'="006"


//----------------------------------------------------
//Input test data - case 39
//----------------------------------------------------
account39.'fname;UserInfo'="sandeep"
account39.'lname;UserInfo'="mk"
account39.'Userid;UserInfo'="SANDEEP"
account39.'email;UserInfo'="kadiyala@email.com"
account39.'RequestReason;Header'="kadiyala"
account39.'Bproc;Header'="basis"
account39.'Email;Header'="kadiyala@email.com"
account39.'ReqInitSystem;Header'="ST1CLNT100"
account39.'Priority;Header'="006"
account39.__UID__="MAY22HH1~*~59~New Account"


account39{
	role1{
		ValidTo="0"
		itemName="fsdff"
		connector="sdsdff"
		validFrom="0"
		
	}
}
 
 
 
// Connector WRONG configuration for TestApiOpTests
testsuite.Test.invalidConfig = [
  [ password: "NonExistingPassword_foo_bar_boo" ]
]





testsuite.Search.disable.caseinsensitive = true

testsuite.Multi.skip.lockout=true

testsuite {
    bundleJar = System.getProperty("bundleJar")
    bundleName = System.getProperty("bundleName")
    bundleVersion=System.getProperty("bundleVersion")
    connectorName="org.identityconnectors.sapumac.SAPUMACConnector"

    Schema {
        oclasses = ['__ACCOUNT__','PROFILES','PARAMETER' ,'ACTIVITYGROUPS']
        attributes {
            __ACCOUNT__.oclasses = [
                           '__NAME__','__PASSWORD__',  '__CURRENT_PASSWORD__', '__LOCK_OUT__', '__ENABLE__','__PASSWORD_EXPIRED__', 'PERNR',
				//'User Lock;NONE;NONE;NONE',
				'ACCNT;LOGONDATA;ACCNT;LOGONDATAX','CLASS;LOGONDATA;CLASS;LOGONDATAX','GLTGV;LOGONDATA;GLTGV;LOGONDATAX', 'GLTGB;LOGONDATA;GLTGB;LOGONDATAX', 
				'TZONE;LOGONDATA;TZONE;LOGONDATAX', 'USTYP;LOGONDATA;USTYP;LOGONDATAX',
				 'LTIME;LOGONDATA;LTIME;LOGONDATAX' ,
 
				'KOSTL;DEFAULTS;KOSTL;DEFAULTSX',  'DATFM;DEFAULTS;DATFM;DEFAULTSX','DCPFM;DEFAULTS;DCPFM;DEFAULTSX',   'LANGU;DEFAULTS;LANGU;DEFAULTSX',  'START_MENU;DEFAULTS;START_MENU;DEFAULTSX', 
 
				'FIRSTNAME;ADDRESS;FIRSTNAME;ADDRESSX', 'LASTNAME;ADDRESS;LASTNAME;ADDRESSX',  'E_MAIL;ADDRESS;E_MAIL;ADDRESSX', 'TITLE_P;ADDRESS;TITLE_P;ADDRESSX', 
				'LANGU_P;ADDRESS;LANGU_P;ADDRESSX', 'FUNCTION;ADDRESS;FUNCTION;ADDRESSX', 'DEPARTMENT;ADDRESS;DEPARTMENT;ADDRESSX', 'COMM_TYPE;ADDRESS;COMM_TYPE;ADDRESSX', 
				'FAX_NUMBER;ADDRESS;FAX_NUMBER;ADDRESSX', 'FAX_EXTENS;ADDRESS;FAX_EXTENS;ADDRESSX','TEL1_EXT;ADDRESS;TEL1_EXT;ADDRESSX', 'TEL1_NUMBR;ADDRESS;TEL1_NUMBR;ADDRESSX',   
				'ROOM_NO_P;ADDRESS;ROOM_NO_P;ADDRESSX', 'BUILDING_P;ADDRESS;BUILDING_P;ADDRESSX', 'FLOOR_P;ADDRESS;FLOOR_P;ADDRESSX',

				'USERALIAS;ALIAS;BAPIALIAS;ALIASX',  'COMPANY;COMPANY;COMPANY;COMPANYX', 'LIC_TYPE;UCLASS;UCLASS;UCLASSX', 'SUBSYSTEM;SYSTEMS',
				'USERGROUP;GROUPS;USERGROUP;GROUPS', 'Userid;UserInfo','title;UserInfo','fname;UserInfo','lname;UserInfo','accno;UserInfo','userGroup;UserInfo','validFrom;UserInfo','validTo;UserInfo','commMethod;UserInfo','fax;UserInfo','email;UserInfo','telnumber;UserInfo','costcenter;UserInfo','startMenu;UserInfo','logonLang;UserInfo','decNotation;UserInfo','dateFormat;UserInfo','alias;UserInfo','userType;UserInfo','manager;UserInfo','managerEmail;UserInfo','managerFirstname;UserInfo','managerLastname;UserInfo','ReqType','RequestStatus','RequestorId;Header','Email;Header','Priority;Header','ReqInitSystem;Header','ReqDueDate;Header','RequestReason;Header','Funcarea;Header','Bproc;Header','userGroup;UserGroup','__CURRENT_ATTRIBUTES__','userLock;None'
				] // __ACCOUNT__.oclasses

	PROFILES.oclasses=['SUBSYSTEM','PROFILE','__NAME__','BAPIAKTPS','BAPIPTEXT','BAPITYPE']
	PARAMETER.oclasses=['PARTXT','__NAME__','PARID','PARVA' ]
	ACTIVITYGROUPS.oclasses=['AGR_NAME','FROM_DAT','TO_DAT','__NAME__' ,'ORG_FLAG','AGR_TEXT','SUBSYSTEM']
	//roles.oclasses=["itemName;ReqLineItem","connector;ReqLineItem","validFrom;ReqLineItem","Validto;ReqLineItem"]
        } // attributes
		
	

        attrTemplate = [
            type: String.class,
            readable: true,
            createable: true,
            updateable: true,
            required: false,
            multiValue: false,
            returnedByDefault: true
        ]// attrTemplate

		multiValueAttrTemplate = [
                 type: EmbeddedObject.class,
                 readable: true,
                 createable: true,
                 updateable: true,
                 required: false,
                 multiValue: false,
                 returnedByDefault: true
         ] //multiAttrTemplate
		 
		 
		        attrTemplatenoC = [
            type: String.class,
            readable: true,
            createable: false,
            updateable: false,
            required: false,
            multiValue: false,
            returnedByDefault: true
        ]
        attrTemplateLong = [
            type: long.class,
            readable: true,
            createable: true,
            updateable: true,
            required: false,
            multiValue: false,
            returnedByDefault: true
        ]// attrTemplateLong

 attreqTemplateName = [
            type: String.class,
            readable: true,
            createable: true,
            updateable: true,
            required: true,
            multiValue: false,
            returnedByDefault: true
        ]

 attrTemplateMvEmbd = [
            type: EmbeddedObject.class,
            readable: true,
            createable: true,
            updateable: true,
            required: false,
            multiValue: true,	    
            returnedByDefault: true
        ]

attrTemplateMv = [
            type: String.class,
            readable: true,
            createable: false,
            updateable: false,
            required: false,
            multiValue: false,	    
            returnedByDefault: true
        ]
		
		attrTemplateMvAc = [
            type: String.class,
            readable: true,
            createable: true,
            updateable: true,
            required: false,
            multiValue: true,	    
            returnedByDefault: true
        ]
		
		attrTemplateAc = [
            type: String.class,
            readable: false,
            createable: true,
            updateable: false,
            required: false,
            multiValue: false,	    
            returnedByDefault: false
        ]

 attreqTemplatePwd = [
            type: GuardedString.class,
            readable: false,
            createable: true,
            updateable: true,
            required: false,
            multiValue: false,
            returnedByDefault: false
        ]
		
		 attrTemplateReqDet = [
            type: String.class,
            readable: true,
            createable: false,
            updateable: false,
            required: false,
            multiValue: false,
            returnedByDefault: true
        ] // 

 attreqTemplateBool = [
            type: boolean.class,
            readable: true,
            createable: true,
            updateable: true,
            required: false,
            multiValue: false,
            returnedByDefault: false
        ]

       
        operations = [
          //  UpdateAttributeValuesOp: ['__ACCOUNT__'],  
            SearchApiOp: ['__ACCOUNT__'],
           // ScriptOnConnectorApiOp: ['__ACCOUNT__'],
            ValidateApiOp: [ ],
         //   AuthenticationApiOp: ['__ACCOUNT__'],
            GetApiOp: ['__ACCOUNT__'],
            SchemaApiOp: ['__ACCOUNT__'],
		UpdateApiOp: ['__ACCOUNT__'],
		SyncApiOp: ['__ACCOUNT__'],
            TestApiOp: ['__ACCOUNT__' ],
          //  ScriptOnResourceApiOp: ['__ACCOUNT__'],
            CreateApiOp: ['__ACCOUNT__'],
          //  DeleteApiOp: ['__ACCOUNT__'],
        //    ResolveUsernameApiOp: ['__ACCOUNT__']
        ]//operations
    } // Schema

	 Schema."PERNR".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplate")
		
	 Schema."__PASSWORD__".attribute.__ACCOUNT__.oclasses = [
            type: GuardedString.class,
            readable: false,
            createable: true,
            updateable: true,
            required: true,
            multiValue: false,
            returnedByDefault: false
        ]
	 Schema."__CURRENT_PASSWORD__".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attreqTemplatePwd")
	 Schema."User Lock;NONE;NONE;NONE".attribute.__ACCOUNT__.oclasses = [
            type: String.class,
            readable: true,
            createable: true,
            updateable: true,
            required: false,
            multiValue: false,
            returnedByDefault: true
        ] 
	 Schema.__LOCK_OUT__.attribute.__ACCOUNT__.oclasses =[
            type: boolean.class,
            readable: true,
            createable: true,
            updateable: true,
            required: false,
            multiValue: false,
            returnedByDefault: true
        ]
	 Schema.__ENABLE__.attribute.__ACCOUNT__.oclasses = 
[
            type: boolean.class,
            readable: true,
            createable: true,
            updateable: true,
            required: false,
            multiValue: false,
            returnedByDefault: true
        ]
	 Schema.__PASSWORD_EXPIRED__.attribute.__ACCOUNT__.oclasses = [
            type: boolean.class,
            readable: true,
            createable: true,
            updateable: true,
            required: false,
            multiValue: false,
            returnedByDefault: false
        ]
	
	
	 Schema."ACCNT;LOGONDATA;ACCNT;LOGONDATAX".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplatenoC")
	 Schema."CLASS;LOGONDATA;CLASS;LOGONDATAX".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplatenoC")
	 Schema."GLTGV;LOGONDATA;GLTGV;LOGONDATAX".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplatenoC")
	 Schema."GLTGB;LOGONDATA;GLTGB;LOGONDATAX".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplatenoC")
	 Schema."TZONE;LOGONDATA;TZONE;LOGONDATAX".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplatenoC")
	 Schema."USTYP;LOGONDATA;USTYP;LOGONDATAX".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplatenoC") 
	 //Schema."LTIME;LOGONDATA;LTIME;LOGONDATAX".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplate")
	 //Schema."LOGONDATA;LTIME".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplate")

	 Schema."__NAME__".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attreqTemplateName")
			 
	 Schema."KOSTL;DEFAULTS;KOSTL;DEFAULTSX".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplatenoC")
	 Schema."DATFM;DEFAULTS;DATFM;DEFAULTSX".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplatenoC")
	 Schema."DCPFM;DEFAULTS;DCPFM;DEFAULTSX".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplatenoC")
	 Schema."LANGU;DEFAULTS;LANGU;DEFAULTSX".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplatenoC")
	 Schema."START_MENU;DEFAULTS;START_MENU;DEFAULTSX".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplatenoC")
	 
	 Schema."USERNAME;BAPIBNAME".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplatenoC") 
	 Schema."FIRSTNAME;ADDRESS;FIRSTNAME;ADDRESSX".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplatenoC")
	 Schema."LASTNAME;ADDRESS;LASTNAME;ADDRESSX".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplatenoC")
	 Schema."E_MAIL;ADDRESS;E_MAIL;ADDRESSX".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplatenoC")
	 Schema."TITLE_P;ADDRESS;TITLE_P;ADDRESSX".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplatenoC")
	 Schema."LANGU_P;ADDRESS;LANGU_P;ADDRESSX".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplatenoC")
	 Schema."FUNCTION;ADDRESS;FUNCTION;ADDRESSX".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplatenoC") 
	 Schema."COMM_TYPE;ADDRESS;COMM_TYPE;ADDRESSX".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplatenoC")
	 Schema."FAX_NUMBER;ADDRESS;FAX_NUMBER;ADDRESSX".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplatenoC")
	 Schema."FAX_EXTENS;ADDRESS;FAX_EXTENS;ADDRESSX".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplatenoC")
	 Schema."TEL1_EXT;ADDRESS;TEL1_EXT;ADDRESSX".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplatenoC")
	 Schema."TEL1_NUMBR;ADDRESS;TEL1_NUMBR;ADDRESSX".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplatenoC")
	 Schema."ROOM_NO_P;ADDRESS;ROOM_NO_P;ADDRESSX".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplatenoC")
				 
	 Schema."BUILDING_P;ADDRESS;BUILDING_P;ADDRESSX".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplatenoC")
	 Schema."DEPARTMENT;ADDRESS;DEPARTMENT;ADDRESSX".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplatenoC")
	 Schema."FLOOR_P;ADDRESS;FLOOR_P;ADDRESSX".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplatenoC")
	 Schema."USERALIAS;ALIAS;BAPIALIAS;ALIASX".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplatenoC")
	 Schema."COMPANY;COMPANY;COMPANY;COMPANYX".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplatenoC")
	 Schema."LIC_TYPE;UCLASS;UCLASS;UCLASSX".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplatenoC")
	 Schema."SUBSYSTEM;SYSTEMS".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplateMv")
	 Schema."USERGROUP;GROUPS;USERGROUP;GROUPS".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplateMv")
	 Schema."profiles".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplateMvEmbd")
	 Schema."parameters".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplateMvEmbd")
	 Schema."roles".attribute.__ACCOUNT__.oclasses =Lazy.get("testsuite.Schema.attrTemplateMvEmbd")


	Schema."SUBSYSTEM".attribute.PROFILES.oclasses = Lazy.get("testsuite.Schema.attrTemplate")
	Schema."PROFILE".attribute.PROFILES.oclasses = Lazy.get("testsuite.Schema.attreqTemplate")
	Schema."__NAME__".attribute.PROFILES.oclasses = Lazy.get("testsuite.Schema.attreqTemplate")
	Schema."BAPIAKTPS".attribute.PROFILES.oclasses = Lazy.get("testsuite.Schema.attrTemplate")
	Schema."BAPIPTEXT".attribute.PROFILES.oclasses = Lazy.get("testsuite.Schema.attrTemplate")
	Schema."BAPITYPE".attribute.PROFILES.oclasses = Lazy.get("testsuite.Schema.attrTemplate")


	Schema."PARTXT".attribute.PARAMETER.oclasses = Lazy.get("testsuite.Schema.attrTemplate")
	Schema."__NAME__".attribute.PARAMETER.oclasses = Lazy.get("testsuite.Schema.attreqTemplate")
	Schema."PARID".attribute.PARAMETER.oclasses = Lazy.get("testsuite.Schema.attreqTemplate")
	Schema."PARVA".attribute.PARAMETER.oclasses = Lazy.get("testsuite.Schema.attrTemplate")

	Schema."AGR_NAME".attribute.ACTIVITYGROUPS.oclasses = Lazy.get("testsuite.Schema.attreqTemplate")
	Schema."FROM_DAT".attribute.ACTIVITYGROUPS.oclasses = Lazy.get("testsuite.Schema.attrTemplate")
	Schema."TO_DAT".attribute.ACTIVITYGROUPS.oclasses = Lazy.get("testsuite.Schema.attrTemplate")
	Schema."__NAME__".attribute.ACTIVITYGROUPS.oclasses = Lazy.get("testsuite.Schema.attreqTemplate")
	Schema."ORG_FLAG".attribute.ACTIVITYGROUPS.oclasses = Lazy.get("testsuite.Schema.attrTemplate")
	Schema."AGR_TEXT".attribute.ACTIVITYGROUPS.oclasses = Lazy.get("testsuite.Schema.attrTemplate")
	Schema."SUBSYSTEM".attribute.ACTIVITYGROUPS.oclasses = Lazy.get("testsuite.Schema.attrTemplate")
	
	
Schema."Userid;UserInfo".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplate");
Schema."title;UserInfo".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplate");
Schema."fname;UserInfo".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplate");
Schema."lname;UserInfo".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplate");
Schema."accno;UserInfo".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplateAc");
Schema."userGroup;UserInfo".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplate");
Schema."validFrom;UserInfo".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplate");
Schema."validTo;UserInfo".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplate");
Schema."commMethod;UserInfo".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplate");
Schema."fax;UserInfo".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplate");
Schema."email;UserInfo".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplate");
Schema."telnumber;UserInfo".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplate");
Schema."costcenter;UserInfo".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplate");
Schema."startMenu;UserInfo".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplate");
Schema."logonLang;UserInfo".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplate");
Schema."decNotation;UserInfo".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplate");
Schema."dateFormat;UserInfo".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplate");
Schema."alias;UserInfo".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplate");
Schema."userType;UserInfo".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplate");
Schema."manager;UserInfo".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplateAc");
Schema."managerEmail;UserInfo".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplateAc");
Schema."managerFirstname;UserInfo".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplateAc");
Schema."managerLastname;UserInfo".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplateAc");
Schema."RequestStatus".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplateReqDet");
Schema."ReqType".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplateReqDet");
Schema."RequestorId;Header".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplateReqDet");
Schema."Email;Header".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplateAc");
Schema."Priority;Header".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplateAc");
Schema."ReqInitSystem;Header".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplateAc");
Schema."ReqDueDate;Header".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplateAc");
Schema."RequestReason;Header".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplateAc");
Schema."Funcarea;Header".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplateAc");
Schema."Bproc;Header".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplateAc");
Schema."userGroup;UserGroup".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplateMvAc");
Schema."__CURRENT_ATTRIBUTES__".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.multiValueAttrTemplate");
Schema."userLock;None".attribute.__ACCOUNT__.oclasses = Lazy.get("testsuite.Schema.attrTemplate");


}


 //__ACCOUNT__."LTIME;LOGONDATA;LTIME;LOGONDATAX"=new ObjectNotFoundException()
 // __ACCOUNT__."LOGONDATA;LTIME"=new ObjectNotFoundException()
 __ACCOUNT__."SUBSYSTEM;SYSTEMS"=new ObjectNotFoundException()
 __ACCOUNT__.__LOCK_OUT__=new ObjectNotFoundException()
__ACCOUNT__.__PASSWORD_EXPIRED__=new ObjectNotFoundException()
__ACCOUNT__.__ENABLE__=true
__ACCOUNT__."USTYP;LOGONDATA;USTYP;LOGONDATAX"=new ObjectNotFoundException()
__ACCOUNT__."CLASS;LOGONDATA;CLASS;LOGONDATAX"=new ObjectNotFoundException()
__ACCOUNT__."START_MENU;DEFAULTS;START_MENU;DEFAULTSX"=new ObjectNotFoundException()
__ACCOUNT__."FLOOR_P;ADDRESS;FLOOR_P;ADDRESSX"=new ObjectNotFoundException()
__ACCOUNT__."COMPANY;COMPANY;COMPANY;COMPANYX"=new ObjectNotFoundException()
__ACCOUNT__."ACCNT;LOGONDATA;ACCNT;LOGONDATAX"=new ObjectNotFoundException()
__ACCOUNT__."__NAME__"="may222user11"
__ACCOUNT__."FIRSTNAME;ADDRESS;FIRSTNAME;ADDRESSX"=new ObjectNotFoundException()
__ACCOUNT__."LASTNAME;ADDRESS;LASTNAME;ADDRESSX"="may30user1"
__ACCOUNT__."COMM_TYPE;ADDRESS;COMM_TYPE;ADDRESSX"=new ObjectNotFoundException()
__ACCOUNT__."KOSTL;DEFAULTS;KOSTL;DEFAULTSX"=new ObjectNotFoundException()
__ACCOUNT__."TZONE;LOGONDATA;TZONE;LOGONDATAX"=new ObjectNotFoundException()
__ACCOUNT__."GLTGB;LOGONDATA;GLTGB;LOGONDATAX"=new ObjectNotFoundException()
__ACCOUNT__."USERALIAS;ALIAS;BAPIALIAS;ALIASX"=new ObjectNotFoundException()
__ACCOUNT__."FAX_NUMBER;ADDRESS;FAX_NUMBER;ADDRESSX"=new ObjectNotFoundException()
__ACCOUNT__."PERNR"=new ObjectNotFoundException() 
__ACCOUNT__."E_MAIL;ADDRESS;E_MAIL;ADDRESSX"=new ObjectNotFoundException()
__ACCOUNT__."USERGROUP;GROUPS;USERGROUP;GROUPS"=new ObjectNotFoundException()
__ACCOUNT__."LANGU_P;ADDRESS;LANGU_P;ADDRESSX"=new ObjectNotFoundException()
__ACCOUNT__."__PASSWORD__"=new GuardedString("Mphasis123".toCharArray())
__ACCOUNT__."FUNCTION;ADDRESS;FUNCTION;ADDRESSX"=new ObjectNotFoundException()
__ACCOUNT__."User Lock;NONE;NONE;NONE"=new ObjectNotFoundException()
__ACCOUNT__."TEL1_EXT;ADDRESS;TEL1_EXT;ADDRESSX"=new ObjectNotFoundException()
__ACCOUNT__."DEPARTMENT;ADDRESS;DEPARTMENT;ADDRESSX"=new ObjectNotFoundException()
__ACCOUNT__."BUILDING_P;ADDRESS;BUILDING_P;ADDRESSX"=new ObjectNotFoundException()
__ACCOUNT__."DCPFM;DEFAULTS;DCPFM;DEFAULTSX"=new ObjectNotFoundException()
__ACCOUNT__."LANGU;DEFAULTS;LANGU;DEFAULTSX"=new ObjectNotFoundException()
__ACCOUNT__."ROOM_NO_P;ADDRESS;ROOM_NO_P;ADDRESSX"=new ObjectNotFoundException()
__ACCOUNT__."LIC_TYPE;UCLASS;UCLASS;UCLASSX"=new ObjectNotFoundException()
__ACCOUNT__."TEL1_NUMBR;ADDRESS;TEL1_NUMBR;ADDRESSX"=new ObjectNotFoundException()
__ACCOUNT__."GLTGV;LOGONDATA;GLTGV;LOGONDATAX"=new ObjectNotFoundException()
__ACCOUNT__."FAX_EXTENS;ADDRESS;FAX_EXTENS;ADDRESSX"=new ObjectNotFoundException()
__ACCOUNT__."DATFM;DEFAULTS;DATFM;DEFAULTSX"=new ObjectNotFoundException()
__ACCOUNT__."TITLE_P;ADDRESS;TITLE_P;ADDRESSX"=new ObjectNotFoundException()
__ACCOUNT__."__CURRENT_ATTRIBUTES__"=new ObjectNotFoundException()

__ACCOUNT__."Userid;UserInfo"="may222user11"
__ACCOUNT__."title;UserInfo"="Mr."
__ACCOUNT__."fname;UserInfo"="may30user1"
__ACCOUNT__."lname;UserInfo"="may30user1"
__ACCOUNT__."accno;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__."userGroup;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__."validFrom;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__."validTo;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__."commMethod;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__."fax;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__."email;UserInfo"="sandeep@mphasis.com"
__ACCOUNT__."telnumber;UserInfo"="9654524852"
__ACCOUNT__."costcenter;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__."startMenu;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__."logonLang;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__."decNotation;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__."dateFormat;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__."alias;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__."userType;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__."manager;UserInfo"="Basis"
__ACCOUNT__."managerEmail;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__."managerFirstname;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__."managerLastname;UserInfo"=new ObjectNotFoundException();
//__ACCOUNT__."RequestStatus"=new ObjectNotFoundException();
__ACCOUNT__."ReqType"=new ObjectNotFoundException();
__ACCOUNT__."RequestorId;Header"=new ObjectNotFoundException();
__ACCOUNT__."Email;Header"="kadiyala@email.com"
__ACCOUNT__."Priority;Header"="006"
__ACCOUNT__."ReqInitSystem;Header"="ST1CLNT100"
__ACCOUNT__."ReqDueDate;Header"=new ObjectNotFoundException();
__ACCOUNT__."RequestReason;Header"="contracttests"
__ACCOUNT__."Funcarea;Header"=new ObjectNotFoundException();
__ACCOUNT__."Bproc;Header"="basis"
__ACCOUNT__."itemName;ReqLineItem"=new ObjectNotFoundException();
__ACCOUNT__."validFrom;ReqLineItem"=new ObjectNotFoundException();
__ACCOUNT__."Validto;ReqLineItem"=new ObjectNotFoundException();
__ACCOUNT__."connector;ReqLineItem"=new ObjectNotFoundException();
__ACCOUNT__."itemName;ReqLineItem"=new ObjectNotFoundException();
__ACCOUNT__."connector;ReqLineItem"=new ObjectNotFoundException();
__ACCOUNT__."parameter;Parameter"=new ObjectNotFoundException();
__ACCOUNT__."parameterValue;Parameter"=new ObjectNotFoundException();
__ACCOUNT__."userGroup;UserGroup"=new ObjectNotFoundException();
__ACCOUNT__."userLock;None"=new ObjectNotFoundException();

__ACCOUNT__.modified."__CURRENT_ATTRIBUTES__"=
getEmbeddedObject("Mr.","sandeep@mphasis.com","may19mk1","may19mk1","XFWNV97","9654524852","kadiyala@email.com","006","ST1CLNT100","contracttests","basis")


i0.Create.__ACCOUNT__."__NAME__"="may222user11"
i0.Create.__ACCOUNT__."Userid;UserInfo"="may222user11"

i1.Create.__ACCOUNT__."__NAME__"="may222user11"
i1.Create.__ACCOUNT__."Userid;UserInfo"="may222user11"

i2.Create.__ACCOUNT__."__NAME__"="may222user11"
i2.Create.__ACCOUNT__."Userid;UserInfo"="may222user11"

i0.Search.__ACCOUNT__."__NAME__"="may222user11"
i0.Search.__ACCOUNT__."Userid;UserInfo"="may222user11"

i1.Search.__ACCOUNT__."__NAME__"="may222user11"
i1.Search.__ACCOUNT__."Userid;UserInfo"="may222user11"

i2.Search.__ACCOUNT__."__NAME__"="may222user11"
i2.Search.__ACCOUNT__."Userid;UserInfo"="may222user11"


i3.Search.__ACCOUNT__."__NAME__"="may222user11"
i3.Search.__ACCOUNT__."Userid;UserInfo"="may222user11"

i4.Search.__ACCOUNT__."__NAME__"="may222user11"
i4.Search.__ACCOUNT__."Userid;UserInfo"="may222user11"


i5.Search.__ACCOUNT__."__NAME__"="may222user11"
i5.Search.__ACCOUNT__."Userid;UserInfo"="may222user11"


i6.Search.__ACCOUNT__."__NAME__"="may222user11"
i6.Search.__ACCOUNT__."Userid;UserInfo"="may222user11"


i7.Search.__ACCOUNT__."__NAME__"="may222user11"
i7.Search.__ACCOUNT__."Userid;UserInfo"="may222user11"


i8.Search.__ACCOUNT__."__NAME__"="may222user11"
i8.Search.__ACCOUNT__."Userid;UserInfo"="may222user11"

i9.Search.__ACCOUNT__."__NAME__"="may222user11"
i9.Search.__ACCOUNT__."Userid;UserInfo"="may222user11"

i10.Search.__ACCOUNT__."__NAME__"="may222user11"
i10.Search.__ACCOUNT__."Userid;UserInfo"="may222user11"

	
	__ACCOUNT__.modified."__CURRENT_PASSWORD__"=new ObjectNotFoundException()
	 //__ACCOUNT__.modified."LTIME;LOGONDATA;LTIME;LOGONDATAX"=new ObjectNotFoundException()
	 // __ACCOUNT__.modified."LTIME;LOGONDATA"=new ObjectNotFoundException()
 __ACCOUNT__.modified.__LOCK_OUT__=new ObjectNotFoundException()
__ACCOUNT__.modified.__PASSWORD_EXPIRED__=new ObjectNotFoundException()
__ACCOUNT__.modified.__ENABLE__=new ObjectNotFoundException()
__ACCOUNT__.modified."USTYP;LOGONDATA;USTYP;LOGONDATAX"=new ObjectNotFoundException()
__ACCOUNT__.modified."CLASS;LOGONDATA;CLASS;LOGONDATAX"=new ObjectNotFoundException()
__ACCOUNT__.modified."START_MENU;DEFAULTS;START_MENU;DEFAULTSX"=new ObjectNotFoundException()
__ACCOUNT__.modified."FLOOR_P;ADDRESS;FLOOR_P;ADDRESSX"=new ObjectNotFoundException()
__ACCOUNT__.modified."COMPANY;COMPANY;COMPANY;COMPANYX"=new ObjectNotFoundException() 
__ACCOUNT__.modified."ACCNT;LOGONDATA;ACCNT;LOGONDATAX"=new ObjectNotFoundException() 
__ACCOUNT__.modified.__NAME__=new ObjectNotFoundException()
__ACCOUNT__.modified."FIRSTNAME;ADDRESS;FIRSTNAME;ADDRESSX"==new ObjectNotFoundException()
__ACCOUNT__.modified."LASTNAME;ADDRESS;LASTNAME;ADDRESSX"==new ObjectNotFoundException()
__ACCOUNT__.modified."COMM_TYPE;ADDRESS;COMM_TYPE;ADDRESSX"=new ObjectNotFoundException()
__ACCOUNT__.modified."KOSTL;DEFAULTS;KOSTL;DEFAULTSX"=new ObjectNotFoundException() 
__ACCOUNT__.modified."TZONE;LOGONDATA;TZONE;LOGONDATAX"=new ObjectNotFoundException() 
__ACCOUNT__.modified."GLTGB;LOGONDATA;GLTGB;LOGONDATAX"=new ObjectNotFoundException()
__ACCOUNT__.modified."USERALIAS;ALIAS;BAPIALIAS;ALIASX"=new ObjectNotFoundException()
__ACCOUNT__.modified."FAX_NUMBER;ADDRESS;FAX_NUMBER;ADDRESSX"=new ObjectNotFoundException()
__ACCOUNT__.modified."PERNR"=new ObjectNotFoundException() 
__ACCOUNT__.modified."E_MAIL;ADDRESS;E_MAIL;ADDRESSX"=new ObjectNotFoundException()
__ACCOUNT__.added."USERGROUP;GROUPS;USERGROUP;GROUPS"=new ObjectNotFoundException()
__ACCOUNT__.modified."LANGU_P;ADDRESS;LANGU_P;ADDRESSX"=new ObjectNotFoundException()
__ACCOUNT__.modified."__PASSWORD__"==new ObjectNotFoundException()
__ACCOUNT__.modified."FUNCTION;ADDRESS;FUNCTION;ADDRESSX"==new ObjectNotFoundException()
__ACCOUNT__.modified."User Lock;NONE;NONE;NONE"=new ObjectNotFoundException()
__ACCOUNT__.modified."TEL1_EXT;ADDRESS;TEL1_EXT;ADDRESSX"=new ObjectNotFoundException()
__ACCOUNT__.modified."DEPARTMENT;ADDRESS;DEPARTMENT;ADDRESSX"=new ObjectNotFoundException()
__ACCOUNT__.modified."BUILDING_P;ADDRESS;BUILDING_P;ADDRESSX"=new ObjectNotFoundException()
__ACCOUNT__.modified."DCPFM;DEFAULTS;DCPFM;DEFAULTSX"=new ObjectNotFoundException()
__ACCOUNT__.modified."LANGU;DEFAULTS;LANGU;DEFAULTSX"=new ObjectNotFoundException() 
__ACCOUNT__.modified."ROOM_NO_P;ADDRESS;ROOM_NO_P;ADDRESSX"=new ObjectNotFoundException()
__ACCOUNT__.modified."LIC_TYPE;UCLASS;UCLASS;UCLASSX"=new ObjectNotFoundException()
__ACCOUNT__.modified."TEL1_NUMBR;ADDRESS;TEL1_NUMBR;ADDRESSX"=new ObjectNotFoundException()
__ACCOUNT__.modified."GLTGV;LOGONDATA;GLTGV;LOGONDATAX"=new ObjectNotFoundException()
__ACCOUNT__.modified."FAX_EXTENS;ADDRESS;FAX_EXTENS;ADDRESSX"=new ObjectNotFoundException() 
__ACCOUNT__.modified."DATFM;DEFAULTS;DATFM;DEFAULTSX"=new ObjectNotFoundException()
__ACCOUNT__.modified."TITLE_P;ADDRESS;TITLE_P;ADDRESSX"=new ObjectNotFoundException()


__ACCOUNT__.modified."Userid;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__.modified."title;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__.modified."fname;UserInfo"="xxxxxxx"
__ACCOUNT__.modified."lname;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__.modified."accno;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__.modified."userGroup;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__.modified."validFrom;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__.modified."validTo;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__.modified."commMethod;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__.modified."fax;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__.modified."email;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__.modified."telnumber;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__.modified."costcenter;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__.modified."startMenu;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__.modified."logonLang;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__.modified."decNotation;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__.modified."dateFormat;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__.modified."alias;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__.modified."userType;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__.modified."manager;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__.modified."managerEmail;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__.modified."managerFirstname;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__.modified."managerLastname;UserInfo"=new ObjectNotFoundException();
__ACCOUNT__.modified."RequestStatus"=new ObjectNotFoundException();
__ACCOUNT__.modified."ReqType"=new ObjectNotFoundException();
__ACCOUNT__.modified."RequestorId;Header"=new ObjectNotFoundException();
__ACCOUNT__.modified."Email;Header"=new ObjectNotFoundException();
__ACCOUNT__.modified."Priority;Header"=new ObjectNotFoundException();
__ACCOUNT__.modified."ReqInitSystem;Header"=new ObjectNotFoundException();
__ACCOUNT__.modified."ReqDueDate;Header"=new ObjectNotFoundException();
__ACCOUNT__.modified."RequestReason;Header"=new ObjectNotFoundException();
__ACCOUNT__.modified."Funcarea;Header"=new ObjectNotFoundException();
__ACCOUNT__.modified."Bproc;Header"=new ObjectNotFoundException();
__ACCOUNT__.modified."itemName;ReqLineItem"=new ObjectNotFoundException();
__ACCOUNT__.modified."validFrom;ReqLineItem"=new ObjectNotFoundException();
__ACCOUNT__.modified."Validto;ReqLineItem"=new ObjectNotFoundException();
__ACCOUNT__.modified."connector;ReqLineItem"=new ObjectNotFoundException();
__ACCOUNT__.modified."itemName;ReqLineItem"=new ObjectNotFoundException();
__ACCOUNT__.modified."connector;ReqLineItem"=new ObjectNotFoundException();
__ACCOUNT__.modified."parameter;Parameter"=new ObjectNotFoundException();
__ACCOUNT__.modified."parameterValue;Parameter"=new ObjectNotFoundException();
__ACCOUNT__.modified."userGroup;UserGroup"=new ObjectNotFoundException();
__ACCOUNT__.modified."userLock;None"=new ObjectNotFoundException();


i0.modified.__ACCOUNT__."__NAME__"="may55mk166"
i1.modified.__ACCOUNT__."__NAME__"="may55mk1"
//i1.modified.__ACCOUNT__."logonname"="000132251780"


i0.Update.__ACCOUNT__."__NAME__"="may30user1"
i0.Update.__ACCOUNT__."Userid;UserInfo"="may30user1"

i1.Update.__ACCOUNT__."__NAME__"="may30user1"
i1.Update.__ACCOUNT__."Userid;UserInfo"="may30user1"

i2.Update.__ACCOUNT__."__NAME__"="may30user1"
i2.Update.__ACCOUNT__."Userid;UserInfo"="may30user1"
//i2.Update.__ACCOUNT__."logonname"="000132251781"

__ACCOUNT__.modified."SUBSYSTEM;SYSTEMS" = new ObjectNotFoundException()

__ACCOUNT__.added.roles= getEmbeddedRoleObject("MW_ADMIN", "EH6CLNT800", "0", "0")
     //     __ACCOUNT__.added.roles= getEmbeddedRoleObject("role", "sys", "validfrom", "validto")

added."SUBSYSTEM;SYSTEMS" = new ObjectNotFoundException()
added."USERGROUP;GROUPS;USERGROUP;GROUPS" = new ObjectNotFoundException()
added."roles"= new ObjectNotFoundException()
added."profiles"= new ObjectNotFoundException()
added."parameters"= new ObjectNotFoundException()
	
 testsuite.Update.updateToNullValue.skippedAttributes = [ 'LIC_TYPE;UCLASS;UCLASS;UCLASSX' ,'BUILDING_P;ADDRESS;BUILDING_P;ADDRESSX','FIRSTNAME;ADDRESS;FIRSTNAME;ADDRESSX', 'LASTNAME;ADDRESS;LASTNAME;ADDRESSX',  
									'E_MAIL;ADDRESS;E_MAIL;ADDRESSX', 'TITLE_P;ADDRESS;TITLE_P;ADDRESSX', 
				'LANGU_P;ADDRESS;LANGU_P;ADDRESSX', 'FUNCTION;ADDRESS;FUNCTION;ADDRESSX', 'DEPARTMENT;ADDRESS;DEPARTMENT;ADDRESSX', 'COMM_TYPE;ADDRESS;COMM_TYPE;ADDRESSX', 
				'FAX_NUMBER;ADDRESS;FAX_NUMBER;ADDRESSX', 'FAX_EXTENS;ADDRESS;FAX_EXTENS;ADDRESSX','TEL1_EXT;ADDRESS;TEL1_EXT;ADDRESSX', 'TEL1_NUMBR;ADDRESS;TEL1_NUMBR;ADDRESSX',   
				'ROOM_NO_P;ADDRESS;ROOM_NO_P;ADDRESSX', 'BUILDING_P;ADDRESS;BUILDING_P;ADDRESSX', 'FLOOR_P;ADDRESS;FLOOR_P;ADDRESSX','ACCNT;LOGONDATA;ACCNT;LOGONDATAX','CLASS;LOGONDATA;CLASS;LOGONDATAX','GLTGV;LOGONDATA;GLTGV;LOGONDATAX', 'GLTGB;LOGONDATA;GLTGB;LOGONDATAX', 'decNotation;UserInfo','roles','profiles','parameters',
				'TZONE;LOGONDATA;TZONE;LOGONDATAX', 'USTYP;LOGONDATA;USTYP;LOGONDATAX', 'LTIME;LOGONDATA;LTIME;LOGONDATAX',

				'USERALIAS;ALIAS;BAPIALIAS;ALIASX',  'COMPANY;COMPANY;COMPANY;COMPANYX', 'LIC_TYPE;UCLASS;UCLASS;UCLASSX','KOSTL;DEFAULTS;KOSTL;DEFAULTSX',  'DATFM;DEFAULTS;DATFM;DEFAULTSX','DCPFM;DEFAULTS;DCPFM;DEFAULTSX',   'LANGU;DEFAULTS;LANGU;DEFAULTSX',  'START_MENU;DEFAULTS;START_MENU;DEFAULTSX','title;UserInfo','accno;UserInfo','userGroup;UserInfo','validFrom;UserInfo',
'validTo;UserInfo','commMethod;UserInfo','fax;UserInfo','email;UserInfo','fname;UserInfo','lname;UserInfo','Userid;UserInfo',
'telnumber;UserInfo','costcenter;UserInfo','startMenu;UserInfo','logonLang;UserInfo','userLock;None',
'decNotation;UserInfo','dateFormat;UserInfo','alias;UserInfo','userType;UserInfo',
'manager;UserInfo','managerEmail;UserInfo','managerFirstname;UserInfo','managerLastname;UserInfo',
'Requeststatus','ReqType','RequestorId;Header','Email;Header','Priority;Header','ReqInitSystem;Header',
'ReqDueDate;Header','RequestReason;Header','Funcarea;Header','Bproc;Header',
'itemName;ReqLineItem','validFrom;ReqLineItem','Validto;ReqLineItem','connector;ReqLineItem',
'itemName;ReqLineItem','connector;ReqLineItem','parameter;Parameter','parameterValue;Parameter',
'userGroup;UserGroup' ]

	strictCheck=false
