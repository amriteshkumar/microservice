package com.citi.itemorder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.citi.itemorder.domain.Item;
import com.citi.itemorder.domain.ItemOrder;

@Service
public class ItemOrderService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ItemProxy itemProxy;
	
	public ItemOrder getItemOrderDetails(Integer itemCode, Integer quantity) {
		String url = "http://localhost:8080/item/"+itemCode;
		Item item = restTemplate.getForObject(url, Item.class);
		Double totalAmount = quantity * item.getPrice();
		return new ItemOrder(itemCode, item.getName(), totalAmount);
	}
	
	public ItemOrder getItemOrderDetailsViaFeignProxy(Integer itemCode, Integer quantity) {
		Item item  = itemProxy.getItemDetails(itemCode);
		Double totalAmount = quantity * item.getPrice();
		return new ItemOrder(itemCode, item.getName(), totalAmount);
	}
	
}
