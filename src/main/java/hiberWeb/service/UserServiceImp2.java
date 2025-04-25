package hiberWeb.service;

import hiberWeb.dao.UserDao;
import hiberWeb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;

@Primary
@Service
public class UserServiceImp2 implements UserService {
//Hibernate
    @Autowired
    private UserDao userDao;


    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }


    @Override
    public void save(User user) {userDao.save(user);}


    @Override
    public List<User> findAll() {
        return userDao.listUsers();
    }


    @Override
    public void update(User user) {
        userDao.update(user);
    }


    @Override
    public User findById(Long id) {
        if (id == null) {
            return null;
        }
        return userDao.findById(id);
    }


    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

}
