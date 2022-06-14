package howoocast.core;

import howoocast.core.discount.DiscountPolicy;
import howoocast.core.discount.FixDiscountPolicy;
import howoocast.core.discount.RateDiscountPolicy;
import howoocast.core.member.MemberRepository;
import howoocast.core.member.MemberService;
import howoocast.core.member.MemberServiceImpl;
import howoocast.core.member.MemoryMemberRepository;
import howoocast.core.order.OrderService;
import howoocast.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Appconfig {

    //@Bean memberService --> new MemoryMemberRepository()
    //@Bean orderService --> new MemoryMemberRepository()
    @Bean
    public MemberService memberService(){
        System.out.println("call Appconfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call Appconfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call Appconfig.orderService");
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        System.out.println("call Appconfig.discountPolicy");

        return new RateDiscountPolicy();
    }

}

