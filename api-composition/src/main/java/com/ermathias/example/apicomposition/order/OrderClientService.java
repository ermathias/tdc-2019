package com.ermathias.example.apicomposition.order;

import com.ermathias.example.apicomposition.WebClientConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class OrderClientService {

    private final WebClientConfiguration webClientConfiguration;

    Flux<OrderDTO> getAllOrders() {
        return webClientConfiguration.getOrderWebClient()
                .get()
                .uri("/orders")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(OrderDTO.class)
                .log();
    }
}
