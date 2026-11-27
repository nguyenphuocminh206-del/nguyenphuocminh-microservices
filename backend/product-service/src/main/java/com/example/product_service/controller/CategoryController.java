package com.example.product_service.controller;
import com.example.product_service.entity.Category;
import com.example.product_service.service.CategoryService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService service;
    public CategoryController(CategoryService service) { this.service = service; }
    @GetMapping
    public List<Category> getAll() { return service.getAll(); }
    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id) { return service.getById(id); }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category create(@RequestBody Category data) { return service.create(data); }
    @PutMapping("/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category data) { return service.update(id, data); }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
