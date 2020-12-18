package com.hibernate.test;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.hibernate.entity.BankAccount;
import com.hibernate.util.HibernateUtil;

public class GetObject {
	public static void main(String[] args) {
		//get session
		Session ses=null;
		BankAccount entity=null;
		try {
			ses=HibernateUtil.getSession();
			entity=ses.get(BankAccount.class, 2l);
			if(entity!=null) {
			System.out.println(entity);
			}else {
				System.out.println("Record not found ");
			}
			System.err.println("record opened at->"+entity.getOpeningDate());
			System.err.println("Record last modify at->"+entity.getLastUpdate());
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			//close the sesssion
			HibernateUtil.closeSessio(ses);
			//close sessionFactory object
			HibernateUtil.CloseSessionFactory();
		}

	}

}
