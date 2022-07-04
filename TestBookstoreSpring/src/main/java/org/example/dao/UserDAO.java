package org.example.dao;

import org.example.model.User;

import java.util.List;

public interface UserDAO {
    public User getUser(String username);
    public List<User> getUsers();
    public void saveUser(User user);
}
