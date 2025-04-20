package hiberWeb.service;

import hiberWeb.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    @Transactional(/*readOnly = true*/)
//    @Override
//    UserService(User user);

    void add(User user);
    List<User> listUsers();
//    User getUsersCar(String model, int series);
    void save(User user);
    void findAll();
    void findById();
    void update();
    void delete();

    // Добавьте реализацию остальных методов
    @javax.transaction.Transactional
    User findById(Long id);

    @javax.transaction.Transactional
    void delete(Long id);
}
