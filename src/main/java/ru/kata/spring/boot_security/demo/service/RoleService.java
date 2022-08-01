package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class RoleService {

    @Autowired
    RoleDao roleDao;

    public    List<User> getAllRoles(){
        return roleDao.getAllRoles();
    }

    public  void add(Role role){
        roleDao.add(role);
    }

    public  void edit(Role role){
        roleDao.edit(role);
    }

    public Role getById(long id){
        return    roleDao.getById(id);
    }

    public Role getRoleByName(String roleName){
        return roleDao.getRoleByName(roleName);
    }


    public Set<Role> getSetRoles(Set<String>roles){
        return roleDao.getSetRoles(roles);
    }
}
