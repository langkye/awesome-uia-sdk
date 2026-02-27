package cn.lnkdoc.sdk.uia.serializer.jackson

import cn.lnkdoc.sdk.uia.serializer.JsonCodec
import cn.lnkdoc.sdk.uia.serializer.config.RuleResolver
import cn.lnkdoc.sdk.uia.serializer.config.SerializationConfig
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.text.SimpleDateFormat

/**
 * JacksonCodec
 *
 * @author langkye
 * @since 1.0.0
 */
class JacksonCodec(private val objectMapper: ObjectMapper) : JsonCodec {
    override fun toJson(obj: Any): String {
        return objectMapper.writeValueAsString(obj)
    }

    override fun <T> fromJson(json: String, clazz: Class<T>): T {
        return objectMapper.readValue(json, clazz)
    }

    /**
     * check json is JSONObject
     * @param json json
     */
    override fun isJSONObject(json: String): Boolean {
        try {
            objectMapper.readTree(json)
            return true
        } catch (_: Exception) {
            return false
        }
    }
}

/**
 * JacksonCodecFactory
 */
object JacksonCodecFactory {
    /**
     * create
     *
     * @param config config
     * @return JacksonCodec
     */
    fun create(config: SerializationConfig): JacksonCodec {
        val mapper = ObjectMapper()
        mapper.registerKotlinModule()
        
        val ruleResolver = RuleResolver(config)
        mapper.setAnnotationIntrospector(ConfigDrivenAnnotationIntrospector(ruleResolver))
        
        // Default naming strategy
        config.default.namingStrategy?.let { strategy ->
            mapper.propertyNamingStrategy = when (strategy) {
                cn.lnkdoc.sdk.uia.serializer.config.NamingStrategy.SNAKE_CASE -> PropertyNamingStrategies.SNAKE_CASE
                cn.lnkdoc.sdk.uia.serializer.config.NamingStrategy.UPPER_CAMEL_CASE -> PropertyNamingStrategies.UPPER_CAMEL_CASE
                cn.lnkdoc.sdk.uia.serializer.config.NamingStrategy.KEBAB_CASE -> PropertyNamingStrategies.KEBAB_CASE
                cn.lnkdoc.sdk.uia.serializer.config.NamingStrategy.LOWER_CASE -> PropertyNamingStrategies.LOWER_CASE
                else -> PropertyNamingStrategies.LOWER_CAMEL_CASE
            }
        }
        
        // Default date format
        config.default.dateTimeFormat?.let {
            mapper.dateFormat = SimpleDateFormat(it)
        }

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        
        return JacksonCodec(mapper)
    }
}
