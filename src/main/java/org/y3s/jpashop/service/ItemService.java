package org.y3s.jpashop.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.y3s.jpashop.domain.item.Book;
import org.y3s.jpashop.domain.item.Item;
import org.y3s.jpashop.repository.ItemRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class ItemService {
    private final ItemRepository itemRepository;

    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Book findBook(Long itemId) {
        return itemRepository.findBook(itemId);
    }
}
