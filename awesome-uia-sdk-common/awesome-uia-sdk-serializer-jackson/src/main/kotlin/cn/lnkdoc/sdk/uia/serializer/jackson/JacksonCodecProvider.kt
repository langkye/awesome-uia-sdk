package cn.lnkdoc.sdk.uia.serializer.jackson

import cn.lnkdoc.sdk.uia.serializer.JsonCodec
import cn.lnkdoc.sdk.uia.serializer.JsonCodecProvider
import cn.lnkdoc.sdk.uia.serializer.config.SerializationConfig
import com.google.auto.service.AutoService

/**
 * JacksonCodecProvider
 *
 * @author langkye
 * @since 1.0.0
 */
@AutoService(JsonCodecProvider::class)
class JacksonCodecProvider : JsonCodecProvider {
    override fun name(): String {
        return "jackson"
    }

    override fun create(config: SerializationConfig): JsonCodec {
        return JacksonCodecFactory.create(config)
    }
}
