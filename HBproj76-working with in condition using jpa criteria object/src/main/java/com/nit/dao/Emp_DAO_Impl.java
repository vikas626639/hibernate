package com.nit.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.domain.emp;
import com.nit.util.HibernateUtil;

public class Emp_DAO_Impl implements Emp_DAO {

	//perform query using in clause
	@Override
	public void fetch_record_using_JPA_Criteria() {
		//get Session
		Session ses=null;
		Transaction tx=null;
		CriteriaBuilder builder=null;
		try {
			ses=HibernateUtil.getSession();
			//open transaction
				tx=ses.beginTransaction();
				//creating CriteriaBuilder Object
				builder=ses.getCriteriaBuilder(); //based on builder design pattern
				//create CriteriaQuery Object
				CriteriaQuery<emp> ctquery=builder.createQuery(emp.class);				//target the doamin class
				//create Root class object
				Root<emp> root=ctquery.from(emp.class);
				//select * from emp where deptno in(10,20);
				ctquery.select(root).where(
						root.get("JOB").in(List.of("CLERK", "MANAGER")))
						.orderBy(builder.asc(root.get("SAL")));
				//create query
				Query query=ses.createQuery(ctquery);
				List<emp>list=query.getResultList();
				list.forEach(System.out::println);
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
