package web.service;

import web.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void addUser(User user);

    User getUserById(int id);

    void deleteUserById(int id);
}
