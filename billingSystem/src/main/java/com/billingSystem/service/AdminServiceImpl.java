package com.billingSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.billingSystem.dao.AdminDao;
import com.billingSystem.model.Authorities;
import com.billingSystem.model.Items;
import com.billingSystem.model.Notes;
import com.billingSystem.model.Users;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	

	@Transactional(propagation=Propagation.REQUIRED)
	public List<Integer> getBillDetails() {
		return adminDao.getBillDetails();
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveItems(Items items){
		adminDao.saveItems(items);
	}

	public void addUser(Users user) {
		adminDao.addUser(user);
		
	}

	public void addAuthorities(Authorities authorities) {
		adminDao.addAuthorities(authorities);
		
	}

	public void addNote(Notes note) {
		adminDao.addNote(note);
	}
}
