package demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.Date;

/**
 * Created by heyong on 2018/8/24 11:09
 * Description:
 * @author heyong
 */

@RedisHash("data:sync_station")
public class SyncStation {

    /**
     * 站点编码
     */
    @Id
    private String stationCode;
    /**
     * 站点名称
     */
    private String stationName;

    /**
     * 益华站点编码
     */
    private String yhStationCode;

    /**
     * 最近同步时间
     */
    private Date lastSyncTime;

    /**
     * 最近出错时间
     */
    private Date lastErrorTime;

    /**
     * 同步状态
     */
    @Indexed
    private int syncStatus = 0;

    public SyncStation() {
    }

    public SyncStation(String stationCode, String stationName, String yhStationCode) {
        this.stationCode = stationCode;
        this.stationName = stationName;
        this.yhStationCode = yhStationCode;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getYhStationCode() {
        return yhStationCode;
    }

    public void setYhStationCode(String yhStationCode) {
        this.yhStationCode = yhStationCode;
    }

    public Date getLastSyncTime() {
        return lastSyncTime;
    }

    public void setLastSyncTime(Date lastSyncTime) {
        this.lastSyncTime = lastSyncTime;
    }

    public Date getLastErrorTime() {
        return lastErrorTime;
    }

    public void setLastErrorTime(Date lastErrorTime) {
        this.lastErrorTime = lastErrorTime;
    }

    public int getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(int syncStatus) {
        this.syncStatus = syncStatus;
    }

    @Override
    public String toString() {
        return "SyncStation{" +
                "stationCode='" + stationCode + '\'' +
                ", stationName='" + stationName + '\'' +
                ", yhStationCode='" + yhStationCode + '\'' +
                ", lastSyncTime=" + lastSyncTime +
                ", lastErrorTime=" + lastErrorTime +
                ", syncStatus=" + syncStatus +
                '}';
    }
}
