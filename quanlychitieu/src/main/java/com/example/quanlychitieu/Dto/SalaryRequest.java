package com.example.quanlychitieu.Dto;


import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryRequest {
    private Long userId;
    private String month;
    private Double baseSalary;
}
