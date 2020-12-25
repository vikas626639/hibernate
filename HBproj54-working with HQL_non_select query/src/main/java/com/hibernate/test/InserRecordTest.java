package com.hibernate.test;

import com.hibernate.dao.InserRecordDAOImpl;
import com.hibernate.dao.InsertRecordDAO;

public class InserRecordTest {

	public static void main(String[] args) {
		InsertRecordDAO dao=null;
		dao=new InserRecordDAOImpl();
		dao.insertRecord();

	}

}
