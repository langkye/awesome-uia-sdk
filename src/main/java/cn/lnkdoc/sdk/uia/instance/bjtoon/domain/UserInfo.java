package cn.lnkdoc.sdk.uia.instance.bjtoon.domain;

import java.io.Serializable;

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
public class UserInfo implements Serializable {

	private static final long serialVersionUID = -1087226865178L;
	/**
	 * 全局唯一标识
	 */
	private String uniqueId;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 绑定手机号
	 */
	private String mobile;
	/**
	 * 姓名
	 */
	private String certName;
	/**
	 * 身份证号(加密值)
	 */
	private String certNo;
	/**
	 * 身份证件类型
	 */
	private String certNoType;
	/**
	 * 身份证件名称
	 */
	private String certNoTypeName;
	/**
	 * <pre>
	 * 认证级别：L1、L2、L3、L4。
	 * 		L1：未认证，匿名；
	 * 		L2：身份证（姓名、身份证号）认证；
	 * 		L3：人脸识别或者银行卡四要素认证；
	 * 		L4：线下（实体大厅）认证
	 * </pre>	
	 */
	private String certLevel;
	/**
	 * 邮箱
	 */
	private String mail;
	/**
	 * 性别：0 男，1 女
	 */
	private Integer sex;
	/**
	 * 出生日期
	 */
	private String birthday;
	/**
	 * 民族
	 */
	private String ethnicity;
	/**
	 * 市民卡号
	 */
	private String toonNo;
	/**
	 * userId,对内输出使用
	 */
	private String userId;

	/**
	 * 登录状态标识
	 */
	private String personToken;
	/**
     * 生日
	 */
	private String birthDay;
	private String clientId;
	private String version;


	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCertName() {
		return certName;
	}

	public void setCertName(String certName) {
		this.certName = certName;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getCertNoType() {
		return certNoType;
	}

	public void setCertNoType(String certNoType) {
		this.certNoType = certNoType;
	}

	public String getCertNoTypeName() {
		return certNoTypeName;
	}

	public void setCertNoTypeName(String certNoTypeName) {
		this.certNoTypeName = certNoTypeName;
	}

	public String getCertLevel() {
		return certLevel;
	}

	public void setCertLevel(String certLevel) {
		this.certLevel = certLevel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	public String getToonNo() {
		return toonNo;
	}

	public void setToonNo(String toonNo) {
		this.toonNo = toonNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPersonToken() {
		return personToken;
	}

	public void setPersonToken(String personToken) {
		this.personToken = personToken;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
