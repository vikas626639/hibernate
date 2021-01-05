package com.hibernate.dao;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.entity.BANK_ACCOUNT;
import com.hibernate.util.HibernateUtil;

public class BankAccounFilter_DAO_Impl implements BankAccounFilter_DAO {

	@Override
	public void fetchRecordByFilter() {
		//get Session
		Session ses=null;
		Transaction tx=null;
		Filter filter=null;
		Query query=null,query1=null;
		try {
			ses=HibernateUtil.getSession();
			//checking active transaction
			if(!ses.getTransaction().isActive()) {
				//activate transaction
				tx=ses.beginTransaction();
				
				//before executing the query we have to activate the filter by specifing filtername configure in entity or xml 
				filter=ses.enableFilter("FILTER_BANK_ACCOUNT_STATUS");
				filter.setParameter("accountTyp1", "blocked");
				filter.setParameter("accountTyp2", "closed");
				//executing the hql queries
				query=ses.createQuery("from com.hibernate.entity.BANK_ACCOUNT");
				///executing the query
				List<BANK_ACCOUNT>list=query.list();
				System.err.println("fetching record alter apply filter:-\n");
				list.forEach(System.out::println);
				
				//desable filter
				ses.disableFilter("FILTER_BANK_ACCOUNT_STATUS");
				System.out.println();
				query1=ses.createQuery("from com.hibernate.entity.BANK_ACCOUNT\n");
				///executing the query
				List<BANK_ACCOUNT>list1=query1.list();
				System.err.println("fetching record without apply filter:-");
				list1.forEach(System.out::println);
				
			}//try
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}//method
}//class
