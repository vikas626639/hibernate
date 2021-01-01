package com.hibernate.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.hibernate.entity.emp;
import com.hibernate.util.HibernateUtil;
public class CreateriaDaoImpl implements CreateriaDao {

	//working aggregate function
	@Override
	public void getRecordFromDB() {
		//get Session
		Session ses=null;
		Transaction tx=null;
		try {
			ses=HibernateUtil.getSession();
				tx=ses.beginTransaction();
				//creating Criteria object
				Criteria c=ses.createCriteria(emp.class); 
				//for working with specific multiple column or one column use projection 
				Projection p=Projections.property("job");
				Projection p1=Projections.property("sal");
				//for adding multiple project we have to user projection list
				ProjectionList plist=Projections.projectionList();
				plist.add(p).add(p1);
				c.setProjection(p);
				Criterion cond1=Restrictions.in("job", "MANAGER");
				//gpt
				c.add(cond1);
				c.setProjection(plist);
				List<Object[]>list=c.list();
				list.forEach(row->{
					System.out.println(row[0]+"...."+row[1]);
				});
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}