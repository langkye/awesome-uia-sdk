package cn.lnkdoc.sdk.uia.instance.wx.property;

import cn.lnkdoc.sdk.uia.common.property.IUiaProperty;
import cn.lnkdoc.sdk.uia.instance.bjtoon.UiaConstants;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public class WxProperty implements IUiaProperty {
    private boolean printStack = false;
    private String domain = "https://api.weixin.qq.com";
    private String clientId;
    private String clientSecret;
    /**
     * 通过code换取access_token	1万/分钟
     */
    private String accessTokenPath = "/sns/oauth2/access_token";
    /**
     * 刷新access_token	5万/分钟
     */
    private String refreshTokenPath = "/sns/oauth2/refresh_token";
    private String accessTokenStatusPath = "sns/auth";
    /**
     * 获取用户基本信息	5万/分钟
     */
    private String userInfoPath = "/sns/userinfo";
    private String grantType = UiaConstants.GRANT_TYPE_CODE;
    private String refreshTokenGrantType = UiaConstants.GRANT_TYPE_REFRESH;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getAccessTokenPath() {
        return accessTokenPath;
    }

    public void setAccessTokenPath(String accessTokenPath) {
        this.accessTokenPath = accessTokenPath;
    }

    public String getRefreshTokenPath() {
        return refreshTokenPath;
    }

    public void setRefreshTokenPath(String refreshTokenPath) {
        this.refreshTokenPath = refreshTokenPath;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getAccessTokenStatusPath() {
        return accessTokenStatusPath;
    }

    public void setAccessTokenStatusPath(String accessTokenStatusPath) {
        this.accessTokenStatusPath = accessTokenStatusPath;
    }

    public String getUserInfoPath() {
        return userInfoPath;
    }

    public void setUserInfoPath(String userInfoPath) {
        this.userInfoPath = userInfoPath;
    }

    public String getRefreshTokenGrantType() {
        return refreshTokenGrantType;
    }

    public void setRefreshTokenGrantType(String refreshTokenGrantType) {
        this.refreshTokenGrantType = refreshTokenGrantType;
    }

    @Override
    public boolean isPrintStack() {
        return printStack;
    }

    public void setPrintStack(boolean printStack) {
        this.printStack = printStack;
    }
}
