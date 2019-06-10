package demo;

import demo.model.SyncStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by heyong on 2018/8/24 11:23
 * Description:
 */
@Service
public class SyncStationService {

    @Autowired
    private SyncStationRepository syncStationRepository;

    public void create(){

        syncStationRepository.save(new SyncStation("CKGB01","重庆三峡广场店_书店", "CQ11"));
        syncStationRepository.save(new SyncStation("CKGB02","重庆西城天街店_书店", "CQ12"));
        syncStationRepository.save(new SyncStation("CKGB03","重庆北城天街店_书店", "CQ13"));
        syncStationRepository.save(new SyncStation("CKGB04","重庆英利店_书店", "CQ14"));
        syncStationRepository.save(new SyncStation("CKGB05","重庆时代天街店_书店", "CQ15"));
        syncStationRepository.save(new SyncStation("CKGB06","重庆大融城店_书店", "CQ16"));
        syncStationRepository.save(new SyncStation("CKGB07","重庆万象城店_书店", "CQ17"));
    }
}
