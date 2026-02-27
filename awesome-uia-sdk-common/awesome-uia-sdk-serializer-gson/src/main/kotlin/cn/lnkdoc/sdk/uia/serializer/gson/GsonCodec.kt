package cn.lnkdoc.sdk.uia.serializer.gson

import cn.lnkdoc.sdk.uia.serializer.JsonCodec
import cn.lnkdoc.sdk.uia.serializer.config.Direction
import cn.lnkdoc.sdk.uia.serializer.config.RuleResolver
import cn.lnkdoc.sdk.uia.serializer.config.SerializationConfig
import com.google.gson.FieldNamingStrategy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import java.lang.reflect.Field


/**
 * GsonCodec
 *
 * @author langkye
 * @since 1.0.0
 */
class GsonCodec(private val gson: Gson) : JsonCodec {
    override fun toJson(obj: Any): String {
        return gson.toJson(obj)
    }

    override fun <T> fromJson(json: String, clazz: Class<T>): T {
        return gson.fromJson(json, clazz)
    }

    /**
     * check json is JSONObject
     * @param json json
     */
    override fun isJSONObject(json: String): Boolean {
        try {
            JsonParser.parseString(json)
            return true
        } catch (_: Exception) {
            return false
        }
    }
}

/**
 * GsonCodecFactory
 */
object GsonCodecFactory {
    fun create(config: SerializationConfig): GsonCodec {
        val ruleResolver = RuleResolver(config)
        val builder = GsonBuilder()

        // 统一规则映射
        builder.setFieldNamingStrategy(object : FieldNamingStrategy {
            override fun translateName(f: Field): String {
                return ruleResolver.resolveFieldName(f.declaringClass, f.name, Direction.SERIALIZE, f) ?: f.name
            }
        })
        
        // 注意：Gson 的 FieldNamingStrategy 是同时用于序列化和反序列化的。
        // 如果 RuleResolver 为两者提供了不同的名称，Gson 只能选其一（通常是序列化的）。

        // Inclusion/Exclusion
        builder.setExclusionStrategies(object : com.google.gson.ExclusionStrategy {
            override fun shouldSkipField(f: com.google.gson.FieldAttributes): Boolean {
                // Try to find field in class to get AnnotatedElement
                val field = try {
                    f.declaringClass.getDeclaredField(f.name)
                } catch (e: Exception) {
                    null
                }
                return !ruleResolver.resolveInclusion(f.declaringClass, f.name, Direction.SERIALIZE, field)
            }

            override fun shouldSkipClass(clazz: Class<*>): Boolean {
                return false
            }
        })

        // Default date format
        config.default.dateTimeFormat?.let {
            builder.setDateFormat(it)
        }

        return GsonCodec(builder.create())
    }
}
