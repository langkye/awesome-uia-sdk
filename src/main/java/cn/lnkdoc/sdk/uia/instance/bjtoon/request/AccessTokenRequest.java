package cn.lnkdoc.sdk.uia.instance.bjtoon.request;

import cn.lnkdoc.sdk.uia.common.HttpMethod;
import cn.lnkdoc.sdk.uia.common.exception.UiaException;
import cn.lnkdoc.sdk.uia.common.property.IUiaProperty;
import cn.lnkdoc.sdk.uia.common.request.AbstractUiaRequest;
import cn.lnkdoc.sdk.uia.common.request.IUiaRequest;
import cn.lnkdoc.sdk.uia.common.util.Assert;
import cn.lnkdoc.sdk.uia.instance.bjtoon.property.BjtoonProperty;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@SuppressWarnings(value = {"unused", "Deprecation", "DeprecatedIsStillUsed", "unchecked"})
public class AccessTokenRequest extends AbstractUiaRequest implements IUiaRequest {
    private String body;
    private String url;

    private String grantType = "authorization_code";
    private String authToken;

    private String scope = "authorization_code";
    private String toonType = "";
    private String state = "";

    private String inType = "";
    private String localCheck = "";

    /**
     * request body
     *
     * @return request body
     */
    @Override
    public String body() {
        return getRequestBody();
    }

    /**
     * request url
     *
     * @param p property
     * @return request url
     */
    @Override
    public String url(IUiaProperty p) {
        BjtoonProperty property = (BjtoonProperty) p;
        Assert.required(property, "北京通配置不能为空");
        try {
            return property.getDomain()
                    + property.getAccessTokenPath();
        } catch (Exception e) {
            throw new UiaException(e);
        }
    }

    /**
     * request method
     *
     * @return request method
     */
    @Override
    public HttpMethod method() {
        return HttpMethod.POST;
    }

    /**
     * @deprecated this method is deprecated.
     *             remove in since 2.
     *             see {@link #getBody()}
     * @return body
     */
    @Deprecated
    public String getRequestBody() {
        return body;
    }

    /**
     * @deprecated this method is deprecated.
     *             remove in since 2.
     *             see {@link #setBody(String)}
     * @param requestBody body
     */
    @Deprecated
    public void setRequestBody(String requestBody) {
        this.body = requestBody;
    }

    /**
     * getter
     * 
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * setter
     * 
     * @param url url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * getter
     * 
     * @return grantCode
     */
    public String getGrantCode() {
        return body();
    }

    /**
     * setter
     * 
     * @param grantCode grantCode
     */
    public void setGrantCode(String grantCode) {
        this.body = grantCode;
    }

    /**
     * getter
     * 
     * @return grantType
     */
    public String getGrantType() {
        return grantType;
    }

    /**
     * setter
     * 
     * @param grantType grantType
     */
    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    /**
     * getter
     * 
     * @return authToken
     */
    public String getAuthToken() {
        return authToken;
    }

    /**
     * setter
     * 
     * @param authToken authToken
     */
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    /**
     * getter
     * 
     * @return scope
     */
    public String getScope() {
        return scope;
    }

    /**
     * setter
     * 
     * @param scope scope
     */
    public void setScope(String scope) {
        this.scope = scope;
    }

    /**
     * getter
     * 
     * @return toonType
     */
    public String getToonType() {
            return toonType;
    }

    /**
     * setter
     * 
     * @param toonType toonType
     */
    public void setToonType(String toonType) {
        this.toonType = toonType;
    }
    
    /**
     * getter
     * 
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * setter
     * 
     * @param state state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * getter
     * 
     * @return inType
     */
    public String getInType() {
        return inType;
    }

    /**
     * setter
     * @param inType inType
     */
    public void setInType(String inType) {
        this.inType = inType;
    }

    /**
     * getter
     * 
     * @return localCheck
     */
    public String getLocalCheck() {
        return localCheck;
    }

    /**
     * setter
     * 
     * @param localCheck localCheck
     */
    public void setLocalCheck(String localCheck) {
        this.localCheck = localCheck;
    }

    /**
     * getter
     * 
     * @return body
     */
    public String getBody() {
        return body;
    }

    /**
     * setter
     * 
     * @param body body
     */
    public void setBody(String body) {
        this.body = body;
    }
}
