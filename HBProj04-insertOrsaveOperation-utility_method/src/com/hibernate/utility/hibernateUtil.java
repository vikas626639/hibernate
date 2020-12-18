package com.hibernate.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernateUtil {
	private static SessionFactory factory=null;

	static {
		//activate hibernate
		Configuration cfg=null;
		try {
			cfg=new Configuration();
			//setting input value of configuration file
			cfg.configure("com/hibernate/cfgs/hibernate.cfg.xml");
			System.out.println("configure xml file loaded");
			//creating SessionFactory object
			factory=cfg.buildSessionFactory();
			System.out.println("session factory object created");

		} catch (HibernateException e) {
			e.printStackTrace();
		}//catch
	}//static

	public static Session getSession() {
		Session ses=null;
		if(factory!=null)
			ses= factory.openSession();
			return ses;
	}
	
	public static void closeSession(Session ses) {
		if(ses!=null)
			ses.close();
	}
	
	
	public static void closeSessionFactory() {
		if(factory!=null)
			factory.close();
	}

}//class
