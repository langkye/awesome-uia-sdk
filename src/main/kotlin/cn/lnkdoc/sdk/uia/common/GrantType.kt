package cn.lnkdoc.sdk.uia.common

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
enum class GrantType(val code: String) {
    /**
     * authorization_code
     */
    AUTHORIZATION_CODE("authorization_code"),
    /**
     * refresh_token
     */
    REFRESH_TOKEN("refresh_token"),
    ;
}