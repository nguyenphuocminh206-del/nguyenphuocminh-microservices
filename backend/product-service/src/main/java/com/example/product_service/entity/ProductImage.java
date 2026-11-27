package com.example.product_service.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "product_images")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    private String imageUrl;
    public Long getId() { return id; }
    public void setId(Long value) { this.id = value; }
    public Product getProduct() { return product; }
    public void setProduct(Product value) { this.product = value; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String value) { this.imageUrl = value; }
}
