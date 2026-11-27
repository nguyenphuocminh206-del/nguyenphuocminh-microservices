package com.example.product_service.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String description;
    public Long getId() { return id; }
    public void setId(Long value) { this.id = value; }
    public String getName() { return name; }
    public void setName(String value) { this.name = value; }
    public String getDescription() { return description; }
    public void setDescription(String value) { this.description = value; }
}
