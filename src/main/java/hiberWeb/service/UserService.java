package hiberWeb.service;

import hiberWeb.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    @Transactional
    List<User> listUsers();

    void save(User user);
    List<User> findAll();

    @javax.transaction.Transactional
    User findById(Long id);

    @javax.transaction.Transactional
    void delete(Long id);

    @javax.transaction.Transactional
    void update(User user);
}
