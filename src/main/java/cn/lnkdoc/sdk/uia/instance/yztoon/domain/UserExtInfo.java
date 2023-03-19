package cn.lnkdoc.sdk.uia.instance.yztoon.domain;

/**
 * 扩展信息中的字段（除粗体标识的字段外）来自法人库等第三方数据源，所 有字段均可能为空，且平台目前不能保证所有信息的真实性和准确性。
 * 建议业务 系统在对接集成对接时，对业务事项要用到的字段数据进行空值判断的处理，且 用户可以对相关的字段数据进行确认和修正。
 * @author langkye
 */
@SuppressWarnings(value = {"unused"})
public class UserExtInfo {
    /**
     * 机构名称
     */
    private String orgName;
    /**
     * 组织机构代码
     */
    private String orgCode;
    /**
     * 注册号
     */
    private String regNo;
    /**
     * 统一社会信用代码
     */
    private String unionCode;
    /**
     * 组织机构类型代码
     */
    private String orgTypeCode;
    /**
     * 组织机构地址
     */
    private String orgAddress;
    /**
     * 法定代表人姓名
     */
    private String legalPerson;
    /**
     * 成立日期
     */
    private String regDate;
    /**
     * 企业联系电话（座机）
     */
    private String telNo;
    /**
     * 机构状态
     */
    private String status;
    /**
     * 企业经济类型（企业性 质）
     */
    private String ecnomicCode;
    /**
     * 行业类别代码
     */
    private String industryCode;
    /**
     * 注册地址行政区划代码
     */
    private String businessScope;
    /**
     * 经营(业务)范围
     */
    private String areaCode;
    /**
     * 营业执照号
     */
    private String bizCode;
    /**
     * 社保号
     */
    private String socialCode;
    /**
     * 税务登记号
     */
    private String taxCode;
    /**
     * 计算机代码
     */
    private String comCode;
    /**
     * 企业邮编
     */
    private String zipCode;
    /**
     * 企业联系人
     */
    private String linkPerson;
    /**
     * 联系人部门职务
     */
    private String duty;
    /**
     * 联系人邮箱
     */
    private String email;
    /**
     * 联系人手机号
     */
    private String mobilePhone;
    /**
     * 联系人办公电话
     */
    private String telPhone;
    /**
     * 联系人传真
     */
    private String fax;
    /**
     * 联系人关联业务信息
     */
    private String bizType;
    /**
     * 企业名称（英文）
     */
    private String orgEname;
    /**
     * 企业注册资金
     */
    private String regMoney;
    /**
     * 国税税务登记证号
     */
    private String satNo;
    /**
     * 法定代表人职务
     */
    private String legalPersonDuty;
    /**
     * 法定代表身份证号
     */
    private String legalPersonId;
    /**
     * 法定代表人电话
     */
    private String legalPersonPhone;
    /**
     * 企业办公地址
     */
    private String officeAddress;
    /**
     * 企业办公邮编
     */
    private String officeAddCode;
    /**
     * 主要股东及持股情况
     */
    private String stockHolder;
    /**
     * 企业扩展信息
     */
    private String infoExt1;
    /**
     * 企业扩展信息
     */
    private String infoExt2;
    /**
     * 办理人姓名
     */
    private String blrName;
    /**
     * 办理人身份证号
     */
    private String blrCardid;
    /**
     * 办理人手机
     */
    private String blrMobile;
    /**
     * 办理人邮箱
     */
    private String blrEmail;
    
    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getUnionCode() {
        return unionCode;
    }

    public void setUnionCode(String unionCode) {
        this.unionCode = unionCode;
    }

    public String getOrgTypeCode() {
        return orgTypeCode;
    }

    public void setOrgTypeCode(String orgTypeCode) {
        this.orgTypeCode = orgTypeCode;
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEcnomicCode() {
        return ecnomicCode;
    }

    public void setEcnomicCode(String ecnomicCode) {
        this.ecnomicCode = ecnomicCode;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getSocialCode() {
        return socialCode;
    }

    public void setSocialCode(String socialCode) {
        this.socialCode = socialCode;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getLinkPerson() {
        return linkPerson;
    }

    public void setLinkPerson(String linkPerson) {
        this.linkPerson = linkPerson;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getOrgEname() {
        return orgEname;
    }

    public void setOrgEname(String orgEname) {
        this.orgEname = orgEname;
    }

    public String getRegMoney() {
        return regMoney;
    }

    public void setRegMoney(String regMoney) {
        this.regMoney = regMoney;
    }

    public String getSatNo() {
        return satNo;
    }

    public void setSatNo(String satNo) {
        this.satNo = satNo;
    }

    public String getLegalPersonDuty() {
        return legalPersonDuty;
    }

    public void setLegalPersonDuty(String legalPersonDuty) {
        this.legalPersonDuty = legalPersonDuty;
    }

    public String getLegalPersonId() {
        return legalPersonId;
    }

    public void setLegalPersonId(String legalPersonId) {
        this.legalPersonId = legalPersonId;
    }

    public String getLegalPersonPhone() {
        return legalPersonPhone;
    }

    public void setLegalPersonPhone(String legalPersonPhone) {
        this.legalPersonPhone = legalPersonPhone;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getOfficeAddCode() {
        return officeAddCode;
    }

    public void setOfficeAddCode(String officeAddCode) {
        this.officeAddCode = officeAddCode;
    }

    public String getStockHolder() {
        return stockHolder;
    }

    public void setStockHolder(String stockHolder) {
        this.stockHolder = stockHolder;
    }

    public String getInfoExt1() {
        return infoExt1;
    }

    public void setInfoExt1(String infoExt1) {
        this.infoExt1 = infoExt1;
    }

    public String getInfoExt2() {
        return infoExt2;
    }

    public void setInfoExt2(String infoExt2) {
        this.infoExt2 = infoExt2;
    }

    public String getBlrName() {
        return blrName;
    }

    public void setBlrName(String blrName) {
        this.blrName = blrName;
    }

    public String getBlrCardid() {
        return blrCardid;
    }

    public void setBlrCardid(String blrCardid) {
        this.blrCardid = blrCardid;
    }

    public String getBlrMobile() {
        return blrMobile;
    }

    public void setBlrMobile(String blrMobile) {
        this.blrMobile = blrMobile;
    }

    public String getBlrEmail() {
        return blrEmail;
    }

    public void setBlrEmail(String blrEmail) {
        this.blrEmail = blrEmail;
    }
}