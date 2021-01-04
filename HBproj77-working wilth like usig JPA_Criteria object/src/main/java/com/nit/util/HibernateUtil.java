package com.nit.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	//creating SessionFactory
	private static SessionFactory factory=null;
	static {
		//bootstrap the hibernate
		Configuration cfg=null;
		try {
			cfg=new Configuration();
			//configure the cfg property to create SessionFactory object
			cfg.configure("com/nit/cfg/hibernate.cfg.xml");
			//creating SessionFactory object
			factory=cfg.buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	//open session 
	public static Session getSession() {
		Session ses=null;
		if(ses==null) 
			ses=factory.getCurrentSession();
		return ses;
	}
	//close the sessionFactory 
	public static void closeSessionFactory() {
		if(factory!=null) {
			factory.close();
		}
	}
}
