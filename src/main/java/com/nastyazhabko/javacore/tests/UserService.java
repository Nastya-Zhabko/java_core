package com.nastyazhabko.javacore.tests;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Метод возвращает имя пользователя, если пользователь найден, или "Unknown"
    public String getUserName(int id) {
        User user = userRepository.findUserById(id);
        return user != null ? user.getName() : "Unknown";
    }

    public boolean saveUser(User user) {
       boolean status = userRepository.saveUser(user);
        return status;
    }
}
