package cn.lnkdoc.sdk.uia.instance.google.client

import cn.lnkdoc.sdk.uia.common.HttpMethod
import cn.lnkdoc.sdk.uia.common.client.IUiaClient
import cn.lnkdoc.sdk.uia.common.exception.UiaException
import cn.lnkdoc.sdk.uia.common.request.IUiaRequest
import cn.lnkdoc.sdk.uia.common.response.UiaResponse
import cn.lnkdoc.sdk.uia.common.response.UiaResponse.Companion.fail
import cn.lnkdoc.sdk.uia.common.response.UiaResponse.Companion.success
import cn.lnkdoc.sdk.uia.common.util.Assert.required
import cn.lnkdoc.sdk.uia.instance.google.property.GoogleProperty
import io.vavr.Tuple
import io.vavr.Tuple2
import okhttp3.Headers
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import org.slf4j.LoggerFactory

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
class GoogleUiaClient private constructor() : IUiaClient {
    private val client = OkHttpClient().newBuilder().build()
    private lateinit var property: GoogleProperty
    
    /**
     * execute
     *
     * @param request request implementation
     * @return response implementation`
     * @throws UiaException UiaException
     */
    @Throws(UiaException::class)
    override fun <RESP> execute(request: IUiaRequest): UiaResponse<RESP> {
        return try {
            // send request
            val string = sendRequest(request)

            // convert
            // match converter
            val converter = request.getConvert<Any, Any>().stream()
                .filter { it?.name() == request.javaClass.getName() + "" }
                ?.findFirst()
                ?.orElseThrow { UiaException("not found converter for [" + request.javaClass.getName() + "]") }!!
            required(converter, "not found converter for [" + request.javaClass.getName() + "]")
            
            val data = try {
                converter.convertResponse<RESP, Tuple2<String, GoogleProperty?>>(Tuple.of(string, property))
            } catch (e: UiaException) {
                if (property.isPrintStack()) {
                    log.error(e.message)
                }
                return fail(e.message)
            }
            
            return success(data)
        } catch (e: Exception) {
            if (property.isPrintStack()) {
                log.error("", e)
            }
            fail(e.message)
        }
    }

    private fun sendRequest(request: IUiaRequest): String {
        // match converter
        @Suppress("Duplicated_code_fragment", "")
        val converter = request.getConvert<Any, Any>()
            .stream()
            .filter { it?.name() == request.javaClass.getName() }
            ?.findFirst()
            ?.orElseThrow { UiaException("not found converter for [" + request.javaClass.getName() + "]") }!!
        required(converter, "not found converter for [" + request.javaClass.getName() + "]")

        // build request url
        val url = request.url(property)
        val logMessage = String.format("[%s][%s]", request.method(), url)
        var success = false
        var string = ""
        val body =
            converter.convertRequest<RequestBody, Tuple2<IUiaRequest?, GoogleProperty?>>(Tuple.of(request, property))
        val headers = converter.buildHeaders<Headers, Tuple2<IUiaRequest?, GoogleProperty?>>(Tuple.of(request, property))

        // build httpRequest
        @Suppress("Duplicated_code_fragment")
        val httpRequest: Request = Request.Builder()
            .url(url)
            .headers(headers)
            .method(request.method().method, if (HttpMethod.POST == request.method()) body else null)
            .build()

        // call 
        try {
            @Suppress("Duplicated_code_fragment")
            client.newCall(httpRequest).execute().use { response ->

                // fetch request
                val responseBody = response.body
                required(responseBody, "请求无响应内容：[$url]")
                string = responseBody!!.string()
                success = true
                return string
            }
        } catch (e: Exception) {
            success = false
            throw UiaException(e)
        } finally {
            log.debug("{}[{}][{}]", logMessage, success, string)
        }
    }

    companion object {
        private val log = LoggerFactory.getLogger(GoogleUiaClient::class.java)

        /**
         * instance
         *
         * @param property property
         * @return client
         */
        @JvmStatic
        fun getInstance(property: GoogleProperty): GoogleUiaClient {
            val client = GoogleUiaClient()
            client.property = property
            checkMustRequired(property)
            return client
        }

        private fun checkMustRequired(property: GoogleProperty) {
            required(property, "the configuration is required")
            required(property.clientId, "the clientId configuration is required")
            required(property.clientSecret, "the clientSecret configuration is required")
        }
    }
}
