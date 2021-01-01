package com.hibernate.test;

import com.hibernate.dao.CreateriaDao;
import com.hibernate.dao.CreateriaDaoImpl;

public class CriteriaApiTest {

	public static void main(String[] args) {
		CreateriaDao dao=null;
		dao=new CreateriaDaoImpl();
		dao.getRecordFromDB();
	}
}
