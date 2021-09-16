package org.y3s.jpashop.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.y3s.jpashop.domain.order.Order;

import javax.persistence.EntityManager;

@Repository
@AllArgsConstructor
public class OrderRepository {
    private final EntityManager em;

    public void save(Order order) {
        em.persist(order);
    }
}
