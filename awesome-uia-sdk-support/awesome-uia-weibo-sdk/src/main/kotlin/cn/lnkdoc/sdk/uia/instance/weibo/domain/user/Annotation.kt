package cn.lnkdoc.sdk.uia.instance.weibo.domain.user

import cn.lnkdoc.sdk.uia.serializer.annotation.UiaJsonField


@Suppress("unused", "MemberVisibilityCanBePrivate")
class Annotation {
    @set:UiaJsonField(name = "mapi_request")
    var mapiRequest: Boolean? = null
}
