package cn.lnkdoc.sdk.uia.instance.wx.domain;

import cn.lnkdoc.sdk.uia.instance.wx.response.WxResponse;
import com.alibaba.fastjson2.annotation.JSONField;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public class RefreshToken extends WxResponse {
    /**
     * 接口调用凭证
     */
    @JSONField(name = "access_token")
    private String accessToken;
    /**
     * access_token接口调用凭证超时时间，单位（秒）
     */
    @JSONField(name = "expires_in")
    private Long expiresIn;
    /**
     * 用户刷新access_token
     */
    @JSONField(name = "refresh_token")
    private String refreshToken;
    /**
     * 授权用户唯一标识
     */
    private String openid;
    /**
     * 用户授权的作用域，使用逗号（,）分隔
     * see: {@link cn.lnkdoc.sdk.uia.instance.wx.Scope}
     */
    private String scope;
    /**
     * 当且仅当该网站应用已获得该用户的userinfo授权时，才会出现该字段。
     */
    private String unionid;

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
     * @return expiresIn
     */
    public Long getExpiresIn() {
        return expiresIn;
    }

    /**
     * setter
     *
     * @param expiresIn expiresIn
     */
    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
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

    /**
     * getter
     *
     * @return openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * setter
     *
     * @param openid openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
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
     * @return unionid
     */
    public String getUnionid() {
        return unionid;
    }

    /**
     * setter
     *
     * @param unionid unionid
     */
    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }
}
