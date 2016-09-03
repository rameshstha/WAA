package com.billingSystem.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.billingSystem.model.BillItems;
import com.billingSystem.model.Bills;
import com.billingSystem.service.AdminService;
import com.billingSystem.service.BillsService;

@Controller
public class BillController {
	@Autowired
	private BillsService billsService;
	
	@Autowired
	private AdminService adminService;
	
	public static List<BillItems> billitems = new ArrayList<BillItems>();

	@RequestMapping(value = "/user/default", method = RequestMethod.GET)
	public String defaultPage(Model model) {
		List<Integer> billDetails=adminService.getBillDetails();
		
		Iterator iterator = billDetails.iterator();
		Object[] row = (Object[])iterator.next();
		
		model.addAttribute("billno", row[0]);
		model.addAttribute("billtotal", row[1]);
		
		return "default";
	}
	
	@RequestMapping(value = "/user/bill", method = RequestMethod.GET)
	public String userPage(Model model) {
		//setting billno
		int billNumber=billsService.getMaxBillno();
		model.addAttribute("billNumber",billNumber);
		
		//setting items
		List<String> items=billsService.getItems();
		model.addAttribute("items", items);
		
		//Note if any
		String note=billsService.getLatestNote();
		model.addAttribute("note", note);
		return "bill";
	}

	@RequestMapping(value = "/user/bill", method = RequestMethod.POST)
	public String save(String billno, String billDate, String sum_subtotal, String notes, String service_tax,
			String sum_discount, String sum_total, @RequestParam("item[]") String[] item,
			@RequestParam("description[]") String[] description, @RequestParam("unit_price[]") String[] unit_price,
			@RequestParam("quantity[]") String[] quantity, @RequestParam("amount[]")String[] amount) {
		int bill_no = Integer.parseInt(billno);
		// for bills table
		Double subtotal = Double.parseDouble(sum_subtotal);
		Double servicetax = Double.parseDouble(service_tax);
		Double discount = Double.parseDouble(sum_discount);
		Double total = Double.parseDouble(sum_total);
		Bills bills = new Bills(bill_no, billDate, subtotal, notes, servicetax, discount, total);
		billsService.addBills(bills);
		 
		String description_arr = null;
		// for billItem table
		  for(int i= 0;i<item.length;i++){ 
			  String item_arr = item[i]; 
			  if(description_arr==null)
				  description_arr="";
			  else description_arr = description[i]; 
			  Double unit_price_arr = Double.parseDouble(unit_price[i]);
		      Double quantity_arr = Double.parseDouble(quantity[i]); 
		      Double amount_arr = Double.parseDouble(amount[i]);
		      BillItems billItems=new BillItems(bill_no, item_arr, description_arr, unit_price_arr, quantity_arr, amount_arr);
		      billsService.addBillItems(billItems);
		  }
		 
		return "redirect:/user/bill";
	}
@RequestMapping(value="/user/getdata", method=RequestMethod.GET)
public @ResponseBody double getquantity(@RequestParam("value") String value){
	double unitPrice=billsService.getUnitPrice(value);
	return unitPrice;
}
}
