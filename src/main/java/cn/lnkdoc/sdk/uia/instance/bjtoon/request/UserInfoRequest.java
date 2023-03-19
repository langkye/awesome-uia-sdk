package cn.lnkdoc.sdk.uia.instance.bjtoon.request;

import cn.lnkdoc.sdk.uia.common.HttpMethod;
import cn.lnkdoc.sdk.uia.common.exception.UiaException;
import cn.lnkdoc.sdk.uia.common.property.IUiaProperty;
import cn.lnkdoc.sdk.uia.common.request.AbstractUiaRequest;
import cn.lnkdoc.sdk.uia.common.request.IUiaRequest;
import cn.lnkdoc.sdk.uia.common.util.Assert;
import cn.lnkdoc.sdk.uia.instance.bjtoon.property.BjtoonProperty;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public class UserInfoRequest extends AbstractUiaRequest implements IUiaRequest {
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
     * request url
     *
     * @param p property
     * @return request url
     */
    @Override
    public String url(IUiaProperty p) {
        BjtoonProperty property = (BjtoonProperty) p;
        Assert.required(property, "北京通配置不能为空");
        try {
            return
                    property.getDomain()
                            + property.getUserInfoPath()
                            + "?"
                            + "access_token=" + this.body
                    ;
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
        return HttpMethod.GET;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
