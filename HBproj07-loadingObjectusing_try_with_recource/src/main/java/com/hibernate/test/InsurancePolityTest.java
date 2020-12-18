package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.Entity.InsuranceEntity;
import com.hibernate.utility.HibernateUtility;

public class InsurancePolityTest {

	public static void main(String[] args) {
		try(SessionFactory factory=HibernateUtility.getSessionFactory(); Session ses=factory.openSession()){
			//creating object of enitity class
			Object obj=ses.load(InsuranceEntity.class, 5);
			System.out.println(obj);
		}
	}
}
