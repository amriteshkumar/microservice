package com.citi.itemorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citi.itemorder.domain.ItemOrder;
import com.citi.itemorder.service.ItemOrderService;

@RestController
@RequestMapping("/itemorder")
public class ItemOrderController {
	
	@Autowired
	private ItemOrderService service;

	@GetMapping(value="/{code}/qty/{quantity}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemOrder> getItemOrder(@PathVariable("code")int code,@PathVariable("quantity")int quantity)
	{
		ItemOrder order=service.getItemOrderDetails(code, quantity);
		return new ResponseEntity<>(order,HttpStatus.OK);
	}
	

	@GetMapping(value="/feign/{code}/qty/{quantity}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemOrder> getItemOrderViaFeign(@PathVariable("code")int code,@PathVariable("quantity")int quantity)
	{
		ItemOrder order=service.getItemOrderDetailsViaFeignProxy(code, quantity);
		return new ResponseEntity<>(order,HttpStatus.OK);
	}
}
