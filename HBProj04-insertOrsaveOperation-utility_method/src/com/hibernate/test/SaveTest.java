package com.hibernate.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Product;
import com.hibernate.utility.hibernateUtil;

public class SaveTest {

	public static void main(String[] args) {
		boolean flag=false;
		Transaction tx=null;
		int idval=0;
		Session ses=null;
		ses=hibernateUtil.getSession();
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
		//close session
		hibernateUtil.closeSession(ses);
		//close factory
		hibernateUtil.closeSessionFactory();
	}
}
