package com.example.curencyexchangeservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class CircuitBreakerController {

    @GetMapping("/sample-api")
//    @Retry(name = "sample-api" , fallbackMethod = "fallbank")
//    @CircuitBreaker(name = "default" , fallbackMethod = "fallbank")
    @RateLimiter(name  = "default")
    @Bulkhead(name = "default")
    public String sampleApi(){
        log.info("Sample api call received");
        ResponseEntity<String>  responseEntity = new RestTemplate().getForEntity("http://localhost:8000//currency-exchange/from/THB/to/USA" , String.class);
        return responseEntity.getBody();
    }

    public String fallbank(Exception ex){
        log.info("Sample api not call received");
        return "Error Sample API !!";
    }
}
