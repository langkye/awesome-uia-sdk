package cn.lnkdoc.sdk.uia.instance.wx.client

import cn.lnkdoc.sdk.uia.common.client.IUiaClient
import cn.lnkdoc.sdk.uia.common.exception.UiaException
import cn.lnkdoc.sdk.uia.common.request.IUiaRequest
import cn.lnkdoc.sdk.uia.common.response.IUiaResponse
import cn.lnkdoc.sdk.uia.common.response.UiaResponse.Companion.fail
import cn.lnkdoc.sdk.uia.common.response.UiaResponse.Companion.success
import cn.lnkdoc.sdk.uia.common.util.Assert.required
import cn.lnkdoc.sdk.uia.instance.wx.property.WxProperty
import cn.lnkdoc.sdk.uia.instance.wx.util.CheckResponseUtil.check
import io.vavr.Tuple
import io.vavr.Tuple3
import okhttp3.OkHttpClient
import okhttp3.Request
import org.slf4j.LoggerFactory

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("Unchecked_cast", "unused")
class WxUiaClient private constructor() : IUiaClient {
    /**
     * client
     */
    private val client = OkHttpClient().newBuilder().build()

    /**
     * property
     */
    private var property: WxProperty? = null

    /**
     * execute
     *
     * @param request request implementation
     * @return response implementation`
     * @throws UiaException UiaException
     */
    @Throws(UiaException::class)
    override fun <RESP> execute(request: IUiaRequest): IUiaResponse<RESP> {
        return try {
            // send request
            val string = sendRequest(request)

            // check success
            check(string, property!!.isPrintStack())

            // convert 
            val converts = request.getConvert<Any, Any>()
            required(converts, "not found converter for [" + request.javaClass.getSimpleName() + "]")
            val convert = converts[0]
            val resp = convert.convertResponse<Any, String>(string) as RESP

            // check success
            success(resp)
        } catch (e: Exception) {
            if (property!!.isPrintStack()) {
                log.error("", e)
            }
            fail(e.message)
        }
    }

    private fun sendRequest(request: IUiaRequest): String {
        // build request url
        val url = request.url(property!!)
        val logMessage = String.format("[%s][%s]", request.method(), url)
        var success = false
        var string = ""
        val convert = request.getConvert<Any, Any>()[0]

        // build httpRequest
        val httpRequest = convert.convertRequest<Request, Tuple3<WxProperty?, OkHttpClient, IUiaRequest>>(
            Tuple.of(
                property,
                client,
                request
            )
        )

        // call 
        try {
            client.newCall(httpRequest).execute().use { response ->

                // fetch request
                val responseBody = response.body
                required(responseBody, "请求无响应内容：[$url]")
                string = responseBody!!.string()
                success = true
                return string
            }
        } catch (e: Exception) {
            throw UiaException(e)
        } finally {
            log.debug("{}[{}][{}]", logMessage, success, string)
        }
    }

    companion object {
        private val log = LoggerFactory.getLogger(WxUiaClient::class.java)

        /**
         * instance
         *
         * @param property property
         * @return client
         */
        fun getInstance(property: WxProperty): WxUiaClient {
            val client = WxUiaClient()
            client.property = property
            checkMustRequired(property)
            return client
        }

        private fun checkMustRequired(property: WxProperty) {
            required(property, "the wxConfiguration is required")
            required(property.domain, "the domain configuration is required")
            required(property.clientId, "the clientId configuration is required")
            required(property.clientSecret, "the clientSecret configuration is required")
        }
    }
}
