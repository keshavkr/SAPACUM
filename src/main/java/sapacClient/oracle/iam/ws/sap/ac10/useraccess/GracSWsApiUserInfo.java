
package oracle.iam.ws.sap.ac10.useraccess;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GracSWsApiUserInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GracSWsApiUserInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Userid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Fname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Lname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SncName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UnsecSnc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Accno" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UserGroup" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ValidFrom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ValidTo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Empposition" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Empjob" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Personnelno" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Personnelarea" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CommMethod" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Fax" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Telnumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Department" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Company" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Location" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Costcenter" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Printer" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Orgunit" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Emptype" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Manager" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ManagerEmail" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ManagerFirstname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ManagerLastname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="StartMenu" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LogonLang" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DecNotation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DateFormat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Alias" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UserType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GracSWsApiUserInfo", propOrder = {
    "userid",
    "title",
    "fname",
    "lname",
    "sncName",
    "unsecSnc",
    "accno",
    "userGroup",
    "validFrom",
    "validTo",
    "empposition",
    "empjob",
    "personnelno",
    "personnelarea",
    "commMethod",
    "fax",
    "email",
    "telnumber",
    "department",
    "company",
    "location",
    "costcenter",
    "printer",
    "orgunit",
    "emptype",
    "manager",
    "managerEmail",
    "managerFirstname",
    "managerLastname",
    "startMenu",
    "logonLang",
    "decNotation",
    "dateFormat",
    "alias",
    "userType"
})
public class GracSWsApiUserInfo {

    @XmlElement(name = "Userid", required = true)
    protected String userid;
    @XmlElement(name = "Title", required = true)
    protected String title;
    @XmlElement(name = "Fname", required = true)
    protected String fname;
    @XmlElement(name = "Lname", required = true)
    protected String lname;
    @XmlElement(name = "SncName", required = true)
    protected String sncName;
    @XmlElement(name = "UnsecSnc", required = true)
    protected String unsecSnc;
    @XmlElement(name = "Accno", required = true)
    protected String accno;
    @XmlElement(name = "UserGroup", required = true)
    protected String userGroup;
    @XmlElement(name = "ValidFrom", required = true)
    protected String validFrom;
    @XmlElement(name = "ValidTo", required = true)
    protected String validTo;
    @XmlElement(name = "Empposition", required = true)
    protected String empposition;
    @XmlElement(name = "Empjob", required = true)
    protected String empjob;
    @XmlElement(name = "Personnelno", required = true)
    protected String personnelno;
    @XmlElement(name = "Personnelarea", required = true)
    protected String personnelarea;
    @XmlElement(name = "CommMethod", required = true)
    protected String commMethod;
    @XmlElement(name = "Fax", required = true)
    protected String fax;
    @XmlElement(name = "Email", required = true)
    protected String email;
    @XmlElement(name = "Telnumber", required = true)
    protected String telnumber;
    @XmlElement(name = "Department", required = true)
    protected String department;
    @XmlElement(name = "Company", required = true)
    protected String company;
    @XmlElement(name = "Location", required = true)
    protected String location;
    @XmlElement(name = "Costcenter", required = true)
    protected String costcenter;
    @XmlElement(name = "Printer", required = true)
    protected String printer;
    @XmlElement(name = "Orgunit", required = true)
    protected String orgunit;
    @XmlElement(name = "Emptype", required = true)
    protected String emptype;
    @XmlElement(name = "Manager", required = true)
    protected String manager;
    @XmlElement(name = "ManagerEmail", required = true)
    protected String managerEmail;
    @XmlElement(name = "ManagerFirstname", required = true)
    protected String managerFirstname;
    @XmlElement(name = "ManagerLastname", required = true)
    protected String managerLastname;
    @XmlElement(name = "StartMenu", required = true)
    protected String startMenu;
    @XmlElement(name = "LogonLang", required = true)
    protected String logonLang;
    @XmlElement(name = "DecNotation", required = true)
    protected String decNotation;
    @XmlElement(name = "DateFormat", required = true)
    protected String dateFormat;
    @XmlElement(name = "Alias", required = true)
    protected String alias;
    @XmlElement(name = "UserType", required = true)
    protected String userType;

    /**
     * Gets the value of the userid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserid() {
        return userid;
    }

    /**
     * Sets the value of the userid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserid(String value) {
        this.userid = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the fname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFname() {
        return fname;
    }

    /**
     * Sets the value of the fname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFname(String value) {
        this.fname = value;
    }

    /**
     * Gets the value of the lname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLname() {
        return lname;
    }

    /**
     * Sets the value of the lname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLname(String value) {
        this.lname = value;
    }

    /**
     * Gets the value of the sncName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSncName() {
        return sncName;
    }

    /**
     * Sets the value of the sncName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSncName(String value) {
        this.sncName = value;
    }

    /**
     * Gets the value of the unsecSnc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnsecSnc() {
        return unsecSnc;
    }

    /**
     * Sets the value of the unsecSnc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnsecSnc(String value) {
        this.unsecSnc = value;
    }

    /**
     * Gets the value of the accno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccno() {
        return accno;
    }

    /**
     * Sets the value of the accno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccno(String value) {
        this.accno = value;
    }

    /**
     * Gets the value of the userGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserGroup() {
        return userGroup;
    }

    /**
     * Sets the value of the userGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserGroup(String value) {
        this.userGroup = value;
    }

    /**
     * Gets the value of the validFrom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidFrom() {
        return validFrom;
    }

    /**
     * Sets the value of the validFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidFrom(String value) {
        this.validFrom = value;
    }

    /**
     * Gets the value of the validTo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidTo() {
        return validTo;
    }

    /**
     * Sets the value of the validTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidTo(String value) {
        this.validTo = value;
    }

    /**
     * Gets the value of the empposition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpposition() {
        return empposition;
    }

    /**
     * Sets the value of the empposition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpposition(String value) {
        this.empposition = value;
    }

    /**
     * Gets the value of the empjob property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpjob() {
        return empjob;
    }

    /**
     * Sets the value of the empjob property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpjob(String value) {
        this.empjob = value;
    }

    /**
     * Gets the value of the personnelno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonnelno() {
        return personnelno;
    }

    /**
     * Sets the value of the personnelno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonnelno(String value) {
        this.personnelno = value;
    }

    /**
     * Gets the value of the personnelarea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonnelarea() {
        return personnelarea;
    }

    /**
     * Sets the value of the personnelarea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonnelarea(String value) {
        this.personnelarea = value;
    }

    /**
     * Gets the value of the commMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommMethod() {
        return commMethod;
    }

    /**
     * Sets the value of the commMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommMethod(String value) {
        this.commMethod = value;
    }

    /**
     * Gets the value of the fax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFax() {
        return fax;
    }

    /**
     * Sets the value of the fax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFax(String value) {
        this.fax = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the telnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelnumber() {
        return telnumber;
    }

    /**
     * Sets the value of the telnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelnumber(String value) {
        this.telnumber = value;
    }

    /**
     * Gets the value of the department property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the value of the department property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartment(String value) {
        this.department = value;
    }

    /**
     * Gets the value of the company property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets the value of the company property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompany(String value) {
        this.company = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Gets the value of the costcenter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCostcenter() {
        return costcenter;
    }

    /**
     * Sets the value of the costcenter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCostcenter(String value) {
        this.costcenter = value;
    }

    /**
     * Gets the value of the printer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrinter() {
        return printer;
    }

    /**
     * Sets the value of the printer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrinter(String value) {
        this.printer = value;
    }

    /**
     * Gets the value of the orgunit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgunit() {
        return orgunit;
    }

    /**
     * Sets the value of the orgunit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgunit(String value) {
        this.orgunit = value;
    }

    /**
     * Gets the value of the emptype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmptype() {
        return emptype;
    }

    /**
     * Sets the value of the emptype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmptype(String value) {
        this.emptype = value;
    }

    /**
     * Gets the value of the manager property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManager() {
        return manager;
    }

    /**
     * Sets the value of the manager property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManager(String value) {
        this.manager = value;
    }

    /**
     * Gets the value of the managerEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManagerEmail() {
        return managerEmail;
    }

    /**
     * Sets the value of the managerEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManagerEmail(String value) {
        this.managerEmail = value;
    }

    /**
     * Gets the value of the managerFirstname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManagerFirstname() {
        return managerFirstname;
    }

    /**
     * Sets the value of the managerFirstname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManagerFirstname(String value) {
        this.managerFirstname = value;
    }

    /**
     * Gets the value of the managerLastname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManagerLastname() {
        return managerLastname;
    }

    /**
     * Sets the value of the managerLastname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManagerLastname(String value) {
        this.managerLastname = value;
    }

    /**
     * Gets the value of the startMenu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartMenu() {
        return startMenu;
    }

    /**
     * Sets the value of the startMenu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartMenu(String value) {
        this.startMenu = value;
    }

    /**
     * Gets the value of the logonLang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogonLang() {
        return logonLang;
    }

    /**
     * Sets the value of the logonLang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogonLang(String value) {
        this.logonLang = value;
    }

    /**
     * Gets the value of the decNotation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDecNotation() {
        return decNotation;
    }

    /**
     * Sets the value of the decNotation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDecNotation(String value) {
        this.decNotation = value;
    }

    /**
     * Gets the value of the dateFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateFormat() {
        return dateFormat;
    }

    /**
     * Sets the value of the dateFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateFormat(String value) {
        this.dateFormat = value;
    }

    /**
     * Gets the value of the alias property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Sets the value of the alias property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlias(String value) {
        this.alias = value;
    }

    /**
     * Gets the value of the userType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserType() {
        return userType;
    }

    /**
     * Sets the value of the userType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserType(String value) {
        this.userType = value;
    }

}
