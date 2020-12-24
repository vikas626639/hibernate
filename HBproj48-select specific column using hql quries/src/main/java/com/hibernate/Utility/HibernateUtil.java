package com.hibernate.Utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory factory=null;

	static {
		try {
			//bootstraping of hibernate
			Configuration cfg=new Configuration();
			//locate the cfg file of xml
			cfg.configure("com/hibernate/cfg/hibernate.cfg.xml");//adding the hibernate.cfg.xml file
			//creating Session factory object
			factory=cfg.buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
		}//catch
	}//static

	//creating session object
	public static Session getSession() {
		Session ses=null;
		if(ses==null) {
			ses=factory.getCurrentSession();
			System.out.println("Session object opened........");
		}
		return ses;
	}//session

	public static void closeSessionFactory() {
		if(factory!=null) {
			factory.close();
		}
	}
}//class
