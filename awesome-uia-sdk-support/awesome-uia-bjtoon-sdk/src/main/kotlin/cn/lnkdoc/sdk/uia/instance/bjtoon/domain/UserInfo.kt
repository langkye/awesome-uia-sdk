package cn.lnkdoc.sdk.uia.instance.bjtoon.domain

import java.io.Serializable


/**
 *
 * UserInfo Object to be returned
 * <pre>备注：
 * 1、返回值中的 uniqueId 表示全局用户唯一标识，三方系统获取后必须建立本地用户与该 uniqueId 的关联；
 * 2、返回的身份证号 certNo，为 AES 对称加密密文，解密秘钥为 client_secret；
 * 3、返回值中的 meta.code 表示返回码，返回码为 0，表示接口调用成功，其他值表示调用异常;meta.message 表示返回码对应的消息；
</pre> *
 * @author qinyi
 * @version  v 1.0 2018-10-23
 */
@Suppress("unused")
open class UserInfo : Serializable {
    /**
     * 全局唯一标识
     */
    var uniqueId: String? = null
    /**
     * 用户名
     */
    var userName: String? = null
    /**
     * 绑定手机号
     */
    var mobile: String? = null
    /**
     * 姓名
     */
    var certName: String? = null
    /**
     * 身份证号(加密值)
     */
    var certNo: String? = null
    /**
     * 身份证件类型
     */
    var certNoType: String? = null
    /**
     * 身份证件名称
     */
    var certNoTypeName: String? = null
    /**
     * <pre>
     * 认证级别：L1、L2、L3、L4。
     * L1：未认证，匿名；
     * L2：身份证（姓名、身份证号）认证；
     * L3：人脸识别或者银行卡四要素认证；
     * L4：线下（实体大厅）认证
    </pre> *
     */
    var certLevel: String? = null
    /**
     * 邮箱
     */
    var mail: String? = null
    /**
     * 性别：0 男，1 女
     */
    var sex: Int? = null
    /**
     * 出生日期
     */
    var birthday: String? = null
    /**
     * 民族
     */
    var ethnicity: String? = null
    /**
     * 市民卡号
     */
    var toonNo: String? = null
    /**
     * userId,对内输出使用
     */
    var userId: String? = null
    /**
     * 登录状态标识
     */
    var personToken: String? = null
    /**
     * 生日
     */
    var birthDay: String? = null
    /**
     * clientId
     */
    var clientId: String? = null
    /**
     * version
     */
    var version: String? = null

    companion object {
        private const val serialVersionUID = -1087226865178L
    }
}
