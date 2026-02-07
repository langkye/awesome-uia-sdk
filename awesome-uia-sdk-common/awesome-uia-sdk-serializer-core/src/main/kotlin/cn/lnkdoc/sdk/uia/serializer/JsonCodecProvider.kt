package cn.lnkdoc.sdk.uia.serializer

import cn.lnkdoc.sdk.uia.serializer.config.SerializationConfig

/**
 * JsonCodecProvider
 *
 * @author langkye
 * @since 1.0.0
 */
interface JsonCodecProvider {
    /**
     * name
     *
     * @return name
     */
    fun name(): String

    /**
     * create
     *
     * @param config config
     * @return JsonCodec
     */
    fun create(config: SerializationConfig): JsonCodec
}
