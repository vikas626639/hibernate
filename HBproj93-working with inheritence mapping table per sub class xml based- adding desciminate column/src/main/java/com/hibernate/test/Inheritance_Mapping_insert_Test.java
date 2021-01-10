package com.hibernate.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.Employee;
import com.hibernate.entity.Person;
import com.hibernate.entity.Student;
import com.hibernate.util.HibernateUtil;

public class Inheritance_Mapping_insert_Test {
	public static void main(String[] args) {
		//get Session
		Session ses=null;
		Transaction tx=null;
		boolean condition=false;
		try {
			ses=HibernateUtil.getSession();
			//get transaction
			if(!ses.getTransaction().isActive()) {
				//activate transaction
				tx=ses.beginTransaction();
				//create entity class object
				Person person=new Person();
				Student student=new Student();
				Employee employee=new Employee();
				
				//set the record
				//person.setId(1001);
				person.setName("vikas");
				person.setAddrs("shahdol");
				
				//setting student record
				student.setAddrs("hyd");
				student.setAvg(34.44f);
				student.setBranch("math");
				student.setName("prabha");
				student.setCollege("sambhunath");
				
				//settting employee record
				employee.setAddrs("kanpur");
				employee.setDeptno(1001);
				employee.setDesg("dev");
				employee.setSalary(90000f);
				employee.setName("vikash1");
				
				ses.save(person);
				ses.save(employee);
				ses.save(student);
				condition=true;
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (condition) {
				tx.commit();
				System.out.println("Records inserted");
			}else {
				tx.commit();
				System.out.println("Record  not inserted");
			}
		}
	}
}
