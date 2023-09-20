package cn.lnkdoc.sdk.uia.common.util.trust;

import okhttp3.OkHttpClient;

import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public class TrustDomain {
    /**
     * trust
     * 
     * @param builder okhttp_builder
     */
    public static void trust(OkHttpClient.Builder builder) {
        try {
            // 创建一个信任所有证书的X509TrustManager
            final TrustManager[] trustAllCerts = new TrustManager[]{new CertsTrustManager()};

            // 创建一个SSLContext，使用我们创建的信任管理器
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            
            // 创建一个HostnameVerifier，允许所有主机名
            HostnameVerifier allHostsValid = (hostname, session) -> true;

            // Set the ssl socket factory and hostname verifier to trust all certificates
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);

            //builder.hostnameVerifier(allHostsValid);
            builder.setHostnameVerifier$okhttp(allHostsValid);
            
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            throw new RuntimeException(e);
        }
    }
}
