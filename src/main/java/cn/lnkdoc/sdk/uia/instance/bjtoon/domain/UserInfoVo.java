package cn.lnkdoc.sdk.uia.instance.bjtoon.domain;

/**
 *
 * UserInfo Object to be returned
 * <pre>备注：
 *     1、返回值中的 uniqueId 表示全局用户唯一标识，三方系统获取后必须建立本地用户与该 uniqueId 的关联；
 *     2、返回的身份证号 certNo，为 AES 对称加密密文，解密秘钥为 client_secret； 
 *     3、返回值中的 meta.code 表示返回码，返回码为 0，表示接口调用成功，其他值表示调用异常;meta.message 表示返回码对应的消息；
 * </pre>
 * @author qinyi
 * @version  v 1.0 2018-10-23
 */
@SuppressWarnings(value = {"unused"})
public class UserInfoVo extends UserInfo {
}
