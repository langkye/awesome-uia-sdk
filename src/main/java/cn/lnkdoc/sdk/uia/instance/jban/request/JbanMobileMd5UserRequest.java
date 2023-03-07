package cn.lnkdoc.sdk.uia.instance.jban.request;

import cn.lnkdoc.sdk.uia.common.HttpMethod;
import cn.lnkdoc.sdk.uia.common.property.IUiaProperty;
import cn.lnkdoc.sdk.uia.common.request.AbstractUiaRequest;
import cn.lnkdoc.sdk.uia.common.request.IUiaRequest;
import cn.lnkdoc.sdk.uia.common.util.EncryptUtils;
import cn.lnkdoc.sdk.uia.instance.jban.property.JbanProperty;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public class JbanMobileMd5UserRequest extends AbstractUiaRequest implements IUiaRequest {
    private String body;
    private String url;
    
    /**
     * request body
     *
     * @return request body
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> T body() {
        return (T) body;
    }

    /**
     * request url
     *
     * @param p property
     * @return request url
     */
    @Override
    public String url(IUiaProperty p) {
        if (url == null) {
            JbanProperty property = (JbanProperty) p;
            
            url = String.join(""
                    , property.getDomain()
                    , property.getMobileMd5Path()
                    , (EncryptUtils.MD5EncryptAsHex(body))
            );
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
        return HttpMethod.GET;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
