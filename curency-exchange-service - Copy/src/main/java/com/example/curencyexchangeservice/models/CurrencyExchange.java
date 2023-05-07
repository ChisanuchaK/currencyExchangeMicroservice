package com.example.curencyexchangeservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class CurrencyExchange {

    @Id
    private Long id;
    @Column(name = "currency_from" , nullable = false)
    private  String from;
    @Column(name = "currency_to" , nullable = false)
    private String to;

    @Column(name = "conversion_mutiple" , nullable = false)
    private BigDecimal  conversionMultiple;
    @Column(name = "environment" , nullable = false)
    private String environment;

}
