package com.example.Pets.Palette.repository;

import com.example.Pets.Palette.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByCognitoUsername(String cognitoUsername);
    User findByCognitoUsername(String cognitoUsername);
}
