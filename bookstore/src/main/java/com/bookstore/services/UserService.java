package com.bookstore.services;

import com.bookstore.domain.User;
import com.bookstore.domain.security.UserRole;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UserService {
    User createUser(User user, Set<UserRole> userRoles);
}
