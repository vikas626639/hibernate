package com.hibernate.test;

import com.hibernate.dao.BankAccoun_DAO;
import com.hibernate.dao.BankAccoun_DAO_Impl1;
import com.hibernate.util.HibernateUtil;

public class Client_Test {

	public static void main(String[] args) {
		//creating dao class object
		BankAccoun_DAO dao=null;
		dao=
				//new BankAccoun_DAO_Impl();
				new BankAccoun_DAO_Impl1();
		//dao.softDeletion();
		dao.SelectOperation();
		//clost the SessionFactory object
		HibernateUtil.CloseSessio();
	}
}
