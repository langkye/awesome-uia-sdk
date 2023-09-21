package cn.lnkdoc.sdk.uia.instance.bjtoon.domain;

import java.io.Serial;
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

	@Serial
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
	/**
	 * clientId
	 */
	private String clientId;
	/**
	 * version
	 */
	private String version;


	/**
	 * getter
	 * 
	 * @return uniqueId
	 */
	public String getUniqueId() {
		return uniqueId;
	}

	/**
	 * setter
	 * 
	 * @param uniqueId uniqueId
	 */
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	/**
	 * getter
	 * 
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * setter
	 * 
	 * @param userName userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * getter
	 * 
	 * @return mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * setter
	 * 
	 * @param mobile mobile
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * getter
	 * 
	 * @return certName
	 */
	public String getCertName() {
		return certName;
	}

	/**
	 * setter
	 * 
	 * @param certName certName
	 */
	public void setCertName(String certName) {
		this.certName = certName;
	}

	/**
	 * getter
	 * 
	 * @return certNo
	 */
	public String getCertNo() {
		return certNo;
	}

	/**
	 * setter
	 * 
	 * @param certNo certNo
	 */
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	/**
	 * getter
	 * 
	 * @return certNoType
	 */
	public String getCertNoType() {
		return certNoType;
	}

	/**
	 * setter
	 * 
	 * @param certNoType certNoType
	 */
	public void setCertNoType(String certNoType) {
		this.certNoType = certNoType;
	}

	/**
	 * getter
	 * 
	 * @return certNoTypeName
	 */
	public String getCertNoTypeName() {
		return certNoTypeName;
	}

	/**
	 * setter
	 * 
	 * @param certNoTypeName certNoTypeName
	 */
	public void setCertNoTypeName(String certNoTypeName) {
		this.certNoTypeName = certNoTypeName;
	}

	/**
	 * getter
	 * 
	 * @return certLevel
	 */
	public String getCertLevel() {
		return certLevel;
	}

	/**
	 * setter
	 * 
	 * @param certLevel certLevel
	 */
	public void setCertLevel(String certLevel) {
		this.certLevel = certLevel;
	}

	/**
	 * getter
	 * 
	 * @return mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * setter
	 * 
	 * @param mail mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * getter
	 * 
	 * @return sex
	 */
	public Integer getSex() {
		return sex;
	}

	/**
	 * setter
	 * 
	 * @param sex sex
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	/**
	 * getter
	 * 
	 * @return birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * setter
	 * 
	 * @param birthday birthday
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * getter
	 * 
	 * @return ethnicity
	 */
	public String getEthnicity() {
		return ethnicity;
	}

	/**
	 * setter
	 * 
	 * @param ethnicity ethnicity
	 */
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	/**
	 * getter
	 * 
	 * @return toonNo
	 */
	public String getToonNo() {
		return toonNo;
	}

	/**
	 * setter
	 * 
	 * @param toonNo toonNo
	 */
	public void setToonNo(String toonNo) {
		this.toonNo = toonNo;
	}

	/**
	 * getter
	 * 
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * setter
	 * 
	 * @param userId userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * getter
	 * 
	 * @return personToken
	 */
	public String getPersonToken() {
		return personToken;
	}

	/**
	 * setter
	 * 
	 * @param personToken personToken
	 */
	public void setPersonToken(String personToken) {
		this.personToken = personToken;
	}

	/**
	 * getter
	 * 
	 * @return birthDay
	 */
	public String getBirthDay() {
		return birthDay;
	}

	/**
	 * setter
	 * 
	 * @param birthDay birthDay
	 */
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	/**
	 * getter
	 * 
	 * @return clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * setter
	 * 
	 * @param clientId clientId
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * getter
	 * 
	 * @return version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * setter
	 * 
	 * @param version version
	 */
	public void setVersion(String version) {
		this.version = version;
	}
}
