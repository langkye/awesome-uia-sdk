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

        return ruleResolver.resolveFieldName(clazz, fieldName, direction)
    }

    override fun hasIgnoreMarker(m: AnnotatedMember): Boolean {
        if (super.hasIgnoreMarker(m)) return true
        
        val clazz = m.declaringClass ?: return false
        val fieldName = getFieldName(m) ?: return false

        // Check if it's explicitly disabled in config for BOTH or relevant direction
        // For simplicity, if disabled for serialization, hasIgnoreMarker returns true
        if (!ruleResolver.resolveInclusion(clazz, fieldName, Direction.SERIALIZE)) {
             return true
        }

        return false
    }

    private fun getFieldName(member: AnnotatedMember): String? {
        return when (member) {
            is AnnotatedField -> member.name
            is AnnotatedMethod -> {
                val name = member.name
                if (name.startsWith("get") || name.startsWith("is")) {
                    // Fixme
                    com.fasterxml.jackson.databind.util.BeanUtil.okNameForGetter(member, false)
                } else if (name.startsWith("set")) {
                    // Fixme
                    com.fasterxml.jackson.databind.util.BeanUtil.okNameForSetter(member, false)
                } else {
                    name
                }
            }
            is AnnotatedParameter -> member.name
            else -> member.name
        }
    }
}
