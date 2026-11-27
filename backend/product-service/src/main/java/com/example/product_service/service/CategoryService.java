package com.example.product_service.service;
import com.example.product_service.entity.Category;
import com.example.product_service.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@Service
public class CategoryService {
    private final CategoryRepository repository;
    public CategoryService(CategoryRepository repository) { this.repository = repository; }
    public List<Category> getAll() { return repository.findAll(); }
    public Category getById(Long id) { return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found")); }
    public Category create(Category data) {
        validate(data);
        data.setId(null);
        return repository.save(data);
    }
    public Category update(Long id, Category data) {
        validate(data);
        Category current = getById(id);
        current.setName(data.getName());
        current.setDescription(data.getDescription());
        return repository.save(current);
    }
    public void delete(Long id) { repository.delete(getById(id)); }
    private void validate(Category data) {
        if (data.getName() == null || data.getName().isBlank()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "name is required");
    }
}
