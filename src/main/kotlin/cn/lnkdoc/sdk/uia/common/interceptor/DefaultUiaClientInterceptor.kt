package cn.lnkdoc.sdk.uia.common.interceptor

import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer
import org.slf4j.LoggerFactory


/**
 * UIA客户端拦截器
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
class DefaultUiaClientInterceptor: AbstractUiaClientInterceptor() {
    companion object {
        private val log = LoggerFactory.getLogger(DefaultUiaClientInterceptor::class.java)
    }

    /**
     * 拦截请求
     */
    override fun interceptRequest(request: Request) {
        // 记录请求方法、请求URL
        log.info("Sending request: [{}][{}]", request.method, request.url)

        // 记录请求体（对于GET方法没有请求体）
        if (request.body != null) {
            val buffer = Buffer()
            request.body!!.writeTo(buffer)
            log.info("Request body: {}", buffer.readUtf8())
        }
    }

    /**
     * 拦截响应
     */
    override fun interceptResponse(response: Response) {
        // 打印响应数据（可选）
        if (response.body != null) {
            val responseBody = response.peekBody(Long.MAX_VALUE)
            log.info("Received response for [{}] with status code [{}]", response.request.url, response.code)
            log.info("Response body: {}", responseBody.string())
        }
    }
}