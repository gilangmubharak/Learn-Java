package com.example.Jwtauthentication.repository;

import com.example.Jwtauthentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
    boolean existingByUsername(String username);
    boolean existingByEmail(String email);
}
