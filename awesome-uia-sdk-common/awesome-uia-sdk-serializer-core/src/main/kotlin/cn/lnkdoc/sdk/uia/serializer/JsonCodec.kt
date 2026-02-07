package cn.lnkdoc.sdk.uia.serializer

/**
 * JsonCodec
 *
 * @author langkye
 * @since 1.0.0
 */
interface JsonCodec {
    /**
     * to json
     *
     * @param obj obj
     * @return json
     */
    fun toJson(obj: Any): String

    /**
     * from json
     *
     * @param json json
     * @param clazz clazz
     * @param T T
     * @return T
     */
    fun <T> fromJson(json: String, clazz: Class<T>): T
}
