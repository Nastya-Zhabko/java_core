package com.nastyazhabko.javacore.streamapi;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streamApi {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        stream.map(n -> n * n).collect(Collectors.toList()).forEach(System.out::println);
    }
}
