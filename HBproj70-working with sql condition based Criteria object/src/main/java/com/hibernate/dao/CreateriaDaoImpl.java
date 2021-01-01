package com.hibernate.dao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;

import com.hibernate.entity.emp;
import com.hibernate.util.HibernateUtil;
public class CreateriaDaoImpl implements CreateriaDao {

	//working with condition based sql criteria object
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
				Criterion cond1=Restrictions.sqlRestriction("rowNum>=? and rowNum<=?",
						new Object[] {1,3,},new Type[] 
								{StandardBasicTypes.INTEGER,StandardBasicTypes.INTEGER});
				c.add(cond1);
				List<emp>list=c.list();
				list.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}