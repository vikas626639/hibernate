package com.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
			//create creteria object
			c=ses.createCriteria(emp.class);
			list=c.list();
			//list.forEach(System.out::println);	
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
