package com.hibernate.test;

import com.hibernate.dao.CompositionDAO;
import com.hibernate.dao.StudentCompositonDAO;
import com.hibernate.util.HibernateUtil;

public class Client_Test {

	public static void main(String[] args) {
		CompositionDAO dao=null;
		dao=new StudentCompositonDAO();
		//dao.insertRecord();
		dao.fetchRecord();
		//close the Object of SessionFactory 
		HibernateUtil.CloseSessio();
	}

}
