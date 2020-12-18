package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.personEntity;
import com.hibernate.hibernateUtility.HibernateUtility;

public class PersonCreateTest {

	public static void main(String[] args) throws InterruptedException {
		//open session
		Session ses=null;
		Transaction tx=null;
		boolean condition=false;
		try {
			ses=HibernateUtility.openingSession();
			tx=ses.beginTransaction();
			System.out.println("Transaction opened.......");
			personEntity entity=new personEntity();
			entity.setPid(103);
			entity.setName("vikas");
			entity.setAddrs("delhi");
			entity.setMobile(8962264618l);
			entity.setAadhar(542132550679l);
			entity.setGender("M");
			System.out.println(entity);
			ses.merge(entity);
			condition=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (condition==true) {
				tx.commit();
				//Thread.sleep(40000);
				System.out.println("record saved");
			}else {
				tx.rollback();
				System.out.println("Record not saved");
			}
			//closing the session object
			HibernateUtility.closeSession(ses);
			///closing the session factory object
			HibernateUtility.closeSessionFactory();
		}
	}
}
