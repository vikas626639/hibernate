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
			//load entity class and perform HQL query
			//we have to create Query object
			Query query=ses.createQuery("from com.hibernate.entity.Indian_state WHERE sno=?1");
			query.setParameter(1, 2);
			
			//execute the query
			List<Indian_state> list=query.list();
			//print the result paresent in list 
			
			//using inhance for loop
			/*for(Indian_state state:list){
				System.out.println(state);
			}*/
			//printing result using lambda expression
			list.forEach(state->System.out.println(state));
			
			//printing the result using stream method foreach 
			//list.stream().forEach(System.out::println);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}
