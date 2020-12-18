package com.hibernate.test;

import org.hibernate.Session;

import com.hibernate.entity.Person_addharDetail;
import com.hibernate.util.HibernateUtil;

public class LoadData {

	public static void main(String[] args) {
		//get session
		Session ses=null;
		Person_addharDetail entity=null;
		try {
			//open session
			ses=HibernateUtil.getSession();
			//creating object of entity class
			entity=ses.get(Person_addharDetail.class, 1);
			if(entity!=null) {
				System.out.println(entity);
				System.out.println("aadhar creation time= "+entity.getAADHARCREATION_DATE());
				System.out.println("aadhar last modify= "+entity.getLAST_MODIFY());
				System.out.println("times of modification= "+entity.getTIMES_OF_MODIFY_RECORD());
			}else {
				System.out.println("Record not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//close the session object
			HibernateUtil.closeSessio(ses);
			//close the sessionFactory object
			HibernateUtil.CloseSessionFactory();
		}
	}
}
