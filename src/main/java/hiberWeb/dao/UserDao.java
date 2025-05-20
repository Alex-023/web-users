package hiberWeb.dao;

import hiberWeb.model.Role;
import hiberWeb.model.User;

import java.util.List;

public interface UserDao {
    List<User> listUsers();
    void save (User user);
    User findById(Long id);
    User findUserByNick(String nick);
    void delete (Long id);
    void update (User user);
    Role findRoleByName(String name);
    void createRoleIfNotExists(String name);
    List<Role> listRoles();
}