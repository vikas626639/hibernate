package com.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.Utility.HibernateUtil;
import com.hibernate.entity.Indian_state;

public class GetStateDAOImpl implements GetStateDAO {

	@Override
	public void getrecordByID() {
		//get Session
		Session ses=null;
		Transaction tx=null;
		Indian_state entity=null;
		try {
			ses=HibernateUtil.getSession();
			//open transaction
			tx=ses.beginTransaction();//its a dummy transaction for getCurrentSession 

			Query query=ses.createQuery("SELECT sno from com.hibernate.entity.Indian_state where sno>=?1");
			query.setParameter(1, 25);

			//execute the query
			List <Integer>list=query.list();
			/*list.forEach(obj->System.out.println(obj));*/
			list.forEach(System.out::println);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}
