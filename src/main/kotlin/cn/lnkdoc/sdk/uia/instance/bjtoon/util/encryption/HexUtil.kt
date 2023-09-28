package cn.lnkdoc.sdk.uia.instance.bjtoon.util.encryption

import org.apache.commons.lang3.StringUtils
import java.util.*


/**
 * @author langkye
 */
object HexUtil {
    /**
     * 把hex转数组
     * @param hexString hexString
     * @return byte[]
     */
    @JvmStatic
    fun hexStr2ByteArray(hexString: String): ByteArray {
        var varHexString = hexString
        require(!StringUtils.isEmpty(varHexString)) { "this hexString must not be empty" }
        varHexString = varHexString.lowercase(Locale.getDefault())
        val byteArray = ByteArray(varHexString.length / 2)
        var k = 0
        for (i in byteArray.indices) {
            //因为是16进制，最多只会占用4位，转换成字节需要两个16进制的字符，高位在先  
            //将hex 转换成byte   "&" 操作为了防止负数的自动扩展  
            // hex转换成byte 其实只占用了4位，然后把高位进行右移四位  
            // 然后“|”操作  低四位 就能得到 两个 16进制数转换成一个byte.  
            val high = ((varHexString[k].digitToIntOrNull(16) ?: (-1 and 0xff))).toByte()
            val low = ((varHexString[k + 1].digitToIntOrNull(16) ?: (-1 and 0xff))).toByte()
            byteArray[i] = (high.toInt() shl 4 or low.toInt()).toByte()
            k += 2
        }
        return byteArray
    }

    /**
     * byte to hex
     *
     * @param byteArray byteArray
     * @return string
     */
    @JvmStatic
    fun byteArray2HexStr(byteArray: ByteArray?): String {
        require(!(byteArray == null || byteArray.isEmpty())) { "this byteArray must not be null or empty" }
        val hexString = StringBuilder()
        byteArray.forEach { b ->
            if (b.toInt() and 0xff < 0x10) // 0~F前面不零
            {
                hexString.append("0")
            }
            hexString.append(Integer.toHexString(0xFF and b.toInt()))
        }
        return hexString.toString().lowercase(Locale.getDefault())
    }
}

