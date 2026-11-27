package com.example.product_service.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "product_images")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long productId;
    private String imageUrl;
    public Long getId() { return id; }
    public void setId(Long value) { this.id = value; }
    public Long getProductId() { return productId; }
    public void setProductId(Long value) { this.productId = value; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String value) { this.imageUrl = value; }
}
