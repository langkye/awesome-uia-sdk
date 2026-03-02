package cn.lnkdoc.sdk.uia.serializer

import java.lang.reflect.Type

/**
 * JsonCodec
 *
 * @author langkye
 * @since 1.0.0
 */
interface JsonCodec {
    /**
     * to JSON
     *
     * @param obj obj
     * @return json
     */
    fun toJson(obj: Any): String

    /**
     * from JSON string
     *
     * @param json json
     * @param clazz clazz
     * @param T T
     * @return T
     */
    fun <T> fromJson(json: String, clazz: Class<T>): T

    /**
     * from JSON with generic type
     *
     * @param json json
     * @param type type
     * @param T T
     * @return T
     */
    fun <T> fromJson(json: String, type: Type): T

    /**
     * check json is JSONObject
     * @param json json
     */
    fun isJSONObject(json: String): Boolean
}
