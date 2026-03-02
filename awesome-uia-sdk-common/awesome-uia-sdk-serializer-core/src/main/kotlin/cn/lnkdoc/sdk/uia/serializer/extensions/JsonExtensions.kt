package cn.lnkdoc.sdk.uia.serializer.extensions

import cn.lnkdoc.sdk.uia.serializer.JsonCodec
import cn.lnkdoc.sdk.uia.serializer.JsonCodecRegistry
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type


abstract class TypeReference<T> {
    val type: Type = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
}

/**
 * to JSON string
 *
 * @receiver Any
 * @param codec JsonCodec
 * @return String
 */
fun Any.toJSONString(codec: JsonCodec): String {
    return codec.toJson(this)
}

/**
 * to JSON string
 *
 * @receiver Any
 * @return String
 */
fun Any.toJSONString(): String {
    return JsonCodecRegistry.load().toJson(this)
}

/**
 * into
 *
 * @receiver String?
 * @param codec JsonCodec
 * @return T
 */
inline fun <reified T : Any> String?.into(codec: JsonCodec): T {
    if (this == null) {
        throw IllegalArgumentException("JSON string cannot be null")
    }
    val type = object : TypeReference<T>() {}.type
    return codec.fromJson(this, type)
}

/**
 * into
 *
 * @receiver String?
 * @return T
 */
inline fun <reified T : Any> String?.into(): T {
    if (this == null) {
        throw IllegalArgumentException("JSON string cannot be null")
    }
    val type = object : TypeReference<T>() {}.type
    return JsonCodecRegistry.load().fromJson(this, type)
}

/**
 * into
 *
 * @receiver String?
 * @return T
 */
fun String?.isJSONObject(): Boolean {
    if (this == null) {
        throw IllegalArgumentException("JSON string cannot be null")
    }
    return JsonCodecRegistry.load().isJSONObject(this)
}
