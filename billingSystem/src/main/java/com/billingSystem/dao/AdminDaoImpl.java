package com.billingSystem.dao;

import com.billingSystem.dao.AdminDao;
import com.billingSystem.model.Authorities;
import com.billingSystem.model.Items;
import com.billingSystem.model.Notes;
import com.billingSystem.model.Users;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AdminDaoImpl implements AdminDao {

    @Autowired
    private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Integer> getBillDetails() {
		return sessionFactory.getCurrentSession().createQuery("select count(*) as aa, sum(b.sum_total) as bb from Bills b").list();
	}

	@Transactional
	public void saveItems(Items items) {
		sessionFactory.getCurrentSession().saveOrUpdate(items);
		
	}
	@Transactional
	public void addUser(Users user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		
	}
	@Transactional
	public void addAuthorities(Authorities authorities) {
		sessionFactory.getCurrentSession().saveOrUpdate(authorities);
		
	}
     @Transactional
	public void addNote(Notes note) {
    	 sessionFactory.getCurrentSession().saveOrUpdate(note);
		
	}

   


} // The End of Class;
