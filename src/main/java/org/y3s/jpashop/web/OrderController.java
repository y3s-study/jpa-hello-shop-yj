package org.y3s.jpashop.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.y3s.jpashop.domain.item.Item;
import org.y3s.jpashop.domain.member.Member;
import org.y3s.jpashop.domain.order.Order;
import org.y3s.jpashop.service.ItemService;
import org.y3s.jpashop.service.MemberService;
import org.y3s.jpashop.service.OrderService;

import java.util.List;

@Controller
@AllArgsConstructor
public class OrderController {
    private MemberService memberService;
    private ItemService itemService;
    private OrderService orderService;

    @GetMapping("/order")
    public String createForm(Model model) {
        List<Member> members = memberService.findAll();
        List<Item> items = itemService.findItems();

        model.addAttribute("members", members);
        model.addAttribute("items", items);

        return "order/orderForm";
    }

    @PostMapping("/order")
    public String order(Long memberId, Long itemId, int count) {
        orderService.order(memberId, itemId, count);
        return "redirect:/";
    }

    @GetMapping("/orders")
    public String orderList(Model model) {
        List<Order> orders = orderService.findAll();
        model.addAttribute("orders", orders);

        return "/order/orderList";
    }

}
