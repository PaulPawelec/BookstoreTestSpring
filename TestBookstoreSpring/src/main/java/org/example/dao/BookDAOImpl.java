package org.example.dao;

import org.example.model.Books;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class BookDAOImpl implements BookDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Books> getBooks() {
        Query<Books> query = sessionFactory.getCurrentSession().createQuery("from Books", Books.class);
        List<Books> books = query.getResultList();

        return books;
    }

    @Override
    public List<Books> getBooks(Set<Integer> bookIds) {
        if(bookIds.isEmpty())
            return null;
        Query<Books> query = sessionFactory.getCurrentSession().createQuery("from Books where id IN (:bookIds)", Books.class);
        query.setParameter("bookIds", bookIds);
        List<Books> books = query.getResultList();

        return books;
    }

    @Override
    public void saveBook(Books book) {
        sessionFactory.getCurrentSession().save(book);
    }

    @Override
    public void deleteBook(int id) {
        Books book = sessionFactory.getCurrentSession().get(Books.class, id);
        sessionFactory.getCurrentSession().delete(book);
    }
}
