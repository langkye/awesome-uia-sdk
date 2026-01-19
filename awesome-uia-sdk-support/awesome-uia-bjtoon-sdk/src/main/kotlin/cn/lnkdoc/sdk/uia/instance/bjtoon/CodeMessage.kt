package cn.lnkdoc.sdk.uia.instance.bjtoon

import org.apache.commons.lang3.RegExUtils
import java.util.concurrent.atomic.AtomicReference


/**
 * CodeMessage
 *
 * @author qinyi
 * @version  v 1.0 2018-10-22
 */
@Suppress("unused")
class CodeMessage {
    /**
     * code 
     */
    var code = 0
    /**
     * message 
     */
    var message: String? = null
    /**
     * constructor
     */
    constructor()

    /**
     * constructor
     *
     * @param code code
     * @param message message
     */
    constructor(code: Int, message: String?) {
        this.code = code
        this.message = message
    }

    /**
     * getter
     *
     * @param paramValue paramValue
     * @return message
     */
    fun getMessage(paramValue: String?): String {
        return RegExUtils.replacePattern(message, "\\$\\{.*\\}", paramValue)
    }

    /**
     * getter
     *
     * @param paramValues paramValues
     * @return message
     */
    fun getMessage(paramValues: Map<String, String?>): String? {
        val msg = AtomicReference(message)
        paramValues.forEach { (k: String, v: String?) ->
            val string =
                RegExUtils.replacePattern(msg.get(), "\\$\\{$k\\}", v)
            msg.set(string)
        }
        return msg.get()
    }

    override fun toString(): String {
        return "code = " + this.code + ",message = " + message
    }
}

