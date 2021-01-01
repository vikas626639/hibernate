package com.hibernate.dao;
import java.util.List;

import org.hibernate.HibernateException;
//woring with native sql query
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.Utility.HibernateUtil;

public class HibernateDaoImpl implements HibernateDao {

	@Override
	public void getRecord() {
		//get Session 
		Session ses=null;
		Transaction tx=null;
		Query query=null;
		List<Object[]>list=null;
		//List<String>list2=null;
		try {
			ses=HibernateUtil.getSession();
			//get transaction 
			if(ses.beginTransaction().isActive()) {
				//create query
				query=ses.createSQLQuery("select empno,ename,deptno from emp");
				list=query.getResultList();
				//list.forEach(System.out::println);
				System.out.print("Executing the "); 
				Thread.sleep(5);
				System.err.print("native sql"); 
				Thread.sleep(5);
				System.out.println(" query:---------");
				System.err.println("EMPNO \t"+"ENAME\t"+"DEPTNO\t");
				list.forEach(row->{
					for(Object obj:row) {
						System.out.print(obj+"\t");
					}
					System.out.println();
				});
				
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
