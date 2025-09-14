package com.nastyazhabko.javacore.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class intermediateOperations {
    public static void main(String[] args) {
        List<String> list = List.of("Java is fun", "Stream API simplifies data processing", "I love study");
        Stream<String> streamFlatMap = list.stream();
        streamFlatMap.flatMap(c -> Arrays.stream(c.split(" ")))
                .filter(s -> s.length() > 3)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }
}
