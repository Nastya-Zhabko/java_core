package com.nastyazhabko.javacore.streamapi.streamapihomework;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();


        Product book1 = new Product(1L, "Anna Karenina", "Books", new BigDecimal("300.00"));
        Product book2 = new Product(2L, "Gamlet", "Books", new BigDecimal("250.60"));
        Product book3 = new Product(2L, "Games Of Thrones", "Books", new BigDecimal("50.30"));
        Product pampers = new Product(3L, "Pampers", "Children's products", new BigDecimal("600.99"));
        Product pacifier = new Product(3L, "Pacifier", "Children's products", new BigDecimal("300.99"));
        Product toy1 = new Product(4L, "Spider-man", "Toys", new BigDecimal("100.00"));
        Product toy2 = new Product(5L, "Batman", "Toys", new BigDecimal("150.50"));
        Product toy3 = new Product(6L, "Robin", "Toys", new BigDecimal("550.50"));

        Order order1 = new Order(1L, LocalDate.of(2025, 2, 13), LocalDate.of(2025, 2, 14), "delivered", new HashSet<Product>(List.of(book1, book2, toy1)));
        Order order2 = new Order(2L, LocalDate.of(2025, 9, 10), LocalDate.of(2025, 9, 12), "delivered", new HashSet<Product>(List.of(book1, pampers, toy2)));
        Order order3 = new Order(3L, LocalDate.of(2025, 9, 14), LocalDate.of(2025, 9, 15), "in delivery", new HashSet<Product>(List.of(toy2)));
        Order order4 = new Order(4L, LocalDate.of(2025, 9, 14), LocalDate.of(2025, 9, 16), "received", new HashSet<Product>(List.of(book3, pampers, pacifier)));
        Order order5 = new Order(5L, LocalDate.of(2025, 3, 14), LocalDate.of(2025, 3, 16), "delivered", new HashSet<Product>(List.of(toy1, pacifier)));

        Order order6 = new Order(6L, LocalDate.of(2025, 3, 14), LocalDate.of(2025, 3, 16), "delivered", new HashSet<Product>(List.of(book3, toy3)));
        Order order7 = new Order(7L, LocalDate.of(2025, 2, 20), LocalDate.of(2025, 2, 22), "delivered", new HashSet<Product>(List.of(pampers)));
        Order order8 = new Order(8L, LocalDate.of(2025, 9, 14), LocalDate.of(2025, 9, 15), "in delivery", new HashSet<Product>(List.of(toy2, pacifier)));
        Order order9 = new Order(9L, LocalDate.of(2025, 9, 14), LocalDate.of(2025, 9, 16), "in delivery", new HashSet<Product>(List.of(book2, pampers)));
        Order order10 = new Order(10L, LocalDate.of(2025, 7, 24), LocalDate.of(2025, 7, 26), "delivered", new HashSet<Product>(List.of(book1, pampers, toy2)));

        Order order11 = new Order(11L, LocalDate.of(2025, 4, 10), LocalDate.of(2025, 4, 11), "delivered", new HashSet<Product>(List.of(toy1, book2, toy2, pacifier)));
        Order order12 = new Order(12L, LocalDate.of(2025, 3, 15), LocalDate.of(2025, 6, 17), "delivered", new HashSet<Product>(List.of(book1)));
        Order order13 = new Order(13L, LocalDate.of(2025, 7, 30), LocalDate.of(2025, 8, 1), "delivered", new HashSet<Product>(List.of(book1)));
        Order order14 = new Order(14L, LocalDate.of(2025, 8, 14), LocalDate.of(2025, 8, 16), "delivered", new HashSet<Product>(List.of(pampers, toy2, book3)));
        Order order15 = new Order(15L, LocalDate.of(2025, 9, 1), LocalDate.of(2025, 9, 3), "delivered", new HashSet<Product>(List.of(toy2, toy1, pacifier)));

        Order order16 = new Order(16L, LocalDate.of(2025, 9, 14), LocalDate.of(2025, 9, 16), "received", new HashSet<Product>(List.of(book1, book2, toy1, pacifier)));
        Order order17 = new Order(17L, LocalDate.of(2025, 3, 15), LocalDate.of(2025, 3, 17), "delivered", new HashSet<Product>(List.of(book3, pampers, toy2, pacifier)));
        Order order18 = new Order(18L, LocalDate.of(2025, 9, 13), LocalDate.of(2025, 9, 15), "in delivery", new HashSet<Product>(List.of(toy2)));
        Order order19 = new Order(19L, LocalDate.of(2025, 9, 14), LocalDate.of(2025, 9, 16), "in delivery", new HashSet<Product>(List.of(book1, pampers)));
        Order order20 = new Order(20L, LocalDate.of(2025, 9, 14), LocalDate.of(2025, 9, 16), "in delivery", new HashSet<Product>(List.of(toy1, pacifier)));

        Order order21 = new Order(21L, LocalDate.of(2025, 2, 4), LocalDate.of(2025, 2, 5), "delivered", new HashSet<Product>(List.of(book1, book3, pampers, toy2, toy1)));
        Order order22 = new Order(22L, LocalDate.of(2025, 9, 10), LocalDate.of(2025, 9, 15), "in delivery", new HashSet<Product>(List.of(pampers, pacifier)));
        Order order23 = new Order(23L, LocalDate.of(2025, 9, 13), LocalDate.of(2025, 9, 16), "in delivery", new HashSet<Product>(List.of(book1, pampers, toy2)));
        Order order24 = new Order(24L, LocalDate.of(2025, 9, 10), LocalDate.of(2025, 9, 16), "received", new HashSet<Product>(List.of(toy1, book3, toy2, pacifier)));
        Order order25 = new Order(25L, LocalDate.of(2025, 3, 14), LocalDate.of(2025, 3, 16), "received", new HashSet<Product>(List.of(toy1, book2, toy2)));

        Customer customer1 = new Customer(1L, "Petr Petrov", 1L, new HashSet<Order>(List.of(order1, order2, order3, order4, order5)));
        Customer customer2 = new Customer(2L, "Svetlana Ivanova", 2L, new HashSet<Order>(List.of(order6, order7, order8, order9, order10)));
        Customer customer3 = new Customer(3L, "Konstantin Smirnov", 1L, new HashSet<Order>(List.of(order11, order12, order13, order14, order15)));
        Customer customer4 = new Customer(4L, "Ivan Ivanov", 2L, new HashSet<Order>(List.of(order16, order17, order18, order19, order20)));
        Customer customer5 = new Customer(5L, "Pavel Pavlov", 3L, new HashSet<Order>(List.of(order21, order22, order23, order24, order25)));

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);

        //Задание 1
        Set<Product> booksWithPriceBiggerThen100 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream()).distinct()
                .filter(product -> product.getCategory().equals("Books") && product.getPrice().compareTo(new BigDecimal("100.00")) >= 0)
                .collect(Collectors.toSet());

        //Задание 2
        Set<Order> ordersWithChildrenProduct = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getProducts().stream()
                        .anyMatch(product -> product.getCategory().equals("Children's products")))
                .collect(Collectors.toSet());

        //Задание 3
        BigDecimal sumOfAllToyProductPricesWith10PersentSale = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> product.getCategory().equals("Toys"))
                .distinct()
                .map(product -> product.getPrice().multiply(new BigDecimal("1.1")))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        //Задание 4
        Set<Product> productsRecievedByCustomer2LevelBetweenFebruaryAndMarch = customers.stream()
                .filter(customer -> customer.getLevel() == 2L)
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getOrderDate().isBefore(LocalDate.of(2025, 4, 1)) && order.getOrderDate().isAfter(LocalDate.of(2025, 2, 1)))
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.toSet());


        //Задание 5
        List<Product> top2cheapestproducts = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .sorted((o1, o2) -> o1.getPrice().compareTo(o2.getPrice()))
                .limit(2)
                .collect(Collectors.toList());

        //Задание 6
        List<Order> top3latestOrders = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .sorted((o1, o2) -> o2.getOrderDate().compareTo(o1.getOrderDate()))
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(top3latestOrders);

        //Задание 7
        Set<Product> productsInOrdersBy15March = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getOrderDate().compareTo(LocalDate.of(2025, 3, 15)) == 0)
                .peek(order -> {
                    System.out.println(order.getId());
                })
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.toSet());


        //Задание 8
        BigDecimal sumOfAllOrdersByFebruary = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getOrderDate().getMonthValue() == 2 && order.getOrderDate().getYear() == 2025)
                .flatMap(order -> order.getProducts().stream())
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);


        //Задание 9
        Set<BigDecimal> sumPaymentInOrdersBy14March = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getOrderDate().compareTo(LocalDate.of(2025, 3, 14)) == 0)
                .map(order -> order.getProducts().stream()
                        .map(Product::getPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
                .collect(Collectors.toSet());

        BigDecimal avgPaymentInOrdersBy14March = sumPaymentInOrdersBy14March.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(sumPaymentInOrdersBy14March.size()), 2, BigDecimal.ROUND_HALF_UP);


        //Задание 10

        // set всех продуктов категории книги
        Set<Product> allBooksProducts = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> product.getCategory().equals("Books"))
                .collect(Collectors.toSet());

        //сумма стоимости всех книг
        BigDecimal sumOfAllBookPrice = allBooksProducts.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        //книга с минимальной стоимостью
        Optional<Product> bookWithMinPrice = allBooksProducts.stream()
                .min(Comparator.comparing(Product::getPrice));

        //книга с максимальной стоимостью
        Optional<Product> bookWithMaxPrice = allBooksProducts.stream()
                .max(Comparator.comparing(Product::getPrice));

        //количество книг
        long countOfBooks = allBooksProducts.stream()
                .count();

        //средняя цена книги
        BigDecimal avgBookPrice = allBooksProducts.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(countOfBooks), 2, BigDecimal.ROUND_HALF_UP);

        System.out.println(avgBookPrice);


        //Задание 11

        //по заданию должна быть Map<Long, Integer>, но не поняла, как сделать, если .count() возвращает Long

        Map<Long, Long> countOfProductInOrder = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .collect(Collectors.toMap(order -> order.getId(), order -> order.getProducts().stream()
                        .map(Product::getPrice)
                        .count()));


        //Задание 12
        Map<Customer, List<Order>> customerOrders = customers.stream()
                .collect(Collectors.toMap(customer -> customer, customer -> customer.getOrders().stream()
                        .collect(Collectors.toList())));

        //Задание 13

        //Тоже не получилось привести BigDecimal к Double
        Map<Order, BigDecimal> sumOfOrder = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .collect(Collectors.toMap(order -> order, order -> order.getProducts().stream()
                        .map(product -> product.getPrice())
                        .reduce(BigDecimal.ZERO, BigDecimal::add)));


        //Задание 14
        Map<String, List<String>> productsByCategory = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.mapping(Product::getName, Collectors.toList())));

        //Задание 15

        //Нормально ли через Optional<Product>? Без Optional не получилось (по заданию надо Map<String, Product>)
        Map<String, Optional<Product>> maxPriceProductInCategory = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.maxBy(Comparator.comparing(Product::getPrice))));
        System.out.println(maxPriceProductInCategory);

    }

}

