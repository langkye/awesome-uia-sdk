package cn.lnkdoc.sdk.uia.instance.jban.domain;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@SuppressWarnings(value = {"unused"})
public class UserInfo  implements Serializable {
    @Serial
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
     * 访问 accessToken
     * 失效时间,单位是秒
     */
    private String accessTokenExpireIn;
    /**
     * 刷新 accessToken
     * 失效时间,单位是秒
     */
    private String refreshTokenExpireIn;
    /**
     * 开放平台用户 ID
     */
    private String openUserId;
    /**
     * 访问 accessToken
     */
    private String accessToken;
    /**
     * 员工账号
     */
    private String userCode;
    /**
     * 刷新访问
     * accessToken 用
     */
    private String refreshToken;

    /**
     * getter
     * 
     * @return thirdUserId
     */
    public String getThirdUserId() {
        return thirdUserId;
    }

    /**
     * setter
     * 
     * @param thirdUserId thirdUserId
     */
    public void setThirdUserId(String thirdUserId) {
        this.thirdUserId = thirdUserId;
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
     * @return avatarUrl
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * setter
     * 
     * @param avatarUrl avatarUrl
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    /**
     * getter
     * 
     * @return accessTokenExpireIn
     */
    public String getAccessTokenExpireIn() {
        return accessTokenExpireIn;
    }

    /**
     * setter
     * 
     * @param accessTokenExpireIn accessTokenExpireIn
     */
    public void setAccessTokenExpireIn(String accessTokenExpireIn) {
        this.accessTokenExpireIn = accessTokenExpireIn;
    }

    /**
     * getter
     * 
     * @return refreshTokenExpireIn
     */
    public String getRefreshTokenExpireIn() {
        return refreshTokenExpireIn;
    }

    /**
     * setter
     * 
     * @param refreshTokenExpireIn refreshTokenExpireIn
     */
    public void setRefreshTokenExpireIn(String refreshTokenExpireIn) {
        this.refreshTokenExpireIn = refreshTokenExpireIn;
    }

    /**
     * getter
     * 
     * @return openUserId
     */
    public String getOpenUserId() {
        return openUserId;
    }

    /**
     * setter
     * 
     * @param openUserId openUserId
     */
    public void setOpenUserId(String openUserId) {
        this.openUserId = openUserId;
    }

    /**
     * getter
     * 
     * @return accessToken
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * setter
     * 
     * @param accessToken accessToken
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * getter
     * 
     * @return userCode
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * setter
     * 
     * @param userCode userCode
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    /**
     * getter
     * 
     * @return refreshToken
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * setter
     * 
     * @param refreshToken refreshToken
     */
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
