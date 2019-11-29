package com.ermathias.example.order;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class CustomerOrder {

    @Id
    @GeneratedValue
    private Long id;

    private Long customerId;

    private String status;

    private BigDecimal value;
}
