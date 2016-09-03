package com.billingSystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Bills {
@Id @GeneratedValue
private int id;
@NotNull
private int billno;
@NotNull
private String billDate;
@NotNull
private double sum_subtotal;
private String notes;
private double service_tax;
private double sum_discount;
@NotNull
private double sum_total;

public Bills(){}
public Bills(int billno, String billDate, double sum_subtotal, String notes, double service_tax, double sum_discount,
		double sum_total) {
	this.billno = billno;
	this.billDate = billDate;
	this.sum_subtotal = sum_subtotal;
	this.notes = notes;
	this.service_tax = service_tax;
	this.sum_discount = sum_discount;
	this.sum_total = sum_total;
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
public String getBillDate() {
	return billDate;
}
public void setBillDate(String billDate) {
	this.billDate = billDate;
}
public double getSum_subtotal() {
	return sum_subtotal;
}
public void setSum_subtotal(double sum_subtotal) {
	this.sum_subtotal = sum_subtotal;
}
public String getNotes() {
	return notes;
}
public void setNotes(String notes) {
	this.notes = notes;
}
public double getService_tax() {
	return service_tax;
}
public void setService_tax(double service_tax) {
	this.service_tax = service_tax;
}
public double getSum_discount() {
	return sum_discount;
}
public void setSum_discount(double sum_discount) {
	this.sum_discount = sum_discount;
}
public double getSum_total() {
	return sum_total;
}
public void setSum_total(double sum_total) {
	this.sum_total = sum_total;
}
}
