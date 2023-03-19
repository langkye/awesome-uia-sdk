package cn.lnkdoc.sdk.uia.instance.jban.domain;

import java.io.Serializable;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@SuppressWarnings(value = {"unused"})
public class MobileInfo  implements Serializable {
    private static final long serialVersionUID = -508722906865178L;
    private String openUserId;

    public String getOpenUserId() {
        return openUserId;
    }

    public void setOpenUserId(String openUserId) {
        this.openUserId = openUserId;
    }
}
