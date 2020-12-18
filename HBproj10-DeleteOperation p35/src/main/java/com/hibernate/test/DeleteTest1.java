//approach 2
package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.Entity.Bankaccount;
import com.hibernate.utility.HibernateUtility;

public class DeleteTest1 {

	public static void main(String[] args) {
		//opening session object
		Session ses=null;
		boolean flag=false;
		Transaction tx=null;
		Bankaccount entity=null;
		try {
			ses=HibernateUtility.getSession();
			tx=ses.beginTransaction();
			//load the entity object
			//entity=new Bankaccount();
			entity=ses.get(Bankaccount.class, 1002);
			if(entity!=null) {
				ses.save(entity);
				//ses.delete(entity);
				flag=true;
			}else {
				System.out.println("record not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				tx.commit();
				System.out.println("object deleted");
			}else {
				tx.rollback();
				System.out.println("object not delete");
			}
			//closing the Session object
			HibernateUtility.closeSession(ses);
			//closing the SessionFactory object
			HibernateUtility.closeSessionFactory();
			System.out.println("hibernate closed.......");
		}
	}
}
