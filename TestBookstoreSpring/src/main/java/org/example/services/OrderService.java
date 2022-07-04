package org.example.services;

import org.example.model.Order;
import org.example.model.enums.Status;

import java.util.List;

public interface OrderService {
    List<Order> getOrders();
    List<Order> getOrders(String username);
    void saveOrder(Order order);
    public void changeStatusOrder(int id, Status status);
}
