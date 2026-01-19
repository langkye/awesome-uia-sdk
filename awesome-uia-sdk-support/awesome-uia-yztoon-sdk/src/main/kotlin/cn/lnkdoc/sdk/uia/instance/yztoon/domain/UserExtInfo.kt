package cn.lnkdoc.sdk.uia.instance.yztoon.domain

/**
 * 扩展信息中的字段（除粗体标识的字段外）来自法人库等第三方数据源，所 有字段均可能为空，且平台目前不能保证所有信息的真实性和准确性。
 * 建议业务 系统在对接集成对接时，对业务事项要用到的字段数据进行空值判断的处理，且 用户可以对相关的字段数据进行确认和修正。
 * @author langkye
 */
@Suppress("unused")
class UserExtInfo {
    /**
     * 机构名称
     */
    var orgName: String? = null
    /**
     * 组织机构代码
     */
    var orgCode: String? = null
    /**
     * 注册号
     */
    var regNo: String? = null
    /**
     * 统一社会信用代码
     */
    var unionCode: String? = null
    /**
     * 组织机构类型代码
     */
    var orgTypeCode: String? = null
    /**
     * 组织机构地址
     */
    var orgAddress: String? = null
    /**
     * 法定代表人姓名
     */
    var legalPerson: String? = null
    /**
     * 成立日期
     */
    var regDate: String? = null
    /**
     * 企业联系电话（座机）
     */
    var telNo: String? = null
    /**
     * 机构状态
     */
    var status: String? = null
    /**
     * 企业经济类型（企业性 质）
     */
    var ecnomicCode: String? = null
    /**
     * 行业类别代码
     */
    var industryCode: String? = null
    /**
     * 注册地址行政区划代码
     */
    var businessScope: String? = null
    /**
     * 经营(业务)范围
     */
    var areaCode: String? = null
    /**
     * 营业执照号
     */
    var bizCode: String? = null
    /**
     * 社保号
     */
    var socialCode: String? = null
    /**
     * 税务登记号
     */
    var taxCode: String? = null
    /**
     * 计算机代码
     */
    var comCode: String? = null
    /**
     * 企业邮编
     */
    var zipCode: String? = null
    /**
     * 企业联系人
     */
    var linkPerson: String? = null
    /**
     * 联系人部门职务
     */
    var duty: String? = null
    /**
     * 联系人邮箱
     */
    var email: String? = null
    /**
     * 联系人手机号
     */
    var mobilePhone: String? = null
    /**
     * 联系人办公电话
     */
    var telPhone: String? = null
    /**
     * 联系人传真
     */
    var fax: String? = null
    /**
     * 联系人关联业务信息
     */
    var bizType: String? = null
    /**
     * 企业名称（英文）
     */
    var orgEname: String? = null
    /**
     * 企业注册资金
     */
    var regMoney: String? = null
    /**
     * 国税税务登记证号
     */
    var satNo: String? = null
    /**
     * 法定代表人职务
     */
    var legalPersonDuty: String? = null
    /**
     * 法定代表身份证号
     */
    var legalPersonId: String? = null
    /**
     * 法定代表人电话
     */
    var legalPersonPhone: String? = null
    /**
     * 企业办公地址
     */
    var officeAddress: String? = null
    /**
     * 企业办公邮编
     */
    var officeAddCode: String? = null
    /**
     * 主要股东及持股情况
     */
    var stockHolder: String? = null
    /**
     * 企业扩展信息
     */
    var infoExt1: String? = null
    /**
     * 企业扩展信息
     */
    var infoExt2: String? = null
    /**
     * 办理人姓名
     */
    var blrName: String? = null
    /**
     * 办理人身份证号
     */
    var blrCardid: String? = null
    /**
     * 办理人手机
     */
    var blrMobile: String? = null
    /**
     * 办理人邮箱
     */
    var blrEmail: String? = null
}