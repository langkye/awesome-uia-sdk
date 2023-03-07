package cn.lnkdoc.sdk.uia.common;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public enum HttpMethod {
    /**
     * POST
     */
    POST("POST"),
    /**
     * GET
     */
    GET("GET"),
    ;
    
    private final String method;

    HttpMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}
