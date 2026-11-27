package com.example.order_service.repository;
import com.example.order_service.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CartRepository extends JpaRepository<Cart, Long> {}
