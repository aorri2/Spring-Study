package howoocast.core.discount;

import howoocast.core.annotation.MainDiscountPolicy;
import howoocast.core.member.Grade;
import howoocast.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if(isGradeVip(member)){
            return price * discountPercent / 100;
        }else{
            return 0;
        }
    }

    private boolean isGradeVip(Member member) {
        return member.getGrade() == Grade.VIP;
    }
}
