package cn.lnkdoc.sdk.uia.instance.jban.property;

import cn.lnkdoc.sdk.uia.common.property.IUiaProperty;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@SuppressWarnings(value = {"unused"})
public class JbanProperty implements IUiaProperty {
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

    public String getOpenTeamId() {
        return openTeamId;
    }

    public void setOpenTeamId(String openTeamId) {
        this.openTeamId = openTeamId;
    }

    public String getAccessTokenPath() {
        return accessTokenPath;
    }

    public void setAccessTokenPath(String accessTokenPath) {
        this.accessTokenPath = accessTokenPath;
    }

    public String getAppAccessTokenPath() {
        return appAccessTokenPath;
    }

    public void setAppAccessTokenPath(String appAccessTokenPath) {
        this.appAccessTokenPath = appAccessTokenPath;
    }

    public String getTeamAccessTokenPath() {
        return teamAccessTokenPath;
    }

    public void setTeamAccessTokenPath(String teamAccessTokenPath) {
        this.teamAccessTokenPath = teamAccessTokenPath;
    }

    public String getMobileMd5Path() {
        return mobileMd5Path;
    }

    public void setMobileMd5Path(String mobileMd5Path) {
        this.mobileMd5Path = mobileMd5Path;
    }
}
