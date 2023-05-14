package com.test.springdemo.service;


import com.test.springdemo.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrderList();
    void createOrder(Order order);
    void deleteOrder(String id);

    void updateOrder(Order order);

    List<Order> getUserOrderList(String userId, String status);
}
