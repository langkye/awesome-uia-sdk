package cn.lnkdoc.sdk.uia.instance.weibo.domain.user


import com.alibaba.fastjson.annotation.JSONField

@Suppress("unused", "MemberVisibilityCanBePrivate")
class HotPage {
    @JSONField(name = "feed_detail_type")
    var feedDetailType: Int? = null
    @JSONField(name = "fid")
    var fid: String? = null
}