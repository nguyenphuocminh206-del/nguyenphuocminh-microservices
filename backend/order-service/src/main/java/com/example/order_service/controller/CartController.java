package com.example.order_service.controller;
import com.example.order_service.entity.Cart;
import com.example.order_service.service.CartService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/carts")
public class CartController {
    private final CartService service;
    public CartController(CartService service) { this.service = service; }
    @GetMapping
    public List<Cart> getAll() { return service.getAll(); }
    @GetMapping("/{id}")
    public Cart getById(@PathVariable Long id) { return service.getById(id); }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cart create(@RequestBody Cart data) { return service.create(data); }
    @PutMapping("/{id}")
    public Cart update(@PathVariable Long id, @RequestBody Cart data) { return service.update(id, data); }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
