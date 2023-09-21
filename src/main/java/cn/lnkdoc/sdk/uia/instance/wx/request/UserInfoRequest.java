package cn.lnkdoc.sdk.uia.instance.wx.request;

import cn.lnkdoc.sdk.uia.common.HttpMethod;
import cn.lnkdoc.sdk.uia.common.property.IUiaProperty;
import cn.lnkdoc.sdk.uia.common.request.AbstractUiaRequest;
import cn.lnkdoc.sdk.uia.common.request.IUiaRequest;
import cn.lnkdoc.sdk.uia.common.util.Assert;
import cn.lnkdoc.sdk.uia.instance.wx.property.WxProperty;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@SuppressWarnings(value = {"unused", "unchecked"})
public class UserInfoRequest extends AbstractUiaRequest implements IUiaRequest {
    /**
     * body
     */
    private Body body;
    
    /**
     * request body
     *
     * @return request body
     */
    @Override
    public Body body() {
        return getBody();
    }

    /**
     * url
     * 
     * @param p property
     * @return request url
     */
    @Override
    public String url(IUiaProperty p) {
        WxProperty property = (WxProperty) p;
        Assert.required(p, "微信配置不能为空");
        Assert.required(body(), "请求体内容不能为空");
        Assert.required(body().accessToken, "AccessToken不能为空");
        Assert.required(body().openid, "openid不能为空");
        return String.join(""
                , property.getDomain()
                , property.getUserInfoPath()
                , "?"
                , "access_token=" + body().accessToken
                , "&openid=" + body().openid
        );
    }

    /**
     * request method
     *
     * @return request method
     */
    @Override
    public HttpMethod method() {
        return HttpMethod.GET;
    }

    /**
     * getter
     * 
     * @return body
     */
    public Body getBody() {
        return body;
    }

    /**
     * setter
     * 
     * @param body body
     */
    public void setBody(Body body) {
        this.body = body;
    }

    /**
     * body class
     */
    public static class Body {
        /**
         * accessToken
         */
        private String accessToken;
        /**
         * openid
         */
        private String openid;

        /**
         * constructor
         * @param accessToken accessToken
         * @param openid openid
         */
        public Body(String accessToken, String openid) {
            this.accessToken = accessToken;
            this.openid = openid;
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
    }
}
