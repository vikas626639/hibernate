package com.hibernate.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.entity.Phone_Number;
import com.hibernate.entity.User_info;
import com.hibernate.util.HibernateUtil;

//fetching parent to child .....but child to parent not possible
public class OneToManySelectTest {
	public static void main(String[] args) {
		//get Session 
		Session ses=null;
		Transaction tx=null;
		Phone_Number ph=null,ph1=null;
		User_info ui=null,ui1=null;
		Query query=null;
		try {
			ses=HibernateUtil.getSession();
			//checking transaction
			if(!ses.getTransaction().isActive()) {
				tx=ses.beginTransaction();
				//fetch record by generating hql query
				query=ses.createQuery("from Phone_Number");
				List<User_info> list = query.list();//will given list of user_info object
				list.forEach(System.out::println);
			}
		}catch (HibernateException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
