package com.hibernate.dao;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.hibernate.entity.BANK_ACCOUNT;
import com.hibernate.util.HibernateUtil;

public class BankAccounFilter_DAO_Impl1 implements BankAccounFilter_DAO {

	@Override
	public void softDeletion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SelectOperation() {
		//get Session
				Session ses=null;
				Transaction tx=null;
				try {
					ses=HibernateUtil.getSession();
					//checking active transaction
					if(!ses.getTransaction().isActive()) {
						//activate transaction
						tx=ses.beginTransaction();
						//executing the hql queries
						Query query1=ses.createQuery("from BANK_ACCOUNT");
						///executing the query
						List<BANK_ACCOUNT>list=query1.list();
						list.forEach(System.out::println);
					}//try
				} catch (HibernateException e) {
					e.printStackTrace();
				}catch (Exception e) {
					e.printStackTrace();
				}
	}
}

