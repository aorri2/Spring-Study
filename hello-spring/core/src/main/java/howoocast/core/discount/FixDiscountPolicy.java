package howoocast.core.discount;

import howoocast.core.member.Grade;
import howoocast.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class FixDiscountPolicy implements DiscountPolicy{
    private final int discounFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        return isGradeVip(member) ? discounFixAmount : 0;
    }

    private boolean isGradeVip(Member member) {
        return member.getGrade() == Grade.VIP;
    }
}
