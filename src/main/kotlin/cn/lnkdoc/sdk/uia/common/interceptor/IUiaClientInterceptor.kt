package cn.lnkdoc.sdk.uia.common.interceptor

import okhttp3.Request
import okhttp3.Response

/**
 * UIA客户端拦截器
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
interface IUiaClientInterceptor {
    /**
     * 拦截请求
     */
    fun interceptRequest(request: Request)

    /**
     * 拦截响应
     */
    fun interceptResponse(response: Response)
}