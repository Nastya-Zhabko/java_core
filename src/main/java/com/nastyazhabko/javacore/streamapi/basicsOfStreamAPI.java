package com.nastyazhabko.javacore.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class basicsOfStreamAPI {
    public static void main(String[] args) {
        List<String> list = List.of("a", "b", "c", "d", "e", "f", "g", "h");
        String[] array = {"HELLO", "WORLD"};

        Stream<String> streamOfList = list.stream();

        streamOfList.map(String::toUpperCase).forEach(System.out::println);

        Stream<String> streamOfArray = Arrays.stream(array);

        streamOfArray.map(String::toLowerCase).forEach(System.out::println);

        Stream<Integer> streamOfInt = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

//        streamOfInt.filter(n -> n % 2 != 0).forEach(System.out::println);


        List<Integer> list1 = streamOfInt.filter(n -> n % 2 == 0).map(n -> n * 2).collect(Collectors.toList());

        System.out.println(list1);

        Stream<Double> streamGenerate = Stream.generate(Math::random);

        streamGenerate.limit(5).forEach(System.out::println);


        Stream<Integer> streamOfNum = Stream.iterate(10, n -> n + 10);

        streamOfNum.limit(10).forEach(System.out::println);

    }
}
