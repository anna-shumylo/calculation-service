package com.calculationservice.services;

import com.calculationservice.DAO.UsersDAO;
import com.calculationservice.DAO.UsersDAOImpl;
import com.calculationservice.models.User;

import java.util.ArrayList;

public class UserService {
    private UsersDAO usersDao = new UsersDAOImpl();

    public UserService() {
    }

    public User getUser(int id) {
        return usersDao.getUserById(id);
    }

    public void addUser(User user) {
        usersDao.addUser(user);
    }

    public void deleteUser(User user) {
        usersDao.deleteUser(user);
    }

    public void updateUser(User user) {
        usersDao.updateUser(user);
    }

    public ArrayList<User> findAllUsers() {
        return new ArrayList(usersDao.getAllUsers());
    }

}
