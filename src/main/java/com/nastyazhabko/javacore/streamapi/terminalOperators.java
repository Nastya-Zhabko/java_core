package com.nastyazhabko.javacore.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class terminalOperators {
    public static void main(String[] args) {
        User user1 = new User("Ivan", 25);
        User user2 = new User("Anna", 45);
        User user3 = new User("Maria", 20);
        User user4 = new User("Pavel", 56);
        User user5 = new User("Slava", 44);
        User user6 = new User("Ivan", 25);
        User user7 = new User("Maria", 26);

        List<User> users = Arrays.asList(user1, user2, user3, user4, user5, user6, user7);

        Stream<User> streamOfUsers = users.stream();
        List<String> newList = streamOfUsers.filter(n -> n.getAge() > 25)
                .map(User::getName)
                .sorted()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(newList);
    }
}
