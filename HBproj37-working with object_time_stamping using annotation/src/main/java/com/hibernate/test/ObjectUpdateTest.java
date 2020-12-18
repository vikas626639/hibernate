package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.Person_addharDetail;
import com.hibernate.util.HibernateUtil;

public class ObjectUpdateTest {

	public static void main(String[] args) {
		//get session
		Session ses=null;
		Transaction tx=null;
		Person_addharDetail entity=null;
		boolean condition=false;
		try {
			//open session
			ses=HibernateUtil.getSession();
			tx=ses.beginTransaction();
			//creating object of entity class
			entity=ses.get(Person_addharDetail.class, 1);
			if(entity!=null) {
				entity.setPERSON_NAME("prabha yadav");	
			}else {
				System.out.println("Record not found");
			}
				condition=true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (condition) {
				tx.commit();
				System.out.println("record update...");
				System.out.println(entity);
				System.out.println("aadhar creation time= "+entity.getAADHARCREATION_DATE());
				System.out.println("aadhar last modify= "+entity.getLAST_MODIFY());
				System.out.println("times of modification= "+entity.getTIMES_OF_MODIFY_RECORD());
			}else {
				tx.rollback();
				System.out.println("record not update...");
			}
			//close the session object
			HibernateUtil.closeSessio(ses);
			//close the sessionFactory object
			HibernateUtil.CloseSessionFactory();
		}
	}
}
