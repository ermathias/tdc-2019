package com.ermathias.example.customer;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> listAllCustomers() {
        return ResponseEntity.ok(customerRepository.findAll());
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(customerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @PostMapping(value = "/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {

        Customer created = customerRepository.save(customer);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.created(uri).body(created);
    }
}
