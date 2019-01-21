package com.calculationservice.DAO;

import com.calculationservice.models.User;

import java.util.Collection;

public interface UsersDAO {
    void addUser(User user);
    void updateUser(User user);
    User getUserById(int users_id);
    Collection getAllUsers();
    void deleteUser(User user);
}