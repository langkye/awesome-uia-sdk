package cn.lnkdoc.sdk.uia.common.util.cert;

import javax.net.ssl.*;
import java.security.cert.*;

/**
 * @author langkye
 */
@SuppressWarnings("unused")
public class SavingTrustManager implements X509TrustManager {
    private final X509TrustManager tm;
    private X509Certificate[] chain;

    /**
     * constructor
     * 
     * @param tm tm
     */
    SavingTrustManager(X509TrustManager tm) {
        this.tm = tm;
    }

    /**
     * Return an array of certificate authority certificates
     * which are trusted for authenticating peers.
     *
     * @return a non-null (possibly empty) array of acceptable
     *          CA issuer certificates.
     */
    @Override
    public X509Certificate[] getAcceptedIssuers() {
        throw new UnsupportedOperationException("SavingTrustManager");
    }

    /**
     * Given the partial or complete certificate chain provided by the
     * peer, build a certificate path to a trusted root and return if
     * it can be validated and is trusted for client SSL
     * authentication based on the authentication type.
     * <p>
     * The authentication type is determined by the actual certificate
     * used. For instance, if RSAPublicKey is used, the authType
     * should be "RSA". Checking is case-sensitive.
     *
     * @param chain the peer certificate chain
     * @param authType the authentication type based on the client certificate
     * @throws IllegalArgumentException if null or zero-length chain
     *         is passed in for the chain parameter or if null or zero-length
     *         string is passed in for the  authType parameter
     */
    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) {
        throw new UnsupportedOperationException("SavingTrustManager");
    }

    /**
     * Given the partial or complete certificate chain provided by the
     * peer, build a certificate path to a trusted root and return if
     * it can be validated and is trusted for server SSL
     * authentication based on the authentication type.
     * <p>
     * The authentication type is the key exchange algorithm portion
     * of the cipher suites represented as a String, such as "RSA",
     * "DHE_DSS". Note: for some exportable cipher suites, the key
     * exchange algorithm is determined at run time during the
     * handshake. For instance, for TLS_RSA_EXPORT_WITH_RC4_40_MD5,
     * the authType should be RSA_EXPORT when an ephemeral RSA key is
     * used for the key exchange, and RSA when the key from the server
     * certificate is used. Checking is case-sensitive.
     *
     * @param chain the peer certificate chain
     * @param authType the key exchange algorithm used
     * @throws IllegalArgumentException if null or zero-length chain
     *         is passed in for the chain parameter or if null or zero-length
     *         string is passed in for the  authType parameter
     * @throws CertificateException if the certificate chain is not trusted
     *         by this TrustManager.
     */
    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        this.chain = chain;
        tm.checkServerTrusted(chain, authType);
    }

    /**
     * getter
     * 
     * @return tm
     */
    public X509TrustManager getTm() {
        return tm;
    }

    /**
     * getter
     * 
     * @return chain
     */
    public X509Certificate[] getChain() {
        return chain;
    }

    /**
     * setter
     * 
     * @param chain chain
     */
    public void setChain(X509Certificate[] chain) {
        this.chain = chain;
    }
}