package com.hibernate.test;

import com.hibernate.dao.JPA_Cretiria_DAO;
import com.hibernate.dao.JPA_Criteria_DAO_impl;
import com.hibernate.util.HibernateUtil;

public class CriteriaApiTest {

	public static void main(String[] args) {
		JPA_Cretiria_DAO dao=null;
		dao=new JPA_Criteria_DAO_impl();
		dao.getRecordFromDB();
		//close SessionFactory object
		HibernateUtil.closeSession();
		}
}
