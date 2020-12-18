package com.hibernate.test;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.MobileCustomer;
import com.hibernate.util.HibernateUtil;

public class VersionInsertionTest {

	public static void main(String[] args) {
		//get Session
		Session ses=null;
		Transaction tx=null;
		MobileCustomer entity=null;
		Serializable id=0;
		boolean condition=false;

		try {
			ses=HibernateUtil.getSession();
			//begin transanction
			tx=ses.beginTransaction();
			//creating the entity class object
			entity=new MobileCustomer();
			//setting data via setter method
			entity.setCustomer_id(101);
			entity.setCustomer_name("vikas");
			entity.setMobileNO(8962264618L);
			entity.setCallerTune(" kyunki tum hi ho");
			id=ses.save(entity);
			condition=true;
			System.out.println("generated value="+id);
			System.out.println("record modified:-"+entity.getModify());
			System.out.println(entity);
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			if (condition) {
				tx.commit();
				System.out.println("Object saved");
			}else {
				tx.rollback();
				System.out.println("Object not saved");
			}
			//close the session
			HibernateUtil.closeSessio(ses);
			//close the SessionFactory 
			HibernateUtil.CloseSessionFactory();
		}
	}
}
