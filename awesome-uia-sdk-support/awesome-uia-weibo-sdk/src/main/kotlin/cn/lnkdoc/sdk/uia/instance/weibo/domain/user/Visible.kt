package cn.lnkdoc.sdk.uia.instance.weibo.domain.user


import com.alibaba.fastjson.annotation.JSONField

@Suppress("unused", "MemberVisibilityCanBePrivate")
class Visible {
    @JSONField(name = "list_id")
    var listId: Int? = null
    @JSONField(name = "type")
    var type: Int? = null
}