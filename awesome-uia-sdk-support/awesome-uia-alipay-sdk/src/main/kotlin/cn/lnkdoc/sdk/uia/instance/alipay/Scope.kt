package cn.lnkdoc.sdk.uia.instance.alipay


/**
 * 应用授权作用域
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused", "MemberVisibilityCanBePrivate", "EnumEntryName")
enum class Scope
/**
 * constructor
 *
 * @param scope scope
 */(
    /**
     * scope
     */
    val scope: String
) {

    /**
     * auth_user
     */
    auth_user("auth_user"),
    ;

}
