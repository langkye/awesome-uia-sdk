package cn.lnkdoc.sdk.uia.serializer.fastjson

import cn.lnkdoc.sdk.uia.serializer.JsonCodec
import cn.lnkdoc.sdk.uia.serializer.config.Direction
import cn.lnkdoc.sdk.uia.serializer.config.RuleResolver
import cn.lnkdoc.sdk.uia.serializer.config.SerializationConfig
import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.alibaba.fastjson.parser.ParserConfig
import com.alibaba.fastjson.util.TypeUtils
import com.alibaba.fastjson.serializer.SerializeFilter
import com.alibaba.fastjson.serializer.SerializeConfig
import com.alibaba.fastjson.serializer.SerializerFeature
import com.alibaba.fastjson.serializer.NameFilter
import com.alibaba.fastjson.serializer.ValueFilter
import com.alibaba.fastjson.serializer.PropertyPreFilter
import com.alibaba.fastjson.serializer.PropertyFilter
import java.lang.reflect.Field
import java.lang.reflect.Method

/**
 * FastjsonCodec
 *
 * @author langkye
 * @since 1.0.0
 */
class FastjsonCodec(
    private val serializeConfig: SerializeConfig,
    private val parserConfig: ParserConfig,
    private val filters: Array<SerializeFilter>,
    private val dateTimeFormat: String?
) : JsonCodec {

    override fun toJson(obj: Any): String {
        return if (dateTimeFormat != null) {
            JSON.toJSONString(obj, serializeConfig, filters, dateTimeFormat, JSON.DEFAULT_GENERATE_FEATURE, SerializerFeature.WriteMapNullValue)
        } else {
            JSON.toJSONString(obj, serializeConfig, filters, SerializerFeature.WriteMapNullValue)
        }
    }

    override fun <T> fromJson(json: String, clazz: Class<T>): T {
        return JSON.parseObject(json, clazz, parserConfig)
    }

    /**
     * check json is JSONObject
     * @param json json
     */
    override fun isJSONObject(json: String): Boolean {
        return JSON.isValidObject(json)
    }
}

/**
 * FastjsonCodecFactory
 */
object FastjsonCodecFactory {
    fun create(config: SerializationConfig): FastjsonCodec {
        val serializeConfig = SerializeConfig()
        val parserConfig = ParserConfig()
        val ruleResolver = RuleResolver(config)

        val filters = mutableListOf<SerializeFilter>()

        // 实现统一的规则映射
        val nameFilter = NameFilter { obj, name, _ ->
            ruleResolver.resolveFieldName(obj.javaClass, name, Direction.SERIALIZE) ?: name
        }
        filters.add(nameFilter)

        val propertyFilter = PropertyFilter { obj, name, _ ->
            ruleResolver.resolveInclusion(obj.javaClass, name, Direction.SERIALIZE)
        }
        filters.add(propertyFilter)
        
        // Fastjson 1.x 不太好通过这种方式处理 format，因为它通常是在 SerializeConfig 中针对特定类型注册的，或者是全局的。
        // 但我们可以针对特定字段使用 ValueFilter

        return FastjsonCodec(serializeConfig, parserConfig, filters.toTypedArray(), config.default.dateTimeFormat)
    }
}
