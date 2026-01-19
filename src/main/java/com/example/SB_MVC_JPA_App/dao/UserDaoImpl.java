package com.example.SB_MVC_JPA_App.dao;


import com.example.SB_MVC_JPA_App.model.User;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> scroll() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User showUser(int id) {
        return em.find(User.class, id);
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public void update(int id, User updatedUser) {
        updatedUser.setId(id);
        em.merge(updatedUser);
    }

    @Override
    public void delete(int id) {
        em.createQuery("delete from User u where u.id=:id").setParameter("id", id).executeUpdate();
    }
}
