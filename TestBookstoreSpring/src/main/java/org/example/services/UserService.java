package org.example.services;

import org.example.model.User;

import java.util.List;

public interface UserService {
    public User getUser(String username);
    List<User> getUsers();
    public void saveUser(User user);
}
