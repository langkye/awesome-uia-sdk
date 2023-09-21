package cn.lnkdoc.sdk.uia.instance.yztoon.property;


import cn.lnkdoc.sdk.uia.common.GrantType;
import cn.lnkdoc.sdk.uia.common.property.IUiaProperty;
import cn.lnkdoc.sdk.uia.instance.yztoon.Scope;

import java.util.Objects;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@SuppressWarnings(value = {"unused"})
public class YztoonProperty implements IUiaProperty {
    /**
     * printStack
     */
    private boolean printStack = false;
    /**
     * domain
     */
    private String domain;
    /**
     * clientId
     */
    private String clientId;
    /**
     * clientSecret
     */
    private String clientSecret;
    /**
     * scope
     */
    private String scope = Scope.ALL.getScope();
    /**
     * accessTokenUrl
     */
    private String accessTokenUrl = "/oauth2/access_token";
    /**
     * refreshTokenUrl
     */
    private String refreshTokenUrl;
    /**
     * userInfoUrl
     */
    private String userInfoUrl = "/oauth2/tokeninfo";
    /**
     * logoutUrl
     */
    private String logoutUrl = "/UI/Logout";
    /**
     * redirectUrl
     */
    private String redirectUrl;
    /**
     * keyStorePath
     */
    private String keyStorePath = "classpath:yzttrust.jks";
    /**
     * keyStorePassword
     */
    private String keyStorePassword = "123456";
    /**
     * service
     */
    private String service = "bjzwService";
    /**
     * grantType
     */
    private String grantType = GrantType.AUTHORIZATION_CODE.getCode();
    /**
     * trustDomain
     */
    private boolean trustDomain;

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
     * @return userInfoUrl
     */
    public String getUserInfoUrl() {
        return userInfoUrl;
    }

    /**
     * setter
     * 
     * @param userInfoUrl userInfoUrl
     */
    public void setUserInfoUrl(String userInfoUrl) {
        this.userInfoUrl = userInfoUrl;
    }

    /**
     * getter
     * 
     * @return logoutUrl
     */
    public String getLogoutUrl() {
        return logoutUrl;
    }

    /**
     * setter
     * 
     * @param logoutUrl logoutUrl
     */
    public void setLogoutUrl(String logoutUrl) {
        this.logoutUrl = logoutUrl;
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
     * @return accessTokenUrl
     */
    public String getAccessTokenUrl() {
        return accessTokenUrl;
    }

    /**
     * setter
     * 
     * @param accessTokenUrl accessTokenUrl
     */
    public void setAccessTokenUrl(String accessTokenUrl) {
        this.accessTokenUrl = accessTokenUrl;
    }

    /**
     * getter
     * 
     * @return refreshTokenUrl
     */
    public String getRefreshTokenUrl() {
        return refreshTokenUrl;
    }

    /**
     * setter
     * 
     * @param refreshTokenUrl refreshTokenUrl
     */
    public void setRefreshTokenUrl(String refreshTokenUrl) {
        this.refreshTokenUrl = refreshTokenUrl;
    }

    /**
     * getter
     * 
     * @return redirectUrl
     */
    public String getRedirectUrl() {
        return redirectUrl;
    }

    /**
     * setter
     * 
     * @param redirectUrl redirectUrl
     */
    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    /**
     * getter
     * 
     * @return keyStorePath
     */
    public String getKeyStorePath() {
        return keyStorePath;
    }

    /**
     * setter
     * 
     * @param keyStorePath keyStorePath
     */
    public void setKeyStorePath(String keyStorePath) {
        this.keyStorePath = keyStorePath;
    }

    /**
     * getter
     * 
     * @return keyStorePassword
     */
    public String getKeyStorePassword() {
        return keyStorePassword;
    }

    /**
     * setter
     * 
     * @param keyStorePassword keyStorePassword
     */
    public void setKeyStorePassword(String keyStorePassword) {
        this.keyStorePassword = keyStorePassword;
    }

    /**
     * getter
     * 
     * @return service
     */
    public String getService() {
        return service;
    }

    /**
     * setter  
     * 
     * @param service service
     */
    public void setService(String service) {
        this.service = service;
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

    /**
     * getter 
     * @return trustDomain
     */
    public boolean isTrustDomain() {
        return trustDomain;
    }

    /**
     * setter
     * 
     * @param trustDomain trustDomain
     */
    public void setTrustDomain(Boolean trustDomain) {
        this.trustDomain = Objects.equals(Boolean.TRUE, trustDomain);
    }
}