package com.citi.itemorder.domain;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"itemCode", "itemName", "totalAmount","port"})
public class ItemOrder {

	private Integer itemCode;
	private String itemName;
	private Double totalAmount;
	private Integer port;
	
	public ItemOrder() {
		super();
	}
	public ItemOrder(Integer itemCode, String itemName, Double totalAmount) {
		super();
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.totalAmount = totalAmount;
	}
	public Integer getItemCode() {
		return itemCode;
	}
	public void setItemCode(Integer itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	
}
