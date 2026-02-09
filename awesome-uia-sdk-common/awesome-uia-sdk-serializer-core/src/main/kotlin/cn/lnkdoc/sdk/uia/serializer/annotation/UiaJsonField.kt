package cn.lnkdoc.sdk.uia.serializer.annotation

import cn.lnkdoc.sdk.uia.serializer.config.Direction

/**
 * UiaJsonField
 *
 * @author langkye
 * @since 1.0.0
 */
@Target(
    AnnotationTarget.FIELD,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.VALUE_PARAMETER
)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class UiaJsonField(
    /**
     * property name
     */
    val name: String = "",

    /**
     * whether to serialize
     */
    val serialize: Boolean = true,

    /**
     * whether to deserialize
     */
    val deserialize: Boolean = true,

    /**
     * date/time format pattern
     */
    val format: String = "",
    
    /**
     * specific direction if needed
     */
    val direction: Direction = Direction.BOTH
)
