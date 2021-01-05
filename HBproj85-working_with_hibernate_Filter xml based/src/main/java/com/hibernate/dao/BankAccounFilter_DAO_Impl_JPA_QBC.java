package com.hibernate.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.entity.BANK_ACCOUNT;
import com.hibernate.util.HibernateUtil;

public class BankAccounFilter_DAO_Impl_JPA_QBC implements BankAccounFilter_DAO {

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
				CriteriaBuilder builder=ses.getCriteriaBuilder();
				//creating criteriaquery object
				CriteriaQuery<BANK_ACCOUNT> ctquery = builder.createQuery(BANK_ACCOUNT.class);
				Root<BANK_ACCOUNT> root = ctquery.from(BANK_ACCOUNT.class);
				ctquery.select(root);
				query=ses.createQuery(ctquery);
				///executing the query
				List<BANK_ACCOUNT>list=query.list();
				System.err.println("fetching record alter apply filter:-\n");
				list.forEach(System.out::println);
				//desable filter
				ses.disableFilter("FILTER_BANK_ACCOUNT_STATUS");
				System.out.println();
				CriteriaQuery<BANK_ACCOUNT> ctquery1 = builder.createQuery(BANK_ACCOUNT.class);
				Root<BANK_ACCOUNT> root1 = ctquery1.from(BANK_ACCOUNT.class);
				ctquery1.select(root1);
				query1=ses.createQuery(ctquery1);///executing the query
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

//as below jpa qbc also support filter

/*Hibernate: 
    select
        bank_accou0_.ACNO as acno1_0_,
        bank_accou0_.HOLDERNAME as holdername2_0_,
        bank_accou0_.BALANCE as balance3_0_,
        bank_accou0_.STATUS as status4_0_ 
    from
        BANK_ACCOUNT bank_accou0_ 
    where
        bank_accou0_.status not in(
            ?,?
        )
fetching record alter apply filter:-

BANK_ACCOUNT(ACNO=1001, HOLDERNAME=rajesh, BALANCE=40000.0, STATUS=active)
BANK_ACCOUNT(ACNO=3456, HOLDERNAME=naresh, BALANCE=30000.0, STATUS=active)

Hibernate: 
    select
        bank_accou0_.ACNO as acno1_0_,
        bank_accou0_.HOLDERNAME as holdername2_0_,
        bank_accou0_.BALANCE as balance3_0_,
        bank_accou0_.STATUS as status4_0_ 
    from
        BANK_ACCOUNT bank_accou0_
fetching record without apply filter:-
BANK_ACCOUNT(ACNO=1001, HOLDERNAME=rajesh, BALANCE=40000.0, STATUS=active)
BANK_ACCOUNT(ACNO=1002, HOLDERNAME=suresh, BALANCE=550000.0, STATUS=blocked)
BANK_ACCOUNT(ACNO=3456, HOLDERNAME=naresh, BALANCE=30000.0, STATUS=active)
BANK_ACCOUNT(ACNO=789, HOLDERNAME=prabha, BALANCE=40000.0, STATUS=closed)

*/