package com.hibernate.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.entity.emp;
import com.hibernate.util.HibernateUtil;

public class JPA_Criteria_DAO_impl implements JPA_Cretiria_DAO {
	
	//creating jpa-cretiria query to perform select operation 
	//this JPA_Criteria_Query can perform select  and non-select both operation 
	@Override
	public void getRecordFromDB() {
		//get Session
		Session ses=null;
		Transaction tx=null;
		CriteriaBuilder builder=null;
		CriteriaQuery<emp> ctquery=null;
		Query<emp> query=null;
		List<emp> list=null;
		try {
			ses=HibernateUtil.getSession();
			tx=ses.beginTransaction();
			//creating JPA-Criteria builder 								//its is responsible to create criteria object
			builder=ses.getCriteriaBuilder();								//builder object created
			//create criteriaquery object
			ctquery=builder.createQuery(emp.class);    						//target entity class
			//create root object for specity table of entity class
			Root<emp> root=ctquery.from(emp.class);							//target emp table 
			//add root object to cretiria query object
			ctquery.select(root);											//perform select operation on this emp table (root) by perform query
			//prepare query object having query object
			query=ses.createQuery(ctquery);
			//execute jpa query
			list=query.list();
			//fetch list record and print the record
			list.forEach(System.out::println);
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
