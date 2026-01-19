package cn.lnkdoc.sdk.uia.instance.bccastle.domain

import cn.lnkdoc.sdk.uia.instance.bccastle.response.BccastleResponse

/**
 * 用户信息
 * <pre>
 * 错误的Json返回示例:
 * {
 * "errcode":2002,"msg":"参数access_token不正确或过期"
 * }
 * </pre>
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
class UserInfo : BccastleResponse() {
    var country: String? = null
    var sorgId: String? = null
    var updateDate: String? = null
    var mail: String? = null
    var gender: String? = null
    var loginType: String? = null
    var nation: String? = null
    var displayName: String? = null
    var positionNumber: String? = null
    var title: String? = null
    var loginInterceptFlagTwo: Int? = null
    var loginInterceptFlagFour: Int? = null
    var employeeNumber: String? = null
    var changePwdAt: String? = null
    var spRoleList: List<String>? = null
    var uid: String? = null
    var pwdPolicy: String? = null
    var loginInterceptFlagFive: Int? = null
    var loginInterceptFlagThree: Int? = null
    var identityNumber: String? = null
    var identityType: String? = null
    var loginName: String? = null
    var secAccValid: Int? = null
    var pinyinShortName: String? = null
    var orgNumber: String? = null
    var wechatNo: String? = null
    var orgNamePath: String? = null
    var passwordModifyRequired: Int? = null
    var birthDay: String? = null
    var givenName: String? = null
    var mobile: String? = null
    var loginInterceptFlagOne: Int? = null
    var certSn: String? = null
    var employeeType: String? = null
    var orgCodePath: String? = null
    var otpKey: String? = null
    var positionStatus: String? = null
    var departmentNumber: String? = null
    var certDn: String? = null
    var spNameList: List<String>? = null
    var isPassRemind: Int? = null
}
