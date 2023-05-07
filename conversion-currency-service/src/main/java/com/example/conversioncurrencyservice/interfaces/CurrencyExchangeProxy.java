package com.example.conversioncurrencyservice.interfaces;

import com.example.conversioncurrencyservice.models.ConversionCurrency;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange")
//@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
     ConversionCurrency getCurrencyExchange(
            @PathVariable String from ,
            @PathVariable String to);

}
