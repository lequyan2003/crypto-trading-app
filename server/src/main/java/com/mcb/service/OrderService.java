package com.mcb.service;

import java.util.List;

import com.mcb.domain.OrderType;
import com.mcb.modal.Coin;
import com.mcb.modal.Order;
import com.mcb.modal.OrderItem;
import com.mcb.modal.User;

public interface OrderService {
    Order createOrder(User user, OrderItem orderItem, OrderType orderType);

    Order getOrderById(Long orderId) throws Exception;

    List<Order> getAllOrdersOfUser(Long userId, OrderType orderType, String assetSymbol);

    Order processOrder(Coin coin, double quantity, OrderType orderType, User user) throws Exception;
}
