package cn.lnkdoc.sdk.uia.instance.jban.property;

import cn.lnkdoc.sdk.uia.common.property.IUiaProperty;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@SuppressWarnings(value = {"unused"})
public class JbanProperty implements IUiaProperty {
    private boolean printStack = false;
    /**
     * 测试：<a href="https://jzb-open-pre.jdcloud.com">...</a>
     * 生产-互联网：<a href="https://open.jzb.beijing.gov.cn">...</a>
     * 生产-政务内网：<a href="https://open.jzb.beijing.egov.cn">...</a>
     */
    private String domain = "https://jzb-open-pre.jdcloud.com";
    private String clientId;
    private String clientSecret;
    private String openTeamId;
    private String accessTokenPath = "/open-api/auth/v1/access_token";
    private String appAccessTokenPath = "/open-api/auth/v1/app_access_token";
    private String teamAccessTokenPath = "/open-api/auth/v1/team_access_token";
    private String mobileMd5Path = "/open-api/contact/v1/user/md5?mobileMd5=";

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
     * @return openTeamId
     */
    public String getOpenTeamId() {
        return openTeamId;
    }

    /**
     * setter
     * 
     * @param openTeamId openTeamId
     */
    public void setOpenTeamId(String openTeamId) {
        this.openTeamId = openTeamId;
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
     * @return appAccessTokenPath
     */
    public String getAppAccessTokenPath() {
        return appAccessTokenPath;
    }

    /**
     * setter
     * 
     * @param appAccessTokenPath appAccessTokenPath
     */
    public void setAppAccessTokenPath(String appAccessTokenPath) {
        this.appAccessTokenPath = appAccessTokenPath;
    }

    /**
     * getter
     * 
     * @return teamAccessTokenPath
     */
    public String getTeamAccessTokenPath() {
        return teamAccessTokenPath;
    }

    /**
     * setter
     * 
     * @param teamAccessTokenPath teamAccessTokenPath
     */
    public void setTeamAccessTokenPath(String teamAccessTokenPath) {
        this.teamAccessTokenPath = teamAccessTokenPath;
    }

    /**
     * getter
     * 
     * @return mobileMd5Path
     */
    public String getMobileMd5Path() {
        return mobileMd5Path;
    }

    /**
     * setter
     * 
     * @param mobileMd5Path mobileMd5Path
     */
    public void setMobileMd5Path(String mobileMd5Path) {
        this.mobileMd5Path = mobileMd5Path;
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
