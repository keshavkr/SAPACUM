
package oracle.iam.ws.sap.ac10.lookup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BusProcList" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracSWsLuOpBusProcWrap"/>
 *         &lt;element name="BusSubProcList" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracSWsLuOpBusSprocWrap"/>
 *         &lt;element name="CommunicationTypeList" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracSWsLuOpCommnTypWrap"/>
 *         &lt;element name="CriticalLevelList" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracSWsLuOpCritLvlWrap"/>
 *         &lt;element name="CustomFieldDetails" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracSWsLuOpCstflValWrap"/>
 *         &lt;element name="EmployeeTypeList" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracSWsLuOpEmptypeWrap"/>
 *         &lt;element name="FunctionAreaList" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracSWsLuOpFuncAreaWrap"/>
 *         &lt;element name="ItemProvActionList" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracSWsLuOpItemActnWrap"/>
 *         &lt;element name="ItemProvTypeList" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracSWsLuOpReqActnWrap"/>
 *         &lt;element name="LandscapeList" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracSWsLuOpLandscapeWrap"/>
 *         &lt;element name="OmObjectIdList" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracSWsLuOpOmObjIdWrap"/>
 *         &lt;element name="OmObjectTypeList" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracSWsLuOpOmObjtypWrap"/>
 *         &lt;element name="PhaseList" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracSWsLuOpPhaseWrap"/>
 *         &lt;element name="PriorityTypeList" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracSWsLuOpPriorityWrap"/>
 *         &lt;element name="ProjectReleaseList" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracSWsLuOpPrjRelsWrap"/>
 *         &lt;element name="RequestCustomFieldsList" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracSWsLuOpCustFldWrap"/>
 *         &lt;element name="RequestTypeList" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracSWsLuOpReqTypWrap"/>
 *         &lt;element name="RoleCustomFieldsList" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracSWsLuOpCustFldWrap"/>
 *         &lt;element name="RoleSensitivityList" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracSWsLuOpRoleSensWrap"/>
 *         &lt;element name="RoleStatusList" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracSWsLuOpRoleStatWrap"/>
 *         &lt;element name="RoleTypeList" type="{urn:sap-com:document:sap:soap:functions:mc-style}GracSWsLuOpRoleTypeWrap"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "busProcList",
    "busSubProcList",
    "communicationTypeList",
    "criticalLevelList",
    "customFieldDetails",
    "employeeTypeList",
    "functionAreaList",
    "itemProvActionList",
    "itemProvTypeList",
    "landscapeList",
    "omObjectIdList",
    "omObjectTypeList",
    "phaseList",
    "priorityTypeList",
    "projectReleaseList",
    "requestCustomFieldsList",
    "requestTypeList",
    "roleCustomFieldsList",
    "roleSensitivityList",
    "roleStatusList",
    "roleTypeList"
})
@XmlRootElement(name = "GracIdmLookupServicesResponse")
public class GracIdmLookupServicesResponse {

    @XmlElement(name = "BusProcList", required = true)
    protected GracSWsLuOpBusProcWrap busProcList;
    @XmlElement(name = "BusSubProcList", required = true)
    protected GracSWsLuOpBusSprocWrap busSubProcList;
    @XmlElement(name = "CommunicationTypeList", required = true)
    protected GracSWsLuOpCommnTypWrap communicationTypeList;
    @XmlElement(name = "CriticalLevelList", required = true)
    protected GracSWsLuOpCritLvlWrap criticalLevelList;
    @XmlElement(name = "CustomFieldDetails", required = true)
    protected GracSWsLuOpCstflValWrap customFieldDetails;
    @XmlElement(name = "EmployeeTypeList", required = true)
    protected GracSWsLuOpEmptypeWrap employeeTypeList;
    @XmlElement(name = "FunctionAreaList", required = true)
    protected GracSWsLuOpFuncAreaWrap functionAreaList;
    @XmlElement(name = "ItemProvActionList", required = true)
    protected GracSWsLuOpItemActnWrap itemProvActionList;
    @XmlElement(name = "ItemProvTypeList", required = true)
    protected GracSWsLuOpReqActnWrap itemProvTypeList;
    @XmlElement(name = "LandscapeList", required = true)
    protected GracSWsLuOpLandscapeWrap landscapeList;
    @XmlElement(name = "OmObjectIdList", required = true)
    protected GracSWsLuOpOmObjIdWrap omObjectIdList;
    @XmlElement(name = "OmObjectTypeList", required = true)
    protected GracSWsLuOpOmObjtypWrap omObjectTypeList;
    @XmlElement(name = "PhaseList", required = true)
    protected GracSWsLuOpPhaseWrap phaseList;
    @XmlElement(name = "PriorityTypeList", required = true)
    protected GracSWsLuOpPriorityWrap priorityTypeList;
    @XmlElement(name = "ProjectReleaseList", required = true)
    protected GracSWsLuOpPrjRelsWrap projectReleaseList;
    @XmlElement(name = "RequestCustomFieldsList", required = true)
    protected GracSWsLuOpCustFldWrap requestCustomFieldsList;
    @XmlElement(name = "RequestTypeList", required = true)
    protected GracSWsLuOpReqTypWrap requestTypeList;
    @XmlElement(name = "RoleCustomFieldsList", required = true)
    protected GracSWsLuOpCustFldWrap roleCustomFieldsList;
    @XmlElement(name = "RoleSensitivityList", required = true)
    protected GracSWsLuOpRoleSensWrap roleSensitivityList;
    @XmlElement(name = "RoleStatusList", required = true)
    protected GracSWsLuOpRoleStatWrap roleStatusList;
    @XmlElement(name = "RoleTypeList", required = true)
    protected GracSWsLuOpRoleTypeWrap roleTypeList;

    /**
     * Gets the value of the busProcList property.
     * 
     * @return
     *     possible object is
     *     {@link GracSWsLuOpBusProcWrap }
     *     
     */
    public GracSWsLuOpBusProcWrap getBusProcList() {
        return busProcList;
    }

    /**
     * Sets the value of the busProcList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracSWsLuOpBusProcWrap }
     *     
     */
    public void setBusProcList(GracSWsLuOpBusProcWrap value) {
        this.busProcList = value;
    }

    /**
     * Gets the value of the busSubProcList property.
     * 
     * @return
     *     possible object is
     *     {@link GracSWsLuOpBusSprocWrap }
     *     
     */
    public GracSWsLuOpBusSprocWrap getBusSubProcList() {
        return busSubProcList;
    }

    /**
     * Sets the value of the busSubProcList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracSWsLuOpBusSprocWrap }
     *     
     */
    public void setBusSubProcList(GracSWsLuOpBusSprocWrap value) {
        this.busSubProcList = value;
    }

    /**
     * Gets the value of the communicationTypeList property.
     * 
     * @return
     *     possible object is
     *     {@link GracSWsLuOpCommnTypWrap }
     *     
     */
    public GracSWsLuOpCommnTypWrap getCommunicationTypeList() {
        return communicationTypeList;
    }

    /**
     * Sets the value of the communicationTypeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracSWsLuOpCommnTypWrap }
     *     
     */
    public void setCommunicationTypeList(GracSWsLuOpCommnTypWrap value) {
        this.communicationTypeList = value;
    }

    /**
     * Gets the value of the criticalLevelList property.
     * 
     * @return
     *     possible object is
     *     {@link GracSWsLuOpCritLvlWrap }
     *     
     */
    public GracSWsLuOpCritLvlWrap getCriticalLevelList() {
        return criticalLevelList;
    }

    /**
     * Sets the value of the criticalLevelList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracSWsLuOpCritLvlWrap }
     *     
     */
    public void setCriticalLevelList(GracSWsLuOpCritLvlWrap value) {
        this.criticalLevelList = value;
    }

    /**
     * Gets the value of the customFieldDetails property.
     * 
     * @return
     *     possible object is
     *     {@link GracSWsLuOpCstflValWrap }
     *     
     */
    public GracSWsLuOpCstflValWrap getCustomFieldDetails() {
        return customFieldDetails;
    }

    /**
     * Sets the value of the customFieldDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracSWsLuOpCstflValWrap }
     *     
     */
    public void setCustomFieldDetails(GracSWsLuOpCstflValWrap value) {
        this.customFieldDetails = value;
    }

    /**
     * Gets the value of the employeeTypeList property.
     * 
     * @return
     *     possible object is
     *     {@link GracSWsLuOpEmptypeWrap }
     *     
     */
    public GracSWsLuOpEmptypeWrap getEmployeeTypeList() {
        return employeeTypeList;
    }

    /**
     * Sets the value of the employeeTypeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracSWsLuOpEmptypeWrap }
     *     
     */
    public void setEmployeeTypeList(GracSWsLuOpEmptypeWrap value) {
        this.employeeTypeList = value;
    }

    /**
     * Gets the value of the functionAreaList property.
     * 
     * @return
     *     possible object is
     *     {@link GracSWsLuOpFuncAreaWrap }
     *     
     */
    public GracSWsLuOpFuncAreaWrap getFunctionAreaList() {
        return functionAreaList;
    }

    /**
     * Sets the value of the functionAreaList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracSWsLuOpFuncAreaWrap }
     *     
     */
    public void setFunctionAreaList(GracSWsLuOpFuncAreaWrap value) {
        this.functionAreaList = value;
    }

    /**
     * Gets the value of the itemProvActionList property.
     * 
     * @return
     *     possible object is
     *     {@link GracSWsLuOpItemActnWrap }
     *     
     */
    public GracSWsLuOpItemActnWrap getItemProvActionList() {
        return itemProvActionList;
    }

    /**
     * Sets the value of the itemProvActionList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracSWsLuOpItemActnWrap }
     *     
     */
    public void setItemProvActionList(GracSWsLuOpItemActnWrap value) {
        this.itemProvActionList = value;
    }

    /**
     * Gets the value of the itemProvTypeList property.
     * 
     * @return
     *     possible object is
     *     {@link GracSWsLuOpReqActnWrap }
     *     
     */
    public GracSWsLuOpReqActnWrap getItemProvTypeList() {
        return itemProvTypeList;
    }

    /**
     * Sets the value of the itemProvTypeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracSWsLuOpReqActnWrap }
     *     
     */
    public void setItemProvTypeList(GracSWsLuOpReqActnWrap value) {
        this.itemProvTypeList = value;
    }

    /**
     * Gets the value of the landscapeList property.
     * 
     * @return
     *     possible object is
     *     {@link GracSWsLuOpLandscapeWrap }
     *     
     */
    public GracSWsLuOpLandscapeWrap getLandscapeList() {
        return landscapeList;
    }

    /**
     * Sets the value of the landscapeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracSWsLuOpLandscapeWrap }
     *     
     */
    public void setLandscapeList(GracSWsLuOpLandscapeWrap value) {
        this.landscapeList = value;
    }

    /**
     * Gets the value of the omObjectIdList property.
     * 
     * @return
     *     possible object is
     *     {@link GracSWsLuOpOmObjIdWrap }
     *     
     */
    public GracSWsLuOpOmObjIdWrap getOmObjectIdList() {
        return omObjectIdList;
    }

    /**
     * Sets the value of the omObjectIdList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracSWsLuOpOmObjIdWrap }
     *     
     */
    public void setOmObjectIdList(GracSWsLuOpOmObjIdWrap value) {
        this.omObjectIdList = value;
    }

    /**
     * Gets the value of the omObjectTypeList property.
     * 
     * @return
     *     possible object is
     *     {@link GracSWsLuOpOmObjtypWrap }
     *     
     */
    public GracSWsLuOpOmObjtypWrap getOmObjectTypeList() {
        return omObjectTypeList;
    }

    /**
     * Sets the value of the omObjectTypeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracSWsLuOpOmObjtypWrap }
     *     
     */
    public void setOmObjectTypeList(GracSWsLuOpOmObjtypWrap value) {
        this.omObjectTypeList = value;
    }

    /**
     * Gets the value of the phaseList property.
     * 
     * @return
     *     possible object is
     *     {@link GracSWsLuOpPhaseWrap }
     *     
     */
    public GracSWsLuOpPhaseWrap getPhaseList() {
        return phaseList;
    }

    /**
     * Sets the value of the phaseList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracSWsLuOpPhaseWrap }
     *     
     */
    public void setPhaseList(GracSWsLuOpPhaseWrap value) {
        this.phaseList = value;
    }

    /**
     * Gets the value of the priorityTypeList property.
     * 
     * @return
     *     possible object is
     *     {@link GracSWsLuOpPriorityWrap }
     *     
     */
    public GracSWsLuOpPriorityWrap getPriorityTypeList() {
        return priorityTypeList;
    }

    /**
     * Sets the value of the priorityTypeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracSWsLuOpPriorityWrap }
     *     
     */
    public void setPriorityTypeList(GracSWsLuOpPriorityWrap value) {
        this.priorityTypeList = value;
    }

    /**
     * Gets the value of the projectReleaseList property.
     * 
     * @return
     *     possible object is
     *     {@link GracSWsLuOpPrjRelsWrap }
     *     
     */
    public GracSWsLuOpPrjRelsWrap getProjectReleaseList() {
        return projectReleaseList;
    }

    /**
     * Sets the value of the projectReleaseList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracSWsLuOpPrjRelsWrap }
     *     
     */
    public void setProjectReleaseList(GracSWsLuOpPrjRelsWrap value) {
        this.projectReleaseList = value;
    }

    /**
     * Gets the value of the requestCustomFieldsList property.
     * 
     * @return
     *     possible object is
     *     {@link GracSWsLuOpCustFldWrap }
     *     
     */
    public GracSWsLuOpCustFldWrap getRequestCustomFieldsList() {
        return requestCustomFieldsList;
    }

    /**
     * Sets the value of the requestCustomFieldsList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracSWsLuOpCustFldWrap }
     *     
     */
    public void setRequestCustomFieldsList(GracSWsLuOpCustFldWrap value) {
        this.requestCustomFieldsList = value;
    }

    /**
     * Gets the value of the requestTypeList property.
     * 
     * @return
     *     possible object is
     *     {@link GracSWsLuOpReqTypWrap }
     *     
     */
    public GracSWsLuOpReqTypWrap getRequestTypeList() {
        return requestTypeList;
    }

    /**
     * Sets the value of the requestTypeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracSWsLuOpReqTypWrap }
     *     
     */
    public void setRequestTypeList(GracSWsLuOpReqTypWrap value) {
        this.requestTypeList = value;
    }

    /**
     * Gets the value of the roleCustomFieldsList property.
     * 
     * @return
     *     possible object is
     *     {@link GracSWsLuOpCustFldWrap }
     *     
     */
    public GracSWsLuOpCustFldWrap getRoleCustomFieldsList() {
        return roleCustomFieldsList;
    }

    /**
     * Sets the value of the roleCustomFieldsList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracSWsLuOpCustFldWrap }
     *     
     */
    public void setRoleCustomFieldsList(GracSWsLuOpCustFldWrap value) {
        this.roleCustomFieldsList = value;
    }

    /**
     * Gets the value of the roleSensitivityList property.
     * 
     * @return
     *     possible object is
     *     {@link GracSWsLuOpRoleSensWrap }
     *     
     */
    public GracSWsLuOpRoleSensWrap getRoleSensitivityList() {
        return roleSensitivityList;
    }

    /**
     * Sets the value of the roleSensitivityList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracSWsLuOpRoleSensWrap }
     *     
     */
    public void setRoleSensitivityList(GracSWsLuOpRoleSensWrap value) {
        this.roleSensitivityList = value;
    }

    /**
     * Gets the value of the roleStatusList property.
     * 
     * @return
     *     possible object is
     *     {@link GracSWsLuOpRoleStatWrap }
     *     
     */
    public GracSWsLuOpRoleStatWrap getRoleStatusList() {
        return roleStatusList;
    }

    /**
     * Sets the value of the roleStatusList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracSWsLuOpRoleStatWrap }
     *     
     */
    public void setRoleStatusList(GracSWsLuOpRoleStatWrap value) {
        this.roleStatusList = value;
    }

    /**
     * Gets the value of the roleTypeList property.
     * 
     * @return
     *     possible object is
     *     {@link GracSWsLuOpRoleTypeWrap }
     *     
     */
    public GracSWsLuOpRoleTypeWrap getRoleTypeList() {
        return roleTypeList;
    }

    /**
     * Sets the value of the roleTypeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracSWsLuOpRoleTypeWrap }
     *     
     */
    public void setRoleTypeList(GracSWsLuOpRoleTypeWrap value) {
        this.roleTypeList = value;
    }

}
