package cn.lnkdoc.sdk.uia.common.request;

import cn.lnkdoc.sdk.uia.common.HttpMethod;
import cn.lnkdoc.sdk.uia.common.convert.IUiaConverter;
import cn.lnkdoc.sdk.uia.common.property.IUiaProperty;

import java.util.List;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public interface IUiaRequest {
    <T, R> List<IUiaConverter> getConvert();

    /**
     * request body
     *
     * @return request body
     */
    <T> T body();
    
    /**
     * request url
     *
     * @param property property
     * @return request url
     */
    String url(IUiaProperty property);

    /**
     * request method
     *
     * @return request method
     */
    HttpMethod method();
}
