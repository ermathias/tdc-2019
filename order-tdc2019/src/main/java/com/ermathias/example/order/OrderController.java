package com.ermathias.example.order;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;

    @GetMapping(value = "/orders")
    public ResponseEntity<List<CustomerOrder>> listAllOrders() {
        return ResponseEntity.ok(orderRepository.findAll());
    }

    @PostMapping(value = "/orders")
    public ResponseEntity<CustomerOrder> createOrder(@RequestBody CustomerOrder customerOrder) {
        CustomerOrder created = orderRepository.save(customerOrder);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.created(uri).body(created);
    }
}
