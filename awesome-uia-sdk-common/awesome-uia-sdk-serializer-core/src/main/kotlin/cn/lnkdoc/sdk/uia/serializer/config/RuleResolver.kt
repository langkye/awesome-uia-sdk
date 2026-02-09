package cn.lnkdoc.sdk.uia.serializer.config

import cn.lnkdoc.sdk.uia.serializer.annotation.UiaJsonField
import java.lang.reflect.AnnotatedElement

/**
 * RuleResolver
 *
 * @author langkye
 * @since 1.0.0
 */
class RuleResolver(private val config: SerializationConfig) {

    /**
     * resolve field name
     *
     * @param clazz clazz
     * @param fieldName fieldName
     * @param direction direction
     * @param element annotated element
     * @return String?
     */
    fun resolveFieldName(clazz: Class<*>, fieldName: String, direction: Direction, element: AnnotatedElement? = null): String? {
        // 1. Try Annotation
        val annotation = element?.getAnnotation(UiaJsonField::class.java)
        if (annotation != null && annotation.name.isNotEmpty()) {
            return annotation.name
        }

        // 2. Try YAML Config
        val classMapping = config.mappings[clazz.name]
        val fieldRule = classMapping?.fields?.get(fieldName)
        val nameRule = fieldRule?.name

        val configuredName = when (direction) {
            Direction.SERIALIZE -> nameRule?.serialize ?: nameRule?.value
            Direction.DESERIALIZE -> nameRule?.deserialize ?: nameRule?.value
            else -> nameRule?.value
        }
        
        if (configuredName != null) {
            return configuredName
        }

        // 3. Fallback for serialization to prevent name propagation from setter
        if (direction == Direction.SERIALIZE) {
            if (hasSetterWithAnnotation(clazz, fieldName)) {
                // If setter has annotation, we must explicitly return the expected serialization name
                // to prevent Jackson from using the setter's name for serialization.
                val namingStrategy = classMapping?.namingStrategy ?: config.default.namingStrategy
                return applyNamingStrategy(fieldName, namingStrategy)
            }
        }

        return null
    }

    private fun hasSetterWithAnnotation(clazz: Class<*>, fieldName: String): Boolean {
        try {
            val methods = clazz.methods
            val setterName = "set" + fieldName.replaceFirstChar { it.uppercase() }
            for (method in methods) {
                if (method.name == setterName && method.parameterCount == 1) {
                    if (method.isAnnotationPresent(UiaJsonField::class.java)) {
                        val anno = method.getAnnotation(UiaJsonField::class.java)
                        if (anno != null && anno.name.isNotEmpty()) {
                            return true
                        }
                    }
                }
            }
        } catch (e: Exception) {
            // ignore
        }
        return false
    }

    private fun applyNamingStrategy(name: String, strategy: String?): String {
        return when (strategy?.uppercase()) {
            "SNAKE_CASE" -> toSnakeCase(name)
            "KEBAB_CASE" -> toKebabCase(name)
            "UPPER_CAMEL_CASE" -> name.replaceFirstChar { it.uppercase() }
            "LOWER_CASE" -> name.lowercase()
            else -> name
        }
    }

    private fun toSnakeCase(input: String): String {
        val result = StringBuilder()
        for (i in input.indices) {
            val c = input[i]
            if (Character.isUpperCase(c) && i > 0) {
                result.append('_')
            }
            result.append(Character.toLowerCase(c))
        }
        return result.toString()
    }

    private fun toKebabCase(input: String): String {
        val result = StringBuilder()
        for (i in input.indices) {
            val c = input[i]
            if (Character.isUpperCase(c) && i > 0) {
                result.append('-')
            }
            result.append(Character.toLowerCase(c))
        }
        return result.toString()
    }

    /**
     * resolve inclusion
     *
     * @param clazz clazz
     * @param fieldName fieldName
     * @param direction direction
     * @param element annotated element
     * @return Boolean
     */
    fun resolveInclusion(clazz: Class<*>, fieldName: String, direction: Direction, element: AnnotatedElement? = null): Boolean {
        // 1. Try Annotation
        val annotation = element?.getAnnotation(UiaJsonField::class.java)
        if (annotation != null) {
            return when (direction) {
                Direction.SERIALIZE -> annotation.serialize
                Direction.DESERIALIZE -> annotation.deserialize
                else -> true
            }
        }

        // 2. Try YAML Config
        val classMapping = config.mappings[clazz.name] ?: return true
        val fieldRule = classMapping.fields[fieldName] ?: return true
        return when (direction) {
            Direction.SERIALIZE -> fieldRule.serialize
            Direction.DESERIALIZE -> fieldRule.deserialize
            else -> true
        }
    }

    /**
     * resolve format
     *
     * @param clazz clazz
     * @param fieldName fieldName
     * @param direction direction
     * @param element annotated element
     * @return String?
     */
    fun resolveFormat(clazz: Class<*>, fieldName: String, direction: Direction, element: AnnotatedElement? = null): String? {
        // 1. Try Annotation
        val annotation = element?.getAnnotation(UiaJsonField::class.java)
        if (annotation != null && annotation.format.isNotEmpty()) {
            return annotation.format
        }

        // 2. Try YAML Config
        val classMapping = config.mappings[clazz.name] ?: return null
        val fieldRule = classMapping.fields[fieldName] ?: return null
        val formatRule = fieldRule.format ?: return null

        return when (direction) {
            Direction.SERIALIZE -> formatRule.serialize ?: formatRule.pattern
            Direction.DESERIALIZE -> formatRule.deserialize ?: formatRule.pattern
            else -> formatRule.pattern
        }
    }
}
