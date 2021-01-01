package com.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.StandardBasicTypes;

import com.hibernate.entity.EmployeeEntity;
import com.hibernate.utility.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	//working with scalar aggrgate quries
	@Override
	public void getEmployeeRecord() {
		//get Session
		Session ses=null;
		Transaction tx=null;
		SQLQuery query=null;
		try {
			ses=HibernateUtil.getSession();
			//open transaction
			tx=ses.beginTransaction();
			//create native query
			query=ses.createSQLQuery("select count(*) from emp");
			Object ob=query.list().get(0);
			System.out.println(ob);
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
