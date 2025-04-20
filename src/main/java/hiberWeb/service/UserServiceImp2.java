package hiberWeb.service;

import hiberWeb.dao.UserDao;
import hiberWeb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Primary
@Service
public class UserServiceImp2 implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }



    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }


    @Transactional//(/*readOnly = true*/)
    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void findAll() {

    }

    @Override
    public void findById() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    //    @Transactional(readOnly = true)
//    public User getUsersCar(String model, int series) {
//        return userDao.findOwnerByCarModelAndSeries(model, series);
//    }
}
