package cn.lnkdoc.sdk.uia.common.request

import cn.lnkdoc.sdk.uia.common.HttpMethod
import cn.lnkdoc.sdk.uia.common.convert.IUiaConverter
import cn.lnkdoc.sdk.uia.common.property.IUiaProperty


/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
interface IUiaRequest {
    /**
     * get convert
     *
     * @return converts
     * @param <T> type
     * @param <R> type
     */
    fun <T, R> getConvert(): List<IUiaConverter>

    /**
     * request body
     *
     * @param <T> type
     * @return request body
     */
    fun <T> body(): T

    /**
     * request url
     *
     * @param property property
     * @return request url
     */
    fun url(property: IUiaProperty): String

    /**
     * request method
     *
     * @return request method
     */
    fun method(): HttpMethod
}

