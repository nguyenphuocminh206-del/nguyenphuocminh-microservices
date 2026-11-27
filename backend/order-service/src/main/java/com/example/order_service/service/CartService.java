package com.example.order_service.service;
import com.example.order_service.entity.Cart;
import com.example.order_service.repository.CartRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@Service
public class CartService {
    private final CartRepository repository;
    public CartService(CartRepository repository) { this.repository = repository; }
    public List<Cart> getAll() { return repository.findAll(); }
    public Cart getById(Long id) { return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart not found")); }
    public Cart create(Cart data) {
        validate(data);
        data.setId(null);
        return repository.save(data);
    }
    public Cart update(Long id, Cart data) {
        validate(data);
        Cart current = getById(id);
        current.setCustomerId(data.getCustomerId());
        return repository.save(current);
    }
    public void delete(Long id) { repository.delete(getById(id)); }
    private void validate(Cart data) {
        if (data.getCustomerId() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "customerId is required");
    }
}
