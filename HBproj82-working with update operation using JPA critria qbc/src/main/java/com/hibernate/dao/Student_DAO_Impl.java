package com.hibernate.dao;

import java.io.Serializable;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.Student;
import com.hibernate.util.HibernateUtil;

public class Student_DAO_Impl implements Student_DAO {

	//update student set sadd='shahdol' where sno=103;
	@Override
	public void updateRecord() {
		//get Session
		Session ses=null;
		Transaction tx=null;
		CriteriaUpdate<Student> ctquery=null;
		Serializable id=0;
		boolean condition=false;
		Query query=null;
		try {
			ses=HibernateUtil.getSession();
			if(!ses.getTransaction().isActive()) {
				tx=ses.beginTransaction();
				//creating CriteriaBuilder object
				CriteriaBuilder builder=ses.getCriteriaBuilder();
				//Creating CriteriaQuery
				ctquery = builder.createCriteriaUpdate(Student.class);		//target entity class--> update student
				//Creating Root object
				Root<Student> root = ctquery.from(Student.class);			//from
				ctquery.set(root.get("SADD"), "shahdol").					//sadd='shahdol'
				where(builder.equal(root.get("SNO"), 103));					//where sno=103;
				//create query
				query=ses.createQuery(ctquery);
				id =query.executeUpdate();
				condition=true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (condition) {
				tx.commit();
				System.out.println("number of record effected="+id);
			}else {
				tx.rollback();
				System.out.println("Record not updated");
			}
		}
	}
}
