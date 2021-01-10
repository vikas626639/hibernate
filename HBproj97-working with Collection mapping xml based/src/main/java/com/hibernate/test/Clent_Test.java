package com.hibernate.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.Employee;
import com.hibernate.util.HibernateUtil;

public class Clent_Test {

	public static void main(String[] args) {
		Session ses=null;
		boolean condition=false;
		Transaction tx=null;
		try {
			ses=HibernateUtil.getSession();
			tx = ses.beginTransaction();
			//create entity class object
			Employee emp=new Employee();
			emp.setEmp_name("vikas");
			//emp.setEmp_Id(40);
			emp.setJOb("nothing");
			emp.setMobile_number(Set.of(77777777L,8888888L));
			emp.setEmp_Frends(List.of("prabha", "preeti"));
			emp.setBank_Account(Map.of("union","7894561","sbi","78945612"));
			ses.save(emp);
			condition=true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
	}finally {
		if (condition) {
			tx.commit();
			System.out.println("Record is saved");
		}else {
			tx.rollback();
			System.out.println("Record is not saved");
		}
		HibernateUtil.CloseSessio();
	}
}
}
