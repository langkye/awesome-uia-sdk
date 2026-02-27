package cn.lnkdoc.sdk.uia.serializer.gson

import cn.lnkdoc.sdk.uia.serializer.JsonCodecRegistry
import cn.lnkdoc.sdk.uia.serializer.config.SerializationConfigLoader
import cn.lnkdoc.sdk.uia.serializer.extensions.toJSONString
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class GsonSerializerTest {

    data class TestUser(
        var userName: String? = null,
        var userAge: Int? = null
    )

    @Test
    fun testSerializationWithConfig() {
        val yaml = $$"""
            mappings:
              cn.lnkdoc.sdk.uia.serializer.gson.GsonSerializerTest$TestUser:
                fields:
                  userName:
                    name:
                      value: name
                  userAge:
                    serialize: false
        """.trimIndent()

        val config = SerializationConfigLoader.loadFromYaml(yaml.byteInputStream())
        val codec = JsonCodecRegistry.load(config, "gson")

        val user = TestUser("Jack", 20)
        val json = user.toJSONString(codec)
        println("[DEBUG_LOG] Gson Generated JSON: $json")

        assertTrue(json.contains("\"name\":\"Jack\""), "userName should be mapped to name")
        assertTrue(!json.contains("userAge") && !json.contains("userAge"), "userAge should be ignored")
    }
}
