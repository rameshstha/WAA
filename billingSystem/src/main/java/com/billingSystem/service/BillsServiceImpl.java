package com.billingSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.billingSystem.dao.BillsDao;
import com.billingSystem.model.BillItems;
import com.billingSystem.model.Bills;

@Service
@Component
public class BillsServiceImpl implements BillsService {

	@Autowired
	private BillsDao billsDao;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void addBills(Bills bill) {	
			billsDao.addBills(bill);
			
		}
	@Transactional(propagation=Propagation.REQUIRED)
	public void addBillItems(BillItems billItems) {	
			billsDao.addBillItems(billItems);
			
		}
	@Transactional(propagation=Propagation.REQUIRED)
	public int getMaxBillno() {
		return billsDao.getMaxBillno();
		
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public List<String> getItems() {
		return billsDao.getItems();
	}
	
	public double getUnitPrice(String item){
		return billsDao.getUnitPrice(item);
	}
	public String getLatestNote() {
		return billsDao.getLatestNote();
	}
}
