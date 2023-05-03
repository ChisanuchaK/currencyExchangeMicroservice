package com.example.conversioncurrencyservice.servicies;

import com.example.conversioncurrencyservice.interfaces.CurrencyExchangeProxy;
import com.example.conversioncurrencyservice.models.ConversionCurrency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@Service
public class ConversionCurrencyService {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeProxy proxy;

    public ConversionCurrency calculateCurrencyConversion(String from ,  String to , BigDecimal quantity){
        HashMap<String , String > uriVariables = new HashMap<>();
            uriVariables.put("from" , from);
            uriVariables.put("to" , to);
        ResponseEntity<ConversionCurrency> responseEntity =  new RestTemplate().getForEntity("http://localhost:8000//currency-exchange/from/{from}/to/{to}" , ConversionCurrency.class , uriVariables);
            ConversionCurrency conversionCurrency = responseEntity.getBody();
        return  ConversionCurrency
                .builder()
                .id(conversionCurrency.getId())
                .from(from)
                .to(to)
                .quantity(quantity)
                .conversionMultiple(conversionCurrency.getConversionMultiple())
                .totalCalculatedAmount(quantity.multiply(conversionCurrency.getConversionMultiple()))
                .environment(conversionCurrency.getEnvironment())
                .build();
    }

    public ConversionCurrency calculateCurrencyConversionFeign(String from ,  String to , BigDecimal quantity){
        ConversionCurrency currency = proxy.getCurrencyExchange(from , to);
        return  ConversionCurrency
                .builder()
                .id(currency.getId())
                .from(from)
                .to(to)
                .quantity(quantity)
                .conversionMultiple(currency.getConversionMultiple())
                .totalCalculatedAmount(quantity.multiply(currency.getConversionMultiple()))
                .environment(currency.getEnvironment())
                .build();
    }

}
