package com.bookstore.repositories;

import com.bookstore.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    Optional<User> findByEmail(String email);
    List<User> findAll();
}
