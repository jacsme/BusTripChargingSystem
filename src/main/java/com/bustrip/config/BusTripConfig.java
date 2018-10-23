package com.bustrip.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bustrip.business.object.BusTripBO;
import com.bustrip.business.object.TripTransactionBO;

@Configuration
public class BusTripConfig {
	
	@Bean
	public BusTripBO busTripBO(){
		return new BusTripBO();
	}
	
	@Bean
	public TripTransactionBO tripTransactionBO(){
		return new TripTransactionBO();
	}
}
