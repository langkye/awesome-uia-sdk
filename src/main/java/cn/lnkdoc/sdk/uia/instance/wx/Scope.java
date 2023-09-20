package cn.lnkdoc.sdk.uia.instance.wx;

/**
 * 应用授权作用域，拥有多个作用域用逗号（,）分隔，网页应用目前仅填写snsapi_login
 * 
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@SuppressWarnings({"ALL"})
public enum Scope {
    /**
     * <pre>
     *      <b>/sns/oauth2/access_token</b>：通过code换取access_token、refresh_token和已授权scope
     *      <b>/sns/oauth2/refresh_token</b>：刷新或续期access_token使用
     *      <b>/sns/auth</b>：检查access_token有效性    
     * </pre>
     */
    snsapi_base("snsapi_base"),
    /**
     * <pre>
     *     <b>/sns/userinfo</b>：获取用户个人信息
     * </pre>
     */
    snsapi_userinfo("snsapi_userinfo"),
    /**
     * 网页应用目前仅填写snsapi_login
     */
    snsapi_login("snsapi_login"),
    ;

    /**
     * scope
     */
    private final String scope;

    /**
     * constructor
     * 
     * @param scope scope
     */
    Scope(String scope) {
        this.scope = scope;
    }

    /**
     * getter
     * 
     * @return scope
     */
    public String getScope() {
        return scope;
    }
}
