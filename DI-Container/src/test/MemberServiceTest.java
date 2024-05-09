package test;

import config.AppConfig;
import member.Grade;
import member.Member;
import member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    AppConfig appConfig = new AppConfig();
    MemberService memberService;

    @BeforeEach
    void setup(){
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        Member member = new Member(1L, "memberA", Grade.VIP);

        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        Assertions.assertEquals(findMember, member);
    }
}
