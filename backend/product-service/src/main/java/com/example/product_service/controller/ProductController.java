package com.example.product_service.controller;
import com.example.product_service.entity.Product;
import com.example.product_service.service.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService service;
    public ProductController(ProductService service) { this.service = service; }
    @GetMapping
    public List<Product> getAll() { return service.getAll(); }
    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) { return service.getById(id); }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product data) { return service.create(data); }
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product data) { return service.update(id, data); }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
