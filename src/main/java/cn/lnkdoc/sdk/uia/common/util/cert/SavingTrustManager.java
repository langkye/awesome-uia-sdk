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

    SavingTrustManager(X509TrustManager tm) {
        this.tm = tm;
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        throw new UnsupportedOperationException("SavingTrustManager");
    }

    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) {
        throw new UnsupportedOperationException("SavingTrustManager");
    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        this.chain = chain;
        tm.checkServerTrusted(chain, authType);
    }

    public X509TrustManager getTm() {
        return tm;
    }

    public X509Certificate[] getChain() {
        return chain;
    }

    public void setChain(X509Certificate[] chain) {
        this.chain = chain;
    }
}