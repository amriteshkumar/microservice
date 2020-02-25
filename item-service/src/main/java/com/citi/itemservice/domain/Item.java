package com.citi.itemservice.domain;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"code","name","price"})
public class Item {

	private Integer code;
	private String name;
	private Double price;
	
	public Item() {
		super();
	}
	public Item(Integer code, String name, Double price) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
