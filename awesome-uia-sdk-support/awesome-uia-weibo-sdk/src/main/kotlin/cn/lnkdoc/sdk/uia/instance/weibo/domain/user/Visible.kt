package cn.lnkdoc.sdk.uia.instance.weibo.domain.user

import cn.lnkdoc.sdk.uia.serializer.annotation.UiaJsonField


@Suppress("unused", "MemberVisibilityCanBePrivate")
class Visible {
    @set:UiaJsonField(name = "list_id")
    var listId: Int? = null
    @set:UiaJsonField(name = "type")
    var type: Int? = null
}
