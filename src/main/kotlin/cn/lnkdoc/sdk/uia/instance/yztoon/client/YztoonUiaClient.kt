package cn.lnkdoc.sdk.uia.instance.yztoon.client

import cn.lnkdoc.sdk.uia.common.HttpMethod
import cn.lnkdoc.sdk.uia.common.client.IUiaClient
import cn.lnkdoc.sdk.uia.common.exception.UiaException
import cn.lnkdoc.sdk.uia.common.request.IUiaRequest
import cn.lnkdoc.sdk.uia.common.response.IUiaResponse
import cn.lnkdoc.sdk.uia.common.response.UiaResponse.Companion.fail
import cn.lnkdoc.sdk.uia.common.response.UiaResponse.Companion.success
import cn.lnkdoc.sdk.uia.common.util.Assert.required
import cn.lnkdoc.sdk.uia.common.util.trust.TrustDomain.trust
import cn.lnkdoc.sdk.uia.instance.yztoon.property.YztoonProperty
import io.vavr.Tuple
import io.vavr.Tuple2
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import org.apache.hc.core5.http.ContentType
import org.slf4j.LoggerFactory

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
class YztoonUiaClient
/**
 * constructor
 */
private constructor() : IUiaClient {
    /**
     * builder
     */
    private val builder: OkHttpClient.Builder = OkHttpClient().newBuilder()

    /**
     * property
     */
    private var property: YztoonProperty? = null

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

            // match converter
            val converters = request.getConvert<Any, Any>()
            required(converters, "not found converter for [" + request.javaClass.getName() + "]")

            // convert
            val converter = converters[0]
            val t = converter.convertResponse<RESP, Tuple2<String, YztoonProperty?>>(Tuple.of(string, property))
            success(t)
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

        // build mediaType
        val mediaType: MediaType = ContentType.TEXT_PLAIN.mimeType.toMediaType()

        // build requestBody
        val body: RequestBody = "".toRequestBody(mediaType)

        // build httpRequest
        val httpRequest: Request = Request.Builder()
            .url(url)
            .method(request.method().method, if (HttpMethod.POST == request.method()) body else null)
            .build()
        // get or build client
        val client = buildClient(property)

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

    private fun buildClient(property: YztoonProperty?): OkHttpClient {
        if (property!!.isTrustDomain) {
            //builder.hostnameVerifier(new AllowAllHostnameVerifier())
            //builder.hostnameVerifier(new NoopHostnameVerifier());
            trust(builder)
        }
        return builder.build()
    }

    companion object {
        private val log = LoggerFactory.getLogger(YztoonUiaClient::class.java)

        /**
         * instance
         *
         * @param property property
         * @return instance
         */
        fun getInstance(property: YztoonProperty): YztoonUiaClient {
            val uiaClient = YztoonUiaClient()
            uiaClient.property = property
            checkMustRequired(property)
            return uiaClient
        }

        private fun checkMustRequired(property: YztoonProperty) {
            required(property, "the yztoonConfiguration is required")
            required(property.domain, "the domain configuration is required")
            required(property.clientId, "the clientId configuration is required")
            required(property.clientSecret, "the clientSecret configuration is required")
            required(property.redirectUrl, "the redirectUrl configuration is required")
        }
    }
}
