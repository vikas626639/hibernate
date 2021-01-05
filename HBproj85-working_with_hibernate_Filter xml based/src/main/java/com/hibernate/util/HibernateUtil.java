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
			//bootstraping hibernate 
			cfg=new Configuration();
			//configuration the hibernate configuration file
			cfg.configure("com/hibernate/cfgs/hibernate.cfg.xml");
			//crearing object of SessionFactory
			factory=cfg.buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}//static block

	public static Session getSession() {
		Session ses=null;
		if(ses==null) {
			ses=factory.getCurrentSession();
		}
		return ses;
	}

	public static void CloseSessio() {
		if(factory!=null) {
			factory.close();
		}
	}
}
