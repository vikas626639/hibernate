package com.hibernate.test;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.composite.Composite;
import com.hibernate.entity.Programmers_project_work;
import com.hibernate.utile.HibernateUtil;

public class ProgrammerProWorkTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		Composite com=null;
		Programmers_project_work entity=null;
		boolean condition=false;
		Serializable id=0;
		try {
			//get Session
			ses=HibernateUtil.getSession();
			tx=ses.beginTransaction();
			//creating composite class object
			com=new Composite();
			com.setPid(102);
			com.setProjid(54321);
			//create entity class object
			entity=new Programmers_project_work();
			entity.setCid(com);
			entity.setPname("vikas");
			entity.setProjName("helth Insorance project");
			entity.setSalary(450000d);
			id=ses.save(entity);
			System.out.println("Generated id value="+id);
			condition=true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			if (condition) {
				tx.commit();
				System.out.println("Object saved");
			}else
			{
				tx.rollback();
				System.out.println("object not saved");
			}
			//close Session
			HibernateUtil.closeSessio(ses);
			//close SessionFactory 
			HibernateUtil.CloseSessionFactory();
		}
	}
}
