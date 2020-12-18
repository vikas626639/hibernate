package com.hibernate.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.hibernate.composite.Composite;
import com.hibernate.entity.Programmers_project_work;
import com.hibernate.utile.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		Session ses=null;
		Composite com=null;
		Object obj=null;
		try {
			//get Session
			ses=HibernateUtil.getSession();
			com=new Composite();
			com.setPid(105);
			com.setProjid(1001);
			obj=ses.get(Programmers_project_work.class, com);
			if(obj!=null) {
				System.out.println(obj);				
			}else {
				System.out.println("record not found");
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			//close Session
			HibernateUtil.closeSessio(ses);
			//close SessionFactory 
			HibernateUtil.CloseSessionFactory();
		}
	}
}
