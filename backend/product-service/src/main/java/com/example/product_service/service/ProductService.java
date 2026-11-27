package com.example.product_service.service;
import com.example.product_service.entity.Product;
import com.example.product_service.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@Service
public class ProductService {
    private final ProductRepository repository;
    public ProductService(ProductRepository repository) { this.repository = repository; }
    public List<Product> getAll() { return repository.findAll(); }
    public Product getById(Long id) { return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found")); }
    public Product create(Product data) {
        validate(data);
        data.setId(null);
        return repository.save(data);
    }
    public Product update(Long id, Product data) {
        validate(data);
        Product current = getById(id);
        current.setName(data.getName());
        current.setPrice(data.getPrice());
        current.setQuantity(data.getQuantity());
        current.setCategoryId(data.getCategoryId());
        current.setBrandId(data.getBrandId());
        return repository.save(current);
    }
    public void delete(Long id) { repository.delete(getById(id)); }
    private void validate(Product data) {
        if (data.getName() == null || data.getName().isBlank()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "name is required");
        if (data.getPrice() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "price is required");
        if (data.getQuantity() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "quantity is required");
    }
}
