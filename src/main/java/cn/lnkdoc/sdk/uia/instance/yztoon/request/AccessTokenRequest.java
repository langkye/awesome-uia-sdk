package cn.lnkdoc.sdk.uia.instance.yztoon.request;

import cn.lnkdoc.sdk.uia.common.HttpMethod;
import cn.lnkdoc.sdk.uia.common.exception.UiaException;
import cn.lnkdoc.sdk.uia.common.property.IUiaProperty;
import cn.lnkdoc.sdk.uia.common.request.AbstractUiaRequest;
import cn.lnkdoc.sdk.uia.common.request.IUiaRequest;
import cn.lnkdoc.sdk.uia.common.util.Assert;
import cn.lnkdoc.sdk.uia.instance.yztoon.property.YztoonProperty;

import java.net.URLEncoder;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@SuppressWarnings("unchecked")
public class AccessTokenRequest extends AbstractUiaRequest implements IUiaRequest {
    /**
     * body
     */
    private String body;
    
    /**
     * request body
     *
     * @return request body
     */
    @Override
    public String body() {
        return getBody();
    }

    /**
     * request url
     *
     * @param p property
     * @return request url
     */
    @Override
    public String url(IUiaProperty p) {
        YztoonProperty property = (YztoonProperty) p;
        Assert.required(property, "一证通配置不能为空");
        try {
            return property.getDomain()
                    + property.getAccessTokenUrl()
                    + "?"
                    + "client_id=" + property.getClientId().replace("ttt", "")
                    + "&"
                    + "redirect_uri=" + URLEncoder.encode(property.getRedirectUrl(), "UTF-8")
                    + "&"
                    + "scope=" + property.getScope()
                    + "&"
                    + "client_secret=" + property.getClientSecret()
                    + "&"
                    + "grant_type=" + property.getGrantType()
                    + "&"
                    + "code=" + this.body;
        } catch (Exception e) {
            throw new UiaException(e);
        }
    }

    /**
     * request method
     *
     * @return request method
     */
    @Override
    public HttpMethod method() {
        return HttpMethod.POST;
    }

    /**
     * getter
     *
     * @return body
     */
    public String getBody() {
        return body;
    }

    /**
     * setter
     *
     * @param body body
     */
    public void setBody(String body) {
        this.body = body;
    }
}
