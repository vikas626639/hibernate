//approach
package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.Entity.Bankaccount;
import com.hibernate.utility.HibernateUtility;

public class DeleteTest {

	public static void main(String[] args) {
		//opening session object
		Session ses=null;
		boolean flag=false;
		Transaction tx=null;
		try {
			ses=HibernateUtility.getSession();
			//creating the object of Entity class
			Bankaccount entity =new Bankaccount();
			entity.setAccountNumber(21);
			tx=ses.beginTransaction();
			ses.delete(entity);
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				tx.commit();
				System.out.println("record deleted");
			}else {
				tx.rollback();
				System.out.println("record not found for delete");
			}
			//closing the Session object
			HibernateUtility.closeSession(ses);
			//closing the SessionFactory object
			HibernateUtility.closeSessionFactory();
			System.out.println("hibernate closed.......");
		}

	}
}
//deleting record by just creating object of entity is bad approach
//we have to check wather record is availbe or not
//if record availb then it should be delete
//so we have to load object using ses.get() method it will generate select query to check the record is available or not
//if availbe then record will delete else not delete
