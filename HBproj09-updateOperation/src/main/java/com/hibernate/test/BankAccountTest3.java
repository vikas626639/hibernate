//approach 3
package com.hibernate.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.Entity.Bankaccount;
import com.hibernate.utility.HibernateUtility;

public class BankAccountTest3 {

	public static void main(String[] args) {
		Session ses=null;
		boolean flag=false;
		Transaction tx=null;
		try {
			//open session
			ses=HibernateUtility.getSession();
			System.out.println("Session object opend......");
			tx=ses.beginTransaction();
			//load the object
			Bankaccount entity=ses.get(Bankaccount.class, 1001);
			if(entity!=null) {
				entity.setAccountName("prabha");
				entity.setSalary(4000);
				//ses.update(entity); not requierd update method
				flag=true;
			}else
			{
				System.out.println("object/record not found");
				return;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("object updated"); 
			}else {
				tx.rollback();
				System.out.println("object not updated"); 
			}

			HibernateUtility.closeSession(ses);
			HibernateUtility.closeSessionFactory();
		}

	}
}
