//approach 1
package com.hibernate.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.Entity.Bankaccount;
import com.hibernate.utility.HibernateUtility;

public class BankAccountTest {

	public static void main(String[] args) {
		Session ses=null;
		boolean flag=false;
		Transaction tx=null;
		try {
			//open session
			ses=HibernateUtility.getSession();
			System.out.println("Session object opend......");
			//crating the object of Entity class
			Bankaccount entity=new Bankaccount();
			entity.setAccountNumber(21);
			entity.setAccountName("krishna");
			//entity.setSalary(8000000);
			tx=ses.beginTransaction();
			ses.update(entity);
			flag=true;
			//Bankaccount entity=ses.get(Bankaccount.class, 1001);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("record updated");
			}else
			{
				tx.rollback();
				System.out.println("record not found for update");
			}
			HibernateUtility.closeSession(ses);
			HibernateUtility.closeSessionFactory();
		}

	}
}

//this approach is not recomended becouse its always hits the databased and show same massage
//and also it also not check wather record is avalble or not

//so we must pass existing identity value and we must check old data peoperties which we dont want to modify
