package com.hibernate.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.SuperMarketEntity;
import com.hibernate.hibernateUtility.HibernateUtility;

public class SuperMarketTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		SuperMarketEntity entity=null;
		boolean condition=false;
		try {
			//opening session
		ses=HibernateUtility.openingSession();
		tx=ses.beginTransaction();
		entity=new SuperMarketEntity();
		entity.setMid(105);
		entity.setAddress("delhi");
		entity.setName("praha");
		entity.setRewardpoint(18);
		//ses.saveOrUpdate(entity);
		ses.merge(entity);
		System.out.println(entity);
		condition=true;
	} catch (HibernateException e) {
			e.printStackTrace();
		}
		finally {
			if(condition) {
				tx.commit();
				System.out.println("record save/updated");
			}else {
				tx.rollback();
				System.out.println("record not saved/update");
			}
			//closeing the session
			HibernateUtility.closeSession(ses);
			//closing the SessionFactory 
			HibernateUtility.closeSessionFactory();
		}

	}

}
