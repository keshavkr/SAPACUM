package oracle.iam.ws.sap.ac53;

import static oracle.iam.ws.sap.util.WsClientUtil.KEY_CONFIG_DATA;
import static oracle.iam.ws.sap.util.WsClientUtil.KEY_FORM_DATA;
import static oracle.iam.ws.sap.util.WsClientUtil.KEY_AC_URL;
import static oracle.iam.ws.sap.util.WsClientUtil.STATUS;


import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import javax.xml.ws.BindingProvider;

import oracle.iam.ws.sap.ac53.ejbutil.submitrequest.RequestSubmissionResult;
import oracle.iam.ws.sap.ac53.submitrequest.SAPGRCACIDMSUBMITREQUEST;
import oracle.iam.ws.sap.ac53.submitrequest.SAPGRCACIDMSUBMITREQUESTViDocument;
import oracle.iam.ws.sap.ac53.submitrequest.ejbutil.ArrayOfRoleData;
import oracle.iam.ws.sap.ac53.submitrequest.ejbutil.RequestDetailsData;
import oracle.iam.ws.sap.ac53.submitrequest.ejbutil.RoleData;
import oracle.iam.ws.sap.ac53.submitrequest.ejbutil.ServiceStatusDTO;
import oracle.iam.ws.sap.util.WsClientUtil;

import org.identityconnectors.common.logging.Log;
import org.identityconnectors.framework.common.objects.Attribute;
import org.identityconnectors.framework.common.objects.EmbeddedObject;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;

/**
 *	<br>Modification History:</br>
 *  S.No.                 Date                              Bug fix no.
 *  1. JAGADEESH        23 Oct 2013                     Bug 17288932 - oim to sap connection over ssl and lb with web dispatcher 
 */

/**
 * @author ranjith.kumar
 *
 */
public class SubmitRequest {

	
	private static final Log LOG = Log.getLog(SubmitRequest.class);
	
    /**
     * Constants for input HashMap
     */
    public final static String KEY_REQDETAILS_USERID = "UserId";
    public final static String KEY_REQDETAILS_REQUESTTYPE = "RequestType";
    public final static String KEY_REQDETAILS_APPLICATION = "Application";
    public final static String KEY_REQDETAILS_PRIORITY = "Priority";
    public final static String KEY_REQDETAILS_EMPLOYEETYPE = "EmployeeType";
    public final static String KEY_REQDETAILS_LASTNAME = "LastName";
    public final static String KEY_REQDETAILS_FIRSTNAME = "FirstName";
    public final static String KEY_REQDETAILS_EMAILADDRESS = "EmailAddress";
    public final static String KEY_REQDETAILS_MGREMAILADDRESS = "MgrEmailAddress";
    public final static String KEY_REQDETAILS_MGRFIRSTNAME ="MgrFirstName";
    public final static String KEY_REQDETAILS_MGRID = "MgrId";
    public final static String KEY_REQDETAILS_MGRLASTNAME = "MgrLastName";
    public final static String KEY_REQDETAILS_REQUESTORID = "RequestorId";
    public final static String KEY_REQDETAILS_REQUESTORLASTNAME="RequestorLastName";
    public final static String KEY_REQDETAILS_REQUESTORFIRSTNAME="RequestorFirstName";
    public final static String KEY_REQDETAILS_REQUESTOREMAILADDRESS="RequestorEmailAddress";
    public final static String KEY_REQDETAILS_UNSECURELOGON = "UnsecureLogon";
    public final static String KEY_ROLEDATA_VALIDFROM = "ValidFrom";
    public final static String KEY_ROLEDATA_VALIDTO = "ValidTo";
    
    public final static String KEY_REQDETAILS_REQUESTREASON= "KEY_REQUESTDETAILSDATA_REQUESTREASON";
    public final static String KEY_REQDETAILS_REQUESTORTELEPHONE = "KEY_REQUESTDETAILSDATA_REQUESTORTELEPHONE";
    public final static String KEY_REQDETAILS_MANAGERTELEPHONE = "KEY_REQUESTDETAILSDATA_MANAGERTELEPHONE";
    public final static String KEY_REQDETAILS_LOCATION = "KEY_REQUESTDETAILSDATA_LOCATION";
    public final static String KEY_REQDETAILS_LOCALE = "KEY_REQUESTDETAILSDATA_LOCALE";
    public final static String KEY_ROLEDATA_COMPANY = "KEY_ROLEDATA_COMPANY";
    public final static String KEY_REQDETAILS_DEPARTMENT = "KEY_REQUESTDETAILSDATA_DEPARTMENT";
    public final static String KEY_REQDETAILS_FUNCTIONALAREA = "KEY_REQUESTDETAILSDATA_FUNCTIONALAREA";
    public final static String KEY_REQDETAILS_SNCNAME = "KEY_REQUESTDETAILSDATA_SNCNAME";
    public final static String KEY_REQDETAILS_TELEPHONE = "KEY_REQUESTDETAILSDATA_TELEPHONE";
    public final static String KEY_REQDETAILS_CUSTOMFIELD = "KEY_REQUESTDETAILSDATA_CUSTOMFIELD";
    public final static String KEY_REQDETAILS_ROLES = "KEY_REQUESTDETAILSDATA_ROLES";
    
    private SAPGRCACIDMSUBMITREQUESTViDocument _port = null;
    
    /**
     * instance of util class 
     */
    private WsClientUtil util = null;
    
    /**
     * List of attributes to exclude from process
     */
    private List<String> attrExclusionList = new ArrayList<String>(5);
    
  
	/**
	 * Constructor of the class
	 */
	public SubmitRequest(){
		attrExclusionList.add("RequestStatus");
		attrExclusionList.add("userLock");
		attrExclusionList.add("RequestId"); //bug 17748964
	}
	
	/**
	 * 
	 * 
	 * Required attributes for getSubmitRequest web service call
	 * ********************************************************
	 * UserId is mandatory,
	 * RequestType is mandatory,
	 * Applications is mandatory,
	 * Priority is mandatory,
	 * LastName is mandatory,
	 * FirstName is mandatory,
	 * EmailAddress is mandatory,
	 * RequestorId is mandatory,
	 * RequestorLastName is mandatory,
	 * RequestorFirstName is mandatory,
	 * RequestorEmailAddr is mandatory
	 * 
	 * @return
	 */
	private RequestDetailsData marshalReqDetails(
			Map<String, Attribute> inputValueMap) throws Exception {
		RequestDetailsData requestDetails = new RequestDetailsData();
		String attrName = null;
		List<Object> valueList = null;
		Object valueObj = null;
		String value = null;
		EmbeddedObject embeddedObject = null; 
		Class<? extends RequestDetailsData> clazz = requestDetails.getClass();
		String[] rolevalues = null;
		String roleAction = null;
		for(Attribute attribute: inputValueMap.values()){
			attrName = util.splitAttrName(attribute.getName());
			if(attrExclusionList.contains(attrName)){
				continue;
			}
			valueList = attribute.getValue();
			valueObj = valueList.get(0);

			if(attrName.equalsIgnoreCase("roles") || attrName.equalsIgnoreCase("profile")){
				LOG.info("Setting Role/Profile...");
				ArrayOfRoleData arrayOfRoleData = new ArrayOfRoleData();
				List<RoleData> roleDataList = arrayOfRoleData.getRoleData();
				RoleData roleData = null;
				
				for(Object roleValueObj :attribute.getValue()){
					roleData = new RoleData();
					embeddedObject = (EmbeddedObject)roleValueObj;
					for (Attribute roleAttr : embeddedObject.getAttributes()){
						attrName = roleAttr.getName();
						valueList = roleAttr.getValue();
						valueObj = valueList.get(0);
						if(valueObj != null){
							LOG.info("******************************************************");
							LOG.info("-->Attribute Name: [{0}]", attrName);
							LOG.info("-->Creating RoleData for [{0}]", valueObj);
							if(attrName.equalsIgnoreCase("validFrom") || 
									attrName.equalsIgnoreCase("validto")){
								setCalendar(RoleData.class, roleData, attrName, valueObj);
							} else {
								value = util.filterAttrValue(valueObj.toString());
								LOG.info("Filtered AttrValue:[{0}]",value);
								util.getMethod(RoleData.class, 
										util.getMethodName(RoleData.class, attrName,
												"set"), String.class).invoke(roleData, value);
								if("roleId".equalsIgnoreCase(attrName)){
									rolevalues = util.getValues(valueObj.toString(), "~");
								}
							}
						}
					}
					if(roleData.getSysId()== null || roleData.getSysId().trim().length()==0){
						LOG.info("SysID not exist so using sysID which is prefixed with role name");
						if(rolevalues != null){
							LOG.info("-->Sys ID:[{0}]", rolevalues[0]);
							LOG.info("-->Role Name:[{0}]", rolevalues[1]);
							roleData.setSysId(rolevalues[0]);
						}
					} else{
						LOG.info("SysID:[{0}]", roleData.getSysId());
					}
					if (roleAction != null){
						roleData.setAction(roleAction);
					} else if (inputValueMap.get("action") != null){
						roleData.setAction(
								inputValueMap.get("action").getValue().get(0).toString());
					}
					LOG.info("******************************************************");
					roleDataList.add(roleData);
				}
				requestDetails.setRoles(arrayOfRoleData);
			} else if(attrName.equalsIgnoreCase("validFrom") || 
					attrName.equalsIgnoreCase("validto")){
				LOG.info("Setting ValidFrom/ValidTo....");
				setCalendar(clazz, requestDetails, attrName, valueObj);
			} else if(attrName.equalsIgnoreCase("action")){
				roleAction = valueObj.toString();
			// Below condition is for SAP UME to add roles	--Jagadeesh
			}else if(attrName.equalsIgnoreCase("roleId")){
				ArrayOfRoleData arrayOfRoleData = new ArrayOfRoleData();
				List<RoleData> roleDataList = arrayOfRoleData.getRoleData();
				
				RoleData roleData = new RoleData();
				value = util.filterAttrValue1(valueObj.toString());
				LOG.info("Filtered AttrValue:[{0}]",value);
				util.getMethod(RoleData.class, 
						util.getMethodName(RoleData.class, attrName,
								"set"), String.class).invoke(roleData, value);	
			
			if(roleData.getSysId()== null || roleData.getSysId().trim().length()==0){
				LOG.info("SysID not exist so using sysID which is prefixed with role name");
				String tmp= inputValueMap.get("application").getValue().get(0).toString();
					roleData.setSysId(tmp.substring(tmp.indexOf("~")+1));
			} else{
				LOG.info("SysID:[{0}]", roleData.getSysId());
			}
			if (roleAction != null){
				roleData.setAction(roleAction);
			} else if (inputValueMap.get("action") != null){
				roleData.setAction(
						inputValueMap.get("action").getValue().get(0).toString());
			}
			roleDataList.add(roleData);
			requestDetails.setRoles(arrayOfRoleData);
		} else {
				value = util.filterAttrValue(valueObj.toString());
				LOG.info("attrName:[{0}]", attrName);
				LOG.info("value:[{0}]", value);
				
				util.getMethod(clazz, util.getMethodName(clazz, attrName,
						"set"), String.class).invoke(requestDetails, value);
			}
		}
		
		return requestDetails;
	}
	
	/**
	 * Method creating and setting calendar object
	 * @param clazz
	 * @param instance
	 * @param attrName
	 * @param valueObj
	 * @throws Exception
	 */
	private void setCalendar(Class<? extends Object> clazz, Object instance, 
			String attrName, Object valueObj) throws Exception {
		if(valueObj == null){
			return;
		}
		long longValue = Long.valueOf(util.filterAttrValue(valueObj.toString()));
		if(longValue <= 0){
			return;
		}
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(new Date(longValue));
		LOG.info("attrName:[{0}]", attrName);
		LOG.info("Date:[{0}]", cal);
		XMLGregorianCalendar xmlCal = new XMLGregorianCalendarImpl(cal);
		
		util.getMethod(clazz, util.getMethodName(clazz, attrName, 
				"set"), XMLGregorianCalendar.class).invoke(instance, xmlCal);
	}
	
	/**
	 * Method preparing required data for webservice call 
	 * and constructing result Hashmap with two parameters as follows,
	 * (1)RequestNo
	 * (2)Status
	 * 
	 * Required convention for "Status" parameter value,
	 * 0_<Success message returned by SAP> 
	 * 4_<Failure message returned by SAP> 
	 * 1_<Exception message got while invoking web service>
	 * 
	 * @param inputValueMap
	 * @return
	 */
	public Map<String, Object> callService(Map<String, Object> inputDataMap) {
		LOG.info("--->callService - SubmitRequest input:[{0}]",inputDataMap);
		Map<String, Object> returnMap = new HashMap<String, Object>(3, 0.75f);
		StringBuffer statusMsg = null;
		Map<String, Attribute> attrMap = null;
		util = new WsClientUtil();
		try {
			attrMap = (Map<String, Attribute>)inputDataMap.get(KEY_FORM_DATA);
			RequestDetailsData requestDetailsData = marshalReqDetails(attrMap);
			//testing
			//inputDataMap.put(KEY_AC_URL, "http://172.26.144.64:50000/SAPGRC_AC_IDM_SUBMITREQUEST/Config1?wsdl");
			
			Map<String, Object> configMap = (Map)inputDataMap.get(KEY_CONFIG_DATA);
			//Start :: BUG 17288932
//			configMap.put(KEY_AC_URL, 
//					util.buildURL((String)configMap.get("server"),
//							(String)configMap.get("port"),"SAPGRC_AC_IDM_SUBMITREQUEST/Config1?wsdl"));
			LOG.info("SubmitRequestWSDLPath:[{0}]"+configMap.get("submitRequestWSDLPath"));
			configMap.put(KEY_AC_URL,configMap.get("submitRequestWSDLPath"));
			//End :: BUG 17288932
			URL url = new URL(configMap.get(KEY_AC_URL).toString());
			QName qName = new QName("urn:SAPGRC_AC_IDM_SUBMITREQUESTWsd", 
					"SAPGRC_AC_IDM_SUBMITREQUEST");
			
			SAPGRCACIDMSUBMITREQUEST req = new SAPGRCACIDMSUBMITREQUEST(url,qName);
			_port = req.getConfig1PortDocument();
			
			util.setCredentials((BindingProvider)_port, configMap, false);
			LOG.error("Perf: callService-SubmitRequest entered");
			RequestSubmissionResult result = _port.getSubmitRequest(requestDetailsData);
			LOG.error("Perf: callService-SubmitRequest exited");
			statusMsg = new StringBuffer();
			if (result != null ) {
				ServiceStatusDTO serviceStatusDto = result.getStatus();
				if(serviceStatusDto != null) {
					if("SUCCESS".equalsIgnoreCase(serviceStatusDto.getMsgType())){
						statusMsg.append("0_");
						statusMsg.append(serviceStatusDto.getMsgType());
						statusMsg.append("_");
						statusMsg.append(serviceStatusDto.getMsgDesc());
						returnMap.put("RequestNo",result.getRequestNo());
					} else {
						statusMsg.append("4_");
						statusMsg.append(serviceStatusDto.getMsgType());
						statusMsg.append("_");
						statusMsg.append(serviceStatusDto.getMsgDesc());
					}
				} else {
					statusMsg.append("4_");
					statusMsg.append("No status message found");
				}
			} else {
				statusMsg.append("4_");
				statusMsg.append("No result and status message from webservice");
			}
			returnMap.put(STATUS,statusMsg.toString());
		} catch (Exception e) {
			LOG.error(e, "SubmitRequest failed");
			//Exception suppressed!
			statusMsg = new StringBuffer("1_");
			statusMsg.append(e.getMessage());
			//setting output map - parameter 2 - exception case - 1
			returnMap.put(STATUS, statusMsg.toString());
		}
		LOG.info("returnMap:[{0}]", returnMap);
		return returnMap;
	}
	

}
