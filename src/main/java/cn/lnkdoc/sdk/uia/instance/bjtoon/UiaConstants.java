package cn.lnkdoc.sdk.uia.instance.bjtoon;

/**
 *
 * General Constants
 *
 * @author qinyi
 * @version  v 1.0 2018-10-22
 */
@SuppressWarnings(value = {"unused"})
public class UiaConstants {

	/**
	 * RETURN_CODE_SUCCESS
	 */
	public static final CodeMessage RETURN_CODE_SUCCESS = new CodeMessage(0, "成功");
	/**
	 * RETURN_CODE_UNKNOWN_ERROR
	 */
	public static final CodeMessage RETURN_CODE_UNKNOWN_ERROR = new CodeMessage(59999, "未知异常");
	/**
	 * HTTP_RESPONSE_SUCCESS_CODE
	 */
	public static final Integer HTTP_RESPONSE_SUCCESS_CODE 	  = 0;
	/**
	 * API_SUCCESS_DATA
	 */
	public static final Integer API_SUCCESS_DATA 		  = 0;
	/**
	 * Default Http Timeout
	 */
	public static final Integer CONNECTION_REQUEST_TIMEOUT    = 5000;
	/**
	 * CONNECTION_TIMEOUT
	 */
	public static final Integer CONNECTION_TIMEOUT            = 15000;
	/**
	 * SOCKET_TIMEOUT
	 */
	public static final Integer SOCKET_TIMEOUT                = 10000;

	/**
	 * Oauth Client
	 */
	public static final String CLIENT_ID                      = "client_id";
	/**
	 * CLIENT_SECRET
	 */
	public static final String CLIENT_SECRET                  = "client_secret";
	/**
	 * REDIRECT_URI
	 */
	public static final String REDIRECT_URI                   = "redirect_uri";
	/**
	 * GRANT_CODE
	 */
	public static final String GRANT_CODE                     = "grant_code";
	/**
	 * GRANT_TYPE
	 */
	public static final String GRANT_TYPE                     = "grant_type";
	/**
	 * AUTH_TOKEN
	 */
	public static final String AUTH_TOKEN                     = "auth_token";
	/**
	 * STATE
	 */
	public static final String STATE                     	  = "state";
	/**
	 * SCOPE
	 */
	public static final String SCOPE                     	  = "scope";
	/**
	 * TOON_TYPE
	 */
	public static final String TOON_TYPE                      = "toonType";
	/**
	 * IN_TYPE
	 */
	public static final String IN_TYPE                        = "inType";
	/**
	 * LOCAL_CHECK
	 */
	public static final String LOCAL_CHECK                    = "localCheck";
	/**
	 * ACCESS_TOKEN
	 */
	public static final String ACCESS_TOKEN                   = "access_token";

	/**
	 * GRANT_TYPE_CODE
	 */
	public static final String GRANT_TYPE_CODE 				  = "authorization_code";
	/**
	 * GRANT_TYPE_REFRESH
	 */
	public static final String GRANT_TYPE_REFRESH 			  = "refresh_token";
	/**
	 * SCOPE_USER_INFO
	 */
	public static final String SCOPE_USER_INFO 				  = "user_info";

	/**
	 * Cert Level
	 */
	public static final String CERT_LEVEL_L1 				  = "L1";
	/**
	 * CERT_LEVEL_L2
	 */
	public static final String CERT_LEVEL_L2 				  = "L2";
	/**
	 * CERT_LEVEL_L3
	 */
	public static final String CERT_LEVEL_L3 				  = "L3";
	/**
	 * CERT_LEVEL_L4
	 */
	public static final String CERT_LEVEL_L4 				  = "L4";
	/**
	 * Encryption Sign
	 */
	public static final String SIGN_TYPE                      = "sign_type";
	/**
	 * SIGN_TYPE_RSA
	 */
	public static final String SIGN_TYPE_RSA                  = "RSA";
	/**
	 * SIGN_TYPE_MD5
	 */
	public static final String SIGN_TYPE_MD5 				  = "MD5" ;
	/**
	 * SIGN_TYPE_RSA2
	 */
	public static final String SIGN_TYPE_RSA2                 = "RSA2";
	/**
	 * SIGN_ALGORITHMS
	 */
	public static final String SIGN_ALGORITHMS                = "SHA1WithRSA";
	/**
	 * SIGN_SHA256RSA_ALGORITHMS
	 */
	public static final String SIGN_SHA256RSA_ALGORITHMS      = "SHA256WithRSA";
	/**
	 * ENCRYPT_TYPE_AES
	 */
	public static final String ENCRYPT_TYPE_AES               = "AES";
	/**
	 * SIGN
	 */
	public static final String SIGN                           = "sign";
	/**
	 * charset
	 */
	public static final String CHARSET_UTF8                   = "UTF-8";
	/**
	 * CHARSET_GBK
	 */
	public static final String CHARSET_GBK                    = "GBK";


}
