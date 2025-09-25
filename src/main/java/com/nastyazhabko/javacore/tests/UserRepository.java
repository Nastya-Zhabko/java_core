package com.nastyazhabko.javacore.tests;

public interface UserRepository {
    User findUserById(int id);

    boolean saveUser(User user);
}
