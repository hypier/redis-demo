package demo;

import demo.model.MemberInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by heyong on 2018/7/31 10:47
 * Description:
 */
public interface MemberRepository  extends CrudRepository<MemberInfo, String> {

    MemberInfo findFirstByCardNumber(String cardNumber);

    MemberInfo findFirstByMemberName(String memberName);

    MemberInfo findFirstByIdCard(String idCard);

    MemberInfo findFirstByBagInfoSet_OpenId(String openId);
}
