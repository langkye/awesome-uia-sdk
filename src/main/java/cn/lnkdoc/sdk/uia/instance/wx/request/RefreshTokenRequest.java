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
public class RefreshTokenRequest extends AbstractUiaRequest implements IUiaRequest {
    private String body;

    /**
     * request body
     *
     * @return request body
     */
    @SuppressWarnings("unchecked")
    @Override
    public String body() {
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
        return String.join(""
                , property.getDomain()
                , property.getRefreshTokenPath()
                , "?"
                , "appid=" + property.getClientId()
                , "&grant_type=" + property.getRefreshTokenGrantType()
                , "&refresh_token=" + this.body()
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
