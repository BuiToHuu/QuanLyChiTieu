package com.example.quanlychitieu.Repository;

import com.example.quanlychitieu.Entity.Salary;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary, Long> {

    Optional<Salary> findByUserIdAndMonth(Long userId, String month);
}
