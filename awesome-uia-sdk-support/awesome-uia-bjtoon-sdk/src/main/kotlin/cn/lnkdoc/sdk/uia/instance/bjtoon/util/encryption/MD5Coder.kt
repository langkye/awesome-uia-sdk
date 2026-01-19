package cn.lnkdoc.sdk.uia.instance.bjtoon.util.encryption

import java.nio.charset.StandardCharsets
import java.security.MessageDigest


/**
 * @author langkye
 */
@Suppress("FunctionName")
object MD5Coder {
    /**
     * md5
     *
     * @param s string
     * @return md5 string
     */
    @JvmStatic
    fun MD5(s: String): String {
        val hexDigits = charArrayOf(
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f'
        )
        try {
            val btInput = s.toByteArray(StandardCharsets.UTF_8)
            val mdInst = MessageDigest.getInstance("MD5")
            mdInst.update(btInput)
            val md = mdInst.digest()
            val j = md.size
            val str = CharArray(j * 2)
            var k = 0
            for (byte0 in md) {
                str[k++] = hexDigits[byte0.toInt() ushr 4 and 0xF]
                str[k++] = hexDigits[byte0.toInt() and 0xF]
            }
            return String(str)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return ""
    }
}