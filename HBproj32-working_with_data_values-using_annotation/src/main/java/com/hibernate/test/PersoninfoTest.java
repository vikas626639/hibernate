package com.hibernate.test;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.PersonInfo2;
import com.hibernate.util.HibernateUtil;

public class PersoninfoTest {

	public static void main(String[] args) {
		//get session
		Session ses=null;
		Transaction tx=null;
		PersonInfo2 entity=null;
		Serializable id=0;
		boolean conditon=false;
		try {
			ses=HibernateUtil.getSession();
			//opening the transaction
			tx=ses.beginTransaction();
			//crating the object of entity class
			entity=new PersonInfo2();
			entity.setPersonid(101);
			entity.setPerson_name("vikas");
			entity.setPerson_addrs("hydrabad");
			entity.setDof(new Date(95,8,18,12,05-02));
			entity.setDom(new Date(95,8,18,12,05-02));
			entity.setDoj(new Date(95,8,18,12,05-02));
			id=ses.save(entity);
			System.out.println(entity);
			conditon=true;
			System.out.println("generated id value is="+id);	
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			if (conditon) {
				tx.commit();
				System.out.println("Record saved");
			}else {
				tx.rollback();
				System.out.println("Record not saved");
			}
		}
	}

}
