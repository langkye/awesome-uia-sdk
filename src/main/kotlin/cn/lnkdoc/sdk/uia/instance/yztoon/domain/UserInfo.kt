package cn.lnkdoc.sdk.uia.instance.yztoon.domain

import cn.lnkdoc.sdk.uia.common.util.CaseFormat
import com.alibaba.fastjson2.JSONObject
import com.alibaba.fastjson2.toJSONString
import org.apache.commons.collections4.CollectionUtils
import org.apache.commons.collections4.MapUtils
import org.apache.commons.lang3.StringUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.Serializable

/**
 * 一证通用户信息。
 * M：必填
 * C：条件必填
 * O：非必填
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
class UserInfo : Serializable {
    private val logger : Logger = LoggerFactory.getLogger(UserInfo::class.java)
    
    /**
     * M
     * 用户唯一标识
     */
    var uid: String? = null
    /**
     * M
     * 单位名称
     */
    var cn: String? = null
    /**
     * M
     * 组织机构代码
     */
    var idCardNumber: String? = null
    /**
     * M
     * 账号类型
     * Credence_002 表示用户名口令账号、
     * Credence_001 表示证书或电子营业执照用户（其中 uid 以 EBL@开头为电子营业执照登录，其他为证书登录）
     */
    var credenceClass: String? = null
    /**
     * M
     * 账号等级:账号等级从低到高为：L1、 L2、L3
     */
    var trustLevel: String? = null
    /**
     * O
     * 被授权的事项及相关的说明
     */
    var instruction: String? = null
    /**
     * tokenId
     */
    var tokenId: String? = null
    /**
     * isParse
     */
    var isParse = false


    /**
     * 扩展信息:
     * 必填字段：
     * UNION_CODE：统一社会信用代码
     * BLR_NAME：办理人姓名
     * BLR_CARDID：办理人身份证号
     * BLR_MOBILE：办理人手机（经办人手机号码，电子营 业执照登录用户无手机号）
     * BLR_EMAIL：办理人邮箱
     */
    var extProperties: List<String?>? = null
        set(extProperties) {
            field = extProperties
            parseExtInfo()
        }
    /**
     * 扩展信息中
     */
    var extInfo: UserExtInfo? = null
        /**
         * getter
         *
         * @return userExtInfo
         */
        get() {
            if (isParse) {
                return field
            }
            if (CollectionUtils.isNotEmpty(extProperties)) {
                val map = HashMap<String?, String?>()
                for (extProperty in extProperties!!) {
                    if (StringUtils.isNotBlank(extProperty)) {
                        if (extProperty!!.contains("=")) {
                            val kv = extProperty.split("=".toRegex()).dropLastWhile { it.isEmpty() }
                                .toTypedArray()
                            var k: String? = null
                            try {
                                k = kv[0]
                            } catch (e: Exception) {
                                logger.error("", e)
                            }
                            var v: String? = null
                            try {
                                v = kv[1]
                                if ("null" == v) {
                                    v = null
                                }
                            } catch (e: Exception) {
                                logger.error("", e)
                            }
                            map[CaseFormat.UPPER_UNDERSCORE_2_LOWER_CAMEL(k)] = v
                        } else {
                            logger.warn(
                                "拓展信息不是以'='分割：{}",
                                extProperty
                            )
                        }
                    }
                }
                if (MapUtils.isNotEmpty(map)) {
                    try {
                        val string = map.toJSONString()
                        field = JSONObject.parseObject(string, UserExtInfo::class.java)
                        isParse = true
                    } catch (e: Exception) {
                        logger.error("", e)
                    }
                }
            }
            if (field == null) {
                field = UserExtInfo()
            }
            return field
        }

    /**
     * parser
     */
    fun parseExtInfo() {
        extInfo
    }

    companion object {
        private val logger = LoggerFactory.getLogger(UserInfo::class.java)
    }
}
