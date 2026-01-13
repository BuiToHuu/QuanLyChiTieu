package com.example.quanlychitieu.Service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import jakarta.transaction.Transactional;
import com.example.quanlychitieu.Entity.Salary;
import com.example.quanlychitieu.Repository.SalaryRepository;

@Service
@RequiredArgsConstructor
public class SalaryService {

    private final SalaryRepository repo;

    /**
     * Lấy lương theo user + tháng
     * Nếu chưa có thì tự tạo
     */
    public Salary get(Long userId, String month) {
        return repo.findByUserIdAndMonth(userId, month)
                .orElseGet(() -> {
                    Salary s = new Salary();
                    s.setUserId(userId);
                    s.setMonth(month);
                    s.setBaseSalary(0.0);
                    s.setBalance(0.0);
                    return repo.save(s);
                });
    }

    /**
     * Cập nhật lương gốc
     * Giữ nguyên số tiền đã chi
     */
    @Transactional
    public Salary save(Long userId, String month, Double newBaseSalary) {

        Salary s = repo.findByUserIdAndMonth(userId, month)
                .orElseGet(() -> {
                    Salary n = new Salary();
                    n.setUserId(userId);
                    n.setMonth(month);
                    n.setBaseSalary(0.0);
                    n.setBalance(0.0);
                    return n;
                });

        double spent = s.getBaseSalary() - s.getBalance();

        s.setBaseSalary(newBaseSalary);
        s.setBalance(newBaseSalary - spent);

        return repo.save(s);
    }
}
