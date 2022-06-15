package howoocast.core;

import howoocast.core.member.Member;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {
    private String name;
    private int age;
    private Member member;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setAge(12);
        System.out.println("helloLombok.getAge() = " + helloLombok.getAge());
        System.out.println("helloLombok.toString() = " + helloLombok.toString());
    }

}
