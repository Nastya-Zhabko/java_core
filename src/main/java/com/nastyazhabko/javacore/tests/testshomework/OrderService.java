package com.nastyazhabko.javacore.tests.testshomework;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OrderService {
    OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String processOrder(Order order) {
        int result = orderRepository.saveOrder(order);
        if (result != 0) {
            return "Order processed successfully";
        } else {
            return "Order processing failed";
        }
    }

    public double calculateTotal(int id) {
        Optional<Order> order = orderRepository.getOrderById(id);
        if (order.isEmpty()) {
            throw new NoSuchElementException("Order id not found");
        } else {
            return order.get().getTotalPrice();
        }
    }

}
