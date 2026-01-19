package cn.lnkdoc.sdk.uia.instance.weibo.domain.user


import com.alibaba.fastjson.annotation.JSONField

@Suppress("unused", "MemberVisibilityCanBePrivate")
class StatusTotalCounter {
    @JSONField(name = "comment_cnt")
    var commentCnt: Int? = null
    @JSONField(name = "comment_like_cnt")
    var commentLikeCnt: Int? = null
    @JSONField(name = "like_cnt")
    var likeCnt: Int? = null
    @JSONField(name = "repost_cnt")
    var repostCnt: Int? = null
    @JSONField(name = "total_cnt")
    var totalCnt: Int? = null
}