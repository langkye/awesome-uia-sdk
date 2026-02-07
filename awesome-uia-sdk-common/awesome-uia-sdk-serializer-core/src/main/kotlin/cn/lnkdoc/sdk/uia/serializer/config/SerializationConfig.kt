package cn.lnkdoc.sdk.uia.serializer.config

/**
 * SerializationConfig
 *
 * @author langkye
 * @since 1.0.0
 */
class SerializationConfig {
    var default: DefaultRules = DefaultRules()
    var mappings: Map<String, ClassMapping> = mutableMapOf()
}

/**
 * LoadMode
 */
enum class LoadMode {
    JACKSON, GSON, FASTJSON2
}

/**
 * Direction
 */
enum class Direction {
    SERIALIZE, DESERIALIZE, BOTH
}

/**
 * DefaultRules
 */
class DefaultRules {
    var namingStrategy: String? = null
    var dateFormat: String? = "yyyy-MM-dd"
    var timeFormat: String? = "HH:mm:ss"
    var dateTimeFormat: String? = "yyyy-MM-dd HH:mm:ss"
}

/**
 * ClassMapping
 */
class ClassMapping {
    var namingStrategy: String? = null
    var fields: Map<String, FieldRule> = mutableMapOf()
}

/**
 * FieldRule
 */
class FieldRule {
    var serialize: Boolean = true
    var deserialize: Boolean = true
    var name: NameRule? = null
    var format: FormatRule? = null
}

/**
 * NameRule
 */
class NameRule {
    var value: String? = null
    var serialize: String? = null
    var deserialize: String? = null
}

/**
 * FormatRule
 */
class FormatRule {
    var pattern: String? = null
    var serialize: String? = null
    var deserialize: String? = null
}
