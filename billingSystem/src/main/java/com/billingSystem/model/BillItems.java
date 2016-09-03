package com.billingSystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class BillItems {
@Id @GeneratedValue
private int id;

@NotNull
private int billno;
@NotNull
private String item;
private String description;
private Double unit_price;
@NotNull
private Double quantity;
@NotNull
private Double amount;

public BillItems(int billno, String item, String description, Double unit_price, Double quantity, Double amount) {
	this.billno = billno;
	this.item = item;
	this.description = description;
	this.unit_price = unit_price;
	this.quantity = quantity;
	this.amount = amount;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getBillno() {
	return billno;
}
public void setBillno(int billNo) {
	this.billno = billNo;
}
public String getItem() {
	return item;
}
public void setItem(String item) {
	this.item = item;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Double getUnit_price() {
	return unit_price;
}
public void setUnit_price(Double unit_price) {
	this.unit_price = unit_price;
}
public Double getQuantity() {
	return quantity;
}
public void setQuantity(Double quantity) {
	this.quantity = quantity;
}
public Double getAmount() {
	return amount;
}
public void setAmount(Double amount) {
	this.amount = amount;
}
}
