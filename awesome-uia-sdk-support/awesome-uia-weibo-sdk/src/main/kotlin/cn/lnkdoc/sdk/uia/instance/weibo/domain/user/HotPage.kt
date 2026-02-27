package cn.lnkdoc.sdk.uia.instance.weibo.domain.user

import cn.lnkdoc.sdk.uia.serializer.annotation.UiaJsonField


@Suppress("unused", "MemberVisibilityCanBePrivate")
class HotPage {
    @set:UiaJsonField(name = "feed_detail_type")
    var feedDetailType: Int? = null
    @set:UiaJsonField(name = "fid")
    var fid: String? = null
}
