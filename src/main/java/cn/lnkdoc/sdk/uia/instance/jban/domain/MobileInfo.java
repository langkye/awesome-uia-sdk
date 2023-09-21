package cn.lnkdoc.sdk.uia.instance.jban.domain;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@SuppressWarnings(value = {"unused"})
public class MobileInfo  implements Serializable {
    @Serial
    private static final long serialVersionUID = -508722906865178L;
    /**
     * openUserId
     */
    private String openUserId;

    /**
     * getter
     * 
     * @return openUserId
     */
    public String getOpenUserId() {
        return openUserId;
    }

    /**
     * setter
     * 
     * @param openUserId openUserId
     */
    public void setOpenUserId(String openUserId) {
        this.openUserId = openUserId;
    }
}
