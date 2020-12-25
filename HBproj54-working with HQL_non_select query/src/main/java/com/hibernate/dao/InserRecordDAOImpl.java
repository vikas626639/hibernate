package com.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.Utility.HibernateUtil;
import com.hibernate.entity.Indian_state;
import com.hibernate.entity.Indian_state1;

public class InserRecordDAOImpl implements InsertRecordDAO {

	@Override
	public void insertRecord() {
		//get session
		Session ses=null;
		Transaction tx=null;
		Query query=null;
		Object obj=null;
		boolean condition =false;
		try {
			ses=HibernateUtil.getSession();
			//begin transaction
			tx=ses.beginTransaction();
			//create query
			query=ses.createQuery("from com.hibernate.entity.Indian_state");
			List<Indian_state> list=query.list();
			//list.forEach(System.out::println);
			//creating object of indian_state1 class
			list.forEach(row->{
				Session ses1=HibernateUtil.getSession();
				Indian_state1 entity=null;
				entity=new Indian_state1();
				entity.setSno(row.getSno());
				entity.setState_language(row.getState_language());
				entity.setState_name(row.getState_name());
				ses1.save(entity);
			});
			condition=true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			if(condition) 
			{
				tx.commit();
				System.out.println("Record copied");
			}else {
				tx.rollback();
				System.out.println("Record  not copied");
			}
		}
	}
}
