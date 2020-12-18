package com.hibernate.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.Proxy;

import com.hibernate.entity.project;
import com.hibernate.hibernateUtility.HibernateUtility;

public class ProjectTest {

	public static void main(String[] args) {
		//open session
		Session ses=null;
		project entity=null;
		try {
			ses=HibernateUtility.openingSession();
			//creating entity class object
			entity=ses.load(project.class, 104);
			System.out.println(entity.getClass()+"..."+entity.getClass().getSuperclass());
			System.out.println(entity);
			System.out.println("record found");
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			//closing the session object
			HibernateUtility.closeSession(ses);
			//closing the sessionFactory object
			HibernateUtility.closeSessionFactory();
		}

	}

}
