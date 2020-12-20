package com.hibernate.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * improving of util class
 * wotking with session class for one per persistance operation is bad practice
 * becouse we have to opean session for diffrent diffrent persistance operation 
 * so this will create problem in web based application so we have to go for thread local
 * intoduced in jave 4 version and also giving generic support from  java 6 version
 * wo that we can kept session as generic and threadlocal internally working with hashmap 
 */

public class HibernateUtil {
	public static ThreadLocal <Session>threadlocal=new ThreadLocal();
	private static SessionFactory factory=null;

	static {
		//bootstrap the hibernate
		Configuration cfg=new Configuration();
		try {
			//seting the configuration file
			cfg.configure("com/hibernate/cfg/hibernate.cfg.xml");
			System.out.println("hibernate activated...........");
			//creating the object of SessionFactory class
			factory=cfg.buildSessionFactory();//creating the session factory by taking the mapping and property file
			System.out.println("Session factory created.......");
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	public static Session getSession() {
		/*first time checking not there then go inside
		and take session put and second time alredy
		there so no need to open another session*/

		Session ses=null;
		ses=threadlocal.get();
		if(ses==null) {
			if(factory!=null) {
				ses=factory.openSession();
				threadlocal.set(ses);
			}
		}
		return ses;
	}

	public static void closeSession() {
		//get the session object from the thread local
		Session ses=null;
		ses=threadlocal.get();
		if(ses!=null) {
			ses.close();
			threadlocal.remove();
		}
	}

	public static void closeSessionFactory() {
		if(factory!=null) 
			factory.close();
	}
}
