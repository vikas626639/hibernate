package com.hibernate.test;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.SuperMarketEntity;
import com.hibernate.hibernateUtility.HibernateUtility;

public class SuperMarketTest1 {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		SuperMarketEntity entity=null,entity1=null;
		boolean condition=false;
		try {
			//opening session
			ses=HibernateUtility.openingSession();
			tx=ses.beginTransaction();
			entity=ses.get(SuperMarketEntity.class, 105);
			System.out.println(entity);
			System.out.println("------------------");
			try {
				entity=new SuperMarketEntity();
				entity.setMid(105);
				entity.setAddress("delhi");
				entity.setName("vikas");
				entity.setRewardpoint(18);
				//ses.update(entity);
				entity1=(SuperMarketEntity) ses.merge(entity);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//ses.merge(entity);
			System.out.println(entity1);
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
