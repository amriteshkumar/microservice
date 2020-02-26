package com.citi.numberservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.numberservice.NumberConfig;


@Service
public class NumberService {

	@Autowired
	private NumberConfig config;
	
	public com.citi.numberservice.domain.Number getNumber() {		
		return new com.citi.numberservice.domain.Number(config.getMin(),config.getMax());
	}

}
