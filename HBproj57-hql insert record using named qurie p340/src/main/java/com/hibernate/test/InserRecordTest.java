package com.hibernate.test;

import com.hibernate.Utility.HibernateUtil;
import com.hibernate.dao.InsertRecordDAO;
import com.hibernate.dao.InsertRecordDaoImpl;

public class InserRecordTest {

	public static void main(String[] args) {
		InsertRecordDAO dao=null;
		dao=new InsertRecordDaoImpl();
		dao.insertRecord(10);
		//close the SessionFactory
		HibernateUtil.closeSessionFactory();
	}
}
