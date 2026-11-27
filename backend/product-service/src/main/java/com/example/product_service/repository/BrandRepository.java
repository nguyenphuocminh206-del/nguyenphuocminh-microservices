package com.example.product_service.repository;
import com.example.product_service.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BrandRepository extends JpaRepository<Brand, Long> {}
