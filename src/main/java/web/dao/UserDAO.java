package web.dao;

import web.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();

    void addUser(User user);

    User getUserById(int id);

    void deleteUserById(int id);
}
