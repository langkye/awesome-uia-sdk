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

package cn.lnkdoc.sdk.uia.common.util.cert

import java.io.BufferedReader
import java.io.File
import java.io.IOException
import java.io.InputStreamReader
import java.nio.file.Files
import java.nio.file.Paths
import java.security.*
import java.security.cert.CertificateException
import java.util.*
import javax.net.ssl.*


/**
 * @author langkye
 */
object InstallCert {
    private val HEX_DIGITS = "0123456789abcdef".toCharArray()
    private val SEPARATOR = File.separatorChar
    private const val DEFAULT_KEYSTORE_PASSWORD = "changeit"
    private const val KEYS_STORE_NAME = "jssecacerts"
    private const val DEFAULT_KEYS_STORE_NAME = "cacerts"
    private val SECURITY_CERT_HOME = System.getProperty("java.home") + SEPARATOR + "lib" + SEPARATOR + "security"
    private val PROJECT_HOME = System.getProperty("user.dir")

    /**
     * main
     *
     * @param args args
     * @throws Exception ex
     */
    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val domain = "yzt.beijing.gov.cn"
        // generate cert : ${PROJECT_HOME}/jssecacerts
        generateTrustStore(domain)

        // move ${PROJECT_HOME}/jssecacerts to $JAVA_HOME/jre/lib/security
    }
    
    /**
     * gen trust store
     *
     * @param domain domain
     * @throws NoSuchAlgorithmException NoSuchAlgorithmException
     * @throws CertificateException CertificateException
     * @throws IOException IOException
     * @throws KeyStoreException KeyStoreException
     * @throws KeyManagementException KeyManagementException
     */
    @JvmOverloads
    @Throws(
        NoSuchAlgorithmException::class,
        CertificateException::class,
        IOException::class,
        KeyStoreException::class,
        KeyManagementException::class
    )
    @JvmStatic
    fun generateTrustStore(domain: String, password: String? = null) {
        var varPassword = password
        if (Objects.isNull(domain)) {
            System.err.println("domain must be not null")
            return
        }
        val keyStoreName = KEYS_STORE_NAME
        val certFilePath = PROJECT_HOME + SEPARATOR + keyStoreName
        varPassword = if (Objects.isNull(varPassword) || varPassword!!.trim { it <= ' ' }
                .isEmpty()) DEFAULT_KEYSTORE_PASSWORD else varPassword
        val host: String
        val port: Int
        val hostAndPort = domain.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        host = hostAndPort[0]
        port = if (hostAndPort.size == 1) 443 else hostAndPort[1].toInt()
        val passwordCharArray: CharArray = varPassword.toCharArray()
        var file = File(certFilePath)
        if (!file.isFile()) {
            val dir = File(SECURITY_CERT_HOME)
            file = File(dir, keyStoreName)
            if (!file.isFile()) {
                file = File(dir, DEFAULT_KEYS_STORE_NAME)
            }
        }
        println("Loading KeyStore $file ...")
        val `in` = Files.newInputStream(file.toPath())
        val ks = KeyStore.getInstance(KeyStore.getDefaultType())
        ks.load(`in`, passwordCharArray)
        `in`.close()
        val tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
        tmf.init(ks)
        val defaultTrustManager = tmf.trustManagers[0] as X509TrustManager
        val tm = SavingTrustManager(defaultTrustManager)
        val context = SSLContext.getInstance("TLS")
        context.init(null, arrayOf<TrustManager>(tm), null)
        val factory = context.socketFactory
        println("Opening connection to $host:$port...")
        val socket = factory.createSocket(host, port) as SSLSocket
        socket.setSoTimeout(10000)
        try {
            println("Starting SSL handshake...")
            socket.startHandshake()
            socket.close()
            println()
            println("No errors, certificate is already trusted")
        } catch (e: SSLException) {
            System.err.println("====================================================================================")
            e.printStackTrace(System.out)
        } catch (ignored: UnsupportedOperationException) {
        }
        val chain = tm.chain
        val reader = BufferedReader(InputStreamReader(System.`in`))
        println()
        println("Server sent " + chain.size + " certificate(s):")
        println()
        val sha1 = MessageDigest.getInstance("SHA1")
        val md5 = MessageDigest.getInstance("MD5")
        for (i in chain.indices) {
            val cert = chain[i]
            println(" " + (i + 1) + " Subject " + cert.getSubjectX500Principal())
            println("  Issuer  " + cert.getSubjectX500Principal())
            sha1.update(cert.encoded)
            println("  sha1    " + toHexString(sha1.digest()))
            md5.update(cert.encoded)
            println("  md5    " + toHexString(md5.digest()))
            println()
        }
        println("Enter certificate to add to trusted keystore or 'q' to quit: [1]")
        val line = reader.readLine().trim { it <= ' ' }
        val k: Int = try {
            if (line.isEmpty()) 0 else line.toInt() - 1
        } catch (e: NumberFormatException) {
            System.err.println("KeyStore not changed")
            return
        }
        val cert = chain[k]
        val alias = host + "-" + (k + 1)
        ks.setCertificateEntry(alias, cert)
        val path = Paths.get(certFilePath)
        val out = Files.newOutputStream(path)
        ks.store(out, passwordCharArray)
        out.close()
        println()
        println(cert)
        println()
        println("Added certificate to keystore $certFilePath using alias '$alias'")
    }

    /**
     * byte to hex
     *
     * @param bytes bytes
     * @return string
     */
    @JvmStatic
    private fun toHexString(bytes: ByteArray): String {
        val sb = StringBuilder(bytes.size * 3)
        for (b in bytes) {
            val byteValue = b.toInt() and 0xff
            sb.append(HEX_DIGITS[byteValue shr 4])
            sb.append(HEX_DIGITS[byteValue and 0x0F])
            sb.append(' ')
        }
        return sb.toString()
    }
}