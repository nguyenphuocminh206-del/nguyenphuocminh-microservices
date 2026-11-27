package com.example.product_service.entity;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private Integer quantity;
    private Long categoryId;
    private Long brandId;
    public Long getId() { return id; }
    public void setId(Long value) { this.id = value; }
    public String getName() { return name; }
    public void setName(String value) { this.name = value; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal value) { this.price = value; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer value) { this.quantity = value; }
    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long value) { this.categoryId = value; }
    public Long getBrandId() { return brandId; }
    public void setBrandId(Long value) { this.brandId = value; }
}
