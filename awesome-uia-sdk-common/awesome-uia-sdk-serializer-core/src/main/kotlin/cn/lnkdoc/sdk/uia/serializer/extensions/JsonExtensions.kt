package cn.lnkdoc.sdk.uia.serializer.extensions

import cn.lnkdoc.sdk.uia.serializer.JsonCodec

/**
 * to json
 *
 * @receiver Any
 * @param codec JsonCodec
 * @return String
 */
fun Any.toJson(codec: JsonCodec): String {
    return codec.toJson(this)
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
