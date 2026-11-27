package com.example.order_service.entity;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long customerId;
    private BigDecimal totalAmount;
    private String status;
    public Long getId() { return id; }
    public void setId(Long value) { this.id = value; }
    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long value) { this.customerId = value; }
    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal value) { this.totalAmount = value; }
    public String getStatus() { return status; }
    public void setStatus(String value) { this.status = value; }
}
