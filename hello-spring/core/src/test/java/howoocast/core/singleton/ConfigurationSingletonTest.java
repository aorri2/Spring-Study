package howoocast.core.singleton;

import howoocast.core.Appconfig;
import howoocast.core.member.MemberRepository;
import howoocast.core.member.MemberService;
import howoocast.core.member.MemberServiceImpl;
import howoocast.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ConfigurationSingletonTest {

    @Test
    @DisplayName("aaa")
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();
        MemberRepository memberRepository3 = ac.getBean("memberRepository", MemberRepository.class);
        System.out.println("memberService --> memberRepository1 = " + memberRepository1);
        System.out.println("orderService --> memberRepository2 = " + memberRepository2);
        System.out.println("memberRepository --> memberRepository3 = " + memberRepository3);

        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository3);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository3);
    }

    @Test
    @DisplayName("test")
    void configurationDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);
        Appconfig bean = ac.getBean(Appconfig.class);
        System.out.println("bean = " + bean.getClass());
    }
}
