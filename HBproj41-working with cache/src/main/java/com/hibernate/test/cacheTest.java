package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.Person_addharDetail;
import com.hibernate.util.HibernateUtil;

public class cacheTest {

	public static void main(String[] args) {
		//get session
		Session ses=null;
		Person_addharDetail entity=null,entity1=null;
		Transaction tx=null;
		var condition=false;
		try {
			//open session
			ses=HibernateUtil.getSession();
			//creating object of entity class
			entity=ses.get(Person_addharDetail.class, 1);
			if(entity!=null) {
				System.err.println(entity);
			}else {
				System.out.println("Record not found");
			}
			//update the record
			tx=ses.beginTransaction();
			entity.setPERSON_NAME("vikas");
			ses.update(entity);
			System.out.println(entity);
			System.out.println("================================");
			entity.setPERSON_NAME(" vikas yadav");
			ses.update(entity);
			System.out.println(entity);
			condition=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if(condition) {
				tx.commit();
				System.out.println("Record updated");
			}else {
				tx.rollback();
				System.out.println("Record not updated");
			}
			
			//close the session object
			HibernateUtil.closeSessio(ses);
			//close the sessionFactory object
			HibernateUtil.CloseSessionFactory();
		}
	}
}

//this chache is nothing but map of map becouse this cache is holding diffrent object also which is not unique
//level 1 and level 2 chache is map of map
