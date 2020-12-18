package com.nit.multithreaded;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.project;
import com.hibernate.hibernateUtility.HibernateUtility;

public class MultiGenerator implements Runnable {

	private Session ses=null;
	project pro=null;
	Transaction tx=null;
	boolean condition=false;
	Integer value;
	//generating 2 param constructor
	public MultiGenerator(Session ses,project p) {
		this.ses=ses;
		this.pro=p;
	}
	@Override
	public void run() {
		System.out.println("MultiGenerator.run()");
		ses=HibernateUtility.openingSession();
		tx=ses.beginTransaction();
		try {
			//opening the connection
			value=(Integer) ses.save(pro);
			System.out.println("generated values="+value);
			System.out.println(pro);
			condition=true;
		} catch (HibernateException  e) {
			e.printStackTrace();
		}finally {
			if(condition) {
				tx.commit();
				System.out.println("object saved");
			}
			else {
				tx.rollback();
				System.out.println("record not saved");
			}
		}
	}

}
