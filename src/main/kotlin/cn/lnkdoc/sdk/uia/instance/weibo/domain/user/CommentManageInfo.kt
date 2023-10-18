package cn.lnkdoc.sdk.uia.instance.weibo.domain.user


import com.alibaba.fastjson.annotation.JSONField

@Suppress("unused", "MemberVisibilityCanBePrivate")
class CommentManageInfo {
    @JSONField(name = "ai_play_picture_type")
    var aiPlayPictureType: Int? = null
    @JSONField(name = "approval_comment_type")
    var approvalCommentType: Int? = null
    @JSONField(name = "comment_permission_type")
    var commentPermissionType: Int? = null
    @JSONField(name = "comment_sort_type")
    var commentSortType: Int? = null
}