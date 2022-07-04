package org.example.dao;

import org.example.model.Categories;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Categories> getCategories() {
        Query<Categories> query = sessionFactory.getCurrentSession().createQuery("from Categories", Categories.class);
        List<Categories> categories = query.getResultList();

        return categories;
    }

    @Override
    public void saveCategory(Categories category) {
        sessionFactory.getCurrentSession().save(category);
    }
}
