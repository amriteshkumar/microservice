package com.citi.itemservice.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.citi.itemservice.domain.Item;

@Service
public class ItemService {

	private Map<Integer, Item> itemList = new HashMap<Integer,Item>();
	
	public ItemService() {
		itemList.put(1001, new Item(1001, "Apple", 120.00));
		itemList.put(1002, new Item(1002, "Orance", 150.00));
		itemList.put(1003, new Item(1003, "Pineapple", 130.00));
		itemList.put(1004, new Item(1004, "Dragun Fruit", 180.00));
	}
	
	public Item getItemDetails(Integer itemCode) {
		return itemList.get(itemCode);
	}
}
