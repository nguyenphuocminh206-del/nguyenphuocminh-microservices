package com.example.order_service.service;
import com.example.order_service.entity.OrderItem;
import com.example.order_service.repository.OrderItemRepository;
import com.example.order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@Service
public class OrderItemService {
    private final OrderItemRepository repository;
    private final OrderRepository orderRepository;
    public OrderItemService(OrderItemRepository repository, OrderRepository orderRepository) {
        this.repository = repository;
        this.orderRepository = orderRepository;
    }
    public List<OrderItem> getAll() { return repository.findAll(); }
    public OrderItem getById(Long id) { return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "OrderItem not found")); }
    public OrderItem create(OrderItem data) {
        validate(data);
        data.setId(null);
        resolveOrder(data);
        return repository.save(data);
    }
    public OrderItem update(Long id, OrderItem data) {
        validate(data);
        OrderItem current = getById(id);
        resolveOrder(data);
        current.setOrder(data.getOrder());
        current.setProductId(data.getProductId());
        current.setQuantity(data.getQuantity());
        current.setUnitPrice(data.getUnitPrice());
        return repository.save(current);
    }
    public void delete(Long id) { repository.delete(getById(id)); }
    private void validate(OrderItem data) {
        if (data.getOrder() == null || data.getOrder().getId() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "order.id is required");
        if (data.getProductId() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "productId is required");
        if (data.getQuantity() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "quantity is required");
        if (data.getUnitPrice() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "unitPrice is required");
    }
    private void resolveOrder(OrderItem data) {
        data.setOrder(orderRepository.findById(data.getOrder().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order not found")));
    }
}
