package com.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.StandardBasicTypes;

import com.hibernate.entity.EmployeeEntity;
import com.hibernate.utility.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	//working with scalar select quries
	@Override
	public void getEmployeeRecord() {
		//get Session
		Session ses=null;
		Transaction tx=null;
		SQLQuery query=null;
		List<Object[]>list=null;
		try {
			ses=HibernateUtil.getSession();
			//open transaction
			tx=ses.beginTransaction();
			//create native query
			query=ses.createSQLQuery("select empno,ename,deptno from emp where deptno in(:one,:two)");
			query.setParameter("one", 10);
			query.setParameter("two", 20);
			//query.addEntity(EmployeeEntity.class);//mapped with entity class
			query.addScalar("empno",StandardBasicTypes.INTEGER);
			query.addScalar("ename",StandardBasicTypes.STRING);
			query.addScalar("deptno",StandardBasicTypes.INTEGER);
			list=query.list();
			list.forEach(row->{
				for(Object obj:row) {
					System.out.print(obj+"\t");
				}
				System.out.println();
			});
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
