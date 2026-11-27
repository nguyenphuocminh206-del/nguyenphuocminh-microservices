package com.example.product_service.service;
import com.example.product_service.entity.ProductImage;
import com.example.product_service.repository.ProductImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@Service
public class ProductImageService {
    private final ProductImageRepository repository;
    public ProductImageService(ProductImageRepository repository) { this.repository = repository; }
    public List<ProductImage> getAll() { return repository.findAll(); }
    public ProductImage getById(Long id) { return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ProductImage not found")); }
    public ProductImage create(ProductImage data) {
        validate(data);
        data.setId(null);
        return repository.save(data);
    }
    public ProductImage update(Long id, ProductImage data) {
        validate(data);
        ProductImage current = getById(id);
        current.setProductId(data.getProductId());
        current.setImageUrl(data.getImageUrl());
        return repository.save(current);
    }
    public void delete(Long id) { repository.delete(getById(id)); }
    private void validate(ProductImage data) {
        if (data.getProductId() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "productId is required");
    }
}
