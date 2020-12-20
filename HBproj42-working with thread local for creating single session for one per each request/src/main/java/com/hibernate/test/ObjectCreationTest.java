package com.hibernate.test;

import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.Person_addharDetail;
import com.hibernate.util.HibernateUtil;

public class ObjectCreationTest {

	public static void main(String[] args) {
		//get session
		Session ses=null;
		Transaction tx=null;
		Person_addharDetail entity=null;
		boolean condition=false;
		try {
			//open session
			ses=HibernateUtil.getSession();
			//creating object of entity class
			entity=new Person_addharDetail();
			entity.setPERSON_NAME("prabha yadav");
			entity.setPERSON_DOB(LocalDate.of(1995, 8, 18));
			entity.setAADHAR_NUMBER(542132550679l);
			try {
				//begin transaction
				tx=ses.beginTransaction();
				ses.save(entity);
				condition=true;
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (condition) {
				tx.commit();
				System.out.println("record saved...");
				System.out.println(entity);
				System.out.println("aadhar creation time= "+entity.getAADHARCREATION_DATE());
				System.out.println("aadhar last modify= "+entity.getLAST_MODIFY());
				System.out.println("times of modification= "+entity.getTIMES_OF_MODIFY_RECORD());
			}else {
				tx.rollback();
				System.out.println("record not save...");
			}
			//close the session object
			HibernateUtil.closeSession();
			//close the sessionFactory object
			HibernateUtil.closeSessionFactory();
		}
	}
}
