package cn.lnkdoc.sdk.uia.serializer

import cn.lnkdoc.sdk.uia.serializer.config.SerializationConfig
import java.util.concurrent.atomic.AtomicReference

/**
 * JsonCodecContext
 * 
 * Global context for JSON serialization.
 * Allows setting the default codec name and configuration globally.
 * 
 * @author langkye
 * @since 1.0.0
 */
object JsonCodecContext {
    private val defaultCodecName = AtomicReference<String>("jackson")
    private val defaultSerializationConfig = AtomicReference<SerializationConfig>(SerializationConfig())

    /**
     * set default codec name
     * 
     * @param name codec name (e.g., "jackson", "fastjson", "gson")
     */
    fun setDefaultCodecName(name: String) {
        defaultCodecName.set(name)
    }

    /**
     * get default codec name
     * 
     * @return default codec name
     */
    fun getDefaultCodecName(): String {
        return defaultCodecName.get()
    }

    /**
     * set default serialization config
     * 
     * @param config serialization config
     */
    fun setDefaultSerializationConfig(config: SerializationConfig) {
        defaultSerializationConfig.set(config)
    }

    /**
     * get default serialization config
     * 
     * @return default serialization config
     */
    fun getDefaultSerializationConfig(): SerializationConfig {
        return defaultSerializationConfig.get()
    }
}
