package com.nastyazhabko.javacore.tests;

import com.nastyazhabko.javacore.tests.testshomework.Order;

public class TestHelper {
    public static Order createDefaultOrder(int id, String productName, int quantity, double unitPrice) {
        return new Order(id, productName, quantity, unitPrice);
    }
}
