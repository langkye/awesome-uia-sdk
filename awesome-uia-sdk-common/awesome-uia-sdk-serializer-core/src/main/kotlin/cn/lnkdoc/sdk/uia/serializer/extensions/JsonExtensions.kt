package cn.lnkdoc.sdk.uia.serializer.extensions

import cn.lnkdoc.sdk.uia.serializer.JsonCodec
import cn.lnkdoc.sdk.uia.serializer.JsonCodecRegistry
import cn.lnkdoc.sdk.uia.serializer.config.SerializationConfig

/**
 * to json
 *
 * @receiver Any
 * @param codec JsonCodec
 * @return String
 */
fun Any.toJSONString(codec: JsonCodec): String {
    return codec.toJson(this)
}

/**
 * to json
 *
 * @receiver Any
 * @return String
 */
fun Any.toJSONString(): String {
    return JsonCodecRegistry.load(SerializationConfig(), "jackson").toJson(this)
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
    return codec.fromJson(this, T::class.java)
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
    return JsonCodecRegistry.load(SerializationConfig(), "jackson").fromJson(this, T::class.java)
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
    return JsonCodecRegistry.load(SerializationConfig(), "jackson").isJSONObject(this)
}
