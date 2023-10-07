package cn.lnkdoc.sdk.uia.instance.alipay.client

import cn.lnkdoc.sdk.uia.common.client.IUiaClient
import cn.lnkdoc.sdk.uia.common.exception.UiaException
import cn.lnkdoc.sdk.uia.common.request.IUiaRequest
import cn.lnkdoc.sdk.uia.common.response.IUiaResponse
import cn.lnkdoc.sdk.uia.common.response.UiaResponse.Companion.fail
import cn.lnkdoc.sdk.uia.common.response.UiaResponse.Companion.success
import cn.lnkdoc.sdk.uia.common.util.Assert.required
import cn.lnkdoc.sdk.uia.instance.alipay.SignMode
import cn.lnkdoc.sdk.uia.instance.alipay.property.AlipayProperty
import cn.lnkdoc.sdk.uia.instance.alipay.util.CheckResponseUtil.check
import com.alibaba.fastjson2.toJSONString
import com.alipay.api.*
import io.vavr.Tuple
import io.vavr.Tuple3
import org.slf4j.LoggerFactory


/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("Unchecked_cast", "unused")
class AlipayUiaClient private constructor() : IUiaClient {
    /**
     * client
     */
    private var client: AlipayClient = DefaultAlipayClient(CertAlipayRequest())

    /**
     * property
     */
    private var property: AlipayProperty? = null

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
            val response = sendRequest(request)

            // check success
            check(response, property?.isPrintStack())

            // convert 
            val converts = request.getConvert<Any, Any>()
            required(converts, "not found converter for [" + request.javaClass.getSimpleName() + "]")
            val convert = converts[0]
            val resp = convert.convertResponse<Any, AlipayResponse>(response) as RESP

            // check success
            success(resp)
        } catch (e: Exception) {
            if (property!!.isPrintStack()) {
                log.error("", e)
            }
            fail(e.message)
        }
    }

    private fun sendRequest(request: IUiaRequest): AlipayResponse {
        checkMustRequired(property)
        
        initClient()
        
        // build request url
        val url = request.url(property!!)
        val method = request.method()
        val logMessage = String.format("[%s][%s]", method, url)
        var success = true
        var string = ""
        val convert = request.getConvert<Any, Any>()[0]

        // build httpRequest
        val alipayRequest = convert.convertRequest<AlipayRequest<AlipayResponse>, Tuple3<AlipayProperty?, AlipayClient, IUiaRequest>>(
            Tuple.of(
                property,
                client,
                request
            )
        )

        // call 
        try {
            val response = (client.execute(alipayRequest, request.body())
                ?: throw UiaException("The alipay response is null"))
            string = response.toJSONString()
            return response
        } catch (e: Exception) {
            success = false
            throw UiaException(e)
        } finally {
            log.debug("{}[{}][{}]", logMessage, success, string)
        }
    }
    
    private fun initClient() {
        // 公钥模式加签
        if (property?.signMode == SignMode.PUBLIC_KEY.signMode) {
            val alipayConfig = AlipayConfig()
            alipayConfig.serverUrl = property?.alipayGatewayUrl
            alipayConfig.appId = property?.appId
            alipayConfig.privateKey = property?.appPrivateKey
            alipayConfig.format = property?.format
            alipayConfig.charset = property?.charset
            alipayConfig.alipayPublicKey = property?.alipayPublicKey
            alipayConfig.signType = property?.signType
            client = DefaultAlipayClient(alipayConfig)
        } 
        // 公钥证书模式加签
        else{
            val certAlipayRequest = CertAlipayRequest()
            certAlipayRequest.serverUrl = property?.alipayGatewayUrl
            certAlipayRequest.appId = property?.appId
            certAlipayRequest.privateKey = property?.appPrivateKey
            certAlipayRequest.format = property?.format
            certAlipayRequest.charset = property?.charset
            certAlipayRequest.signType = property?.signType
            certAlipayRequest.certPath = property?.appCertPath
            certAlipayRequest.alipayPublicCertPath = property?.alipayCertPath
            certAlipayRequest.rootCertPath = property?.alipayRootCertPath
            client = DefaultAlipayClient(certAlipayRequest)
        }
    }

    companion object {
        private val log = LoggerFactory.getLogger(AlipayUiaClient::class.java)

        /**
         * instance
         *
         * @param property property
         * @return client
         */
        fun getInstance(property: AlipayProperty): AlipayUiaClient {
            val client = AlipayUiaClient()
            client.property = property
            checkMustRequired(property)
            return client
        }

        private fun checkMustRequired(property: AlipayProperty?) {
            required(property, "the configuration is required")
            //required(property.domain, "the domain configuration is required")
            //required(property.clientId, "the clientId configuration is required")
            //required(property.clientSecret, "the clientSecret configuration is required")
        }
    }
}
