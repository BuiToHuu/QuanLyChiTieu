package com.example.quanlychitieu.Controller;

import com.example.quanlychitieu.Entity.Transaction;
import com.example.quanlychitieu.Service.TransactionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class TransactionController {

    private final TransactionService service;

    @GetMapping
    public List<Transaction> list(
        @RequestParam Long userId,
        @RequestParam String month
    ) {
        return service.list(userId, month);
    }

    @PostMapping
    public Transaction add(@RequestBody Transaction t) {
        return service.add(t);
    }

    @PutMapping("/{id}")
    public Transaction update(
        @PathVariable Long id,
        @RequestBody Transaction t
    ) {
        return service.update(id, t);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
