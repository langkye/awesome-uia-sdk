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

    public boolean isNeedsDecrypt() {
        return needsDecrypt;
    }

    public void setNeedsDecrypt(boolean needsDecrypt) {
        this.needsDecrypt = needsDecrypt;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAccessTokenPath() {
        return accessTokenPath;
    }

    public void setAccessTokenPath(String accessTokenPath) {
        this.accessTokenPath = accessTokenPath;
    }

    public String getUserInfoPath() {
        return userInfoPath;
    }

    public void setUserInfoPath(String userInfoPath) {
        this.userInfoPath = userInfoPath;
    }

    public String getSsoStatusPath() {
        return ssoStatusPath;
    }

    public void setSsoStatusPath(String ssoStatusPath) {
        this.ssoStatusPath = ssoStatusPath;
    }

    public String getLogoutPath() {
        return logoutPath;
    }

    public void setLogoutPath(String logoutPath) {
        this.logoutPath = logoutPath;
    }

    public String getAuthTicketPath() {
        return authTicketPath;
    }

    public void setAuthTicketPath(String authTicketPath) {
        this.authTicketPath = authTicketPath;
    }

    public String getRegisterPath() {
        return registerPath;
    }

    public void setRegisterPath(String registerPath) {
        this.registerPath = registerPath;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    @Override
    public boolean isPrintStack() {
        return printStack;
    }

    public void setPrintStack(boolean printStack) {
        this.printStack = printStack;
    }
}
