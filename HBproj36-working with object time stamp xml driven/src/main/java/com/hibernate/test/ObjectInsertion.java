package com.hibernate.test;



import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.BankAccount;
import com.hibernate.util.HibernateUtil;

public class ObjectInsertion {

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
			entity=new BankAccount();
			entity.setAccno(565412789456L);
			entity.setBalance(8000d);
			entity.setHolderName("vikas yadav");
			entity.setOpeningDate(LocalDateTime.now());
			entity.setType("saving account");
			//entity.setLastUpdate(LocalDateTime.now());
			id=ses.save(entity);
			System.out.println(entity);
			condition=true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			if (condition) {
				tx.commit();
				System.out.println("object saved");
			}else {
				tx.rollback();
				System.out.println("Object not saved ");
			}
		}

	}

}
