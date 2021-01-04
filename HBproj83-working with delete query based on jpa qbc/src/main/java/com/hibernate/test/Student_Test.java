package com.hibernate.test;

import com.hibernate.dao.Student_DAO;
import com.hibernate.dao.Student_DAO_Impl;
import com.hibernate.util.HibernateUtil;

public class Student_Test {

	public static void main(String[] args) {
		Student_DAO dao=null;
		dao=new Student_DAO_Impl();
		dao.updateRecord();
		//close SessionFatory
		HibernateUtil.CloseSessio();
	}

}
