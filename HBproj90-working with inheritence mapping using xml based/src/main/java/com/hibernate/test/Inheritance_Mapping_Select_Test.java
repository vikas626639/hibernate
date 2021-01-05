package com.hibernate.test;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.Student;
import com.hibernate.util.HibernateUtil;

public class Inheritance_Mapping_Select_Test {
	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		boolean condition=false;
		try {
			ses=HibernateUtil.getSession();
			if(!ses.getTransaction().isActive()) {
				tx=ses.beginTransaction();
				Query query=ses.createQuery("from com.hibernate.entity.Student");
				//query.setParameter("state", "vikas");
				List<Student> list = query.getResultList();
				list.forEach(System.out::println);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
