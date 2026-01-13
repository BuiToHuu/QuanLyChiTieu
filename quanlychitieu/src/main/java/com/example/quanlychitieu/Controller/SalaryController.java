package com.example.quanlychitieu.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.quanlychitieu.Dto.SalaryRequest;
import com.example.quanlychitieu.Entity.Salary;
import lombok.RequiredArgsConstructor;
import com.example.quanlychitieu.Service.SalaryService;


@RestController
@RequestMapping("/salary")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class SalaryController {

    private final SalaryService service;

    @GetMapping
    public Salary get(
        @RequestParam Long userId,
        @RequestParam String month
    ) {
        return service.get(userId, month);
    }

    @PostMapping
    public Salary save(@RequestBody SalaryRequest req) {
        return service.save(
            req.getUserId(),
            req.getMonth(),
            req.getBaseSalary()
        );
    }
}
