package com.hibernate.test;



import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.BankAccount;
import com.hibernate.util.HibernateUtil;

public class Objectupdation {

	public static void main(String[] args) {
		//get session
		Session ses=null;
		Transaction tx=null;
		BankAccount entity=null;
		Serializable id=null;
		boolean condition=false;
		try {
			ses=HibernateUtil.getSession();
			tx=ses.beginTransaction();
			//create entity object
			entity=ses.get(BankAccount.class, 2l);
			if(entity!=null) {
			entity.setBalance(entity.getBalance()+3000);
			System.out.println(entity);
			}
			condition=true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			if (condition) {
				tx.commit();
				System.out.println("object updated");
				System.err.println("record opened at->"+entity.getOpeningDate());
				System.err.println("Record last modify at->"+entity.getLastUpdate());
			}else {
				tx.rollback();
				System.out.println("Object not updated ");
			}
		}

	}

}
