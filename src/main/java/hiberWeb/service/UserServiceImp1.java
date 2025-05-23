package hiberWeb.service;

import hiberWeb.model.Role;
import hiberWeb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImp1 {
//WEB
    private final UserService userServiceH;

    @Autowired
    public UserServiceImp1(UserService userServiceH) {
        this.userServiceH = userServiceH;
    }

    public List<User> findAll() {
        return userServiceH.findAll();
    }

    public User findById(Long id) {
        return userServiceH.findById(id);
    }

    public void save(User user) {
        userServiceH.update(user);
    }

    public void update(User user) {
        userServiceH.update(user);
    }

    public void delete(Long id) {
        userServiceH.delete(id);
    }

    public List<Role> listRoles(){return userServiceH.listRoles();}

    public User findUserByNick(String nick){
        return userServiceH.findUserByNick(nick);
    }
}