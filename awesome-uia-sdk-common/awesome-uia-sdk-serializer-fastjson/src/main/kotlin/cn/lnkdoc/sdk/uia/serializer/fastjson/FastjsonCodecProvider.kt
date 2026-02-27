package cn.lnkdoc.sdk.uia.serializer.fastjson

import cn.lnkdoc.sdk.uia.serializer.JsonCodec
import cn.lnkdoc.sdk.uia.serializer.JsonCodecProvider
import cn.lnkdoc.sdk.uia.serializer.config.SerializationConfig
import com.google.auto.service.AutoService

/**
 * FastjsonCodecProvider
 *
 * @author langkye
 * @since 1.0.0
 */
@AutoService(JsonCodecProvider::class)
class FastjsonCodecProvider : JsonCodecProvider {
    override fun name(): String {
        return "fastjson"
    }

    override fun create(config: SerializationConfig): JsonCodec {
        return FastjsonCodecFactory.create(config)
    }
}
