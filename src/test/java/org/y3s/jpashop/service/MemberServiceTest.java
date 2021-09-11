package org.y3s.jpashop.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.y3s.jpashop.domain.member.Address;
import org.y3s.jpashop.domain.member.Member;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@SpringBootTest
@Transactional
class MemberServiceTest {
    @Autowired
    MemberService sut;
    @Autowired
    EntityManager em;

    @Test
    void join() {
        // given
        Address address = Address.from("city", "street", "zipcode");
        Member member = new Member("peter", address);

        // when
        Long newMemberId = sut.join(member);

        // then
        assertThat(member).isEqualTo(em.find(Member.class, newMemberId));
    }

    @Test
    void duplicateMemberJoin() {
        // given
        Address address = Address.from("city", "street", "zipcode");
        Member member1 = new Member("peter", address);
        Member member2 = new Member("peter", address);

        // when
        Throwable throwable = catchThrowable(() -> {
            sut.join(member1);
            sut.join(member2);
        });

        // then
        assertThat(throwable)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("이미 존재하는 회원입니다.");
    }
}