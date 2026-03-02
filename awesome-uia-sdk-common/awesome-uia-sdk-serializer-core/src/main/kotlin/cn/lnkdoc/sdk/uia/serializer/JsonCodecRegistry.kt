package cn.lnkdoc.sdk.uia.serializer

import cn.lnkdoc.sdk.uia.serializer.config.SerializationConfig
import java.util.*

/**
 * JsonCodecRegistry
 *
 * @author langkye
 * @since 1.0.0
 */
object JsonCodecRegistry {
    private val providers: Map<String, JsonCodecProvider> by lazy {
        ServiceLoader.load(JsonCodecProvider::class.java)
            .associateBy { it.name() }
    }

    /**
     * load
     *
     * @param config config
     * @param preferred preferred
     * @return JsonCodec
     */
    fun load(config: SerializationConfig? = null, preferred: String? = null): JsonCodec {
        val name = preferred ?: JsonCodecContext.getDefaultCodecName()
        val serializationConfig = config ?: JsonCodecContext.getDefaultSerializationConfig()
        val provider = providers[name] ?: throw IllegalArgumentException("No JsonCodecProvider found for name: $name")
        return provider.create(serializationConfig)
    }
}
