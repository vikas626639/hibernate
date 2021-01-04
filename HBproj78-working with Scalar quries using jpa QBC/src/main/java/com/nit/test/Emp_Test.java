package com.nit.test;

import com.nit.dao.Emp_DAO;
import com.nit.dao.Emp_DAO_Impl;
import com.nit.util.HibernateUtil;

public class Emp_Test {
	public static void main(String[] args) {
		/*Emp_DAO dao=null;
		dao=new Emp_DAO_Impl();
		dao.fetch_record_using_JPA_Criteria();
		//close the hibernate SessionFactory object
		HibernateUtil.closeSessionFactory();*/
		int b=50;
		String bit=Integer.toBinaryString(b);
		System.out.println(bit);
	}
}
