package com.hibernate.test;

import com.hibernate.Utility.HibernateUtil;
import com.hibernate.dao.GetStateDAO;
import com.hibernate.dao.GetStateDAOImpl;
import com.hibernate.dao.GetStateDAOImpl1;

public class SpecificColumnTest {

	public static void main(String[] args) {
		GetStateDAO dao=null;
		dao=new GetStateDAOImpl1();
		dao.getrecordByID(); 
		//closeing the SessionFactory object
		HibernateUtil.closeSessionFactory();
	}
}
