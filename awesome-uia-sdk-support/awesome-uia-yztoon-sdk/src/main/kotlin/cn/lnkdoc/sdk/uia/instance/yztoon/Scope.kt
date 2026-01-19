package cn.lnkdoc.sdk.uia.instance.yztoon

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
enum class Scope
/**
 * constructor
 *
 * @param scope scope
 */(
    /**
     * scope
     */
    val scope: String
) {
    /**
     * cn
     */
    CN("cn"),

    /**
     * uid
     */
    UID("uid"),

    /**
     * idCardNumber
     */
    ID_CARD_NUMBER("idCardNumber"),

    /**
     * reserve3
     */
    RESERVE3("reserve3"),

    /**
     * extProperties
     */
    EXT_PROPERTIES("extProperties"),

    /**
     * credenceClass
     */
    CREDENCE_CLASS("credenceClass"),

    /**
     * ALL
     */
    ALL(
        java.lang.String.join(
            "+", CN.scope, UID.scope, ID_CARD_NUMBER.scope, RESERVE3.scope, EXT_PROPERTIES.scope, CREDENCE_CLASS.scope
        )
    )
}
