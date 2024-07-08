package cn.lnkdoc.sdk.uia.common.interceptor

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


/**
 * UIA客户端拦截器
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
abstract class AbstractUiaClientInterceptor: Interceptor, IUiaClientInterceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        
        //************ 拦截请求 ************//
        // 获取请求
        val request: Request = chain.request()
        this.interceptRequest(request);
        
        //************ 拦截响应 ************//
        // 处理请求，并获取响应
        val response = chain.proceed(request)
        this.interceptResponse(response)

        return response
    }
}