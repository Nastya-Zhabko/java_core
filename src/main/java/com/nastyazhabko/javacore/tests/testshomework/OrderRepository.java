package com.nastyazhabko.javacore.tests.testshomework;

import java.util.Optional;

public interface OrderRepository {
    int saveOrder(Order order);

    Optional<Order> getOrderById(int id);
}
