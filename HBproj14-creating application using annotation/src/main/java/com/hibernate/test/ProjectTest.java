package com.hibernate.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.project;
import com.hibernate.hibernateUtility.HibernateUtility;

public class ProjectTest {

	public static void main(String[] args) {
		//open session
		Session ses=null;
		Transaction tx=null;
		project entity=null;
		boolean condition=false;
		try {
			ses=HibernateUtility.openingSession();
			//opening transanction
			tx=ses.beginTransaction();
			//creating entity class object
			entity=new project();
			entity.setProid(105);
			entity.setProjName("HISh");
			entity.setCompany("deloyte");
			entity.setTeamSize(4);
			ses.save(entity);
			condition=true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			if (condition) {
				tx.commit();
				System.out.println("record saved");
			}else {
				tx.rollback();
				System.out.println("record not saved");
			}
			//closing the session object
			HibernateUtility.closeSession(ses);
			//closing the sessionFactory object
			HibernateUtility.closeSessionFactory();
		}

	}

}
