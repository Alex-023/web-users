package hiberWeb.dao;

import hiberWeb.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

//    @Override
//    public User findOwnerByCarModelAndSeries(String model, int series) {
//
//        // HQL-запрос с JOIN между User и Car
//        String hql = "SELECT u FROM User u JOIN u.car c WHERE c.model = :model AND c.series = :series";
//
//        return sessionFactory.getCurrentSession().createQuery(hql, User.class)
//                .setParameter("model", model)
//                .setParameter("series", series)
//                .uniqueResult(); // Возвращает null, если результат не найден
//    }

    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
}
