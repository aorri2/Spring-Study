package howoocast.core.discount;

import howoocast.core.member.Grade;
import howoocast.core.member.Member;

public interface DiscountPolicy {
    /*
    @return 할인 대상 금액
    * */
    int discount(Member member, int price);
}
