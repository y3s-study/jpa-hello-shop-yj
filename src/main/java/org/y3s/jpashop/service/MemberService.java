package org.y3s.jpashop.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.y3s.jpashop.domain.member.Member;
import org.y3s.jpashop.repository.MemberRepository;

import java.util.List;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        log.info("New member joined. {}", member);
        return member.getId();
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());

        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

}
