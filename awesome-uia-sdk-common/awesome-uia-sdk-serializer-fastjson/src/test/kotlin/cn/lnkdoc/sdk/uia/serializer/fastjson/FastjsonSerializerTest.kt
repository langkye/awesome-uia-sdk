package cn.lnkdoc.sdk.uia.serializer.fastjson

import cn.lnkdoc.sdk.uia.serializer.JsonCodecRegistry
import cn.lnkdoc.sdk.uia.serializer.annotation.UiaJsonField
import cn.lnkdoc.sdk.uia.serializer.config.SerializationConfig
import cn.lnkdoc.sdk.uia.serializer.config.SerializationConfigLoader
import cn.lnkdoc.sdk.uia.serializer.extensions.toJSONString
import cn.lnkdoc.sdk.uia.serializer.extensions.into
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class FastjsonSerializerTest {

    data class TestUser(
        var userName: String? = null,
        var userAge: Int? = null
    )

    @Test
    fun testSerializationWithConfig() {
        val yaml = $$"""
            mappings:
              cn.lnkdoc.sdk.uia.serializer.fastjson.FastjsonSerializerTest$TestUser:
                fields:
                  userName:
                    name:
                      value: name
                  userAge:
                    serialize: false
        """.trimIndent()

        val config = SerializationConfigLoader.loadFromYaml(yaml.byteInputStream())
        val codec = JsonCodecRegistry.load(config, "fastjson")

        val user = TestUser("Jack", 20)
        val json = user.toJSONString(codec)
        println("[DEBUG_LOG] Fastjson Generated JSON: $json")

        assertTrue(json.contains("\"name\":\"Jack\""), "userName should be mapped to name")
        assertTrue(!json.contains("userAge") && !json.contains("user_age"), "userAge should be ignored")
    }


    @Suppress("unused")
    data class AccessToken (
        /**
         * accessToken
         */
        //@set:UiaJsonField(name = "access_token")
        //@get:UiaJsonField(name = "accessToken")
        var accessToken: String? = null,
        /**
         * tokenType
         */
        //@set:UiaJsonField(name = "token_type")
        var tokenType: String? = null,
        /**
         * expiresIn
         */
        //@set:UiaJsonField(name = "expires_in")
        var expiresIn: String? = null,
        /**
         * refreshToken
         */
        @set:UiaJsonField(name = "refresh_token")
        var refreshToken: String? = null,
    )
    
    @Test
    fun testAccessTokenSerializationUseAnnotation() {
        val codec = JsonCodecRegistry.load(SerializationConfig(), "fastjson")
        val accessToken = AccessToken("token", "Bearer", "3600", "ser_refresh_token_value")
        val json = accessToken.toJSONString(codec)
        println("[DEBUG_LOG] AccessToken JSON: $json")

        // 序列化验证：应该保持原属性名（因为只配置了 @set，没配置 @get）
        assertTrue(json.contains("\"accessToken\":\"token\""), "accessToken should use property name")
        assertTrue(json.contains("\"refreshToken\":\"ser_refresh_token_value\""), "refreshToken should use property name, not annotated name from setter")

        // 反序列化验证
        val jsonInput = """{"accessToken":"token","tokenType":"Bearer","expiresIn":"3600","refresh_token":"de_refresh_token_from_json"}"""
        val deserialized = jsonInput.into<AccessToken>(codec)
        println("[DEBUG_LOG] Deserialized object: $deserialized")

        assertEquals("de_refresh_token_from_json", deserialized.refreshToken, "refreshToken should be deserialized from refresh_token")
    }
}
