package com.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.Utility.HibernateUtil;
import com.hibernate.entity.Indian_state;

public class GetStateDAOImpl1 implements GetStateDAO {

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
			
			//aggreagate query
			Query query=ses.createQuery("select count(*) from com.hibernate.entity.Indian_state");
			//query.setParameter("id", 25);

			//execute the query
			List<?>list=query.getResultList();
			if(!list.isEmpty())
			{
			Object obj=(Object) list.get(0);
			System.out.println(obj);
			}
			else {
				System.err.println("\tRecord not found");
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}
