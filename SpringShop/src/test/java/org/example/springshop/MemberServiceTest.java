package org.example.springshop;

import org.example.springshop.config.AppConfig;
import org.example.springshop.member.Grade;
import org.example.springshop.member.Member;
import org.example.springshop.member.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberServiceTest {
    AppConfig appConfig = new AppConfig();
    MemberService memberService;

    @BeforeEach
    void setup(){
        this.memberService = appConfig.memberService();
    }

    @Test
    void join(){
        Member member = new Member(1L, "memberA", Grade.VIP);

        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        assertThat(findMember).isEqualTo(member);
    }

}
