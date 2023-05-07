package com.example.curencyexchangeservice.repository;

import com.example.curencyexchangeservice.models.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange , Long> {

    CurrencyExchange findByFromAndTo(String from , String to);
}
