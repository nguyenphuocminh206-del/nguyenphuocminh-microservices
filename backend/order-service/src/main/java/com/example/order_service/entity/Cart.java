package com.example.order_service.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long customerId;
    public Long getId() { return id; }
    public void setId(Long value) { this.id = value; }
    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long value) { this.customerId = value; }
}
