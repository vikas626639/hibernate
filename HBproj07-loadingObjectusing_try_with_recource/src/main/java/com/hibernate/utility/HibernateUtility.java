package com.hibernate.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
	private static SessionFactory factory=null;
	//
	static {
		Configuration cfg=null;
		try {
			//bootstrap the hibernate
			cfg=new Configuration();
			System.out.println("hibernate activated");
			cfg.configure("com/hibernate/cfgs/insurancePolicy.cfg.xml");
			//creating the object of sessionFactory
			factory=cfg.buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
		}//catch
	}//static
	
	
	public static Session getSession() {
		Session ses=null;
		if(factory!=null) {
			ses=factory.openSession();
		}//if
		return ses;
	}
	
	public static SessionFactory getSessionFactory() {
		if(factory!=null)
			return factory;
		else return null;
	}
	
	public static void closeSession(Session ses) {
		if(ses!=null) {
			ses.close();
		}
	}
	
	public static void closeSessionFactory() {
		if(factory!=null) {
			factory.close();
		}
	}

}
