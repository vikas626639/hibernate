package com.hibernate.dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.entity.CardPayment;
import com.hibernate.entity.CheckPayment;
import com.hibernate.entity.Payment;
import com.hibernate.util.HibernateUtil;

public class Payment_DAO_Impl implements PaymentDAO {

	@Override
	public void proceedPayment() {
		//Get Session
		Session ses=null;
		Transaction tx=null;
		boolean condition=false;
		try {
			ses=HibernateUtil.getSession();
			//check active Transaction
			if(!ses.getTransaction().isActive()) {
				//activate transaction
				tx=ses.beginTransaction();
				//create object of Entity class
				CardPayment c1=new CardPayment();
				CheckPayment c2=new CheckPayment();

				//setting the card value
				c1.setCard_number(142064668L);
				c1.setAmount(8000F);
				c1.setCard_Type("Credit");
				c1.setPaymentGatWay("phonepay");

				//setting the check value
				c2.setCheck_type("SBI");
				c2.setExpirydate(LocalDate.of(2021, 8, 18));
				c2.setAmount(60000F);
				c2.setCheck_number(15214544L);

				//save data
				ses.save(c1);
				ses.save(c2);
				condition=true;
			}
		} catch (HibernateException he) {
			he.printStackTrace();
			he.getMessage();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (condition) {
				tx.commit();
				System.out.println("Record Saved....");
			}else {
				tx.rollback();
				System.out.println("Record not Saved.....");
			}
		}
	}

	
	@Override
	public void fetchRecord() {
		//Get Session
		Session ses=null;
		Transaction tx=null;
		boolean condition=false;
		try {
			ses=HibernateUtil.getSession();
			//check active Transaction
			if(!ses.getTransaction().isActive()) {
				//activate transaction
				tx=ses.beginTransaction();
				//fetch record from table
				Query query=ses.createQuery("from Payment");
				List<Payment>list=query.list();
				list.forEach(System.out::println);
				System.out.println();
				Query query1=ses.createQuery("from CheckPayment");
				List<CheckPayment>list1=query1.list();
				list1.forEach(System.out::println);
				System.out.println();
				Query query2=ses.createQuery("from CardPayment");
				List<CardPayment>list2=query2.list();
				list2.forEach(System.out::println);
			}
		}catch (HibernateException he) {
			he.printStackTrace();
			he.getMessage();
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
