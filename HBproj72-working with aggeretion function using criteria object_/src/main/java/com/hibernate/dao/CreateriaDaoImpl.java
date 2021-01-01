package com.hibernate.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.hibernate.entity.emp;
import com.hibernate.util.HibernateUtil;
public class CreateriaDaoImpl implements CreateriaDao {

	//working with aggreration function
	@Override
	public void getRecordFromDB() {
		//get Session
		Session ses=null;
		Transaction tx=null;
		try {
			ses=HibernateUtil.getSession();
				tx=ses.beginTransaction();
				//creating Criteria object
				Criteria c=ses.createCriteria(emp.class); //select * from emp internally created and where condition also automatically applied
				//create Criterian object to apply condition
			Projection p=Projections.rowCount();
			c.setProjection(p);
			Object obj=c.list().get(0);
			System.err.println("TOTAL ROW OF EMP TABLE ARE ="+obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

//write Hb_QBC logic to get specific to get specific 3 col values by 2 condition in desc order
//write HB-QBC logic to get multiple aggragate result
