package ru.kata.spring.boot_security.demo.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserDao {
    public Collection<User> listUser();
    public void addUser(User user);

    public void updateUser(User user);

    public void removeUser(Long id);

    public User findByUsername(String username);
}
