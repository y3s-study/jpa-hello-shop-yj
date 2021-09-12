package org.y3s.jpashop.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.y3s.jpashop.domain.item.Book;
import org.y3s.jpashop.service.ItemService;

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

        return "redirect:/";
    }
}
