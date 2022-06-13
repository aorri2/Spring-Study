package howoocast.core.order;

import howoocast.core.discount.DiscountPolicy;
import howoocast.core.discount.FixDiscountPolicy;
import howoocast.core.member.Member;
import howoocast.core.member.MemberRepository;
import howoocast.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);


        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
