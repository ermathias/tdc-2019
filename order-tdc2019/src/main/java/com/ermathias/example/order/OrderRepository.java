package com.ermathias.example.order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<CustomerOrder, Long> {

    List<CustomerOrder> findAll();

    List<CustomerOrder> findByStatus(String status);
}
