package com.citi.itemorder.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.citi.itemorder.domain.Item;

@FeignClient("ItemService")
public interface ItemProxy {

	@GetMapping("/item/{code}")
	public Item getItemDetails(@PathVariable("code") int code);
}
