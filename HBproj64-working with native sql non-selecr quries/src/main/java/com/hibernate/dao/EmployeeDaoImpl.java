package com.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.hibernate.utility.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	//working with scalar aggrgate quries
	@Override
	public void getEmployeeRecord() {
		//get Session
		Session ses=null;
		Transaction tx=null;
		NativeQuery query=null;
		int count=0;
		boolean condition=false;
		try {
			ses=HibernateUtil.getSession();
			//open transaction
			tx=ses.beginTransaction();
			if(tx.isActive()) {
			//create query
			query=ses.createSQLQuery("INSERT INTO VIKAS VALUES(?,?,?)");
			//set param values
			query.setParameter(1, 10);
			query.setParameter(2, "vikas");
			query.setParameter(3, "hyd");
			count=query.executeUpdate();
			condition=true;
			}	
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(condition) {
				tx.commit();
				System.out.println("record inserted one="+count);
			}else {
				tx.rollback();
				System.out.println("Record insertion failed...");
			}
		}
	}

}
