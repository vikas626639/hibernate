package com.hibernate.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.Util.HibernateUtil;
import com.hibernate.entity.StudentRecords;

public class StudentRecordTest {

	public static void main(String[] args) {
		//get Session
		Session ses = null;
		StudentRecords entity=null;
		Transaction tx=null;
		boolean condition=false;
		int id;
		try {
			ses=HibernateUtil.getSession();
			tx=ses.beginTransaction();
			//creating entity class object
			entity=new StudentRecords();
			entity.setStudentId(101);
			entity.setStudentAddress("hydrabad");
			entity.setStudentMobileNum(9862264618L);
			entity.setStudentName("vikas");
			entity.setStudentRollNum(784896);
			//save the student record into the database
			id=(int) ses.save(entity);
			System.out.println("generated student id="+id);
			condition=true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			if(condition) {
				tx.commit();
				System.out.println("object saved");
			}else {
				System.out.println("Object not saved");
			}
			//close the session
			HibernateUtil.closeSessio(ses);
			//closeSessionFactory 
			HibernateUtil.CloseSessionFactory();
		}
	}
}
