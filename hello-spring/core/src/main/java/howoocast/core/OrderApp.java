package howoocast.core;

import howoocast.core.member.Grade;
import howoocast.core.member.Member;
import howoocast.core.member.MemberService;
import howoocast.core.member.MemberServiceImpl;
import howoocast.core.order.Order;
import howoocast.core.order.OrderService;
import howoocast.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);


        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
    }
}
