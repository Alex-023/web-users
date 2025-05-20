package hiberWeb.dao;

import hiberWeb.model.Role;
import hiberWeb.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoEM implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Transactional
    @Override
    public void save(User user) {
        entityManager.persist(user);//merge(user);
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Transactional
    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Transactional
    public Role findRoleByName(String name) {
        try {
            return entityManager.createQuery(
                            "SELECT r FROM Role r WHERE r.name = :name", Role.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Transactional
    public User findUserByNick(String nick) {
        try {
            return entityManager.createQuery(
                            "SELECT u FROM User u WHERE u.nickName = :nick", User.class)
                    .setParameter("nick", nick)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Transactional
    public void createRoleIfNotExists(String name) {
        if (findRoleByName(name) == null) {
            Role role = new Role();
            role.setName(name);
            entityManager.persist(role);
        }
    }
    @Override
    public List<Role> listRoles() {
        return entityManager.createQuery("FROM Role", Role.class).getResultList();
    }
}
