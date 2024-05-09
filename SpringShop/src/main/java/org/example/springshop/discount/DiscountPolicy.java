package org.example.springshop.discount;

import org.example.springshop.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
