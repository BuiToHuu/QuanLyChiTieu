package com.example.quanlychitieu.Service;

import org.springframework.stereotype.Service;

import com.example.quanlychitieu.Entity.User;
import com.example.quanlychitieu.Repository.UserInterface;

@Service
public class UserService {
    private final UserInterface userRepository;

    public UserService(UserInterface userRepository) {
        this.userRepository = userRepository;
    }

    // 1. Thêm phương thức lấy User theo ID để Frontend gọi khi load trang Settings
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public User createUser(User userCreate) {
        if (userRepository.existsByUsername(userCreate.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        return userRepository.save(userCreate);
    }

    public User authenticate(String username, String password) {
        return userRepository.findByUsername(username)
                .filter(user -> user.getPassword().equals(password))
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));
    }

    public User updateUser(Long id, User userUpdate) {
        return userRepository.findById(id).map(existingUser -> {
            // Cập nhật Email
            if (userUpdate.getEmail() != null && !userUpdate.getEmail().isEmpty()) {
                existingUser.setEmail(userUpdate.getEmail());
            }
            // Chỉ cập nhật Password nếu người dùng có nhập mới
            if (userUpdate.getPassword() != null && !userUpdate.getPassword().trim().isEmpty()) {
                existingUser.setPassword(userUpdate.getPassword());
            }
            return userRepository.save(existingUser);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }
}

