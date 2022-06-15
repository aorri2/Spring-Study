package howoocast.core;

import howoocast.core.member.MemberRepository;
import howoocast.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = {"howoocast.core.member","howoocast.core.order","howoocast.core.discount"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    @Bean
    MemberRepository memberRepository(){
     return new MemoryMemberRepository();
    }
}
