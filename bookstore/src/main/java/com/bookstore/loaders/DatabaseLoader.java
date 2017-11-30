package com.bookstore.loaders;

import com.bookstore.config.SecurityUtility;
import com.bookstore.domain.User;
import com.bookstore.domain.security.Role;
import com.bookstore.domain.security.UserRole;
import com.bookstore.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(DatabaseLoader.class);

    private UserService userService;

    @Autowired
    public DatabaseLoader(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Adams");
        user.setUsername("j");
        user.setPassword(SecurityUtility.passwordEncoder().encode("p"));
        user.setEmail("JAdams@gmail.com");
        Set<UserRole> userRoles = new HashSet<>();
        Role role1 = new Role();
        role1.setRoleId(1L);
        role1.setName("ROLE_USER");
        userRoles.add(new UserRole(user, role1));

        userService.createUser(user, userRoles);
        userRoles.clear();

        User admin = new User();
        admin.setFirstName("Admin");
        admin.setLastName("Admin");
        admin.setUsername("admin");
        admin.setPassword(SecurityUtility.passwordEncoder().encode("p"));
        admin.setEmail("admin@gmail.com");
        Role role2 = new Role();
        role2.setRoleId(0L);
        role2.setName("ROLE_ADMIN");
        userRoles.add(new UserRole(admin, role2));

        userService.createUser(admin, userRoles);
    }
}
