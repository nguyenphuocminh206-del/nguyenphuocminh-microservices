package com.example.product_service.service;
import com.example.product_service.entity.ProductImage;
import com.example.product_service.repository.ProductImageRepository;
import com.example.product_service.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@Service
public class ProductImageService {
    private final ProductImageRepository repository;
    private final ProductRepository productRepository;
    public ProductImageService(ProductImageRepository repository, ProductRepository productRepository) {
        this.repository = repository;
        this.productRepository = productRepository;
    }
    public List<ProductImage> getAll() { return repository.findAll(); }
    public ProductImage getById(Long id) { return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ProductImage not found")); }
    public ProductImage create(ProductImage data) {
        validate(data);
        data.setId(null);
        resolveProduct(data);
        return repository.save(data);
    }
    public ProductImage update(Long id, ProductImage data) {
        validate(data);
        ProductImage current = getById(id);
        resolveProduct(data);
        current.setProduct(data.getProduct());
        current.setImageUrl(data.getImageUrl());
        return repository.save(current);
    }
    public void delete(Long id) { repository.delete(getById(id)); }
    private void validate(ProductImage data) {
        if (data.getProduct() == null || data.getProduct().getId() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "product.id is required");
    }
    private void resolveProduct(ProductImage data) {
        data.setProduct(productRepository.findById(data.getProduct().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product not found")));
    }
}
