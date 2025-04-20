package hiberWeb.hiber.dao;

import hiberWeb.hiber.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> listUsers();
//    User findOwnerByCarModelAndSeries(String model, int series);
    void save (User user);
    //---

    //---
}