package demo;

import cn.sisyphe.framework.cache.core.annotation.EnableS2Cache;
import demo.model.BagInfo;
import demo.model.GenderValue;
import demo.model.MemberInfo;
import demo.model.SyncStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by heyong on 2018/7/31 10:37
 * Description:
 *
 * @author heyong
 */
@SpringBootApplication
@EnableS2Cache
@EnableRedisRepositories
public class RedisApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private SyncStationService syncStationService;

    @Autowired
    private SyncStationRepository syncStationRepository;

    @Override
    public void run(String... args) throws Exception {


        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for (int i = 0; i < 100; i++) {

            SyncStation syncStation = syncStationRepository.findFirstBySyncStatus(0);
            if (syncStation == null) {
                syncStationService.create();
                continue;
            }

            syncStation.setSyncStatus(1);
            syncStationRepository.save(syncStation);

//            System.err.println(datetime + " " + syncStation);
        }
        stopWatch.stop();
        System.err.println(stopWatch.prettyPrint());
//        for (int i = 0; i < 10; i++) {
//            String memberCode = "MM0001" + i;
//            create(memberCode);
//        }

//        findByMemberCode("MM000110");

//        findByMemberName("何勇");

//        findByCardNumber("cardMM000110");

//        findByOpenId("ac2f5cb5-2a2b-4f53-bc98-2aa8a978ba72");

    }


    /**
     * 根据memberName查询,没有索引查不出来
     *
     * @param memberName
     */
    private void findByMemberName(String memberName) {
        MemberInfo memberInfo = memberRepository.findFirstByMemberName(memberName);

        System.err.println(memberInfo);
    }

    /**
     * 根据memberCode查询
     *
     * @param memberCode
     */
    private void findByMemberCode(String memberCode) {
        MemberInfo memberInfo = memberRepository.findOne(memberCode);

        System.err.println(memberInfo);
    }

    /**
     * 根据OPenID查询
     *
     * @param openId
     */
    private void findByOpenId(String openId) {
        MemberInfo memberInfo = memberRepository.findFirstByBagInfoSet_OpenId(openId);

        System.err.println(memberInfo);
    }

    /**
     * 根据卡号查询
     *
     * @param cardNumber
     */
    private void findByCardNumber(String cardNumber) {

        MemberInfo memberInfo = memberRepository.findFirstByCardNumber(cardNumber);

        System.err.println(memberInfo);
    }

    /**
     * 创建会员或更新
     *
     * @param memberCode
     */
    private void create(String memberCode) {
        MemberInfo memberInfo = new MemberInfo();
        memberInfo.setMemberCode(memberCode);
        memberInfo.setCardNumber("card" + memberCode);
        memberInfo.setAge(10);
        memberInfo.setBalance(BigDecimal.ONE);
        memberInfo.setGender(GenderValue.Female);
        memberInfo.setMemberName("何勇");
        memberInfo.setIdCard("id" + memberCode);

        BagInfo bagInfo = new BagInfo();
        bagInfo.setInfoCode(memberCode);
        bagInfo.setOpenId(UUID.randomUUID().toString());

        List<BagInfo> bagInfoList = new ArrayList<BagInfo>();
        bagInfoList.add(bagInfo);

        memberInfo.setBagInfoSet(bagInfoList);

        memberRepository.save(memberInfo);
    }
}
