package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.entity.User;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private final UserDAO dao;
    @Autowired
    public UserServiceImpl(UserDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public User getUserById(int id) {
        return dao.getUserById(id);
    }
    @Override
    public void deleteUserById(int id) {
        dao.deleteUserById(id);
    }
}
