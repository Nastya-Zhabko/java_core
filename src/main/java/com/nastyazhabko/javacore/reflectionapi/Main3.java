package com.nastyazhabko.javacore.reflectionapi;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main3 {

    public static void main(String[] args) {
        Book book = new Book("dgffgdfg", 400);

        Method[] bookMethods = book.getClass().getDeclaredMethods();
        Arrays.stream(bookMethods)
                .map(method -> method.getAnnotation(Author.class))
                .map(Author::name)
                .forEach(System.out::println);

    }
}
