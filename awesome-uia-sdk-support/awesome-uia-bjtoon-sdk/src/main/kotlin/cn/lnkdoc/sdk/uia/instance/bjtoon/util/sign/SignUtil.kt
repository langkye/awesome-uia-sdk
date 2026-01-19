package cn.lnkdoc.sdk.uia.instance.bjtoon.util.sign

import cn.lnkdoc.sdk.uia.instance.bjtoon.util.encryption.MD5Coder
import org.apache.commons.lang3.StringUtils
import java.util.*


/**
 * AbstractUiaClient
 *
 * @author shizongwang
 * @version v 1.0 2017-12-28
 */
@Suppress("unused")
object SignUtil {
    /**
     * getter
     *
     * @param params sign map
     * @return sign (String)
     */
    @JvmStatic
    fun getSignContent(params: Map<String, String?>): String {
        val content = StringBuilder()
        val keys: List<String> = ArrayList(params.keys)
        //Collections.sort(keys)
        keys.sorted()
        var index = 0
        for (key in keys) {
            val value = params[key]
            //参数不为空的按照key=value用&拼接
            if (StringUtils.isNoneBlank(key, value)) {
                content.append(if (index == 0) "" else "&").append(key).append("=").append(value)
                index++
            }
        }
        return content.toString()
    }

    /**
     * getter
     *
     * @param content content
     * @param signType signType
     * @return sign
     */
    @JvmStatic
    fun getSign(content: String, signType: String?): String? {
        return if (StringUtils.equalsIgnoreCase("md5", signType)) {
            MD5Coder.MD5(content)
        } else null
    }
}

