package com.example.product_service.service;
import com.example.product_service.entity.Product;
import com.example.product_service.repository.ProductRepository;
import com.example.product_service.repository.CategoryRepository;
import com.example.product_service.repository.BrandRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@Service
public class ProductService {
    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;
    public ProductService(ProductRepository repository, CategoryRepository categoryRepository, BrandRepository brandRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
        this.brandRepository = brandRepository;
    }
    public List<Product> getAll() { return repository.findAll(); }
    public Product getById(Long id) { return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found")); }
    public Product create(Product data) {
        validate(data);
        data.setId(null);
        resolveRelations(data);
        return repository.save(data);
    }
    public Product update(Long id, Product data) {
        validate(data);
        Product current = getById(id);
        current.setName(data.getName());
        current.setPrice(data.getPrice());
        current.setQuantity(data.getQuantity());
        data.setId(id);
        resolveRelations(data);
        current.setCategory(data.getCategory());
        current.setBrand(data.getBrand());
        return repository.save(current);
    }
    public void delete(Long id) { repository.delete(getById(id)); }
    private void validate(Product data) {
        if (data.getName() == null || data.getName().isBlank()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "name is required");
        if (data.getPrice() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "price is required");
        if (data.getQuantity() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "quantity is required");
    }
    private void resolveRelations(Product data) {
        if (data.getCategory() != null && data.getCategory().getId() != null) {
            data.setCategory(categoryRepository.findById(data.getCategory().getId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category not found")));
        }
        if (data.getBrand() != null && data.getBrand().getId() != null) {
            data.setBrand(brandRepository.findById(data.getBrand().getId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Brand not found")));
        }
    }
}
