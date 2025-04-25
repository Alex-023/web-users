package hiberWeb.dao;

import hiberWeb.model.User;

import java.util.List;

public interface UserDao {
    List<User> listUsers();
    void save (User user);
    User findById(Long id);
    void delete (Long id);
    void update (User user);

}