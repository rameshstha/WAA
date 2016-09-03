package com.billingSystem.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.billingSystem.model.Authorities;
import com.billingSystem.model.Items;
import com.billingSystem.model.Notes;
import com.billingSystem.model.Users;
import com.billingSystem.service.AdminService;

@Controller
public class AdminController {
	
@Autowired
private AdminService adminService;

@RequestMapping(value="/admin/main",method=RequestMethod.GET)
public String adminPage(Model model){
	
	List<Integer> billDetails=adminService.getBillDetails();
	
	Iterator iterator = billDetails.iterator();
	Object[] row = (Object[])iterator.next();
	
	model.addAttribute("billno", row[0]);
	model.addAttribute("billtotal", row[1]);
	
	return "admin";
}

@RequestMapping(value = "/admin/addUser", method = RequestMethod.GET)
public String addUser() {
	return "addUser";
}

@RequestMapping(value="/admin/addUser", method=RequestMethod.POST)
public String user(String username, String password, String authority){
	Users user=new Users(username,password);
	Authorities authorities=new Authorities(username,authority);
	
	adminService.addUser(user);
	adminService.addAuthorities(authorities);
	
	return "addUser";
}

@RequestMapping(value="/admin/addItem", method=RequestMethod.GET)
public String addItem(@ModelAttribute("additems") Items items){
	return "addItems";
}

@RequestMapping(value="/admin/addItem", method=RequestMethod.POST)
public String saveItem(@ModelAttribute("additems") Items items){
	
	adminService.saveItems(items);
	return "redirect:/admin/addItem";
}

@RequestMapping(value="/admin/addNote", method=RequestMethod.GET)
public String addNote(@ModelAttribute("notes") Notes note){
	return "addNotes";
}

@RequestMapping(value="/admin/addNote", method=RequestMethod.POST)
public String saveNote(@ModelAttribute("notes") Notes note){
	
	adminService.addNote(note);
	return "addNotes";
}

}
