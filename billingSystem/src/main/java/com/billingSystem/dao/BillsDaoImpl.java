package com.billingSystem.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.billingSystem.model.BillItems;
import com.billingSystem.model.Bills;

@Repository
public class BillsDaoImpl implements BillsDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(propagation = Propagation.SUPPORTS)
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void addBills(Bills bill) {
		sessionFactory.getCurrentSession().saveOrUpdate(bill);
	}

	@Transactional
	public void addBillItems(BillItems billItems) {
		sessionFactory.getCurrentSession().saveOrUpdate(billItems);
	}

	@Transactional
	public int getMaxBillno() {
		int count=((Long) sessionFactory.getCurrentSession().createQuery("Select count(b.billno) from Bills b")
				.uniqueResult()).intValue();
		if(count==0)
			return 1;
		else
		return ((Integer) sessionFactory.getCurrentSession().createQuery("Select max(b.billno) from Bills b")
				.uniqueResult()).intValue() + 1;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<String> getItems() {
		return sessionFactory.getCurrentSession().createQuery("Select i.itemName from Items i").list();
	}

	@Transactional
	public double getUnitPrice(String item) {
		return ((Double) sessionFactory.getCurrentSession()
				.createQuery("select i.unitPrice from Items i where i.itemName=:item").setParameter("item", item).uniqueResult()).doubleValue();
	}

	@Transactional
	public String getLatestNote() {
		int maxId= ((Integer)sessionFactory.getCurrentSession().createQuery("select max(n.id) from Notes n").uniqueResult()).intValue();
		return ((String)sessionFactory.getCurrentSession().createQuery("select n.note from Notes n where n.id=:maxId").setParameter("maxId", maxId).uniqueResult()).toString();
	}
}
