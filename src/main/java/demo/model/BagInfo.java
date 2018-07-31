package demo.model;

import org.springframework.data.redis.core.index.Indexed;

/**
 * Created by heyong on 2018/7/31 10:44
 * Description:
 * @author heyong
 */
public class BagInfo {

    private String infoCode;

    @Indexed
    private String openId;

    public String getInfoCode() {
        return infoCode;
    }

    public void setInfoCode(String infoCode) {
        this.infoCode = infoCode;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Override
    public String toString() {
        return "BagInfo{" +
                "infoCode='" + infoCode + '\'' +
                ", openId='" + openId + '\'' +
                '}';
    }
}
