package ru.kata.spring.boot_security.demo.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Set;

public interface RoleDao {
    List<User> getAllRoles();

    void add(Role role);

    void edit(Role role);

    Role getById(long id);

    Role getRoleByName(String roleName);

    Set<Role> getSetRoles(Set<String>roles);
}
