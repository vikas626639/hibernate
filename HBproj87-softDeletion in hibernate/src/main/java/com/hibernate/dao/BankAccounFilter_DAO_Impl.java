package com.hibernate.dao;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.entity.BANK_ACCOUNT;
import com.hibernate.util.HibernateUtil;

public class BankAccounFilter_DAO_Impl implements BankAccounFilter_DAO {

	
	@Override
	public void softDeletion() {
		//get Session
				Session ses=null;
				Transaction tx=null;
				boolean flag=false;
				
				try {
					ses=HibernateUtil.getSession();
					//checking active transaction
					if(!ses.getTransaction().isActive()) {
						//activate transaction
						tx=ses.beginTransaction();
						//creating entity class object
						BANK_ACCOUNT entity=new BANK_ACCOUNT();
						entity.setACNO(1010);
						ses.delete(entity);
						flag=true;
				}//try
				} catch (HibernateException e) {
					e.printStackTrace();
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					if (flag) {
						tx.commit();
						System.out.println("Record deleted");
					}
					else {
						tx.rollback();
						System.out.println("Record not deleted");
					}
				}

	}
}//class
