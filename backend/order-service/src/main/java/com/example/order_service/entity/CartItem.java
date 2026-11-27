package com.example.order_service.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long cartId;
    @Column(nullable = false)
    private Long productId;
    @Column(nullable = false)
    private Integer quantity;
    public Long getId() { return id; }
    public void setId(Long value) { this.id = value; }
    public Long getCartId() { return cartId; }
    public void setCartId(Long value) { this.cartId = value; }
    public Long getProductId() { return productId; }
    public void setProductId(Long value) { this.productId = value; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer value) { this.quantity = value; }
}
