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

	//perform query using like 
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
				CriteriaQuery<Object[]> ctquery=builder.createQuery(Object[].class);				//target the doamin class
				//create Root class object
				Root<emp> root=ctquery.from(emp.class);
				//select empno,ename from emp where job='manager';
				ctquery.multiselect(root.get("EMPNO"),root.get("ENAME")).
									where(builder.equal(root.get("JOB"), "MANAGER"));
				Query query=ses.createQuery(ctquery);
				List<Object[]>list=query.getResultList();
				list.forEach(row->{
					for(Object obj:row) {
						System.out.print(obj+"\t");
					}
					System.out.println();
				});
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
