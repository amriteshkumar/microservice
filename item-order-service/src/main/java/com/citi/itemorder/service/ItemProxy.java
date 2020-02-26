package com.citi.itemorder.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.citi.itemorder.domain.Item;
//Use this if don't use the Zuul API Gateway @FeignClient("ItemService")

@FeignClient("zuulApiGateway")
@RibbonClient("ItemService")
public interface ItemProxy {

	@GetMapping("/ItemService/item/{code}")
	public Item getItemDetails(@PathVariable("code") int code);
}
