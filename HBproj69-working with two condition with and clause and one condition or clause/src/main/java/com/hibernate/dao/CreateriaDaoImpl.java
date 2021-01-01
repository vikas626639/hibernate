package com.hibernate.dao;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.hibernate.entity.emp;
import com.hibernate.util.HibernateUtil;

public class CreateriaDaoImpl implements CreateriaDao {

	
	//adding multiple condition with or and ..and clause to criteria object
	//select * from emp where deptno between 10 and 20 and job in 
	@Override
	public void getRecordFromDB() {
		//get session 
		Session ses=null;
		Transaction tx=null;
		Criteria c=null;
		try {
			ses=HibernateUtil.getSession();
			//open transaction
			tx=ses.beginTransaction();
			//create criterian object
			c=ses.createCriteria(emp.class);
			//prepare Criteria object
			Criterion cond1=Restrictions.between("DEPTNO", 10, 20);
			//Criterion cond2=Restrictions.in("job",List.of("CLERK","MANAGER")); 				//list.of method introduced in since java 9 version
			Criterion cond2=Restrictions.in("job","CLERK","MANAGER");
			Criterion cond3=Restrictions.ilike("ename","j%");
			Criterion finalCondition=Restrictions.or(Restrictions.and(cond1,cond2),cond3);
		//	list.forEach(System.out::println);	
			c.add(finalCondition);
			List<emp>list=c.list();
			list.forEach(System.out::println);
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}