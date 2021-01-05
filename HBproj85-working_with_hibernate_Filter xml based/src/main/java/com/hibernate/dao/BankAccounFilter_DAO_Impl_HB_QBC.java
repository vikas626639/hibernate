package com.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.BANK_ACCOUNT;
import com.hibernate.util.HibernateUtil;

public class BankAccounFilter_DAO_Impl_HB_QBC implements BankAccounFilter_DAO {

	@Override
	public void fetchRecordByFilter() {
		//get Session
		Session ses=null;
		Transaction tx=null;
		Filter filter=null;
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
				Criteria query = ses.createCriteria(BANK_ACCOUNT.class);
				///executing the query
				List<BANK_ACCOUNT>list=query.list();
				System.err.println("fetching record alter apply filter:-\n");
				list.forEach(System.out::println);
				
				//desable filter
				ses.disableFilter("FILTER_BANK_ACCOUNT_STATUS");
				System.out.println();
				Criteria query1 = ses.createCriteria(BANK_ACCOUNT.class);
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


//hiberate query by Criteria support filter as below output 

/*Hibernate: 
    select
        this_.ACNO as acno1_0_0_,
        this_.HOLDERNAME as holdername2_0_0_,
        this_.BALANCE as balance3_0_0_,
        this_.STATUS as status4_0_0_ 
    from
        BANK_ACCOUNT this_ 
    where
        this_.status not in(
            ?,?
        )
fetching record alter apply filter:-

BANK_ACCOUNT(ACNO=1001, HOLDERNAME=rajesh, BALANCE=40000.0, STATUS=active)
BANK_ACCOUNT(ACNO=3456, HOLDERNAME=naresh, BALANCE=30000.0, STATUS=active)
Jan 04, 2021 7:50:34 PM org.hibernate.internal.SessionImpl createCriteria
WARN: HHH90000022: Hibernate's legacy org.hibernate.Criteria API is deprecated; use the JPA javax.persistence.criteria.CriteriaQuery instead

Hibernate: 
    select
        this_.ACNO as acno1_0_0_,
        this_.HOLDERNAME as holdername2_0_0_,
        this_.BALANCE as balance3_0_0_,
        this_.STATUS as status4_0_0_ 
    from
        BANK_ACCOUNT this_
fetching record without apply filter:-
BANK_ACCOUNT(ACNO=1001, HOLDERNAME=rajesh, BALANCE=40000.0, STATUS=active)
BANK_ACCOUNT(ACNO=1002, HOLDERNAME=suresh, BALANCE=550000.0, STATUS=blocked)
BANK_ACCOUNT(ACNO=3456, HOLDERNAME=naresh, BALANCE=30000.0, STATUS=active)
BANK_ACCOUNT(ACNO=789, HOLDERNAME=prabha, BALANCE=40000.0, STATUS=closed)

*/