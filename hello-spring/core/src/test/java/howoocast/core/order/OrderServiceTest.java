package howoocast.core.order;

import howoocast.core.Appconfig;
import howoocast.core.member.Grade;
import howoocast.core.member.Member;
import howoocast.core.member.MemberService;
import howoocast.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        Appconfig appconfig = new Appconfig();
        memberService = appconfig.memberService();
        orderService = appconfig.orderService();
    }
    @Test
    void createOrder(){
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        //when
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
