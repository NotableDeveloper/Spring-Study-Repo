package org.example.springshop.config;


import org.example.springshop.discount.DiscountPolicy;
import org.example.springshop.discount.FixDiscountPolicy;
import org.example.springshop.order.OrderService;
import org.example.springshop.order.OrderServiceImpl;
import org.example.springshop.member.MemberRepository;
import org.example.springshop.member.MemberService;
import org.example.springshop.member.MemberServiceImpl;
import org.example.springshop.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}
