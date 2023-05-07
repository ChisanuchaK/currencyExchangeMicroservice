package com.example.curencyexchangeservice.servicies;

import com.example.curencyexchangeservice.models.CurrencyExchange;
import com.example.curencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CurrencyExchangeService {
    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    public CurrencyExchange saveDataCurrencyExchange(CurrencyExchange ce){
        CurrencyExchange currencyExchange = CurrencyExchange.builder()
                .id(ce.getId())
                .from(ce.getFrom())
                .to(ce.getTo())
                .conversionMultiple(ce.getConversionMultiple())
                .environment(ce.getEnvironment())
                .build();
        return  currencyExchangeRepository.save(currencyExchange);
    }

    public CurrencyExchange listAllDataCurrencyExchange(String from , String to){
        return currencyExchangeRepository.findByFromAndTo(from , to);
    }

}
