package cn.lnkdoc.sdk.uia.common;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public enum GrantType {
    /**
     * authorization_code
     */
    AUTHORIZATION_CODE("authorization_code")
    ;
    
    private final String code;

    GrantType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
