package cn.lnkdoc.sdk.uia.serializer.gson

import cn.lnkdoc.sdk.uia.serializer.JsonCodec
import cn.lnkdoc.sdk.uia.serializer.JsonCodecProvider
import cn.lnkdoc.sdk.uia.serializer.config.SerializationConfig
import com.google.auto.service.AutoService

/**
 * GsonCodecProvider
 *
 * @author langkye
 * @since 1.0.0
 */
@AutoService(JsonCodecProvider::class)
class GsonCodecProvider : JsonCodecProvider {
    override fun name(): String {
        return "gson"
    }

    override fun create(config: SerializationConfig): JsonCodec {
        return GsonCodecFactory.create(config)
    }
}
