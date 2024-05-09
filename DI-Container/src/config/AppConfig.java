package config;

import discount.DiscountPolicy;
import discount.FixDiscountPolicy;
import discount.OrderService;
import discount.OrderServiceImpl;
import member.MemberRepository;
import member.MemberService;
import member.MemberServiceImpl;
import member.MemoryMemberRepository;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    private MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    private DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}
