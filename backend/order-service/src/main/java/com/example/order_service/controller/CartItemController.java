package com.example.order_service.controller;
import com.example.order_service.entity.CartItem;
import com.example.order_service.service.CartItemService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/cart-items")
public class CartItemController {
    private final CartItemService service;
    public CartItemController(CartItemService service) { this.service = service; }
    @GetMapping
    public List<CartItem> getAll() { return service.getAll(); }
    @GetMapping("/{id}")
    public CartItem getById(@PathVariable Long id) { return service.getById(id); }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CartItem create(@RequestBody CartItem data) { return service.create(data); }
    @PutMapping("/{id}")
    public CartItem update(@PathVariable Long id, @RequestBody CartItem data) { return service.update(id, data); }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
