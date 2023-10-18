package cn.lnkdoc.sdk.uia.instance.weibo.domain.user


import com.alibaba.fastjson.annotation.JSONField

@Suppress("unused", "MemberVisibilityCanBePrivate")
class Status {
    @JSONField(name = "ad_marked")
    var adMarked: Boolean? = null
    @JSONField(name = "annotations")
    var annotations: List<Annotation>? = null
    @JSONField(name = "attitudes_count")
    var attitudesCount: Int? = null
    @JSONField(name = "biz_feature")
    var bizFeature: Int? = null
    @JSONField(name = "biz_ids")
    var bizIds: List<Int>? = null
    @JSONField(name = "can_edit")
    var canEdit: Boolean? = null
    @JSONField(name = "can_reprint")
    var canReprint: Boolean? = null
    @JSONField(name = "comment_manage_info")
    var commentManageInfo: CommentManageInfo? = null
    @JSONField(name = "comments_count")
    var commentsCount: Int? = null
    @JSONField(name = "content_auth")
    var contentAuth: Int? = null
    @JSONField(name = "created_at")
    var createdAt: String? = null
    @JSONField(name = "darwin_tags")
    var darwinTags: List<Any>? = null
    @JSONField(name = "favorited")
    var favorited: Boolean? = null
    @JSONField(name = "geo")
    var geo: Any? = null
    @JSONField(name = "gif_ids")
    var gifIds: String? = null
    @JSONField(name = "hasActionTypeCard")
    var hasActionTypeCard: Int? = null
    @JSONField(name = "hide_flag")
    var hideFlag: Int? = null
    @JSONField(name = "hot_page")
    var hotPage: HotPage? = null
    @JSONField(name = "hot_weibo_tags")
    var hotWeiboTags: List<Any>? = null
    @JSONField(name = "id")
    var id: Long? = null
    @JSONField(name = "idstr")
    var idstr: String? = null
    @JSONField(name = "in_reply_to_screen_name")
    var inReplyToScreenName: String? = null
    @JSONField(name = "in_reply_to_status_id")
    var inReplyToStatusId: String? = null
    @JSONField(name = "in_reply_to_user_id")
    var inReplyToUserId: String? = null
    @JSONField(name = "isLongText")
    var isLongText: Boolean? = null
    @JSONField(name = "is_paid")
    var isPaid: Boolean? = null
    @JSONField(name = "is_show_bulletin")
    var isShowBulletin: Int? = null
    @JSONField(name = "item_category")
    var itemCategory: String? = null
    @JSONField(name = "mblog_vip_type")
    var mblogVipType: Int? = null
    @JSONField(name = "mblogtype")
    var mblogtype: Int? = null
    @JSONField(name = "mid")
    var mid: String? = null
    @JSONField(name = "mlevel")
    var mlevel: Int? = null
    @JSONField(name = "more_info_type")
    var moreInfoType: Int? = null
    @JSONField(name = "new_comment_style")
    var newCommentStyle: Int? = null
    @JSONField(name = "pending_approval_count")
    var pendingApprovalCount: Int? = null
    @JSONField(name = "pic_num")
    var picNum: Int? = null
    @JSONField(name = "pic_urls")
    var picUrls: List<Any>? = null
    @JSONField(name = "positive_recom_flag")
    var positiveRecomFlag: Int? = null
    @JSONField(name = "reposts_count")
    var repostsCount: Int? = null
    @JSONField(name = "reprint_cmt_count")
    var reprintCmtCount: Int? = null
    @JSONField(name = "reward_exhibition_type")
    var rewardExhibitionType: Int? = null
    @JSONField(name = "rid")
    var rid: String? = null
    @JSONField(name = "show_additional_indication")
    var showAdditionalIndication: Int? = null
    @JSONField(name = "show_mlevel")
    var showMlevel: Int? = null
    @JSONField(name = "source")
    var source: String? = null
    @JSONField(name = "source_allowclick")
    var sourceAllowclick: Int? = null
    @JSONField(name = "source_type")
    var sourceType: Int? = null
    @JSONField(name = "text")
    var text: String? = null
    @JSONField(name = "textLength")
    var textLength: Int? = null
    @JSONField(name = "text_tag_tips")
    var textTagTips: List<Any>? = null
    @JSONField(name = "truncated")
    var truncated: Boolean? = null
    @JSONField(name = "userType")
    var userType: Int? = null
    @JSONField(name = "visible")
    var visible: Visible? = null
}