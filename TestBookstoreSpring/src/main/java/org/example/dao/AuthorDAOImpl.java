package org.example.dao;

import org.example.model.Authors;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDAOImpl implements AuthorDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Authors> getAuthors() {
        Query<Authors> query = sessionFactory.getCurrentSession().createQuery("from Authors", Authors.class);
        List<Authors> authors = query.getResultList();

        return authors;
    }

    @Override
    public void saveAuthor(Authors author) {
//        Session session;
//        try {
//            session = sessionFactory.getCurrentSession();
//        } catch (HibernateException e) {
//            session = sessionFactory.openSession();
//        }
        sessionFactory.getCurrentSession().save(author);
    }
}
