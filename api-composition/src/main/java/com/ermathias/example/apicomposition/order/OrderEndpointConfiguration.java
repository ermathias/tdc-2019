package com.ermathias.example.apicomposition.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class OrderEndpointConfiguration {

    @Bean
    RouterFunction<ServerResponse> routes(OrderHandler orderHandler) {
        return route(GET("/orders"), orderHandler::getAllOrders);
    }
}
