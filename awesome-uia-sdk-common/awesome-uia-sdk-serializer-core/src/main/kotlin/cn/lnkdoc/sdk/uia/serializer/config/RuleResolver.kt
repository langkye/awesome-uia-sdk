package cn.lnkdoc.sdk.uia.serializer.config

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
     * @return String?
     */
    fun resolveFieldName(clazz: Class<*>, fieldName: String, direction: Direction): String? {
        val classMapping = config.mappings[clazz.name] ?: return null
        val fieldRule = classMapping.fields[fieldName] ?: return null
        val nameRule = fieldRule.name ?: return null

        return when (direction) {
            Direction.SERIALIZE -> nameRule.serialize ?: nameRule.value
            Direction.DESERIALIZE -> nameRule.deserialize ?: nameRule.value
            else -> nameRule.value
        }
    }

    /**
     * resolve inclusion
     *
     * @param clazz clazz
     * @param fieldName fieldName
     * @param direction direction
     * @return Boolean
     */
    fun resolveInclusion(clazz: Class<*>, fieldName: String, direction: Direction): Boolean {
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
     * @return String?
     */
    fun resolveFormat(clazz: Class<*>, fieldName: String, direction: Direction): String? {
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
