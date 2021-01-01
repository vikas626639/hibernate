package com.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.hibernate.entity.emp;
import com.hibernate.util.HibernateUtil;

public class CreateriaDaoImpl implements CreateriaDao {

	@Override
	public void getRecordFromDB() {
		//get session 
		Session ses=null;
		Transaction tx=null;
		List<emp>list=null;
		Criteria c=null;
		try {
			ses=HibernateUtil.getSession();
			//open transaction
			tx=ses.beginTransaction();
			//create criterian object
			c=ses.createCriteria(emp.class);
			Criterion c1=Restrictions.ge("Empno",7000);
			Criterion c2=Restrictions.le("Empno",7666);
			//adding creterian object to Criteria object
			c.add(c1);c.add(c2);
			//getting record by order
			Order order=Order.asc("sal");
			Order order1=Order.desc("Empno");
			c.addOrder(order);
			c.addOrder(order1);
			//execute QBC logic
			list=c.list();
			list.forEach(System.out::println);	
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
