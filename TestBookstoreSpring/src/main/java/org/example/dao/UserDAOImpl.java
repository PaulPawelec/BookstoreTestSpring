package org.example.dao;

import org.example.model.Authority;
import org.example.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User getUser(String username) {
//        Query<User> query = session.createQuery("from User as u WHERE u.username="+username, User.class);
        Query<User> query = sessionFactory.getCurrentSession().createQuery("from User as u WHERE u.username= :username");
        query.setParameter("username", username);
        User user = query.getSingleResult();

        return null;
    }

    @Override
    public List<User> getUsers() {
        Query<User> query = sessionFactory.getCurrentSession().createQuery("from User", User.class);
        List<User> users = query.getResultList();

        return null;
    }

    @Override
    public void saveUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
}
