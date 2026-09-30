package com.auth_service_nov2.repository;

import com.auth_service_nov2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {

        User findByUsername(String username);
        User findByEmail(String email);
        boolean existsByUsername(String username);
        boolean existsByEmail(String email);
}