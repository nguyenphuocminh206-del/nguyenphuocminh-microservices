package com.example.order_service.controller;
import com.example.order_service.entity.OrderItem;
import com.example.order_service.service.OrderItemService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {
    private final OrderItemService service;
    public OrderItemController(OrderItemService service) { this.service = service; }
    @GetMapping
    public List<OrderItem> getAll() { return service.getAll(); }
    @GetMapping("/{id}")
    public OrderItem getById(@PathVariable Long id) { return service.getById(id); }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderItem create(@RequestBody OrderItem data) { return service.create(data); }
    @PutMapping("/{id}")
    public OrderItem update(@PathVariable Long id, @RequestBody OrderItem data) { return service.update(id, data); }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
