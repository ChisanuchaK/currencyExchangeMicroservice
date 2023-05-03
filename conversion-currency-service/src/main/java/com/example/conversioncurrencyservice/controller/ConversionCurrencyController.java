package com.example.conversioncurrencyservice.controller;

import com.example.conversioncurrencyservice.models.ConversionCurrency;
import com.example.conversioncurrencyservice.servicies.ConversionCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency-conversion")
public class ConversionCurrencyController {

    @Autowired
    private ConversionCurrencyService conversionCurrencyService;

    @GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
    public ConversionCurrency calculateCurrencyConversion(@PathVariable String from , @PathVariable String to , @PathVariable BigDecimal quantity ){
        return  conversionCurrencyService.calculateCurrencyConversion(from, to, quantity);
    }

    @GetMapping("feign/from/{from}/to/{to}/quantity/{quantity}")
    public ConversionCurrency calculateCurrencyConversionFeign(@PathVariable String from , @PathVariable String to , @PathVariable BigDecimal quantity ){
        return  conversionCurrencyService.calculateCurrencyConversionFeign(from, to, quantity);
    }
}
