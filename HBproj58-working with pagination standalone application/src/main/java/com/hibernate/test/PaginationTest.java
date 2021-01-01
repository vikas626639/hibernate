package com.hibernate.test;

import com.hibernate.Utility.HibernateUtil;
import com.hibernate.dao.PaginationDao;
import com.hibernate.dao.PaginationDaoImpl;

public class PaginationTest {

	public static void main(String[] args) {
		//get dao
		PaginationDao dao=null;
		dao= new PaginationDaoImpl();
		dao.displayRecordByPagination(6, 2);
		//close the Sessionfactory
		HibernateUtil.closeSessionFactory();
	}
}
