package hiberWeb.service;

import hiberWeb.model.Role;
import hiberWeb.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    @Transactional
    List<User> listUsers();

    @Transactional
    void save(User user);
    List<User> findAll();

    @Transactional
    User findById(Long id);

    @Transactional
    void delete(Long id);

    @Transactional
    void update(User user);

    @Transactional
    User findUserByNick(String nick);

    @Transactional
    List<Role> listRoles();
}
