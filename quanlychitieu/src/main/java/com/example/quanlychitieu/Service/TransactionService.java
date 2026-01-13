package com.example.quanlychitieu.Service;

import com.example.quanlychitieu.Entity.Transaction;
import com.example.quanlychitieu.Repository.TransactionRepository;
import org.springframework.stereotype.Service;
import com.example.quanlychitieu.Entity.Salary;
import com.example.quanlychitieu.Repository.SalaryRepository;
import lombok.RequiredArgsConstructor;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepo;
    private final SalaryRepository salaryRepo;

    @Transactional
    public Transaction add(Transaction t) {
        Salary s = salaryRepo.findByUserIdAndMonth(t.getUserId(), t.getMonth())
                .orElseThrow(() -> new RuntimeException("Chưa có lương tháng này"));

        // trừ lương
        s.setBalance(s.getBalance() - t.getAmount());
        salaryRepo.save(s);

        return transactionRepo.save(t);
    }

    @Transactional
    public Transaction update(Long id, Transaction newData) {
        Transaction old = transactionRepo.findById(id).orElseThrow();

        Salary s = salaryRepo.findByUserIdAndMonth(old.getUserId(), old.getMonth())
                .orElseThrow();

        // hoàn tiền cũ
        s.setBalance(s.getBalance() + old.getAmount());
        // trừ tiền mới
        s.setBalance(s.getBalance() - newData.getAmount());

        salaryRepo.save(s);

        old.setTitle(newData.getTitle());
        old.setCategory(newData.getCategory());
        old.setAmount(newData.getAmount());
        old.setDate(newData.getDate());

        return transactionRepo.save(old);
    }

    @Transactional
    public void delete(Long id) {
        Transaction t = transactionRepo.findById(id).orElseThrow();

        Salary s = salaryRepo.findByUserIdAndMonth(t.getUserId(), t.getMonth())
                .orElseThrow();

        // cộng lại lương
        s.setBalance(s.getBalance() + t.getAmount());
        salaryRepo.save(s);

        transactionRepo.delete(t);
    }

    public List<Transaction> list(Long userId, String month) {
        return transactionRepo.findByUserIdAndMonth(userId, month);
    }
}
