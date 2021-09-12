package org.y3s.jpashop.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.y3s.jpashop.domain.item.Item;
import org.y3s.jpashop.repository.ItemRepository;

@Service
@AllArgsConstructor
@Transactional
public class ItemService {
    private final ItemRepository itemRepository;

    public void saveItem(Item item) {
        itemRepository.save(item);
    }
}
