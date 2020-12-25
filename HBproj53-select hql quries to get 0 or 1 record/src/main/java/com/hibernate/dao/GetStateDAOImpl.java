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

			Query query=ses.createQuery("select sno,State_name from com.hibernate.entity.Indian_state where sno=:id");
			query.setParameter("id", 25);

			//execute the query
			List<Object[]>list=query.list();
			if(!list.isEmpty())
			{
			Object obj[]=list.get(0);
			System.out.println(obj[0]+"  "+obj[1]);
			}
			else {
				System.err.println("\tRecord not found");
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}
