package cn.lnkdoc.sdk.uia.instance.bjtoon.property;


import cn.lnkdoc.sdk.uia.common.property.IUiaProperty;
import cn.lnkdoc.sdk.uia.instance.bjtoon.UiaConstants;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@SuppressWarnings(value = {"unused"})
public class BjtoonProperty implements IUiaProperty {
    private boolean printStack = false;
    private String domain;
    private String clientId;
    private String clientSecret;
    boolean needsDecrypt = true;
    private String grantType = UiaConstants.GRANT_TYPE_CODE;
    private String scope = UiaConstants.SCOPE_USER_INFO;
    private String accessTokenPath = "/api/oauth/getAccessToken";
    private String userInfoPath = "/api/info/getUserInfo";
    private String ssoStatusPath = "/api/login/getSSOStatus";
    private String logoutPath = "/api/login/doSSOLogout";
    private String authTicketPath = "/api/oauth/getAuthTicket";
    private String registerPath = "/open/api/register/doUserRegisterByCertInfo";
    private String redirectUri = "";

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
     * @return needsDecrypt
     */
    public boolean isNeedsDecrypt() {
        return needsDecrypt;
    }

    /**
     * setter
     * 
     * @param needsDecrypt needsDecrypt
     */
    public void setNeedsDecrypt(boolean needsDecrypt) {
        this.needsDecrypt = needsDecrypt;
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
     * @return ssoStatusPath
     */
    public String getSsoStatusPath() {
        return ssoStatusPath;
    }

    /**
     * setter
     * 
     * @param ssoStatusPath ssoStatusPath
     */
    public void setSsoStatusPath(String ssoStatusPath) {
        this.ssoStatusPath = ssoStatusPath;
    }

    /**
     * getter
     * 
     * @return logoutPath
     */
    public String getLogoutPath() {
        return logoutPath;
    }

    /**
     * setter
     * 
     * @param logoutPath logoutPath
     */
    public void setLogoutPath(String logoutPath) {
        this.logoutPath = logoutPath;
    }

    /**
     * getter
     * 
     * @return authTicketPath
     */
    public String getAuthTicketPath() {
        return authTicketPath;
    }

    /**
     * setter
     * 
     * @param authTicketPath authTicketPath
     */
    public void setAuthTicketPath(String authTicketPath) {
        this.authTicketPath = authTicketPath;
    }

    /**
     * getter
     * 
     * @return registerPath
     */
    public String getRegisterPath() {
        return registerPath;
    }

    /**
     * setter
     * 
     * @param registerPath registerPath
     */
    public void setRegisterPath(String registerPath) {
        this.registerPath = registerPath;
    }

    /**
     * getter
     * 
     * @return redirectUri
     */
    public String getRedirectUri() {
        return redirectUri;
    }

    /**
     * setter
     * 
     * @param redirectUri redirectUri
     */
    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
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
