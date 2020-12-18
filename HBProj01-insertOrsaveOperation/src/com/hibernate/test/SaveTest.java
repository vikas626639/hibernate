package com.hibernate.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Product;

public class SaveTest {

	public static void main(String[] args) {
		boolean flag=false;
		Transaction tx=null;
		int idval=0;
		//activating hibernate
		Configuration cfg=new Configuration();
		//read and store HB cfg file, mapping file data into configuration obj
		cfg=cfg.configure("com/hibernate/cfgs/hibernate.cfg.xml");
		//create session factory object
		SessionFactory sf=cfg.buildSessionFactory();
		//get session obj
		Session ses=sf.openSession();
		//create Entity class object
		Product p=new Product();
		//p.setPid(107);
		p.setPname("prabha");
		p.setPrice(12000);
		p.setQty(5);
		
		System.out.println("record has to insert is="+p);
		
		try {
			tx=ses.beginTransaction();
			idval=(int) ses.save(p);
			System.err.println("generator hiberated id is="+idval);
			flag=true;
			System.out.println("record saved");
			
		} catch (HibernateException he) {
			he.printStackTrace();
			tx.rollback();
			flag=false;
		}
		finally {
			if(flag==true) {
				tx.commit();
			}else {
				tx.rollback();
			}
			
		}
		//close ob
	}
}
