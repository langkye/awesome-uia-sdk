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

    /**
     * getter
     * 
     * @return orgName
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * setter
     * 
     * @param orgName orgName
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * getter
     * 
     * @return orgCode
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * setter
     * 
     * @param orgCode orgCode
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    /**
     * getter
     * 
     * @return regNo
     */
    public String getRegNo() {
        return regNo;
    }

    /**
     * setter
     * 
     * @param regNo regNo
     */
    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    /**
     * getter
     * 
     * @return unionCode
     */
    public String getUnionCode() {
        return unionCode;
    }

    /**
     * setter
     * 
     * @param unionCode unionCode
     */
    public void setUnionCode(String unionCode) {
        this.unionCode = unionCode;
    }

    /**
     * getter
     * 
     * @return orgTypeCode
     */
    public String getOrgTypeCode() {
        return orgTypeCode;
    }

    /**
     * setter
     * 
     * @param orgTypeCode orgTypeCode
     */
    public void setOrgTypeCode(String orgTypeCode) {
        this.orgTypeCode = orgTypeCode;
    }

    /**
     * getter
     * 
     * @return orgAddress
     */
    public String getOrgAddress() {
        return orgAddress;
    }

    /**
     * setter
     * 
     * @param orgAddress orgAddress
     */
    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress;
    }

    /**
     * getter
     * 
     * @return legalPerson
     */
    public String getLegalPerson() {
        return legalPerson;
    }

    /**
     * setter
     * 
     * @param legalPerson legalPerson
     */
    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    /**
     * getter
     * 
     * @return regDate
     */
    public String getRegDate() {
        return regDate;
    }

    /**
     * setter
     * 
     * @param regDate regDate
     */
    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    /**
     * getter
     * 
     * @return telNo
     */
    public String getTelNo() {
        return telNo;
    }

    /**
     * setter
     * 
     * @param telNo telNo
     */
    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    /**
     * getter
     * 
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * setter
     * 
     * @param status status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * getter
     * 
     * @return ecnomicCode
     */
    public String getEcnomicCode() {
        return ecnomicCode;
    }

    /**
     * setter
     * 
     * @param ecnomicCode ecnomicCode
     */
    public void setEcnomicCode(String ecnomicCode) {
        this.ecnomicCode = ecnomicCode;
    }

    /**
     * getter
     * 
     * @return industryCode
     */
    public String getIndustryCode() {
        return industryCode;
    }

    /**
     * setter
     * 
     * @param industryCode industryCode
     */
    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    /**
     * getter
     * 
     * @return businessScope
     */
    public String getBusinessScope() {
        return businessScope;
    }

    /**
     * setter
     * 
     * @param businessScope businessScope
     */
    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    /**
     * getter
     * 
     * @return areaCode
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * setter
     * 
     * @param areaCode areaCode
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * getter
     * 
     * @return bizCode
     */
    public String getBizCode() {
        return bizCode;
    }

    /**
     * setter
     * 
     * @param bizCode bizCode
     */
    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    /**
     * getter
     * 
     * @return socialCode
     */
    public String getSocialCode() {
        return socialCode;
    }

    /**
     * setter
     * 
     * @param socialCode socialCode
     */
    public void setSocialCode(String socialCode) {
        this.socialCode = socialCode;
    }

    /**
     * getter
     * 
     * @return taxCode
     */
    public String getTaxCode() {
        return taxCode;
    }

    /**
     * setter
     * 
     * @param taxCode taxCode
     */
    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    /**
     * getter
     * 
     * @return comCode
     */
    public String getComCode() {
        return comCode;
    }

    /**
     * setter
     * 
     * @param comCode comCode
     */
    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    /**
     * getter
     * 
     * @return zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * setter
     * 
     * @param zipCode zipCode
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * getter
     * 
     * @return linkPerson
     */
    public String getLinkPerson() {
        return linkPerson;
    }

    /**
     * setter
     * 
     * @param linkPerson linkPerson
     */
    public void setLinkPerson(String linkPerson) {
        this.linkPerson = linkPerson;
    }

    /**
     * getter
     * 
     * @return duty
     */
    public String getDuty() {
        return duty;
    }

    /**
     * setter
     * 
     * @param duty duty
     */
    public void setDuty(String duty) {
        this.duty = duty;
    }

    /**
     * getter
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * setter
     * 
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * getter
     * 
     * @return mobilePhone
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * setter
     * 
     * @param mobilePhone mobilePhone
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * getter
     * 
     * @return telPhone
     */
    public String getTelPhone() {
        return telPhone;
    }

    /**
     * setter
     * 
     * @param telPhone telPhone
     */
    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    /**
     * getter
     * 
     * @return fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * setter
     * 
     * @param fax fax
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * getter
     * 
     * @return bizType
     */
    public String getBizType() {
        return bizType;
    }

    /**
     * setter
     * 
     * @param bizType bizType
     */
    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    /**
     * getter
     * 
     * @return orgEname
     */
    public String getOrgEname() {
        return orgEname;
    }

    /**
     * setter
     * 
     * @param orgEname orgEname
     */
    public void setOrgEname(String orgEname) {
        this.orgEname = orgEname;
    }

    /**
     * getter
     * 
     * @return regMoney
     */
    public String getRegMoney() {
        return regMoney;
    }

    /**
     * setter
     * 
     * @param regMoney regMoney
     */
    public void setRegMoney(String regMoney) {
        this.regMoney = regMoney;
    }

    /**
     * getter
     * 
     * @return satNo
     */
    public String getSatNo() {
        return satNo;
    }

    /**
     * setter
     * 
     * @param satNo satNo
     */
    public void setSatNo(String satNo) {
        this.satNo = satNo;
    }

    /**
     * getter
     * 
     * @return legalPersonDuty
     */
    public String getLegalPersonDuty() {
        return legalPersonDuty;
    }

    /**
     * setter
     * 
     * @param legalPersonDuty legalPersonDuty
     */
    public void setLegalPersonDuty(String legalPersonDuty) {
        this.legalPersonDuty = legalPersonDuty;
    }

    /**
     * getter
     * 
     * @return legalPersonId
     */
    public String getLegalPersonId() {
        return legalPersonId;
    }

    /**
     * setter
     * 
     * @param legalPersonId legalPersonId
     */
    public void setLegalPersonId(String legalPersonId) {
        this.legalPersonId = legalPersonId;
    }

    /**
     * getter
     * 
     * @return legalPersonPhone
     */
    public String getLegalPersonPhone() {
        return legalPersonPhone;
    }

    /**
     * setter
     * 
     * @param legalPersonPhone legalPersonPhone
     */
    public void setLegalPersonPhone(String legalPersonPhone) {
        this.legalPersonPhone = legalPersonPhone;
    }

    /**
     * getter
     * 
     * @return officeAddress
     */
    public String getOfficeAddress() {
        return officeAddress;
    }

    /**
     * setter
     * 
     * @param officeAddress officeAddress
     */
    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    /**
     * getter
     * 
     * @return officeAddCode
     */
    public String getOfficeAddCode() {
        return officeAddCode;
    }

    /**
     * setter
     * 
     * @param officeAddCode officeAddCode
     */
    public void setOfficeAddCode(String officeAddCode) {
        this.officeAddCode = officeAddCode;
    }

    /**
     * getter
     * 
     * @return stockHolder
     */
    public String getStockHolder() {
        return stockHolder;
    }

    /**
     * setter
     * 
     * @param stockHolder stockHolder
     */
    public void setStockHolder(String stockHolder) {
        this.stockHolder = stockHolder;
    }

    /**
     * getter
     * 
     * @return infoExt1
     */
    public String getInfoExt1() {
        return infoExt1;
    }

    /**
     * setter
     * 
     * @param infoExt1 infoExt1
     */
    public void setInfoExt1(String infoExt1) {
        this.infoExt1 = infoExt1;
    }

    /**
     * getter
     * 
     * @return infoExt2
     */
    public String getInfoExt2() {
        return infoExt2;
    }

    /**
     * setter
     * 
     * @param infoExt2 infoExt2
     */
    public void setInfoExt2(String infoExt2) {
        this.infoExt2 = infoExt2;
    }

    /**
     * getter
     * 
     * @return blrName
     */
    public String getBlrName() {
        return blrName;
    }

    /**
     * setter
     * 
     * @param blrName blrName
     */
    public void setBlrName(String blrName) {
        this.blrName = blrName;
    }

    /**
     * getter
     * 
     * @return blrCardid
     */
    public String getBlrCardid() {
        return blrCardid;
    }

    /**
     * setter
     * 
     * @param blrCardid blrCardid
     */
    public void setBlrCardid(String blrCardid) {
        this.blrCardid = blrCardid;
    }

    /**
     * getter
     * 
     * @return blrMobile
     */
    public String getBlrMobile() {
        return blrMobile;
    }

    /**
     * setter
     * 
     * @param blrMobile blrMobile
     */
    public void setBlrMobile(String blrMobile) {
        this.blrMobile = blrMobile;
    }

    /**
     * getter
     * 
     * @return blrEmail
     */
    public String getBlrEmail() {
        return blrEmail;
    }

    /**
     * setter
     * 
     * @param blrEmail blrEmail
     */
    public void setBlrEmail(String blrEmail) {
        this.blrEmail = blrEmail;
    }
}