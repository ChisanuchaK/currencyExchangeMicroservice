package com.example.curencyexchangeservice.controller;

import com.example.curencyexchangeservice.models.CurrencyExchange;
import com.example.curencyexchangeservice.servicies.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

   @Autowired
   private CurrencyExchangeService currencyExchangeService;

   @Autowired
   Environment environment;

    @PostMapping("/from/{from}/to/{to}")
    public CurrencyExchange SaveCurrencyExchange(@PathVariable String from , @PathVariable String to ,
                                                @Param("id") Long id , @Param("conversionMultiple") BigDecimal conversionMultiple){
        CurrencyExchange currencyExchange = CurrencyExchange.builder()
                .id(id)
                .from(from)
                .to(to)
                .conversionMultiple(conversionMultiple.setScale(conversionMultiple.scale() , RoundingMode.UNNECESSARY))
                .environment(environment.getProperty("server.port") + " " + environment.getProperty("spring.application.name"))
                .build();
        return  currencyExchangeService.saveDataCurrencyExchange(currencyExchange);
    }

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchange getCurrencyExchange(@PathVariable String from , @PathVariable String to){
        if(currencyExchangeService.listAllDataCurrencyExchange(from , to) != null){
            return currencyExchangeService.listAllDataCurrencyExchange(from , to);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND , "currencyExchange not found from " + from + "to " +to  );
        }
    }

}
