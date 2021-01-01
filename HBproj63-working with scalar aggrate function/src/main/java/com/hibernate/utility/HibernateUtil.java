package com.hibernate.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory=null;

	static {
		Configuration cfg=new Configuration();
		cfg.configure("com/hibernate/cfg/hibernate.cfg.xml");
		factory=cfg.buildSessionFactory();
	}

	public static Session getSession() {
		Session ses=null;
		if(ses==null) {
			ses=factory.getCurrentSession();
		}
		return ses;
	}

	public static void closeSession() {
		if(factory!=null) {
			factory.close();
		}
	}

}
