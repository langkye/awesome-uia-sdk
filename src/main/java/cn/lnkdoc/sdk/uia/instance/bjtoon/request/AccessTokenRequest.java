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
@SuppressWarnings(value = {"unused"})
public class AccessTokenRequest extends AbstractUiaRequest implements IUiaRequest {
    private String requestBody;
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
    @SuppressWarnings("unchecked")
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

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGrantCode() {
        return body();
    }

    public void setGrantCode(String grantCode) {
        this.requestBody = grantCode;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getToonType() {
        return toonType;
    }

    public void setToonType(String toonType) {
        this.toonType = toonType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getInType() {
        return inType;
    }

    public void setInType(String inType) {
        this.inType = inType;
    }

    public String getLocalCheck() {
        return localCheck;
    }

    public void setLocalCheck(String localCheck) {
        this.localCheck = localCheck;
    }
}
