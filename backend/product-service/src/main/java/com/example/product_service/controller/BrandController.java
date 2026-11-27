package com.example.product_service.controller;
import com.example.product_service.entity.Brand;
import com.example.product_service.service.BrandService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/brands")
public class BrandController {
    private final BrandService service;
    public BrandController(BrandService service) { this.service = service; }
    @GetMapping
    public List<Brand> getAll() { return service.getAll(); }
    @GetMapping("/{id}")
    public Brand getById(@PathVariable Long id) { return service.getById(id); }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Brand create(@RequestBody Brand data) { return service.create(data); }
    @PutMapping("/{id}")
    public Brand update(@PathVariable Long id, @RequestBody Brand data) { return service.update(id, data); }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
