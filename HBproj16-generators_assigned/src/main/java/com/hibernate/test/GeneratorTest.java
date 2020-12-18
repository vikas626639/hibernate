package com.hibernate.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.project;
import com.hibernate.hibernateUtility.HibernateUtility;

public class GeneratorTest {

	public static void main(String[] args) {
		//open session
		Session ses=null;
		project entity=null;
		int idval=0;
		Transaction tx=null;
		boolean condition=false;
		try {
			ses=HibernateUtility.openingSession();
			tx=ses.beginTransaction();
			//creating entity class object
			entity=new project();
			entity.setProid(1);
			entity.setProjName("helth project");
			entity.setCompany("hcl");
			entity.setTeamSize(8);
			idval=(int) ses.save(entity);
			System.out.println("generated id value is="+idval);
			condition=true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			if(condition) {
				tx.commit();
				System.out.println("object saved");
			}else {
				tx.rollback();
				System.out.println("object not saved");
			}
			//closing the session object
			HibernateUtility.closeSession(ses);
			//closing the sessionFactory object
			HibernateUtility.closeSessionFactory();
		}
	}
}

//working with assigned generator 
//we have to set id values every time this is usefull to assign our choice bike number or mobile number 
//assigned generator work both oracle and mysql also
