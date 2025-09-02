package com.nastyazhabko.javacore.collections;

import java.util.HashMap;
import java.util.Map;

public class ProductTesting {
    public static void main(String[] args) {
        Map<Product, String> products = new HashMap<>();

        Product product1 = new Product(1, "Apple", 400);
        Product product2 = new Product(2, "Banana", 300);
        Product product3 = new Product(1, "Orange", 500);
        Product product4 = new Product(3, "Banana", 300);

        products.put(product1, "First product");
        products.put(product2, "Second product");
        products.put(product3, "Third product");
        products.put(product4, "Fourth product");

        for (Map.Entry<Product, String> entry : products.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
