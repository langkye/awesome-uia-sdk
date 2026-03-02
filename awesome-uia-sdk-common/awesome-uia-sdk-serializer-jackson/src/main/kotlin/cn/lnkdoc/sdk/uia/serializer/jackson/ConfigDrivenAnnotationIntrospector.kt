package cn.lnkdoc.sdk.uia.serializer.jackson

import cn.lnkdoc.sdk.uia.serializer.config.Direction
import cn.lnkdoc.sdk.uia.serializer.config.RuleResolver
import com.fasterxml.jackson.databind.PropertyName
import com.fasterxml.jackson.databind.introspect.Annotated
import com.fasterxml.jackson.databind.introspect.AnnotatedField
import com.fasterxml.jackson.databind.introspect.AnnotatedMember
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector

/**
 * ConfigDrivenAnnotationIntrospector
 *
 * @author langkye
 * @since 1.0.0
 */
class ConfigDrivenAnnotationIntrospector(private val ruleResolver: RuleResolver) : JacksonAnnotationIntrospector() {

    override fun findNameForSerialization(a: Annotated): PropertyName? {
        val name = resolveName(a, Direction.SERIALIZE)
        return if (name != null) PropertyName.construct(name) else super.findNameForSerialization(a)
    }

    override fun findNameForDeserialization(a: Annotated): PropertyName? {
        val name = resolveName(a, Direction.DESERIALIZE)
        return if (name != null) PropertyName.construct(name) else super.findNameForDeserialization(a)
    }

    private fun resolveName(a: Annotated, direction: Direction): String? {
        val member = when (a) {
            is AnnotatedMember -> a
            else -> return null
        }
        val clazz = member.declaringClass ?: return null
        val fieldName = getFieldName(member) ?: return null

        // println("[DEBUG_LOG] resolveName for $fieldName in ${clazz.simpleName}, direction $direction")
        val resolved = ruleResolver.resolveFieldName(clazz, fieldName, direction, member.annotated)
        // println("[DEBUG_LOG] resolved: $resolved")
        return resolved
    }

    override fun hasIgnoreMarker(m: AnnotatedMember): Boolean {
        // First check our config/annotation
        val clazz = m.declaringClass ?: return super.hasIgnoreMarker(m)
        val fieldName = getFieldName(m) ?: return super.hasIgnoreMarker(m)

        // println("[DEBUG_LOG] hasIgnoreMarker for $fieldName in ${clazz.simpleName}")
        val include = ruleResolver.resolveInclusion(clazz, fieldName, Direction.SERIALIZE, m.annotated)
        // println("[DEBUG_LOG] include: $include")
        
        if (!include) {
             return true
        }

        return super.hasIgnoreMarker(m)
    }

    private fun getFieldName(member: AnnotatedMember): String? {
        return when (member) {
            is AnnotatedField -> member.name
            is AnnotatedMethod -> {
                val name = member.name
                when {
                    name.startsWith("get") -> legacyManglePropertyName(name, 3)
                    name.startsWith("is") && isBooleanGetter(member) -> legacyManglePropertyName(name, 2)
                    name.startsWith("set") -> legacyManglePropertyName(name, 3)
                    else -> name
                }
            }
            is AnnotatedParameter -> {
                // For Kotlin data class constructor parameters
                member.name
            }
            else -> member.name
        }
    }

    @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
    private fun isBooleanGetter(member: AnnotatedMethod): Boolean {
        val rt = member.rawType
        return rt == Boolean::class.java || rt == java.lang.Boolean::class.java || rt == java.lang.Boolean.TYPE
    }

    /**
     * Legacy property-name mangling (equivalent to BeanUtil legacy behavior).
     * Keeps compatibility with stdNaming = false.
     */
    private fun legacyManglePropertyName(basename: String, offset: Int): String? {
        val end = basename.length
        if (end == offset) return null
        val c = basename[offset]
        val d = c.lowercaseChar()
        if (c == d) {
            return basename.substring(offset)
        }
        val sb = StringBuilder(end - offset)
        sb.append(d)
        var i = offset + 1
        while (i < end) {
            val c2 = basename[i]
            val d2 = c2.lowercaseChar()
            if (c2 == d2) {
                sb.append(basename, i, end)
                break
            }
            sb.append(d2)
            i++
        }
        return sb.toString()
    }
}
