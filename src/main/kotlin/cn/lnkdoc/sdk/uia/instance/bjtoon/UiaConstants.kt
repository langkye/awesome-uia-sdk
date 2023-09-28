package cn.lnkdoc.sdk.uia.instance.bjtoon

/**
 *
 * General Constants
 *
 * @author qinyi
 * @version  v 1.0 2018-10-22
 */
@Suppress("unused")
object UiaConstants {
    /**
     * RETURN_CODE_SUCCESS
     */
    val RETURN_CODE_SUCCESS = CodeMessage(0, "成功")
    /**
     * RETURN_CODE_UNKNOWN_ERROR
     */
    val RETURN_CODE_UNKNOWN_ERROR = CodeMessage(59999, "未知异常")
    /**
     * HTTP_RESPONSE_SUCCESS_CODE
     */
    const val HTTP_RESPONSE_SUCCESS_CODE = 0
    /**
     * API_SUCCESS_DATA
     */
    const val API_SUCCESS_DATA = 0
    /**
     * Default Http Timeout
     */
    const val CONNECTION_REQUEST_TIMEOUT = 5000
    /**
     * CONNECTION_TIMEOUT
     */
    const val CONNECTION_TIMEOUT = 15000
    /**
     * SOCKET_TIMEOUT
     */
    const val SOCKET_TIMEOUT = 10000
    /**
     * Oauth Client
     */
    const val CLIENT_ID = "client_id"
    /**
     * CLIENT_SECRET
     */
    const val CLIENT_SECRET = "client_secret"
    /**
     * REDIRECT_URI
     */
    const val REDIRECT_URI = "redirect_uri"
    /**
     * GRANT_CODE
     */
    const val GRANT_CODE = "grant_code"
    /**
     * GRANT_TYPE
     */
    const val GRANT_TYPE = "grant_type"
    /**
     * AUTH_TOKEN
     */
    const val AUTH_TOKEN = "auth_token"
    /**
     * STATE
     */
    const val STATE = "state"
    /**
     * SCOPE
     */
    const val SCOPE = "scope"
    /**
     * TOON_TYPE
     */
    const val TOON_TYPE = "toonType"
    /**
     * IN_TYPE
     */
    const val IN_TYPE = "inType"
    /**
     * LOCAL_CHECK
     */
    const val LOCAL_CHECK = "localCheck"
    /**
     * ACCESS_TOKEN
     */
    const val ACCESS_TOKEN = "access_token"
    /**
     * GRANT_TYPE_CODE
     */
    const val GRANT_TYPE_CODE = "authorization_code"
    /**
     * GRANT_TYPE_REFRESH
     */
    const val GRANT_TYPE_REFRESH = "refresh_token"
    /**
     * SCOPE_USER_INFO
     */
    const val SCOPE_USER_INFO = "user_info"
    /**
     * Cert Level
     */
    const val CERT_LEVEL_L1 = "L1"
    /**
     * CERT_LEVEL_L2
     */
    const val CERT_LEVEL_L2 = "L2"
    /**
     * CERT_LEVEL_L3
     */
    const val CERT_LEVEL_L3 = "L3"
    /**
     * CERT_LEVEL_L4
     */
    const val CERT_LEVEL_L4 = "L4"
    /**
     * Encryption Sign
     */
    const val SIGN_TYPE = "sign_type"
    /**
     * SIGN_TYPE_RSA
     */
    const val SIGN_TYPE_RSA = "RSA"
    /**
     * SIGN_TYPE_MD5
     */
    const val SIGN_TYPE_MD5 = "MD5"
    /**
     * SIGN_TYPE_RSA2
     */
    const val SIGN_TYPE_RSA2 = "RSA2"
    /**
     * SIGN_ALGORITHMS
     */
    const val SIGN_ALGORITHMS = "SHA1WithRSA"
    /**
     * SIGN_SHA256RSA_ALGORITHMS
     */
    const val SIGN_SHA256RSA_ALGORITHMS = "SHA256WithRSA"
    /**
     * ENCRYPT_TYPE_AES
     */
    const val ENCRYPT_TYPE_AES = "AES"
    /**
     * SIGN
     */
    const val SIGN = "sign"
    /**
     * charset
     */
    const val CHARSET_UTF8 = "UTF-8"
    /**
     * CHARSET_GBK
     */
    const val CHARSET_GBK = "GBK"
}
