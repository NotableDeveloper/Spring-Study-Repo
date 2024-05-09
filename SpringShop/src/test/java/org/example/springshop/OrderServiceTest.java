package org.example.springshop;

import org.assertj.core.api.Assertions;
import org.example.springshop.config.AppConfig;
import org.example.springshop.discount.Order;
import org.example.springshop.discount.OrderService;
import org.example.springshop.member.Grade;
import org.example.springshop.member.Member;
import org.example.springshop.member.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceTest {
    AppConfig appConfig = new AppConfig();
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void setup() {
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
