package com.hibernate.test;

import com.hibernate.dao.BankAccounFilter_DAO;
import com.hibernate.dao.BankAccounFilter_DAO_Impl1;
import com.hibernate.util.HibernateUtil;

public class Client_Test {

	public static void main(String[] args) {
		//creating dao class object
		BankAccounFilter_DAO dao=null;
		dao=
				//new BankAccounFilter_DAO_Impl();
				new BankAccounFilter_DAO_Impl1();
				//new BankAccounFilter_DAO_Impl_HB_QBC();
				//new	BankAccounFilter_DAO_Impl_JPA_QBC();
		dao.SelectOperation();
		//clost the SessionFactory object
		HibernateUtil.CloseSessio();
	}
}
