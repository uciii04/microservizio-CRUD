package com.example.GestioneCatalogo.security.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.GestioneCatalogo.security.model.User;

public interface UserRepository extends MongoRepository<User, Long> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
    
}
