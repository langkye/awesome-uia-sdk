package cn.lnkdoc.sdk.uia.serializer.config

import org.yaml.snakeyaml.Yaml
import java.io.InputStream

/**
 * SerializationConfigLoader
 *
 * @author langkye
 * @since 1.0.0
 */
object SerializationConfigLoader {
    /**
     * load from yaml
     *
     * @param input input
     * @return SerializationConfig
     */
    fun loadFromYaml(input: InputStream): SerializationConfig {
        val yaml = Yaml()
        return yaml.loadAs(input, SerializationConfig::class.java)
    }
}
