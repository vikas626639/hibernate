package com.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.Indian_state;
import com.hibernate.utility.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public void getEmployeeRecord() {
		//get Session
		Session ses=null;
		Transaction tx=null;
		SQLQuery query=null;
		List<Indian_state>list=null;
		try {
			ses=HibernateUtil.getSession();
			//open transaction
			tx=ses.beginTransaction();
			//create native query
			query=ses.createSQLQuery("select * from Indian_state");
			query.addEntity(Indian_state.class);//mapped with entity class
			list=query.list();
			list.forEach(System.out::println);
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
