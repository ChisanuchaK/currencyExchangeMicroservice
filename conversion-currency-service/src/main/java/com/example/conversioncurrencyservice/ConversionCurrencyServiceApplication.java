package com.example.conversioncurrencyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConversionCurrencyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConversionCurrencyServiceApplication.class, args);
	}

}
