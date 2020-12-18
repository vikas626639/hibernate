package com.hibernate.test;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.PersonInfo;
import com.hibernate.util.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		//get session
		Session ses=null;
		PersonInfo entity=null;
		Serializable id=0;
		try {
			ses=HibernateUtil.getSession();
			//opening the transaction
			id=ses.get(PersonInfo.class, 1);
			if(id!=null) {
				System.out.println(id);
			}else {
				System.out.println("record not found");
			}
			} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			//close hibernate session
			HibernateUtil.closeSessio(ses);
			//close hibernate SessionFactory
			HibernateUtil.CloseSessionFactory();
			
		}
	}
}
