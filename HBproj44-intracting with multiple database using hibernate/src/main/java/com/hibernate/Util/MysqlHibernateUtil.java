package com.hibernate.Util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MysqlHibernateUtil {
	private static SessionFactory factory=null;

	static {
		//bootstrap the hibernate
		Configuration cfg=new Configuration();
		try {
			//seting the configuration file
			cfg.configure("com/hibernate/cfgs/MysqlHibernate.cfg.xml");
			System.out.println("hibernate activated...........");
			//creating the object of SessionFactory class
			factory=cfg.buildSessionFactory();//creating the session factory by taking the mapping and property file
			System.out.println("Session factory created.......");
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	public static Session getSession() {
		Session ses=null;
		if(ses==null) {
			if(factory!=null) {
				ses=factory.getCurrentSession();
			}
		}
		return ses;
	}

	public static void closeSessionFactory() {
		if(factory!=null) 
			factory.close();
	}
}
