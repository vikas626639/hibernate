package com.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.Utility.HibernateUtil;
import com.hibernate.entity.Indian_state;

public class PaginationDaoImpl implements PaginationDao{

	@Override
	public void displayRecordByPagination(int min, int max) {
		//get sessions
		Session ses=null;
		Transaction tx=null;
		Query query=null;
		try {
			ses=HibernateUtil.getSession();
			tx=ses.beginTransaction();//dummy transaction
			//create query
			query=ses.createQuery("from com.hibernate.entity.Indian_state");//select query to fetch all the recards
			//setting pagination
			query.setFirstResult(min);
			query.setMaxResults(max);
			
			//diaplay the records
			List<Indian_state>list=query.list();//will return record in list
			list.forEach(row->System.out.println(row));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}
	

}
