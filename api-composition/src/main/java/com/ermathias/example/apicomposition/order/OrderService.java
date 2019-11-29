package com.ermathias.example.apicomposition.order;

import com.ermathias.example.apicomposition.customer.CustomerClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Comparator;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderClientService orderClientService;

    private CustomerClientService customerClientService;

    Flux<OrderDTO> getAllOrders() {
        return orderClientService.getAllOrders()
                .flatMap(orderDTO -> customerClientService.getCustomerById(orderDTO.getCustomerId())
                        .flatMap(customerDTO -> {
                            orderDTO.setCustomerName(customerDTO.getName());
                            return Mono.just(orderDTO);
                        })
                        .subscribeOn(Schedulers.parallel())
                        .switchIfEmpty(Mono.just(orderDTO)))
                .sort(Comparator.comparing(OrderDTO::getId));
    }
}
