package cn.lnkdoc.sdk.uia.serializer.jackson

import cn.lnkdoc.sdk.uia.serializer.annotation.UiaJsonField
import cn.lnkdoc.sdk.uia.serializer.JsonCodecRegistry
import cn.lnkdoc.sdk.uia.serializer.config.SerializationConfigLoader
import cn.lnkdoc.sdk.uia.serializer.extensions.toJson
import cn.lnkdoc.sdk.uia.serializer.extensions.into
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.*

class JacksonSerializerTest {

    data class TestUser(
        var userName: String? = null,
        var userAge: Int? = null,
        var birthDate: Date? = null
    )


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
    fun testSerializationWithConfig() {
        val yaml = """
            default:
              namingStrategy: SNAKE_CASE
              dateTimeFormat: yyyy-MM-dd HH:mm:ss
            mappings:
              cn.lnkdoc.sdk.uia.serializer.jackson.JacksonSerializerTest${"$"}TestUser:
                fields:
                  userName:
                    name:
                      value: name
                  userAge:
                    serialize: false
        """.trimIndent()

        val config = SerializationConfigLoader.loadFromYaml(yaml.byteInputStream())
        val codec = JsonCodecRegistry.load(config, "jackson")

        val user = TestUser("Jack", 20, Date(1738918440000)) // 2025-02-07 16:54:00 GMT+8 or similar
        
        val json = user.toJson(codec)
        println("[DEBUG_LOG] Generated JSON: $json")

        // Check if userName is mapped to "name"
        assertTrue(json.contains("\"name\":\"Jack\""), "userName should be mapped to name")
        // Check if userAge is ignored
        assertTrue(!json.contains("user_age"), "userAge should be ignored in serialization")
        //assertTrue(!json.contains("20"), "userAge value should not be present")
        
        // Deserialization
        val jsonInput = "{\"name\":\"Rose\",\"user_age\":25}"
        val deserialized = jsonInput.into<TestUser>(codec)
        
        assertEquals("Rose", deserialized.userName)
        // user_age should be mapped back to userAge if it's SNAKE_CASE by default
        //assertEquals(25, deserialized.userAge)
    }
    
    @Test
    fun testAccessTokenSerializationUseAnnotation() {
        val codec = JsonCodecRegistry.load(cn.lnkdoc.sdk.uia.serializer.config.SerializationConfig(), "jackson")
        val accessToken = AccessToken("token", "Bearer", "3600", "refresh_token_value")
        val json = accessToken.toJson(codec)
        println("[DEBUG_LOG] AccessToken JSON: $json")
        
        // 序列化验证：应该保持原属性名（因为只配置了 @set，没配置 @get）
        assertTrue(json.contains("\"accessToken\":\"token\""), "accessToken should use property name")
        assertTrue(json.contains("\"refreshToken\":\"refresh_token_value\""), "refreshToken should use property name, not annotated name from setter")
        
        // 反序列化验证
        val jsonInput = """{"accessToken":"token","tokenType":"Bearer","expiresIn":"3600","refresh_token":"refresh_token_from_json"}"""
        val deserialized = jsonInput.into<AccessToken>(codec)
        println("[DEBUG_LOG] Deserialized object: $deserialized")
        
        assertEquals("refresh_token_from_json", deserialized.refreshToken, "refreshToken should be deserialized from refresh_token")
    }

    @Test
    fun testAccessTokenSerializationWithSnakeCase() {
        val config = cn.lnkdoc.sdk.uia.serializer.config.SerializationConfig().apply {
            default.namingStrategy = "SNAKE_CASE"
        }
        val codec = JsonCodecRegistry.load(config, "jackson")
        val accessToken = AccessToken("token", "Bearer", "3600", "refresh_token_value")
        val json = accessToken.toJson(codec)
        println("[DEBUG_LOG] AccessToken Snake JSON: $json")
        
        // 应该都变成 snake_case
        assertTrue(json.contains("\"access_token\":\"token\""), "accessToken should be access_token")
        assertTrue(json.contains("\"token_type\":\"Bearer\""), "tokenType should be token_type")
        assertTrue(json.contains("\"refresh_token\":\"refresh_token_value\""), "refreshToken should be refresh_token due to SNAKE_CASE strategy")
        
        // 现在如果我给某一个配一个冲突的 @set
        // refreshToken 已经在策略下是 refresh_token 了，所以看不出效果。
        // 我们试一个其它的，比如 accessToken
    }
    
    data class MixedAnnotation(
        @set:UiaJsonField(name = "set_name")
        var propertyName: String? = null
    )
    
    @Test
    fun testMixedAnnotationWithSnakeCase() {
        val config = cn.lnkdoc.sdk.uia.serializer.config.SerializationConfig().apply {
            default.namingStrategy = "SNAKE_CASE"
        }
        val codec = JsonCodecRegistry.load(config, "jackson")
        val obj = MixedAnnotation("value")
        val json = obj.toJson(codec)
        println("[DEBUG_LOG] Mixed Snake JSON: $json")
        
        // propertyName -> snake_case -> property_name
        // @set -> set_name
        // 期望序列化结果是 property_name，而不是 set_name
        assertTrue(json.contains("\"property_name\":\"value\""), "Should use snake_case name, not setter name")
        
        val deserialized = """{"set_name":"new_value"}""".into<MixedAnnotation>(codec)
        assertEquals("new_value", deserialized.propertyName)
    }
}
