package com.hibernate.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.entity.emp;
import com.hibernate.util.HibernateUtil;

public class JPA_Criteria_DAO_impl implements JPA_Cretiria_DAO {

	
	//creating jpa-cretiria query to perform select operation with condition 
	/*@Override
	public void getRecordFromDB() {
		//get Session
		Session ses=null;
		Transaction tx=null;
		CriteriaBuilder builder=null;
		CriteriaQuery<emp> ctquery=null;
		Query<emp> query=null;
		List<emp> list=null;
		try {
			ses=HibernateUtil.getSession();
			tx=ses.beginTransaction();
			//creating Criteria builder object
			builder=ses.getCriteriaBuilder();
			//create Criteria object which target to entity class
			ctquery=builder.createQuery(emp.class);
			//create root class target to entity table
			Root<emp> root=ctquery.from(emp.class);
			ctquery.select(root);
			//apply condition for this create parameter
			ParameterExpression<Integer> param1=builder.parameter(Integer.class);
			ParameterExpression<Integer> param2=builder.parameter(Integer.class);
			//create predicate object
			Predicate p=builder.ge(root.get("Empno"), param1);
			Predicate p1=builder.le(root.get("Empno"), param2);
			Predicate pfinal=builder.and(p,p1);
			//add predicate objects to criteria query object
			ctquery.where(pfinal);
			//create Order object
			Order order=builder.desc(root.get("job"));
			ctquery.orderBy(order);
			//set  query param value
			query=ses.createQuery(ctquery);
			//set query param value
			query.setParameter(param1, 7700);
			query.setParameter(param2, 8000);
			list=query.list();
			list.forEach(System.out::println);
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/

	
	//sort wave of above code or alternative code
	@Override
	public void getRecordFromDB() {
		//get Session
				Session ses=null;
				Transaction tx=null;
				CriteriaBuilder builder=null;
				CriteriaQuery<emp> ctquery=null;
				Query<emp> query=null;
				List<emp> list=null;
				try {
					ses=HibernateUtil.getSession();
					tx=ses.beginTransaction();
					//creating Criteria builder object
					builder=ses.getCriteriaBuilder();
					//create Criteria object which target to entity class
					ctquery=builder.createQuery(emp.class);
					//create root class target to entity table
					Root<emp> root=ctquery.from(emp.class);
					//select * from emp where empno>7700 and empno<8000 orderby desc sal;
					ctquery.select(root).																	//select * from emp		
										where(builder.and(													//where condition with and(,-,)
											  builder.ge(root.get("Empno"),7700),							//first condition   --first param
											  builder.le(root.get("Empno"),8000)))//where close				//second condition  --second param 
											.orderBy(builder.desc(root.get("sal")));						//order applied.
					
					query=ses.createQuery(ctquery);															//create query
					list=query.list();																		//execute query			
					list.forEach(System.out::println);														//fetch record and print
				} catch (HibernateException e) {
					e.printStackTrace();
				}catch (Exception e) {
					e.printStackTrace();
				}
	}
}

/*output
 
emp(Empno=7839, ename=KING, job=PRESIDENT, sal=5000, DEPTNO=10)
emp(Empno=7788, ename=SCOTT, job=ANALYST, sal=3000, DEPTNO=20)
emp(Empno=7902, ename=FORD, job=ANALYST, sal=3000, DEPTNO=20)
emp(Empno=7782, ename=CLARK, job=MANAGER, sal=2450, DEPTNO=10)
emp(Empno=7844, ename=TURNER, job=SALESMAN, sal=1500, DEPTNO=30)
emp(Empno=7934, ename=MILLER, job=CLERK, sal=1300, DEPTNO=10)
emp(Empno=7876, ename=ADAMS, job=CLERK, sal=1100, DEPTNO=20)
emp(Empno=7900, ename=JAMES, job=CLERK, sal=950, DEPTNO=30)
*/