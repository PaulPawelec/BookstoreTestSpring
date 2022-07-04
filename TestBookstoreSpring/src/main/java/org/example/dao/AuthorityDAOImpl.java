package org.example.dao;

import org.example.model.Authority;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorityDAOImpl implements AuthorityDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveAuthority(Authority authority) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        session.save(authority);
    }
}
