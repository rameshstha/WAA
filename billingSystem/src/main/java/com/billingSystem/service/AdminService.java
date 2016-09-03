
package com.billingSystem.service;

import java.util.List;

import com.billingSystem.model.Authorities;
import com.billingSystem.model.Items;
import com.billingSystem.model.Notes;
import com.billingSystem.model.Users;

public interface AdminService {
public List<Integer>getBillDetails();
public void addUser(Users user);
public void addAuthorities(Authorities authorities);
public void saveItems(Items items);
public void addNote(Notes note);
}
