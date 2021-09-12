package org.y3s.jpashop.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.y3s.jpashop.domain.item.Book;
import org.y3s.jpashop.domain.item.Item;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@AllArgsConstructor
public class ItemRepository {
    private final EntityManager em;

    public void save(Item item) {
        if (item.getId() == null) {
            em.persist(item);
        } else {
            em.merge(item);
        }
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }

    public Book findBook(Long itemId) {
        return em.find(Book.class, itemId);
    }
}
