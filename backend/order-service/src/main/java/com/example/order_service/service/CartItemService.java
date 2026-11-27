package com.example.order_service.service;
import com.example.order_service.entity.CartItem;
import com.example.order_service.repository.CartItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@Service
public class CartItemService {
    private final CartItemRepository repository;
    public CartItemService(CartItemRepository repository) { this.repository = repository; }
    public List<CartItem> getAll() { return repository.findAll(); }
    public CartItem getById(Long id) { return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CartItem not found")); }
    public CartItem create(CartItem data) {
        validate(data);
        data.setId(null);
        return repository.save(data);
    }
    public CartItem update(Long id, CartItem data) {
        validate(data);
        CartItem current = getById(id);
        current.setCartId(data.getCartId());
        current.setProductId(data.getProductId());
        current.setQuantity(data.getQuantity());
        return repository.save(current);
    }
    public void delete(Long id) { repository.delete(getById(id)); }
    private void validate(CartItem data) {
        if (data.getCartId() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "cartId is required");
        if (data.getProductId() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "productId is required");
        if (data.getQuantity() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "quantity is required");
    }
}
