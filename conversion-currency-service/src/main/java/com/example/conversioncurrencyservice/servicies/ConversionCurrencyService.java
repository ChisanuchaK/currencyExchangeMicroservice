package com.example.conversioncurrencyservice.servicies;

import com.example.conversioncurrencyservice.models.ConversionCurrency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@Service
public class ConversionCurrencyService {

    @Autowired
    private Environment environment;

    public ConversionCurrency calculateCurrencyConversion(String from ,  String to ,  BigDecimal quantity , BigDecimal conversionMultiple){
        ConversionCurrency conversionCurrency = ConversionCurrency.builder()
                .id(1000L)
                .from(from)
                .to(to)
                .environment(environment.getProperty("server.port") + environment.getProperty("spring.application.name"))
                .conversionMultiple(conversionMultiple)
                .quantity(quantity)
                .conversionMultiple(conversionMultiple)
                .totalCalculatedAmount(conversionMultiple.multiply(quantity))
                .build();
        return  conversionCurrency;
    }
}
