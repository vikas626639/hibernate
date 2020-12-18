package com.hibernate.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
	private static SessionFactory factory=null;

	static {
		//bootstrap hibernate
		Configuration cfg=null;

		try {
			cfg=new Configuration();
			System.out.println("hibernate activated......");
			//creating the object of SessionFactory
			cfg.configure("com/hibernate/cfgs/bankAccount.cfg.xml");
			System.out.println("Connection stablish with database......");
			//create the object of session factory
			factory=cfg.buildSessionFactory();
			System.out.println("Session Factory object created");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}//static

	public static Session getSession() {
		Session ses=null;
		if(factory!=null) {
			ses=factory.openSession();
			System.out.println("Session object opened......");
		}
		return ses;
	}

	//closing the session object
	public static void closeSession(Session ses) {
		if(ses!=null) {
			ses.close();
		}
	}
	//closing the sessonFactory object
	public static void closeSessionFactory() {
		if(factory!=null) {
			factory.close();
		}
	}
}
