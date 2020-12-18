package com.hibernate.test;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.MobileCustomer;
import com.hibernate.util.HibernateUtil;

public class VersionModifyTest {

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
			//entity=new MobileCustomer();
			entity=ses.get(MobileCustomer.class, 2);
			//setting data via setter method
			entity.setCustomer_name(" yadav");
			entity.setMobileNO(9630550195L);
			entity.setCallerTune("kon hu m");
			//id=ses.save(entity);
			condition=true;
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
