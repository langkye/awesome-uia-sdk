package cn.lnkdoc.sdk.uia.instance.weibo.domain.user

import cn.lnkdoc.sdk.uia.serializer.annotation.UiaJsonField


@Suppress("unused", "MemberVisibilityCanBePrivate")
class StatusTotalCounter {
    @set:UiaJsonField(name = "comment_cnt")
    var commentCnt: Int? = null
    @set:UiaJsonField(name = "comment_like_cnt")
    var commentLikeCnt: Int? = null
    @set:UiaJsonField(name = "like_cnt")
    var likeCnt: Int? = null
    @set:UiaJsonField(name = "repost_cnt")
    var repostCnt: Int? = null
    @set:UiaJsonField(name = "total_cnt")
    var totalCnt: Int? = null
}
