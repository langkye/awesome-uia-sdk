package cn.lnkdoc.sdk.uia.common.util.trust

import okhttp3.OkHttpClient.Builder
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import java.security.SecureRandom
import javax.net.ssl.*


/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
object TrustDomain {
    /**
     * trust
     *
     * @param builder okhttp_builder
     */
    @JvmStatic
    fun trust(builder: Builder) {
        try {
            // 创建一个信任所有证书的X509TrustManager
            val trustAllCerts = arrayOf<TrustManager>(CertsTrustManager())

            // 创建一个SSLContext，使用我们创建的信任管理器
            val sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, SecureRandom())

            // Create an ssl socket factory with our all-trusting manager
            val sslSocketFactory = sslContext.socketFactory

            // 创建一个HostnameVerifier，允许所有主机名
            val allHostsValid =
                HostnameVerifier { _: String?, _: SSLSession? -> true }

            // Set the ssl socket factory and hostname verifier to trust all certificates
            builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)

            builder.hostnameVerifier(allHostsValid)
        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException(e)
        } catch (e: KeyManagementException) {
            throw RuntimeException(e)
        }
    }
}

