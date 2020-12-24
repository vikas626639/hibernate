package com.hibernate.test;

import com.hibernate.Util.MysqlHibernateUtil;
import com.hibernate.Util.OracleHibernateUtil;
import com.hibernate.dao.DataTransferDAO;
import com.hibernate.dao.DataTransferDAOImpl;

public class intractingWithtwoDbTest {

	public static void main(String[] args) {
		DataTransferDAO dao=null;
		dao=new DataTransferDAOImpl();
		dao.transgerRecordbyId(2);
		
		//closeSessionFactory
		OracleHibernateUtil.closeSessionFactory();
		MysqlHibernateUtil.closeSessionFactory();
	}

}
