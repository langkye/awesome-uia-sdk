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


	public static final CodeMessage RETURN_CODE_SUCCESS = new CodeMessage(0, "成功");

	public static final CodeMessage RETURN_CODE_UNKNOWN_ERROR = new CodeMessage(59999, "未知异常");

	public static final Integer HTTP_RESPONSE_SUCCESS_CODE 	  = 0;

	public static final Integer API_SUCCESS_DATA 		  = 0;


	//Default Http Timeout
	public static final Integer CONNECTION_REQUEST_TIMEOUT    = 5000;
	public static final Integer CONNECTION_TIMEOUT            = 15000;
	public static final Integer SOCKET_TIMEOUT                = 10000;

	//Oauth Client
	public static final String CLIENT_ID                      = "client_id";

	public static final String CLIENT_SECRET                  = "client_secret";

	public static final String REDIRECT_URI                   = "redirect_uri";

	public static final String GRANT_CODE                     = "grant_code";

	public static final String GRANT_TYPE                     = "grant_type";

	public static final String AUTH_TOKEN                     = "auth_token";

	public static final String STATE                     	  = "state";

	public static final String SCOPE                     	  = "scope";

	public static final String TOON_TYPE                      = "toonType";

	public static final String IN_TYPE                        = "inType";

	public static final String LOCAL_CHECK                    = "localCheck";

	public static final String ACCESS_TOKEN                   = "access_token";


	public static final String GRANT_TYPE_CODE 				  = "authorization_code";

	public static final String GRANT_TYPE_REFRESH 			  = "refresh_token";

	public static final String SCOPE_USER_INFO 				  = "user_info";

	//Cert Level
	public static final String CERT_LEVEL_L1 				  = "L1";

	public static final String CERT_LEVEL_L2 				  = "L2";

	public static final String CERT_LEVEL_L3 				  = "L3";

	public static final String CERT_LEVEL_L4 				  = "L4";

	//Encryption & Sign
	public static final String SIGN_TYPE                      = "sign_type";

	public static final String SIGN_TYPE_RSA                  = "RSA";

	public static final String SIGN_TYPE_MD5 				  = "MD5" ;

	public static final String SIGN_TYPE_RSA2                 = "RSA2";

	public static final String SIGN_ALGORITHMS                = "SHA1WithRSA";

	public static final String SIGN_SHA256RSA_ALGORITHMS      = "SHA256WithRSA";

	public static final String ENCRYPT_TYPE_AES               = "AES";

	public static final String SIGN                           = "sign";

	//charset
	public static final String CHARSET_UTF8                   = "UTF-8";

	public static final String CHARSET_GBK                    = "GBK";


}
