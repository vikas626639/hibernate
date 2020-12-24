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

			Query query=ses.createQuery("SELECT sno,State_name,State_language from com.hibernate.entity.Indian_state where State_language like :n");
			query.setParameter("n", "h%");

			//execute the query
			List<Object[]> list=query.list();
			//object present inside the list so first we have
			//to fetch object from the list so perform forEach
			//then print data from the object so perform 
			//inhanced for loop
			list.forEach(row->{
				for(Object obj:row)
					System.out.print(obj+"\t\t");
				System.out.println();
			});

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}
