package com.example.SB_MVC_JPA_App.service;


import com.example.SB_MVC_JPA_App.dao.UserDAO;
import com.example.SB_MVC_JPA_App.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> scroll() {
        return userDAO.scroll();
    }

    @Override
    public User showUser(int id) {
        return userDAO.showUser(id);
    }

    @Override
    public void save(User person) {
        userDAO.save(person);
    }

    @Override
    public void update(int id, User updatedPerson) {
        userDAO.update(id, updatedPerson);
    }

    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }
}
