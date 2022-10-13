package ru.kata.spring.boot_security.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.util.Set;

@SpringBootApplication
public class SpringBootSecurityDemoApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SpringBootSecurityDemoApplication.class, args);

        UserService userService = context.getBean(UserService.class);
        RoleService roleService = context.getBean(RoleService.class);

        if (userService.findByUsername("admin1@mail.ru") == null) {
            if (roleService.getRoleByName("ROLE_ADMIN") == null) {
                Role role = new Role("ROLE_ADMIN");
                roleService.saveRole(role);
            }
            Role role = roleService.getRoleByName("ROLE_ADMIN");
            User userAdmin = new User();
            userAdmin.setFirstName("admins");
            userAdmin.setLastName("admins");
            userAdmin.setEmail("admin1@mail.ru");
            userAdmin.setPassword("admins");
            userAdmin.setAge(33);
            userAdmin.setRoles(Set.of(role));

            userService.saveUser(userAdmin);
        }
        if (userService.findByUsername("user1@mail.ru") == null) {
            if (roleService.getRoleByName("ROLE_USER") == null) {
                Role role = new Role("ROLE_USER");
                roleService.saveRole(role);
            }
            Role role = roleService.getRoleByName("ROLE_USER");
            User user = new User();
            user.setFirstName("users");
            user.setLastName("users");
            user.setEmail("user1@mail.ru");
            user.setPassword("users");
            user.setAge(33);
            user.setRoles(Set.of(role));

            userService.saveUser(user);
        }
    }


}
