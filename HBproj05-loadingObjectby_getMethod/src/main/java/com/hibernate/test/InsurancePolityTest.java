package com.hibernate.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.hibernate.Entity.InsuranceEntity;
import com.hibernate.utility.HibernateUtility;

public class InsurancePolityTest {

	public static void main(String[] args) {
		Session ses=null;
		try {
			//getting session object
			ses=HibernateUtility.getSession();
			System.out.println("session opend...");
			//creating entity class object
			InsuranceEntity e=new InsuranceEntity();
			e=ses.get(InsuranceEntity.class, 2);
			if(e==null) {
				System.out.println("record not found");
			}else {
				System.out.println(e);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			//close the object of session object
			HibernateUtility.closeSession(ses);
			//close the object of SessionOjbectFactory
			HibernateUtility.closeSessionFactory();
		}
	}
}
