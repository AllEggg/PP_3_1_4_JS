package ru.kata.spring.boot_security.demo.services;


import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
@Service
public interface UserService {

    List<User> getAllUsers();
    User getUser(Long id);
    void deleteUser(Long id);
    void saveUser(User user);
    User findByUsername(String userName);

    List<Role> getAllRoles();
}
