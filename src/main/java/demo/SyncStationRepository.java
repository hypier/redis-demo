package demo;

import demo.model.SyncStation;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by heyong on 2018/8/24 11:21
 * Description:
 */
public interface SyncStationRepository extends CrudRepository<SyncStation, String> {

    /**
     * 根据状态取1条数据
     * @param syncStatus
     * @return
     */
    SyncStation findFirstBySyncStatus(int syncStatus);
}
