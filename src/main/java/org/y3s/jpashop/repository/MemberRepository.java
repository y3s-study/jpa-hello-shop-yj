package org.y3s.jpashop.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.y3s.jpashop.domain.member.Member;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@AllArgsConstructor
public class MemberRepository {
    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

    public Member findOne(Long memberId) {
        return em.find(Member.class, memberId);
    }
}
