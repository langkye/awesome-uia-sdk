package cn.lnkdoc.sdk.uia.instance.jban.domain;

import java.io.Serializable;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@SuppressWarnings(value = {"unused"})
public class UserInfo  implements Serializable {
    private static final long serialVersionUID = -508722906865178L;
    /**
     * 第三方用户 ID,无则返回 null
     */
    private String thirdUserId;
    /**
     * 开放平台租户 ID
     */
    private String openTeamId;
    /**
     * 头像地址
     */
    private String avatarUrl;
    /**
     * 访问 accesstoken
     * 失效时间,单位是秒
     */
    private String accessTokenExpireIn;
    /**
     * 刷新 accesstoken
     * 失效时间,单位是秒
     */
    private String refreshTokenExpireIn;
    /**
     * 开放平台用户 ID
     */
    private String openUserId;
    /**
     * 访问 accesstoken
     */
    private String accessToken;
    /**
     * 员工账号
     */
    private String userCode;
    /**
     * 刷新访问
     * accesstoken 用
     */
    private String refreshToken;

    public String getThirdUserId() {
        return thirdUserId;
    }

    public void setThirdUserId(String thirdUserId) {
        this.thirdUserId = thirdUserId;
    }

    public String getOpenTeamId() {
        return openTeamId;
    }

    public void setOpenTeamId(String openTeamId) {
        this.openTeamId = openTeamId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getAccessTokenExpireIn() {
        return accessTokenExpireIn;
    }

    public void setAccessTokenExpireIn(String accessTokenExpireIn) {
        this.accessTokenExpireIn = accessTokenExpireIn;
    }

    public String getRefreshTokenExpireIn() {
        return refreshTokenExpireIn;
    }

    public void setRefreshTokenExpireIn(String refreshTokenExpireIn) {
        this.refreshTokenExpireIn = refreshTokenExpireIn;
    }

    public String getOpenUserId() {
        return openUserId;
    }

    public void setOpenUserId(String openUserId) {
        this.openUserId = openUserId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
