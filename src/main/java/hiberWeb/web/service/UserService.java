package hiberWeb.web.service;



import hiberWeb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final hiberWeb.hiber.service.UserService userServiceH;

    @Autowired

    public UserService(hiberWeb.hiber.service.UserService userServiceH) {
        this.userServiceH = userServiceH;
    }

    public List<User> findAll() {

//        return userServiceH.findAll();
        return null;
    }

    public User findById(Long id) {
//        return userServiceH.findById(id);
        return null;
    }

    public void save(User user) {
        userServiceH.save(user);
    }

    public void update(User user) {
//        userServiceH.update(user);
        userServiceH.update();
    }

    public void delete(Long id) {
//        userServiceH.delete(userServiceH.findById(id));
        userServiceH.delete();
    }
}