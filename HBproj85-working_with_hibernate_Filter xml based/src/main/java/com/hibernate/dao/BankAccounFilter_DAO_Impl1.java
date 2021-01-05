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
	//testing filter with native sql queries
	@Override
	public void fetchRecordByFilter() {
		//get Session
		Session ses=null;
		Transaction tx=null;
		Filter filter=null;
		//Query query=null,query1=null;
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
				NativeQuery query1=ses.createSQLQuery("select * from BANK_ACCOUNT");
				query1.addEntity(BANK_ACCOUNT.class);
				///executing the query
				List<BANK_ACCOUNT>list=query1.list();
				System.err.println("fetching record alter apply filter:-\n");
				list.forEach(System.out::println);
				
				//desable filter
				ses.disableFilter("FILTER_BANK_ACCOUNT_STATUS");
				System.out.println();
				NativeQuery query2=ses.createSQLQuery("select * from BANK_ACCOUNT");
				query2.addEntity(BANK_ACCOUNT.class);
				///executing the query
				List<BANK_ACCOUNT>list1=query2.list();
				System.err.println("fetching record without apply filter:-\n");
				list1.forEach(System.out::println);
				
			}//try
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}//method
}//class

//in below output of nativesql quries 
//native sql not support the filter concept

/*Hibernate: 
    select
        * 
    from
        BANK_ACCOUNT
fetching record alter apply filter:-

BANK_ACCOUNT(ACNO=1001, HOLDERNAME=rajesh, BALANCE=40000.0, STATUS=active)
BANK_ACCOUNT(ACNO=1002, HOLDERNAME=suresh, BALANCE=550000.0, STATUS=blocked)
BANK_ACCOUNT(ACNO=3456, HOLDERNAME=naresh, BALANCE=30000.0, STATUS=active)
BANK_ACCOUNT(ACNO=789, HOLDERNAME=prabha, BALANCE=40000.0, STATUS=closed)

Hibernate: 
    select
        * 
    from
        BANK_ACCOUNT
fetching record without apply filter:-

BANK_ACCOUNT(ACNO=1001, HOLDERNAME=rajesh, BALANCE=40000.0, STATUS=active)
BANK_ACCOUNT(ACNO=1002, HOLDERNAME=suresh, BALANCE=550000.0, STATUS=blocked)
BANK_ACCOUNT(ACNO=3456, HOLDERNAME=naresh, BALANCE=30000.0, STATUS=active)
BANK_ACCOUNT(ACNO=789, HOLDERNAME=prabha, BALANCE=40000.0, STATUS=closed)
*/