/**
 * 
 */
package org.identityconnectors.sapacum;


/**
 * @author ranjith.kumar
 *
 */
public interface SAPACUMConstants {
	
	public static final String VALUE_YES ="YES";
	public static final String ATTR_REQTYPE = "RequestType";
	public static final String STATUS = "Status";
	public static final String RESULT = "Result";
	public static final String[] roleCodeKeyDecode = new String[]{"RCODE","RDECODE"};
	public static final String[] applCodeKeyDecode = new String[]{"REQSYSCODE","REQSYSDECODE"};
	public static final String[] lookupCodeKeyDecode = new String[]{"LCODE","LDECODE"};
	public static final String DECODE_USERLOCK = "userLock;None";
	public static final String REMOVE_CHILD = "removeChild";
	public static final String ADD_CHILD = "addChild";
	public static final String ROLE_RECON = "ROLE";
	public static final String SYSTEM_RECON="SYSTEM";
	public static final String BUSPROC_RECON="BUSPROC";
	public static final String FUNCTIONAREA_RECON="FUNCTIONAREA";
	public static final String ITEMPROVACTIONTYPE="ItemProvActionType";
	public static final String PRIORITYTYPE_RECON="PriorityType";
	public static final String REQUESTTYPE="RequestType";
	public static final String CREATE_REQ_TYPE="NEW";
	public static final String DELETE_REQ_TYPE="DELETE";
	public static final String REQUESTNO="RequestNo";
	public static final String FORMDATA="FormData";
	public static final String USERID="User ID";	
	public static final String USERIDKEY="userid";	
	public static final String LOGONNAME="Logon Name";
	public static final String REQUESTID="RequestId";
	public static final String ITEMPROVTYPE="ItemProvType";
	public static final String ITEMTYPE="ItemType";
	public static final String VALUE_NO="NO";
	public static final String VALUE_OK="OK";
	public static final String CLOSED="CLOSED";
	public static final String TRUE="true";
	public static final String ROLES="roles";
	//Start : Bug 26442572 - AOB: SAP AC UM CHILD ATTRIBUTERS RECON IS NOT WORKING
	public static final String PROFILES="profiles";
	//End : Bug 26442572 - AOB: SAP AC UM CHILD ATTRIBUTERS RECON IS NOT WORKING
	public static final String ROLEID="roleId";
	public static final String REQTYPE="ReqType";
	public static final String VALIDTO="validto";
	public static final String ACTION="action";
	public static final String ATTRS_TO_GET="ATTRS_TO_GET";
	public static final String PATTERN_REQ_NO = "~*~";
	public static final String PATTERN_REQ_TYPE = "~";
	public static final String PATTERN_EQUALTO = "=";
	public static final String PATTERN_SEMI_COLON = ";";
	public static final String PATTERN_AND = "&";
	public static final String DIGIT_ZERO = "0";
	public static final String DIGIT_ONE= "1";
	public static final String DIGIT_FOUR="4";
	public static final String CONFIGURATION = "Configuration";

	

	public static final String ATTR_UI_USER_ID = "userId;UserInfo";
	public static final String ATTR_UI_TITLE = "title;UserInfo";
	public static final String ATTR_UI_FNAME = "fname;UserInfo";
	public static final String ATTR_UI_LNAME = "lname;UserInfo";
	public static final String ATTR_UI_ACCNO = "accno;UserInfo";
	public static final String ATTR_UI_USER_GROUP = "userGroup;UserInfo";
	public static final String ATTR_UI_VALID_FROM = "validFrom;UserInfo";
	public static final String ATTR_UI_VALID_TO = "validTo;UserInfo";
	public static final String ATTR_UI_COMM_METHOD = "commMethod;UserInfo";
	public static final String ATTR_UI_FAX = "fax;UserInfo";
	public static final String ATTR_UI_EMAIL = "email;UserInfo";
	public static final String ATTR_UI_TELEPHONE = "telnumber;UserInfo";
	public static final String ATTR_UI_COST_CENTER = "costcenter;UserInfo";
	public static final String ATTR_UI_START_MENU = "startMenu;UserInfo";
	public static final String ATTR_UI_LONGON_LANGUAGE = "logonLang;UserInfo";
	public static final String ATTR_UI_DECIMAL_NOTATION = "decNotation;UserInfo";
	public static final String ATTR_UI_DAYE_FORMAT = "dateFormat;UserInfo";
	public static final String ATTR_UI_ALIAS = "alias;UserInfo";
	public static final String ATTR_UI_USER_TYPE = "userType;UserInfo";
	public static final String ATTR_UI_AC_MANAGER = "manager;UserInfo";
	public static final String ATTR_UI_AC_MGR_EMAIL = "managerEmail;UserInfo";
	public static final String ATTR_UI_AC_MGR_FNAME = "managerFirstname;UserInfo";
	public static final String ATTR_UI_AC_MGR_LNAME = "managerLastname;UserInfo";
	
	public static final String ATTR_AC_REQ_STATUS = "RequestStatus";
	public static final String ATTR_REQ_TYPE = "ReqType";
	
	public static final String ATTR_HDR_REQTR_ID = "RequestorId;Header";
	public static final String ATTR_HDR_REQTR_EMAIL = "Email;Header";
	public static final String ATTR_HDR_PRIORITY = "Priority;Header";
	public static final String ATTR_HDR_SYSTEM = "ReqInitSystem;Header";
	public static final String ATTR_HDR_REQ_DUEDATE = "ReqDueDate;Header";
	public static final String ATTR_HDR_REQ_REASON = "RequestReason;Header";
	public static final String ATTR_HDR_FUNC_AREA= "Funcarea;Header";
	public static final String ATTR_HDR_BPROCESS= "Bproc;Header";
	
	public static final String ATTR_ROLE_NAME = "itemName;ReqLineItem";
	public static final String ATTR_ROLE_STARTDATE= "validFrom;ReqLineItem";
	public static final String ATTR_ROLE_ENDDATE= "Validto;ReqLineItem";
	public static final String ATTR_ROLE_SYS_NAME= "connector;ReqLineItem";
	
	public static final String ATTR_PROFILE_NAME = "itemName;ReqLineItem";
	public static final String ATTR_PROFILE_SYS_NAME = "connector;ReqLineItem";
	
	public static final String ATTR_PARA_NAME = "parameter;Parameter";
	public static final String ATTR_PARA_VALUE = "parameterValue;Parameter";
	
	public static final String ATTR_USER_GROUP = "userGroup;UserGroup";

	public static final String SERVICE_METHODNAME = "callService";
	public static final String ATTR_UI_IS_LOCKED= "userLock;None";
	
    public static final String OLD_PASSWORD ="oldpassword";
    public static final String IS_PASSWORD_DISABLED ="ispassworddisabled";
    public static final String Role_ValidTo = "roles~ACTIVITYGROUPS~ValidTo;ReqLineItem";
    public static final String Role_RoleName = "roles~ACTIVITYGROUPS~itemName;ReqLineItem";
    public static final String Role_System = "roles~ACTIVITYGROUPS~connector;ReqLineItem";
    public static final String Role_ValidFrom = "roles~ACTIVITYGROUPS~validFrom;ReqLineItem";
    
    public static final String Profile_RoleName = "profile~PROFILES~itemName;ReqLineItem";
    public static final String Profile_System = "profile~PROFILES~connector;ReqLineItem";
    

    

    
	//AC 5.3 attributes
	
	public static final String ATTR_UI_USER_ID_53 = "userid";
	//public static final String ATTR_UI_TITLE_53 = "title;UserInfo";
	public static final String ATTR_UI_FNAME_53 = "firstName";
	public static final String ATTR_UI_LNAME_53 = "lastname";

	public static final String ATTR_UI_VALID_FROM_53 = "validFrom";
	public static final String ATTR_UI_VALID_TO_53 = "validto";
	
	public static final String ATTR_UI_EMAIL_53 = "emailAddress";
	public static final String ATTR_UI_TELEPHONE_53 = "telephone";

	public static final String ATTR_UI_AC_MANAGER_53 = "mgrId";
	public static final String ATTR_UI_AC_MGR_EMAIL_53 = "mgrEmailAddress";
	public static final String ATTR_UI_AC_MGR_FNAME_53 = "mgrFirstName";
	public static final String ATTR_UI_AC_MGR_LNAME_53 = "mgrLastName";
	
	public static final String ATTR_AC_REQ_STATUS_53 = "RequestStatus";
	public static final String ATTR_REQ_TYPE_53 = "RequestType";
	
	public static final String ATTR_HDR_REQTR_ID_53 = "requestorId";
	public static final String ATTR_HDR_REQTR_EMAIL_53 = "requestorEmailAddress";
	public static final String ATTR_HDR_REQTR_TELEPHONE_53 = "managerTelephone";
	public static final String ATTR_HDR_REQTR_FNAME_53 = "requestorFirstName";
	public static final String ATTR_HDR_REQTR_LNAME_53 = "requestorLastName";
	public static final String ATTR_HDR_PRIORITY_53 = "priority";
	public static final String ATTR_HDR_SYSTEM_53 = "application";

	public static final String ATTR_HDR_REQ_REASON_53 = "requestReason";
	public static final String ATTR_HDR_FUNC_AREA_53= "functionalArea";
	public static final String ATTR_UI_AC_COMPANY_53= "company";
	
	public static final String ATTR_ROLE_NAME53 = "roleId";
	public static final String ATTR_ROLE_STARTDATE53= "validFrom";
	public static final String ATTR_ROLE_ENDDATE53= "Validto";
	public static final String ATTR_ROLE_SYS_NAME53= "sysId";
	
	public static final String ATTR_PROFILE_NAME53 = "roleId";
	public static final String ATTR_PROFILE_SYS_NAME53 = "sysId";

	public static final String ATTR_ROLE_NAME_53 = "roles~ACTIVITYGROUPS~roleId";
	public static final String ATTR_ROLE_STARTDATE_53= "roles~ACTIVITYGROUPS~validFrom";
	public static final String ATTR_ROLE_ENDDATE_53= "roles~ACTIVITYGROUPS~validto";
	public static final String ATTR_ROLE_SYS_NAME_53= "roles~ACTIVITYGROUPS~sysId";
	
	public static final String ATTR_PROFILE_NAME_53 = "profile~PROFILES~roleId";
	public static final String ATTR_PROFILE_SYS_NAME_53 = "profile~PROFILES~sysId";	
	public static final String ATTR_USER_GROUP_53 = "userGroup;UserGroup";
	
	
	//Embedded object	
	public static final String ATTR_ROLES_EMBEDED = "roles";
	public static final String ATTR_PROFILES_EMBEDED = "profiles";
	public static final String ATTR_PARAMETERS_EMBEDED = "parameters";
	
}
