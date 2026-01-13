package com.example.quanlychitieu.Service;

import com.example.quanlychitieu.Entity.Category;
import com.example.quanlychitieu.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repo;

    public List<Category> getByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    public Category create(Category c) {
        return repo.save(c);
    }

    public Category update(Long id, Category data) {
        Category c = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        c.setName(data.getName());
        c.setColor(data.getColor());
        c.setIcon(data.getIcon());

        return repo.save(c);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
