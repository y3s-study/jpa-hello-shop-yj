package org.y3s.jpashop.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.y3s.jpashop.domain.item.Item;

import javax.persistence.EntityManager;

@Repository
@AllArgsConstructor
public class ItemRepository {
    private final EntityManager em;

    public void save(Item item) {
        em.persist(item);
    }
}
