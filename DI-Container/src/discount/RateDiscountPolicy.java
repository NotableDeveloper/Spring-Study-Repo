package discount;

import member.Grade;
import member.Member;

public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) return price / discountPercent;
        else return 0;
    }
}