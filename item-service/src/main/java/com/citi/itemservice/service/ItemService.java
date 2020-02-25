package com.citi.itemservice.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.citi.itemservice.domain.Item;

@Service
public class ItemService {

	private Map<Integer, Item> itemList = new HashMap<Integer,Item>();
	
	@Autowired
	private Environment environment;
	
	public ItemService() {
		itemList.put(1001, new Item(1001, "Apple", 120.00));
		itemList.put(1002, new Item(1002, "Orance", 150.00));
		itemList.put(1003, new Item(1003, "Pineapple", 130.00));
		itemList.put(1004, new Item(1004, "Dragun Fruit", 180.00));
	}
	
	public Item getItemDetails(Integer itemCode) {
		int port = Integer.parseInt(environment.getProperty("local.server.port"));
		Item item = itemList.get(itemCode);
		item.setPort(port);
		return item;
	}
}
