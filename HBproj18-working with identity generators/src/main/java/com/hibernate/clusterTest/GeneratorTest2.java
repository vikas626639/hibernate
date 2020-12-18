package com.hibernate.clusterTest;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.project;
import com.hibernate.hibernateUtility.HibernateUtility;

public class GeneratorTest2 {

	public static void main(String[] args) throws InterruptedException {
		//open session
		Session ses=null;
		project entity=null,entity1=null;
		int idval=0;
		int idval1=0;
		Transaction tx=null;
		boolean condition=false;
		try {
			ses=HibernateUtility.openingSession();
			tx=ses.beginTransaction();
			//creating entity class object
			entity=new project();
			//entity.setProid(3001);
			entity.setProjName("helth project");
			entity.setCompany("hcl");
			entity.setTeamSize(8);
			idval1=(int) ses.save(entity);
			System.out.println("generated id value is="+idval1);
			Thread.sleep(30000);
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

//working with increment generator 
//this generators always hits the database to generate id val
//becouse this max value work based on the table not on the object of class or values those we provide
//inceremtns generators work on both oracle and mysql both data base
//incremtns generators suitable for multithread env but not suitable for cluster env

