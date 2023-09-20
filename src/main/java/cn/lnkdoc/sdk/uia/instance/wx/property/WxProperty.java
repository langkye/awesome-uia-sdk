package cn.lnkdoc.sdk.uia.instance.wx.property;

import cn.lnkdoc.sdk.uia.common.property.IUiaProperty;
import cn.lnkdoc.sdk.uia.instance.bjtoon.UiaConstants;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public class WxProperty implements IUiaProperty {
    /**
     * printStack
     */
    private boolean printStack = false;
    /**
     * domain
     */
    private String domain = "https://api.weixin.qq.com";
    /**
     * clientId
     */
    private String clientId;
    /**
     * clientSecret
     */
    private String clientSecret;
    /**
     * 通过code换取access_token	1万/分钟
     */
    private String accessTokenPath = "/sns/oauth2/access_token";
    /**
     * 刷新access_token	5万/分钟
     */
    private String refreshTokenPath = "/sns/oauth2/refresh_token";
    /**
     * accessTokenStatusPath
     */
    private String accessTokenStatusPath = "sns/auth";
    /**
     * 获取用户基本信息	5万/分钟
     */
    private String userInfoPath = "/sns/userinfo";
    /**
     * grantType
     */
    private String grantType = UiaConstants.GRANT_TYPE_CODE;
    /**
     * refreshTokenGrantType
     */
    private String refreshTokenGrantType = UiaConstants.GRANT_TYPE_REFRESH;

    /**
     * getter
     * 
     * @return domain
     */
    public String getDomain() {
        return domain;
    }

    /**
     * setter
     * 
     * @param domain domain
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * getter
     * 
     * @return clientId
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * setter
     * 
     * @param clientId clientId
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * getter
     * 
     * @return clientSecret
     */
    public String getClientSecret() {
        return clientSecret;
    }

    /**
     * setter
     * 
     * @param clientSecret clientSecret
     */
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    /**
     * getter
     * 
     * @return accessTokenPath
     */
    public String getAccessTokenPath() {
        return accessTokenPath;
    }

    /**
     * setter
     * 
     * @param accessTokenPath accessTokenPath
     */
    public void setAccessTokenPath(String accessTokenPath) {
        this.accessTokenPath = accessTokenPath;
    }

    /**
     * getter
     * 
     * @return refreshTokenPath
     */
    public String getRefreshTokenPath() {
        return refreshTokenPath;
    }

    /**
     * setter
     * 
     * @param refreshTokenPath refreshTokenPath
     */
    public void setRefreshTokenPath(String refreshTokenPath) {
        this.refreshTokenPath = refreshTokenPath;
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
     * @return accessTokenStatusPath
     */
    public String getAccessTokenStatusPath() {
        return accessTokenStatusPath;
    }

    /**
     * setter
     * 
     * @param accessTokenStatusPath accessTokenStatusPath
     */
    public void setAccessTokenStatusPath(String accessTokenStatusPath) {
        this.accessTokenStatusPath = accessTokenStatusPath;
    }

    /**
     * getter
     * 
     * @return userInfoPath
     */
    public String getUserInfoPath() {
        return userInfoPath;
    }

    /**
     * setter
     * 
     * @param userInfoPath userInfoPath
     */
    public void setUserInfoPath(String userInfoPath) {
        this.userInfoPath = userInfoPath;
    }

    /**
     * getter
     * 
     * @return refreshTokenGrantType
     */
    public String getRefreshTokenGrantType() {
        return refreshTokenGrantType;
    }

    /**
     * setter
     * 
     * @param refreshTokenGrantType refreshTokenGrantType
     */
    public void setRefreshTokenGrantType(String refreshTokenGrantType) {
        this.refreshTokenGrantType = refreshTokenGrantType;
    }
    
    /**
     * getter
     *
     * @return printStack
     */
    @Override
    public boolean isPrintStack() {
        return printStack;
    }

    /**
     * setter
     *
     * @param printStack printStack
     */
    public void setPrintStack(boolean printStack) {
        this.printStack = printStack;
    }
}
