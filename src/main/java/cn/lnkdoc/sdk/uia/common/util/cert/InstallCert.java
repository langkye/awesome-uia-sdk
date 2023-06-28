package cn.lnkdoc.sdk.uia.common.util.cert;

/*
 * Copyright 2006 Sun Microsystems, Inc.  All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  - Neither the name of Sun Microsystems nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.*;
import java.security.cert.*;
import java.util.Objects;

import javax.net.ssl.*;

/**
 * @author langkye
 */
public class InstallCert {
    private static final char[] HEX_DIGITS = "0123456789abcdef".toCharArray();
    private static final char SEPARATOR = File.separatorChar;
    private static final String DEFAULT_KEYSTORE_PASSWORD = "changeit";
    private static final String KEYS_STORE_NAME = "jssecacerts";
    private static final String DEFAULT_KEYS_STORE_NAME = "cacerts";
    private static final String SECURITY_CERT_HOME = System.getProperty("java.home") + SEPARATOR + "lib" + SEPARATOR + "security";
    private static final String PROJECT_HOME = System.getProperty("user.dir");

    public static void main(String[] args) throws Exception {
        String domain = "yzt.beijing.gov.cn";
        // generate cert : ${PROJECT_HOME}/jssecacerts
        generateTrustStore(domain);
        
        // move ${PROJECT_HOME}/jssecacerts to ${SECURITY_CERT_HOME}
    }

    public static void generateTrustStore(String domain) throws NoSuchAlgorithmException, CertificateException, IOException, KeyStoreException, KeyManagementException {
        generateTrustStore(domain, null);
    }

    public static void generateTrustStore(String domain, String password) throws NoSuchAlgorithmException, CertificateException, IOException, KeyStoreException, KeyManagementException {
        if (Objects.isNull(domain)) {
            System.err.println("domain must be not null");
            return;
        }
        String keyStoreName = KEYS_STORE_NAME;
        String certFilePath = PROJECT_HOME + SEPARATOR + keyStoreName;

        password = (Objects.isNull(password) || "".equals(password.trim())) ? DEFAULT_KEYSTORE_PASSWORD : password;
        String host;
        int port;
        char[] passwordCharArray;

        String[] hostAndPort = domain.split(":");

        host = hostAndPort[0];
        port = (hostAndPort.length == 1) ? 443 : Integer.parseInt(hostAndPort[1]);
        passwordCharArray = password.toCharArray();

        File file = new File(certFilePath);

        if (!file.isFile()) {
            File dir = new File(SECURITY_CERT_HOME);
            file = new File(dir, keyStoreName);
            if (!file.isFile()) {
                file = new File(dir, DEFAULT_KEYS_STORE_NAME);
            }
        }

        System.out.println("Loading KeyStore " + file + " ...");

        InputStream in = Files.newInputStream(file.toPath());
        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
        ks.load(in, passwordCharArray);
        in.close();

        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(ks);
        X509TrustManager defaultTrustManager = (X509TrustManager) tmf.getTrustManagers()[0];
        SavingTrustManager tm = new SavingTrustManager(defaultTrustManager);

        SSLContext context = SSLContext.getInstance("TLS");
        context.init(null, new TrustManager[]{tm}, null);
        SSLSocketFactory factory = context.getSocketFactory();

        System.out.println("Opening connection to " + host + ":" + port + "...");

        SSLSocket socket = (SSLSocket) factory.createSocket(host, port);
        socket.setSoTimeout(10000);

        try {
            System.out.println("Starting SSL handshake...");
            socket.startHandshake();
            socket.close();
            System.out.println();
            System.out.println("No errors, certificate is already trusted");
        } catch (SSLException e) {
            System.err.println("====================================================================================");
            e.printStackTrace(System.out);
        } catch (UnsupportedOperationException ignored) {
        }

        X509Certificate[] chain = tm.getChain();
        if (chain == null) {
            System.err.println("Could not obtain server certificate chain");
            return;
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println();
        System.out.println("Server sent " + chain.length + " certificate(s):");
        System.out.println();

        MessageDigest sha1 = MessageDigest.getInstance("SHA1");
        MessageDigest md5 = MessageDigest.getInstance("MD5");

        for (int i = 0; i < chain.length; i++) {
            X509Certificate cert = chain[i];
            System.out.println(" " + (i + 1) + " Subject " + cert.getSubjectDN());
            System.out.println("  Issuer  " + cert.getIssuerDN());

            sha1.update(cert.getEncoded());
            System.out.println("  sha1    " + toHexString(sha1.digest()));

            md5.update(cert.getEncoded());
            System.out.println("  md5    " + toHexString(md5.digest()));
            System.out.println();
        }

        System.out.println("Enter certificate to add to trusted keystore or 'q' to quit: [1]");

        String line = reader.readLine().trim();
        int k;
        try {
            k = (line.length() == 0) ? 0 : Integer.parseInt(line) - 1;
        } catch (NumberFormatException e) {
            System.err.println("KeyStore not changed");
            return;
        }

        X509Certificate cert = chain[k];
        String alias = host + "-" + (k + 1);
        ks.setCertificateEntry(alias, cert);
        Path path = Paths.get(certFilePath);
        OutputStream out = Files.newOutputStream(path);

        ks.store(out, passwordCharArray);
        out.close();

        System.out.println();
        System.out.println(cert);
        System.out.println();
        System.out.println("Added certificate to keystore " + certFilePath + " using alias '" + alias + "'");
    }

    private static String toHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 3);
        for (int b : bytes) {
            b &= 0xff;
            sb.append(HEX_DIGITS[b >> 4]);
            sb.append(HEX_DIGITS[b & 15]);
            sb.append(' ');
        }
        return sb.toString();
    }

}