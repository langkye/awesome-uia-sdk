package cn.lnkdoc.sdk.uia.instance.weibo.domain

import cn.lnkdoc.sdk.uia.instance.weibo.domain.user.Insecurity
import cn.lnkdoc.sdk.uia.instance.weibo.domain.user.Status
import cn.lnkdoc.sdk.uia.instance.weibo.domain.user.StatusTotalCounter
import cn.lnkdoc.sdk.uia.instance.weibo.domain.user.VideoTotalCounter
import cn.lnkdoc.sdk.uia.instance.weibo.response.ErrorResponse
import cn.lnkdoc.sdk.uia.serializer.annotation.UiaJsonField


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
    @set:UiaJsonField(name = "allow_all_act_msg")
    var allowAllActMsg: Boolean? = null

    /**
     * allow_all_comment
     */
    @set:UiaJsonField(name = "allow_all_comment")
    var allowAllComment: Boolean? = null

    /**
     * audio_ability
     */
    @set:UiaJsonField(name = "audio_ability")
    var audioAbility: Int? = null

    /**
     * avatar_hd
     */
    @set:UiaJsonField(name = "avatar_hd")
    var avatarHd: String? = null

    /**
     * avatar_large
     */
    @set:UiaJsonField(name = "avatar_large")
    var avatarLarge: String? = null

    /**
     * avatar_type
     */
    @set:UiaJsonField(name = "avatar_type")
    var avatarType: Int? = null

    /**
     * bi_followers_count
     */
    @set:UiaJsonField(name = "bi_followers_count")
    var biFollowersCount: Int? = null

    /**
     * block
     */
    @set:UiaJsonField(name = "block")
    var block: Int? = null

    /**
     * block_app
     */
    @set:UiaJsonField(name = "block_app")
    var blockApp: Int? = null

    /**
     * block_me
     */
    @set:UiaJsonField(name = "block_me")
    var blockMe: Int? = null

    /**
     * block_word
     */
    @set:UiaJsonField(name = "block_word")
    var blockWord: Int? = null

    /**
     * brand_ability
     */
    @set:UiaJsonField(name = "brand_ability")
    var brandAbility: Int? = null

    /**
     * brand_account
     */
    @set:UiaJsonField(name = "brand_account")
    var brandAccount: Int? = null

    /**
     * chaohua_ability
     */
    @set:UiaJsonField(name = "chaohua_ability")
    var chaohuaAbility: Int? = null

    /**
     * city
     */
    @set:UiaJsonField(name = "city")
    var city: String? = null

    /**
     * class
     */
    @set:UiaJsonField(name = "class")
    var classX: Int? = null

    /**
     * cover_image_phone
     */
    @set:UiaJsonField(name = "cover_image_phone")
    var coverImagePhone: String? = null

    /**
     * created_at
     */
    @set:UiaJsonField(name = "created_at")
    var createdAt: String? = null

    /**
     * credit_score
     */
    @set:UiaJsonField(name = "credit_score")
    var creditScore: Int? = null

    /**
     * description
     */
    @set:UiaJsonField(name = "description")
    var description: String? = null

    /**
     * domain
     */
    @set:UiaJsonField(name = "domain")
    var domain: String? = null

    /**
     * ecommerce_ability
     */
    @set:UiaJsonField(name = "ecommerce_ability")
    var ecommerceAbility: Int? = null

    /**
     * favourites_count
     */
    @set:UiaJsonField(name = "favourites_count")
    var favouritesCount: Int? = null

    /**
     * follow_me
     */
    @set:UiaJsonField(name = "follow_me")
    var followMe: Boolean? = null

    /**
     * followers_count
     */
    @set:UiaJsonField(name = "followers_count")
    var followersCount: Int? = null

    /**
     * followers_count_str
     */
    @set:UiaJsonField(name = "followers_count_str")
    var followersCountStr: String? = null

    /**
     * following
     */
    @set:UiaJsonField(name = "following")
    var following: Boolean? = null

    /**
     * friends_count
     */
    @set:UiaJsonField(name = "friends_count")
    var friendsCount: Int? = null

    /**
     * gender
     */
    @set:UiaJsonField(name = "gender")
    var gender: String? = null

    /**
     * geo_enabled
     */
    @set:UiaJsonField(name = "geo_enabled")
    var geoEnabled: Boolean? = null

    /**
     * gongyi_ability
     */
    @set:UiaJsonField(name = "gongyi_ability")
    var gongyiAbility: Int? = null

    /**
     * green_mode
     */
    @set:UiaJsonField(name = "green_mode")
    var greenMode: Int? = null

    /**
     * hardfan_ability
     */
    @set:UiaJsonField(name = "hardfan_ability")
    var hardfanAbility: Int? = null

    /**
     * hongbaofei
     */
    @set:UiaJsonField(name = "hongbaofei")
    var hongbaofei: Int? = null

    /**
     * id
     */
    @set:UiaJsonField(name = "id")
    var id: Long? = null

    /**
     * idstr
     */
    @set:UiaJsonField(name = "idstr")
    var idstr: String? = null

    /**
     * insecurity
     */
    @set:UiaJsonField(name = "insecurity")
    var insecurity: Insecurity? = null

    /**
     * interaction_user
     */
    @set:UiaJsonField(name = "interaction_user")
    var interactionUser: Int? = null

    /**
     * is_guardian
     */
    @set:UiaJsonField(name = "is_guardian")
    var isGuardian: Int? = null

    /**
     * is_teenager
     */
    @set:UiaJsonField(name = "is_teenager")
    var isTeenager: Int? = null

    /**
     * is_teenager_list
     */
    @set:UiaJsonField(name = "is_teenager_list")
    var isTeenagerList: Int? = null

    /**
     * lang
     */
    @set:UiaJsonField(name = "lang")
    var lang: String? = null

    /**
     * light_ring
     */
    @set:UiaJsonField(name = "light_ring")
    var lightRing: Boolean? = null

    /**
     * like
     */
    @set:UiaJsonField(name = "like")
    var like: Boolean? = null

    /**
     * like_me
     */
    @set:UiaJsonField(name = "like_me")
    var likeMe: Boolean? = null

    /**
     * live_ability
     */
    @set:UiaJsonField(name = "live_ability")
    var liveAbility: Int? = null

    /**
     * live_status
     */
    @set:UiaJsonField(name = "live_status")
    var liveStatus: Int? = null

    /**
     * location
     */
    @set:UiaJsonField(name = "location")
    var location: String? = null

    /**
     * mb_expire_time
     */
    @set:UiaJsonField(name = "mb_expire_time")
    var mbExpireTime: Int? = null

    /**
     * mbrank
     */
    @set:UiaJsonField(name = "mbrank")
    var mbrank: Int? = null

    /**
     * mbtype
     */
    @set:UiaJsonField(name = "mbtype")
    var mbtype: Int? = null

    /**
     * name
     */
    @set:UiaJsonField(name = "name")
    var name: String? = null

    /**
     * newbrand_ability
     */
    @set:UiaJsonField(name = "newbrand_ability")
    var newbrandAbility: Int? = null

    /**
     * nft_ability
     */
    @set:UiaJsonField(name = "nft_ability")
    var nftAbility: Int? = null

    /**
     * online_status
     */
    @set:UiaJsonField(name = "online_status")
    var onlineStatus: Int? = null

    /**
     * pagefriends_count
     */
    @set:UiaJsonField(name = "pagefriends_count")
    var pagefriendsCount: Int? = null

    /**
     * paycolumn_ability
     */
    @set:UiaJsonField(name = "paycolumn_ability")
    var paycolumnAbility: Int? = null

    /**
     * pc_new
     */
    @set:UiaJsonField(name = "pc_new")
    var pcNew: Int? = null

    /**
     * planet_video
     */
    @set:UiaJsonField(name = "planet_video")
    var planetVideo: Int? = null

    /**
     * profile_image_url
     */
    @set:UiaJsonField(name = "profile_image_url")
    var profileImageUrl: String? = null

    /**
     * profile_url
     */
    @set:UiaJsonField(name = "profile_url")
    var profileUrl: String? = null

    /**
     * province
     */
    @UiaJsonField(name = "province")
    var province: String? = null

    /**
     * ptype
     */
    @UiaJsonField(name = "ptype")
    var ptype: Int? = null

    /**
     * remark
     */
    @UiaJsonField(name = "remark")
    var remark: String? = null

    /**
     * screen_name
     */
    @UiaJsonField(name = "screen_name")
    var screenName: String? = null

    /**
     * special_follow
     */
    @UiaJsonField(name = "special_follow")
    var specialFollow: Boolean? = null

    /**
     * star
     */
    @UiaJsonField(name = "star")
    var star: Int? = null

    /**
     * status
     */
    @UiaJsonField(name = "status")
    var status: Status? = null

    /**
     * status_total_counter
     */
    @UiaJsonField(name = "status_total_counter")
    var statusTotalCounter: StatusTotalCounter? = null

    /**
     * statuses_count
     */
    @UiaJsonField(name = "statuses_count")
    var statusesCount: Int? = null

    /**
     * story_read_state
     */
    @UiaJsonField(name = "story_read_state")
    var storyReadState: Int? = null

    /**
     * super_topic_not_syn_count
     */
    @UiaJsonField(name = "super_topic_not_syn_count")
    var superTopicNotSynCount: Int? = null

    /**
     * svip
     */
    @UiaJsonField(name = "svip")
    var svip: Int? = null

    /**
     * unfollowing_recom_switch
     */
    @UiaJsonField(name = "unfollowing_recom_switch")
    var unfollowingRecomSwitch: Int? = null

    /**
     * urank
     */
    @UiaJsonField(name = "urank")
    var urank: Int? = null

    /**
     * urisk
     */
    @UiaJsonField(name = "urisk")
    var urisk: Int? = null

    /**
     * url
     */
    @UiaJsonField(name = "url")
    var url: String? = null

    /**
     * user_ability
     */
    @UiaJsonField(name = "user_ability")
    var userAbility: Int? = null

    /**
     * user_ability_extend
     */
    @UiaJsonField(name = "user_ability_extend")
    var userAbilityExtend: Int? = null

    /**
     * vclub_member
     */
    @UiaJsonField(name = "vclub_member")
    var vclubMember: Int? = null

    /**
     * verified
     */
    @UiaJsonField(name = "verified")
    var verified: Boolean? = null

    /**
     * verified_reason
     */
    @UiaJsonField(name = "verified_reason")
    var verifiedReason: String? = null

    /**
     * verified_reason_url
     */
    @UiaJsonField(name = "verified_reason_url")
    var verifiedReasonUrl: String? = null

    /**
     * verified_source
     */
    @UiaJsonField(name = "verified_source")
    var verifiedSource: String? = null

    /**
     * verified_source_url
     */
    @UiaJsonField(name = "verified_source_url")
    var verifiedSourceUrl: String? = null

    /**
     * verified_trade
     */
    @UiaJsonField(name = "verified_trade")
    var verifiedTrade: String? = null

    /**
     * verified_type
     */
    @UiaJsonField(name = "verified_type")
    var verifiedType: Int? = null

    /**
     * video_mark
     */
    @UiaJsonField(name = "video_mark")
    var videoMark: Int? = null

    /**
     * video_play_count
     */
    @UiaJsonField(name = "video_play_count")
    var videoPlayCount: Int? = null

    /**
     * video_status_count
     */
    @UiaJsonField(name = "video_status_count")
    var videoStatusCount: Int? = null

    /**
     * video_total_counter
     */
    @UiaJsonField(name = "video_total_counter")
    var videoTotalCounter: VideoTotalCounter? = null

    /**
     * vplus_ability
     */
    @UiaJsonField(name = "vplus_ability")
    var vplusAbility: Int? = null

    /**
     * vvip
     */
    @UiaJsonField(name = "vvip")
    var vvip: Int? = null

    /**
     * wbcolumn_ability
     */
    @UiaJsonField(name = "wbcolumn_ability")
    var wbcolumnAbility: Int? = null

    /**
     * weihao
     */
    @UiaJsonField(name = "weihao")
    var weihao: String? = null

    /**
     * wenda_ability
     */
    @UiaJsonField(name = "wenda_ability")
    var wendaAbility: Int? = null
}
