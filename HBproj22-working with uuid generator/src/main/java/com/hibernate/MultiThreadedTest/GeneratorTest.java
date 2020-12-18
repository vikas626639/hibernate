package com.hibernate.MultiThreadedTest;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.project;
import com.hibernate.hibernateUtility.HibernateUtility;
import com.nit.multithreaded.MultiGenerator;

public class GeneratorTest {

	public static void main(String[] args) {
		//open session
		Session ses=null,ses1=null,ses2=null;
		project p=null,p1=null,p2=null;
		
		p=new project();
		p.setCompany("hin");
		p.setProid(101);
		p.setProjName("lic");
		p.setTeamSize(4);
		
		p1=new project();
		p1.setCompany("hic");
		p1.setProid(101);
		p1.setProjName("lic");
		p1.setTeamSize(4);
		
		p2=new project();
		p2.setCompany("hic");
		p2.setProid(101);
		p2.setProjName("lic");
		p2.setTeamSize(4);
		try {
			MultiGenerator m=new MultiGenerator(ses,p);
			MultiGenerator m1=new MultiGenerator(ses1,p1);
			MultiGenerator m2=new MultiGenerator(ses2,p2);
			Thread t1=new Thread(m);
			Thread t2=new Thread(m1);
			Thread t3=new Thread(m2);
			t1.start();
			t2.start();
			t3.start();
			Thread.sleep(50000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			//closing the session object
			HibernateUtility.closeSession(ses);
			HibernateUtility.closeSession(ses1);
			HibernateUtility.closeSession(ses2);
			//closing the sessionFactory object
			HibernateUtility.closeSessionFactory();
		
	}
}
//working with increment generator 
//this generators always hits the database to generate id val
//becouse this max value work based on the table not on the object of class or values those we provide
//inceremtns generators work on both oracle and mysql both data base
//incremtns generators suitable for multithread env but not suitable for cluster env

