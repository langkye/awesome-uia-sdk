package cn.lnkdoc.sdk.uia.instance.weibo.domain.user


import com.alibaba.fastjson.annotation.JSONField

@Suppress("unused", "MemberVisibilityCanBePrivate")
class Insecurity {
    @JSONField(name = "sexual_content")
    var sexualContent: Boolean? = null
}