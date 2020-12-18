package com.hibernate.test;

import org.hibernate.Session;

import com.hibernate.entity.Person_addharDetail;
import com.hibernate.util.HibernateUtil;

public class LoadData {

	public static void main(String[] args) {
		//get session
		Session ses=null;
		Person_addharDetail entity=null,entity1=null;
		try {
			//open session
			ses=HibernateUtil.getSession();
			//creating object of entity class
			entity=ses.get(Person_addharDetail.class, 1);
			if(entity!=null) {
				System.err.println(entity);
				/*
				 * System.out.println("aadhar creation time= "+entity.getAADHARCREATION_DATE());
				 * System.out.println("aadhar last modify= "+entity.getLAST_MODIFY());
				 * System.out.println("times of modification= "+entity.getTIMES_OF_MODIFY_RECORD
				 * ());
				 */
			}else {
				System.out.println("Record not found");
			}
			ses.clear();
			//clearing the cache if useing this method so query again hit the database
			
			entity1=ses.get(Person_addharDetail.class, 1);
			System.out.println("======================================");
			
			//second time fetch the record from cache and display the output and also second time no query generated
			System.err.println(entity1);
			System.out.println(entity.hashCode()+"\t"+entity1.hashCode());
			
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

//this chache is nothing but map of map becouse this cache is holding diffrent object also which is not unique
//level 1 and level 2 chache is map of map
