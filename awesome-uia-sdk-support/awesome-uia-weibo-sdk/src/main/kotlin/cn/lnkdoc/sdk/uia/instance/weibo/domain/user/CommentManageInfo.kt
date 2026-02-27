package cn.lnkdoc.sdk.uia.instance.weibo.domain.user

import cn.lnkdoc.sdk.uia.serializer.annotation.UiaJsonField


@Suppress("unused", "MemberVisibilityCanBePrivate")
class CommentManageInfo {
    @set:UiaJsonField(name = "ai_play_picture_type")
    var aiPlayPictureType: Int? = null
    @set:UiaJsonField(name = "approval_comment_type")
    var approvalCommentType: Int? = null
    @set:UiaJsonField(name = "comment_permission_type")
    var commentPermissionType: Int? = null
    @set:UiaJsonField(name = "comment_sort_type")
    var commentSortType: Int? = null
}
