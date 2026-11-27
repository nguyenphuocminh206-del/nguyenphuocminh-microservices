package com.example.order_service.service;
import com.example.order_service.entity.OrderItem;
import com.example.order_service.repository.OrderItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@Service
public class OrderItemService {
    private final OrderItemRepository repository;
    public OrderItemService(OrderItemRepository repository) { this.repository = repository; }
    public List<OrderItem> getAll() { return repository.findAll(); }
    public OrderItem getById(Long id) { return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "OrderItem not found")); }
    public OrderItem create(OrderItem data) {
        validate(data);
        data.setId(null);
        return repository.save(data);
    }
    public OrderItem update(Long id, OrderItem data) {
        validate(data);
        OrderItem current = getById(id);
        current.setOrderId(data.getOrderId());
        current.setProductId(data.getProductId());
        current.setQuantity(data.getQuantity());
        current.setUnitPrice(data.getUnitPrice());
        return repository.save(current);
    }
    public void delete(Long id) { repository.delete(getById(id)); }
    private void validate(OrderItem data) {
        if (data.getOrderId() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "orderId is required");
        if (data.getProductId() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "productId is required");
        if (data.getQuantity() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "quantity is required");
        if (data.getUnitPrice() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "unitPrice is required");
    }
}
