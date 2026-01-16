package com.example.SB_MVC_JPA_App.dao;


import com.example.SB_MVC_JPA_App.model.User;

import java.util.List;

public interface UserDAO {
    List<User> scroll();

    // Returns a list of users

    User showUser(int id);

    // Finds a user by ID

    void save(User person);

    // Saves the user

    void update(int id, User updatedPerson);

    // Updates the user

    void delete(int id);
}
