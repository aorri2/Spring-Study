package howoocast.core;

import howoocast.core.member.Grade;
import howoocast.core.member.Member;
import howoocast.core.member.MemberService;
import howoocast.core.member.MemberServiceImpl;
import howoocast.core.order.Order;
import howoocast.core.order.OrderService;
import howoocast.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
        /*Appconfig appconfig = new Appconfig();
        MemberService memberService = appconfig.memberService();
        OrderService orderService = appconfig.orderService();*/
//        MemberService memberService = new MemberServiceImpl(null);
//        OrderService orderService = new OrderServiceImpl(null,null);

        ApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);


        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
    }
}
