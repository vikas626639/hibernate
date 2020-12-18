package com.hibernate.test;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.PersonInfo3;
import com.hibernate.util.HibernateUtil;

public class PersoninfoTest {

	public static void main(String[] args) {
		//get session
		Session ses=null;
		Transaction tx=null;
		PersonInfo3 entity=null;
		Serializable id=0;
		boolean conditon=false;
		try {
			ses=HibernateUtil.getSession();
			//opening the transaction
			tx=ses.beginTransaction();
			//crating the object of entity class
			entity=new PersonInfo3();
			entity.setPersonid(101);
			entity.setPerson_name("vikas");
			entity.setPerson_addrs("hydrabad");
			entity.setDob(LocalDateTime.of(1995, 8, 18,12, 02, 00));
			entity.setDoj(LocalDateTime.of(2018, 01, 18,03,45,45));
			entity.setDom(LocalDate.now());
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
