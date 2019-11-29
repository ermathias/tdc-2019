package com.ermathias.example.apicomposition;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@AllArgsConstructor
public class WebClientConfiguration {

    public WebClient getOrderWebClient() {
        return WebClient
                .builder()
                .baseUrl("http://localhost:9090")
                .build();
    }

    public WebClient getCustomerWebClient() {
        return WebClient
                .builder()
                .baseUrl("http://localhost:9191")
                .build();
    }
}
