package org.example.services;

import org.example.dao.OrderDAO;
import org.example.model.Order;
import org.example.model.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    private OrderDAO orderDAO;

    @Autowired
    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    @Transactional
    public List<Order> getOrders() {
        List<Order> orders = orderDAO.getOrders();

        return orders;
    }

    @Override
    @Transactional
    public List<Order> getOrders(String username) {
        List<Order> orders = orderDAO.getOrders(username);

        return orders;
    }

    @Override
    @Transactional
    public void saveOrder(Order order) {
        orderDAO.saveOrder(order);
    }

    @Override
    @Transactional
    public void changeStatusOrder(int id, Status status) {
        orderDAO.changeStatusOrder(id, status);
    }
}
