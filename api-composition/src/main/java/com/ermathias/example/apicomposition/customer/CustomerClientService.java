package com.ermathias.example.apicomposition.customer;

import com.ermathias.example.apicomposition.WebClientConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CustomerClientService {

    private final WebClientConfiguration webClientConfiguration;

    public Mono<CustomerDTO> getCustomerById(Long customerId) {
        return webClientConfiguration.getCustomerWebClient()
                .get()
                .uri("/customers/{id}", customerId)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus.NOT_FOUND::equals, clientResponse -> Mono.empty())
                .bodyToMono(CustomerDTO.class)
                .log();
    }
}
