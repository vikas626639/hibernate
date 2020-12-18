//sync between application to db table row show we should use refresh method to show sync
package com.hibernate.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.hibernate.Entity.Bankaccount;
import com.hibernate.utility.HibernateUtility;

public class refreshingObject {

	public static void main(String[] args) {
		Session ses=null;
		boolean flag=false;
		try {
			//open session
			ses=HibernateUtility.getSession();
			System.out.println("Session object opend......");
			//load the object
			Bankaccount entity=ses.get(Bankaccount.class, 21);
			if(entity!=null) {
				System.out.println(entity);
				try {
					Thread.sleep(40000);//modify db table record usng sql prompt or developr
				} catch (Exception e) {
					e.printStackTrace();
				}
				ses.refresh(entity);
				System.out.println(entity);
			}else {
				System.out.println("record not found ");
			}
			//ses.update(entity); not requierd update method
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtility.closeSession(ses);
			HibernateUtility.closeSessionFactory();
		}
	}
}
