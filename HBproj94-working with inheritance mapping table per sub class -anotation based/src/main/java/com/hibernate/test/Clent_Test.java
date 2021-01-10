package com.hibernate.test;

import com.hibernate.dao.PaymentDAO;
import com.hibernate.dao.Payment_DAO_Impl;
import com.hibernate.util.HibernateUtil;

public class Clent_Test {

	public static void main(String[] args) {
		
		PaymentDAO dao=null;
		dao=new Payment_DAO_Impl();
		
		//dao.proceedPayment();
		dao.fetchRecord();
		//close SessionFactory object
		HibernateUtil.CloseSessio();
	}
}
