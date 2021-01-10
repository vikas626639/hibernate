package com.hibernate.test;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.Phone_Number;
import com.hibernate.entity.User_info;
import com.hibernate.util.HibernateUtil;
//Parent_to_child insertion
public class OneToManyInsertTest {
	public static void main(String[] args) {
		//get Session 
		Session ses=null;
		Transaction tx=null;
		boolean condition=false;
		Phone_Number ph=null,ph1=null;
		User_info ui=null,ui1=null;
		try {
			ses=HibernateUtil.getSession();
			//checing transaction
			if(!ses.getTransaction().isActive()) {
				//create entity class object
				ph=new Phone_Number();
				ph.setPhone(8888888L);
				ph.setProvider("airtel");
				ph.setType("residence");
				//second child class object
				ph1=new Phone_Number();
				ph1.setPhone(66666666666L);
				ph1.setProvider("jio");
				ph1.setType("office");
				
				//put thesee object in set
			//	Set<Phone_Number>phoneSet=Set.of(ph, ph1);
				
				//prepare user_info class object
				ui=new User_info();
				ui.setUser_name("vikas");
				ui.setAddress("shahdol");
				ui.setPhone(Set.of(ph,ph1));
				
				tx=ses.beginTransaction();
				ses.save(ui);
				condition=true;
			}
		}catch (HibernateException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (condition) {
				tx.commit();
				System.out.println("Record saved");
			}else {
				tx.rollback();
				System.out.println("Record not saved");
			}
		}
	}

}
