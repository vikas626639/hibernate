package com.hibernate.hibernateUtility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
	private static SessionFactory factory=null;
	static {
		//bootstrap hibernate
		Configuration cfg=new Configuration();
		System.out.println("hibernate activated.......");
		cfg.configure("com/hibernate/cfgs/supermarket.cfg.xml");
		//create the object of SessionFactory class
		factory=cfg.buildSessionFactory();
		System.out.println("SessionFactory obect created........");		
	}

	public static Session openingSession() {
		Session ses=null;
		if(factory!=null) {
			ses=factory.openSession();
			System.out.println("Session opend....");
		}//if
		return ses;
	}

	public static void closeSession(Session ses) {
		if(ses!=null) {
			ses.close();
		}
	}
	
	public static void closeSessionFactory() {
		if(factory!=null)
			factory.close();
	}

}
