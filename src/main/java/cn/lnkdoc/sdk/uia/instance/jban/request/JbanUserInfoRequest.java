package cn.lnkdoc.sdk.uia.instance.jban.request;

import cn.lnkdoc.sdk.uia.common.HttpMethod;
import cn.lnkdoc.sdk.uia.common.property.IUiaProperty;
import cn.lnkdoc.sdk.uia.common.request.AbstractUiaRequest;
import cn.lnkdoc.sdk.uia.common.request.IUiaRequest;
import cn.lnkdoc.sdk.uia.instance.jban.property.JbanProperty;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public class JbanUserInfoRequest extends AbstractUiaRequest implements IUiaRequest {
    /**
     * body
     */
    private String body;
    /**
     * url
     */
    private String url;
    
    /**
     * request body
     *
     * @return request body
     */
    @SuppressWarnings({"unchecked"})
    @Override
    public <T> T body() {
        return (T) body;
    }

    /**
     * request url
     *
     * @param property property
     * @return request url
     */
    @Override
    public String url(IUiaProperty property) {
        if (url == null) {
            JbanProperty jbanProperty = (JbanProperty) property;
            url = String.join("", jbanProperty.getDomain(), jbanProperty.getAccessTokenPath());
        }
        return url;
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

    /**
     * getter
     * 
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * setter
     * 
     * @param url url
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
