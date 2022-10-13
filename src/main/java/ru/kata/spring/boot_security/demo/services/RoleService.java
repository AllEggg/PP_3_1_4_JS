package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.model.Role;
import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();

    Role getRoleByName(String name);

    void saveRole(Role role);
}