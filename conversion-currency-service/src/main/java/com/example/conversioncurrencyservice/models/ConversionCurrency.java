package com.example.conversioncurrencyservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConversionCurrency {
    private  Long id;
    private  String from;
    private  String to;
    private BigDecimal conversionMultiple;
    private BigDecimal totalCalculatedAmount;

    private  BigDecimal quantity;
    private String environment;
}
