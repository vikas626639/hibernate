package com.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.Address;
import com.hibernate.entity.Student;
import com.hibernate.util.HibernateUtil;

public class StudentCompositonDAO implements CompositionDAO {

	@Override
	public void insertRecord() {
		Session ses=null;
		Transaction tx=null;
		boolean condition=false;
		try {
			ses=HibernateUtil.getSession();
			if(!ses.getTransaction().isActive()) {
				//create object of entity class
				Student entity=new Student();
				Address address=new Address();
				//set the record
				address.setStreetName("police line");
				address.setCountry("india");
				address.setDoorNo("345/45");
				address.setState("m.p");
				address.setPinCode(484001l);
				entity.setSid(101);
				entity.setAvg(34.5f);
				entity.setSname("prabha");
				entity.setAddress(address);
				//open transaction 
				tx = ses.beginTransaction();
				ses.save(entity);
				condition=true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (condition) {
				tx.commit();
				System.out.println("Record inserted");
			}else {
				tx.rollback();
				System.out.println("Record not saved");
			}
		}
	}
}
