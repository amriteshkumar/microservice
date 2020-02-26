package com.citi.numberservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NumberController {
	@Autowired
	private com.citi.numberservice.service.NumberService service;
	
	@GetMapping(path="/number",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Number> getData()
	{
		return new ResponseEntity(service.getNumber(),HttpStatus.OK);
	}
	
	

}