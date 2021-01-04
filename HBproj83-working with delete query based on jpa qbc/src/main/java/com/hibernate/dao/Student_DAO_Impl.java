package com.hibernate.dao;

import java.io.Serializable;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.Student;
import com.hibernate.util.HibernateUtil;

public class Student_DAO_Impl implements Student_DAO {

	//delete student where sno=103;
	@Override
	public void updateRecord() {
		//get Session
		Session ses=null;
		Transaction tx=null;
		CriteriaDelete<Student> ctdelete =null;
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
				ctdelete = builder.createCriteriaDelete(Student.class);				//delete 
				//create Root object
				Root<Student> root = ctdelete.from(Student.class);											//from student
				//generate criteria query
				ctdelete.where(builder.equal(root.get("SNO"), 1));
				query=ses.createQuery(ctdelete);
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
				System.out.println("number of record deleted="+id);
			}else {
				tx.rollback();
				System.out.println("Record not delete");
			}
		}
	}
}
