package com.example.order_service.service;
import com.example.order_service.entity.Order;
import com.example.order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@Service
public class OrderService {
    private final OrderRepository repository;
    public OrderService(OrderRepository repository) { this.repository = repository; }
    public List<Order> getAll() { return repository.findAll(); }
    public Order getById(Long id) { return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found")); }
    public Order create(Order data) {
        validate(data);
        data.setId(null);
        return repository.save(data);
    }
    public Order update(Long id, Order data) {
        validate(data);
        Order current = getById(id);
        current.setCustomerId(data.getCustomerId());
        current.setTotalAmount(data.getTotalAmount());
        current.setStatus(data.getStatus());
        return repository.save(current);
    }
    public void delete(Long id) { repository.delete(getById(id)); }
    private void validate(Order data) {
        if (data.getCustomerId() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "customerId is required");
    }
}
