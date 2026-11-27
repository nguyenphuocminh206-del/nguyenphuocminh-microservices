package com.example.product_service.controller;
import com.example.product_service.entity.ProductImage;
import com.example.product_service.service.ProductImageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/product-images")
public class ProductImageController {
    private final ProductImageService service;
    public ProductImageController(ProductImageService service) { this.service = service; }
    @GetMapping
    public List<ProductImage> getAll() { return service.getAll(); }
    @GetMapping("/{id}")
    public ProductImage getById(@PathVariable Long id) { return service.getById(id); }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductImage create(@RequestBody ProductImage data) { return service.create(data); }
    @PutMapping("/{id}")
    public ProductImage update(@PathVariable Long id, @RequestBody ProductImage data) { return service.update(id, data); }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
