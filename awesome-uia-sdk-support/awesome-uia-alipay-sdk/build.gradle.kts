dependencies { 
    api(project(":$CORE"))
    api(alipay_sdk_java) {
        exclude(group = "dom4j", module = "dom4j")
        exclude(group = "org.bouncycastle", module = "bcprov-jdk15on")
    }
    api(bcprovJdk15to18)
    api(bcprov_jdk18on)
    api(dom4j)
}
