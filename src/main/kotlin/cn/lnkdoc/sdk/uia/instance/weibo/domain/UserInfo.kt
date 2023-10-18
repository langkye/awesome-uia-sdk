package cn.lnkdoc.sdk.uia.instance.weibo.domain

import cn.lnkdoc.sdk.uia.instance.weibo.domain.user.Insecurity
import cn.lnkdoc.sdk.uia.instance.weibo.domain.user.Status
import cn.lnkdoc.sdk.uia.instance.weibo.domain.user.StatusTotalCounter
import cn.lnkdoc.sdk.uia.instance.weibo.domain.user.VideoTotalCounter
import cn.lnkdoc.sdk.uia.instance.weibo.response.ErrorResponse
import com.alibaba.fastjson.annotation.JSONField

/**
 * @document https://open.weibo.com/wiki/%E5%BE%AE%E5%8D%9AAPI
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused", "MemberVisibilityCanBePrivate")
class UserInfo: ErrorResponse() {

    /**
     * allow_all_act_msg
     */
    @JSONField(name = "allow_all_act_msg")
    var allowAllActMsg: Boolean? = null

    /**
     * allow_all_comment
     */
    @JSONField(name = "allow_all_comment")
    var allowAllComment: Boolean? = null

    /**
     * audio_ability
     */
    @JSONField(name = "audio_ability")
    var audioAbility: Int? = null

    /**
     * avatar_hd
     */
    @JSONField(name = "avatar_hd")
    var avatarHd: String? = null

    /**
     * avatar_large
     */
    @JSONField(name = "avatar_large")
    var avatarLarge: String? = null

    /**
     * avatar_type
     */
    @JSONField(name = "avatar_type")
    var avatarType: Int? = null

    /**
     * bi_followers_count
     */
    @JSONField(name = "bi_followers_count")
    var biFollowersCount: Int? = null

    /**
     * block
     */
    @JSONField(name = "block")
    var block: Int? = null

    /**
     * block_app
     */
    @JSONField(name = "block_app")
    var blockApp: Int? = null

    /**
     * block_me
     */
    @JSONField(name = "block_me")
    var blockMe: Int? = null

    /**
     * block_word
     */
    @JSONField(name = "block_word")
    var blockWord: Int? = null

    /**
     * brand_ability
     */
    @JSONField(name = "brand_ability")
    var brandAbility: Int? = null

    /**
     * brand_account
     */
    @JSONField(name = "brand_account")
    var brandAccount: Int? = null

    /**
     * chaohua_ability
     */
    @JSONField(name = "chaohua_ability")
    var chaohuaAbility: Int? = null

    /**
     * city
     */
    @JSONField(name = "city")
    var city: String? = null

    /**
     * class
     */
    @JSONField(name = "class")
    var classX: Int? = null

    /**
     * cover_image_phone
     */
    @JSONField(name = "cover_image_phone")
    var coverImagePhone: String? = null

    /**
     * created_at
     */
    @JSONField(name = "created_at")
    var createdAt: String? = null

    /**
     * credit_score
     */
    @JSONField(name = "credit_score")
    var creditScore: Int? = null

    /**
     * description
     */
    @JSONField(name = "description")
    var description: String? = null

    /**
     * domain
     */
    @JSONField(name = "domain")
    var domain: String? = null

    /**
     * ecommerce_ability
     */
    @JSONField(name = "ecommerce_ability")
    var ecommerceAbility: Int? = null

    /**
     * favourites_count
     */
    @JSONField(name = "favourites_count")
    var favouritesCount: Int? = null

    /**
     * follow_me
     */
    @JSONField(name = "follow_me")
    var followMe: Boolean? = null

    /**
     * followers_count
     */
    @JSONField(name = "followers_count")
    var followersCount: Int? = null

    /**
     * followers_count_str
     */
    @JSONField(name = "followers_count_str")
    var followersCountStr: String? = null

    /**
     * following
     */
    @JSONField(name = "following")
    var following: Boolean? = null

    /**
     * friends_count
     */
    @JSONField(name = "friends_count")
    var friendsCount: Int? = null

    /**
     * gender
     */
    @JSONField(name = "gender")
    var gender: String? = null

    /**
     * geo_enabled
     */
    @JSONField(name = "geo_enabled")
    var geoEnabled: Boolean? = null

    /**
     * gongyi_ability
     */
    @JSONField(name = "gongyi_ability")
    var gongyiAbility: Int? = null

    /**
     * green_mode
     */
    @JSONField(name = "green_mode")
    var greenMode: Int? = null

    /**
     * hardfan_ability
     */
    @JSONField(name = "hardfan_ability")
    var hardfanAbility: Int? = null

    /**
     * hongbaofei
     */
    @JSONField(name = "hongbaofei")
    var hongbaofei: Int? = null

    /**
     * id
     */
    @JSONField(name = "id")
    var id: Long? = null

    /**
     * idstr
     */
    @JSONField(name = "idstr")
    var idstr: String? = null

    /**
     * insecurity
     */
    @JSONField(name = "insecurity")
    var insecurity: Insecurity? = null

    /**
     * interaction_user
     */
    @JSONField(name = "interaction_user")
    var interactionUser: Int? = null

    /**
     * is_guardian
     */
    @JSONField(name = "is_guardian")
    var isGuardian: Int? = null

    /**
     * is_teenager
     */
    @JSONField(name = "is_teenager")
    var isTeenager: Int? = null

    /**
     * is_teenager_list
     */
    @JSONField(name = "is_teenager_list")
    var isTeenagerList: Int? = null

    /**
     * lang
     */
    @JSONField(name = "lang")
    var lang: String? = null

    /**
     * light_ring
     */
    @JSONField(name = "light_ring")
    var lightRing: Boolean? = null

    /**
     * like
     */
    @JSONField(name = "like")
    var like: Boolean? = null

    /**
     * like_me
     */
    @JSONField(name = "like_me")
    var likeMe: Boolean? = null

    /**
     * live_ability
     */
    @JSONField(name = "live_ability")
    var liveAbility: Int? = null

    /**
     * live_status
     */
    @JSONField(name = "live_status")
    var liveStatus: Int? = null

    /**
     * location
     */
    @JSONField(name = "location")
    var location: String? = null

    /**
     * mb_expire_time
     */
    @JSONField(name = "mb_expire_time")
    var mbExpireTime: Int? = null

    /**
     * mbrank
     */
    @JSONField(name = "mbrank")
    var mbrank: Int? = null

    /**
     * mbtype
     */
    @JSONField(name = "mbtype")
    var mbtype: Int? = null

    /**
     * name
     */
    @JSONField(name = "name")
    var name: String? = null

    /**
     * newbrand_ability
     */
    @JSONField(name = "newbrand_ability")
    var newbrandAbility: Int? = null

    /**
     * nft_ability
     */
    @JSONField(name = "nft_ability")
    var nftAbility: Int? = null

    /**
     * online_status
     */
    @JSONField(name = "online_status")
    var onlineStatus: Int? = null

    /**
     * pagefriends_count
     */
    @JSONField(name = "pagefriends_count")
    var pagefriendsCount: Int? = null

    /**
     * paycolumn_ability
     */
    @JSONField(name = "paycolumn_ability")
    var paycolumnAbility: Int? = null

    /**
     * pc_new
     */
    @JSONField(name = "pc_new")
    var pcNew: Int? = null

    /**
     * planet_video
     */
    @JSONField(name = "planet_video")
    var planetVideo: Int? = null

    /**
     * profile_image_url
     */
    @JSONField(name = "profile_image_url")
    var profileImageUrl: String? = null

    /**
     * profile_url
     */
    @JSONField(name = "profile_url")
    var profileUrl: String? = null

    /**
     * province
     */
    @JSONField(name = "province")
    var province: String? = null

    /**
     * ptype
     */
    @JSONField(name = "ptype")
    var ptype: Int? = null

    /**
     * remark
     */
    @JSONField(name = "remark")
    var remark: String? = null

    /**
     * screen_name
     */
    @JSONField(name = "screen_name")
    var screenName: String? = null

    /**
     * special_follow
     */
    @JSONField(name = "special_follow")
    var specialFollow: Boolean? = null

    /**
     * star
     */
    @JSONField(name = "star")
    var star: Int? = null

    /**
     * status
     */
    @JSONField(name = "status")
    var status: Status? = null

    /**
     * status_total_counter
     */
    @JSONField(name = "status_total_counter")
    var statusTotalCounter: StatusTotalCounter? = null

    /**
     * statuses_count
     */
    @JSONField(name = "statuses_count")
    var statusesCount: Int? = null

    /**
     * story_read_state
     */
    @JSONField(name = "story_read_state")
    var storyReadState: Int? = null

    /**
     * super_topic_not_syn_count
     */
    @JSONField(name = "super_topic_not_syn_count")
    var superTopicNotSynCount: Int? = null

    /**
     * svip
     */
    @JSONField(name = "svip")
    var svip: Int? = null

    /**
     * unfollowing_recom_switch
     */
    @JSONField(name = "unfollowing_recom_switch")
    var unfollowingRecomSwitch: Int? = null

    /**
     * urank
     */
    @JSONField(name = "urank")
    var urank: Int? = null

    /**
     * urisk
     */
    @JSONField(name = "urisk")
    var urisk: Int? = null

    /**
     * url
     */
    @JSONField(name = "url")
    var url: String? = null

    /**
     * user_ability
     */
    @JSONField(name = "user_ability")
    var userAbility: Int? = null

    /**
     * user_ability_extend
     */
    @JSONField(name = "user_ability_extend")
    var userAbilityExtend: Int? = null

    /**
     * vclub_member
     */
    @JSONField(name = "vclub_member")
    var vclubMember: Int? = null

    /**
     * verified
     */
    @JSONField(name = "verified")
    var verified: Boolean? = null

    /**
     * verified_reason
     */
    @JSONField(name = "verified_reason")
    var verifiedReason: String? = null

    /**
     * verified_reason_url
     */
    @JSONField(name = "verified_reason_url")
    var verifiedReasonUrl: String? = null

    /**
     * verified_source
     */
    @JSONField(name = "verified_source")
    var verifiedSource: String? = null

    /**
     * verified_source_url
     */
    @JSONField(name = "verified_source_url")
    var verifiedSourceUrl: String? = null

    /**
     * verified_trade
     */
    @JSONField(name = "verified_trade")
    var verifiedTrade: String? = null

    /**
     * verified_type
     */
    @JSONField(name = "verified_type")
    var verifiedType: Int? = null

    /**
     * video_mark
     */
    @JSONField(name = "video_mark")
    var videoMark: Int? = null

    /**
     * video_play_count
     */
    @JSONField(name = "video_play_count")
    var videoPlayCount: Int? = null

    /**
     * video_status_count
     */
    @JSONField(name = "video_status_count")
    var videoStatusCount: Int? = null

    /**
     * video_total_counter
     */
    @JSONField(name = "video_total_counter")
    var videoTotalCounter: VideoTotalCounter? = null

    /**
     * vplus_ability
     */
    @JSONField(name = "vplus_ability")
    var vplusAbility: Int? = null

    /**
     * vvip
     */
    @JSONField(name = "vvip")
    var vvip: Int? = null

    /**
     * wbcolumn_ability
     */
    @JSONField(name = "wbcolumn_ability")
    var wbcolumnAbility: Int? = null

    /**
     * weihao
     */
    @JSONField(name = "weihao")
    var weihao: String? = null

    /**
     * wenda_ability
     */
    @JSONField(name = "wenda_ability")
    var wendaAbility: Int? = null
}