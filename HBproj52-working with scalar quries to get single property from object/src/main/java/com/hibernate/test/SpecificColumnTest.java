package com.hibernate.test;

import com.hibernate.Utility.HibernateUtil;
import com.hibernate.dao.GetStateDAO;
import com.hibernate.dao.GetStateDAOImpl;

public class SpecificColumnTest {

	public static void main(String[] args) {
		GetStateDAO dao=null;
		dao=new GetStateDAOImpl();
		dao.getrecordByID(); 
		//closeing the SessionFactory object
		HibernateUtil.closeSessionFactory();
	}
}
