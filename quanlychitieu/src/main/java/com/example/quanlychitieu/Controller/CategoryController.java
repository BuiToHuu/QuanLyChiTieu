package com.example.quanlychitieu.Controller;

import com.example.quanlychitieu.Entity.Category;
import com.example.quanlychitieu.Service.CategoryService;
import com.example.quanlychitieu.Dto.CategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

    private final CategoryService service;

    @GetMapping
    public List<Category> getByUser(@RequestParam Long userId) {
        return service.getByUser(userId);
    }

    @PostMapping
    public Category create(@RequestBody CategoryRequest req) {
        return service.create(
            new Category(
                null,
                req.getUserId(),
                req.getName(),
                req.getColor(),
                req.getIcon()
            )
        );
    }

    @PutMapping("/{id}")
    public Category update(
        @PathVariable Long id,
        @RequestBody CategoryRequest req
    ) {
        return service.update(
            id,
            new Category(
                null,
                null,
                req.getName(),
                req.getColor(),
                req.getIcon()
            )
        );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
