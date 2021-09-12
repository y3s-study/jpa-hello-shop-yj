package org.y3s.jpashop.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.y3s.jpashop.domain.item.Book;
import org.y3s.jpashop.domain.item.Item;
import org.y3s.jpashop.service.ItemService;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/items")
@AllArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/books/new")
    public String createBookForm() {
        return "item/book/createBookForm";
    }

    @PostMapping("/books/new")
    public String createBook(@ModelAttribute Book book) {

        itemService.saveItem(book);
        log.info("create new book {}", book);

        return "redirect:/items";
    }

    @GetMapping
    public String list(Model model) {
        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "item/list";
    }
}
