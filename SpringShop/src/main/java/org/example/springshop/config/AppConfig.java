package org.example.springshop.config;


import org.example.springshop.discount.DiscountPolicy;
import org.example.springshop.discount.FixDiscountPolicy;
import org.example.springshop.discount.OrderService;
import org.example.springshop.discount.OrderServiceImpl;
import org.example.springshop.member.MemberRepository;
import org.example.springshop.member.MemberService;
import org.example.springshop.member.MemberServiceImpl;
import org.example.springshop.member.MemoryMemberRepository;

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
