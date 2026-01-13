package com.example.quanlychitieu.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quanlychitieu.Entity.User;

public interface UserInterface extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
    // Optional<User> findById(Long id);
}
