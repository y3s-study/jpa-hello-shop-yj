package org.y3s.jpashop.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.y3s.jpashop.domain.delivery.Delivery;
import org.y3s.jpashop.domain.item.Item;
import org.y3s.jpashop.domain.member.Member;
import org.y3s.jpashop.domain.order.Order;
import org.y3s.jpashop.domain.order.OrderItem;
import org.y3s.jpashop.repository.ItemRepository;
import org.y3s.jpashop.repository.MemberRepository;
import org.y3s.jpashop.repository.OrderRepository;

@Service
@AllArgsConstructor
@Transactional
public class OrderService {
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;

    public Long order(Long memberId, Long itemId, int count) {
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOneItem(itemId);

        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
        Delivery delivery = new Delivery(member.getAddress());
        Order order = Order.createOrder(member, delivery, orderItem);

        orderRepository.save(order);
        return order.getId();
    }
}
