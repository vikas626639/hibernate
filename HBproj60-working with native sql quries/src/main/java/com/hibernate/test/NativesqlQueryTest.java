package com.hibernate.test;

import com.hibernate.Utility.HibernateUtil;
import com.hibernate.dao.HibernateDao;
import com.hibernate.dao.HibernateDaoImpl;

public class NativesqlQueryTest {

	public static void main(String[] args) {
		HibernateDao dao=null;
		dao=new HibernateDaoImpl();
		dao.getRecord();
		
		//close SessionFactory
		HibernateUtil.closeSessionFactory();
	}
}
