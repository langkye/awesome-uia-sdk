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
                if (name.startsWith("get") || name.startsWith("is")) {
                    com.fasterxml.jackson.databind.util.BeanUtil.okNameForGetter(member, false)
                } else if (name.startsWith("set")) {
                    com.fasterxml.jackson.databind.util.BeanUtil.okNameForSetter(member, false)
                } else {
                    name
                }
            }
            is AnnotatedParameter -> {
                // For Kotlin data class constructor parameters
                member.name
            }
            else -> member.name
        }
    }
}
