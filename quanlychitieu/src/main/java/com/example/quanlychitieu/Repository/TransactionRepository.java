package com.example.quanlychitieu.Repository;

import com.example.quanlychitieu.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByUserIdAndMonth(Long userId, String month);
}
