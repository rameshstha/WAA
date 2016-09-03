
package com.billingSystem.service;

import java.util.List;

import com.billingSystem.model.BillItems;
import com.billingSystem.model.Bills;

public interface BillsService {
public void addBills(Bills bill);
public void addBillItems(BillItems billItems);
public int getMaxBillno();
public List<String> getItems();
public double getUnitPrice(String item);
public String getLatestNote();
}
