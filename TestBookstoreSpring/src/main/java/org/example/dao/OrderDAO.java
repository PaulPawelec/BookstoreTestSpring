package org.example.dao;

import org.example.model.Order;
import org.example.model.enums.Status;

import java.util.List;

public interface OrderDAO {
    public List<Order> getOrders();
    public List<Order> getOrders(String username);
    public void saveOrder(Order order);
    public void changeStatusOrder(int id, Status status);
}
