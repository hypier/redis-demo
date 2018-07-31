package demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by heyong on 2018/7/31 10:39
 * Description:
 * @author heyong
 */
@RedisHash("member:info")
public class MemberInfo {

    /**
     * 会员号
     */
    @Id
    private String memberCode;
    /**
     * 会员名
     */
    private String memberName;

    /**
     * 身份证
     */
    @Indexed
    private String idCard;
    /**
     * 卡号
     */
    @Indexed
    private String cardNumber;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 余额
     */
    private BigDecimal balance;
    /**
     * 性别
     */
    private GenderValue gender;

    /**
     * 卡包
     */
    private List<BagInfo> bagInfoSet;

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public GenderValue getGender() {
        return gender;
    }

    public void setGender(GenderValue gender) {
        this.gender = gender;
    }

    public List<BagInfo> getBagInfoSet() {
        return bagInfoSet;
    }

    public void setBagInfoSet(List<BagInfo> bagInfoSet) {
        this.bagInfoSet = bagInfoSet;
    }

    @Override
    public String toString() {
        return "MemberInfo{" +
                "memberCode='" + memberCode + '\'' +
                ", memberName='" + memberName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", age=" + age +
                ", balance=" + balance +
                ", gender=" + gender +
                ", bagInfoSet=" + bagInfoSet +
                '}';
    }
}
