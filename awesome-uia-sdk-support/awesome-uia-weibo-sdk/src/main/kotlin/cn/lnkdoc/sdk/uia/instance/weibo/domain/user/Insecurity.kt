package cn.lnkdoc.sdk.uia.instance.weibo.domain.user

import cn.lnkdoc.sdk.uia.serializer.annotation.UiaJsonField


@Suppress("unused", "MemberVisibilityCanBePrivate")
class Insecurity {
    @set:UiaJsonField(name = "sexual_content")
    var sexualContent: Boolean? = null
}
