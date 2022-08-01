package ru.kata.spring.boot_security.demo.dao;


import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManger;

    @Override
    public Collection<User> listUser() {
        return entityManger.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManger.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManger.merge(user);
    }

    @Override
    public void removeUser(Long id) {
        User user = entityManger.find(User.class, id);
        entityManger.remove(user);
    }

    @Override
    public User findByUsername(String username) {
        User user = entityManger.find(User.class, username);
        entityManger.detach(user);
        return user;
    }
}
