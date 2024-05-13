package org.example.springshop.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
