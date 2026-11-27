package com.example.order_service.controller;
import com.example.order_service.entity.Order;
import com.example.order_service.service.OrderService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService service;
    public OrderController(OrderService service) { this.service = service; }
    @GetMapping
    public List<Order> getAll() { return service.getAll(); }
    @GetMapping("/{id}")
    public Order getById(@PathVariable Long id) { return service.getById(id); }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody Order data) { return service.create(data); }
    @PutMapping("/{id}")
    public Order update(@PathVariable Long id, @RequestBody Order data) { return service.update(id, data); }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
