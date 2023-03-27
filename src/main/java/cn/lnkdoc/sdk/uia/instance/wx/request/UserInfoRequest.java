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
@SuppressWarnings(value = {"unused"})
public class UserInfoRequest extends AbstractUiaRequest implements IUiaRequest {
    private Body body;
    
    /**
     * request body
     *
     * @return request body
     */
    @SuppressWarnings("unchecked")
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

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
    
    public static class Body {
        private String accessToken;
        private String openid;

        public Body(String accessToken, String openid) {
            this.accessToken = accessToken;
            this.openid = openid;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }
    }
}
