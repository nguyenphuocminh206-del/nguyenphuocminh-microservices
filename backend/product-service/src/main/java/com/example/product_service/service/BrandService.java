package com.example.product_service.service;
import com.example.product_service.entity.Brand;
import com.example.product_service.repository.BrandRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@Service
public class BrandService {
    private final BrandRepository repository;
    public BrandService(BrandRepository repository) { this.repository = repository; }
    public List<Brand> getAll() { return repository.findAll(); }
    public Brand getById(Long id) { return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Brand not found")); }
    public Brand create(Brand data) {
        validate(data);
        data.setId(null);
        return repository.save(data);
    }
    public Brand update(Long id, Brand data) {
        validate(data);
        Brand current = getById(id);
        current.setName(data.getName());
        current.setDescription(data.getDescription());
        return repository.save(current);
    }
    public void delete(Long id) { repository.delete(getById(id)); }
    private void validate(Brand data) {
        if (data.getName() == null || data.getName().isBlank()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "name is required");
    }
}
