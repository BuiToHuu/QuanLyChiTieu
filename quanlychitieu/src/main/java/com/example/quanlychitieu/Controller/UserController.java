package com.example.quanlychitieu.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.quanlychitieu.Entity.User;
import com.example.quanlychitieu.Service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Lấy thông tin User để hiển thị lên Form (Phòng lỗi Failed to fetch khi load trang)
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // API Đăng ký
    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return userService.createUser(user);
    }

    // API Đăng nhập
    @PostMapping("/login")
    public User login(@RequestBody User loginRequest) {
        return userService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
    }

    // API Cập nhật - Khớp chính xác với yêu cầu của bạn
    @PostMapping("/update/{id}")
    public User update(@RequestBody User user, @PathVariable Long id) {
        return userService.updateUser(id, user);
    }
}