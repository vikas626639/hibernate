package com.hibernate.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory=null;

	static {
		Configuration cfg=null;
		try {
			//bootstrap the hibernate
			cfg=new Configuration();
			System.out.println("hibernate activated............");
			cfg.configure("com/hibernate/cfgs/bankaccount.cfg.xml");
			factory=cfg.buildSessionFactory();
			System.out.println("SessionFactory object created.......");
			//creating the session factory object
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	public static Session getSession() {
		Session ses = null;
		if(factory!=null) {
			ses=factory.openSession();
			System.out.println("Session object opened......");
		}
		return ses;
	}

	public static void closeSessio(Session ses) {
		if(ses!=null) {
			ses.close();
		}
	}

	public static void CloseSessionFactory() {
		if(factory!=null) {
			factory.close();
		}
	}
}
