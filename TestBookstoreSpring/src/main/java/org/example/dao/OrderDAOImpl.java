package org.example.dao;

import org.example.model.Order;
import org.example.model.enums.Status;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Order> getOrders() {
        Query<Order> query = sessionFactory.getCurrentSession().createQuery("from Order", Order.class);
        List<Order> orders = query.getResultList();

        return orders;
    }

    @Override
    public List<Order> getOrders(String username) {
        Query<Order> query = sessionFactory.getCurrentSession().createQuery("from Order where username = :username", Order.class);
        query.setParameter("username", username);
        List<Order> orders = query.getResultList();
        return orders;
    }

    @Override
    public void saveOrder(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public void changeStatusOrder(int id, Status status) {
        Order order = sessionFactory.getCurrentSession().get(Order.class, id);
        order.setStatus(status);
    }
}
