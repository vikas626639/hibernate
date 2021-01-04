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

	//scalar quries to get single record

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
				CriteriaQuery<String> ctquery=builder.createQuery(String.class);				//target the doamin class
				//create Root class object
				Root<emp> root=ctquery.from(emp.class);
				//select ename from emp where sal between (?,?) orderby sals
				ctquery.multiselect(root.get("ENAME")).
									where(builder.between(root.get("SAL"), 1000, 10000)).orderBy(builder.asc(root.get("ENAME")));
				Query query=ses.createQuery(ctquery);
				List<String>list=query.getResultList();
				list.forEach(System.out::println);
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
