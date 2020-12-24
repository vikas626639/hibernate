package com.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.Util.MysqlHibernateUtil;
import com.hibernate.Util.OracleHibernateUtil;
import com.hibernate.entity.Indian_state;

public class DataTransferDAOImpl implements DataTransferDAO {

	/*DataTransferDAO dt=id->{
		Session orases=null, mysqlses=null,ses=null;
		Transaction oratx=null,mysqltx=null;
		Indian_state entity=null;
		int  idval=0;
		boolean flag=false;
		//load data from oracle database
		try {
			//get both session object
			orases=OracleHibernateUtil.getSession();
			mysqlses=MysqlHibernateUtil.getSession();
			oratx=orases.beginTransaction();
			entity=orases.get(Indian_state.class, id);
			if(entity!=null) {
				System.out.println(entity);
				try {
					//mysql begin transaction
	
					mysqltx=mysqlses.beginTransaction();
					idval=(int) mysqlses.save(entity);
					System.out.println("Generated id="+idval);
					flag=true;
				} catch (HibernateException e) {
					e.printStackTrace();
				}
			}else {
				System.out.println("Record not found");
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				mysqltx.commit();
				return "record copied";
			}else {
				mysqltx.rollback();
				return "record not copied";
			}
			//
			
		}
	};
	*/
	
	
	@Override
	public String transgerRecordbyId(int id) {
		Session orases=null, mysqlses=null,ses=null;
		Transaction oratx=null,mysqltx=null;
		Indian_state entity=null;
		int  idval=0;
		boolean flag=false;
		String msg="";
		//load data from oracle database
		try {
			//get both session object
			orases=OracleHibernateUtil.getSession();
			mysqlses=MysqlHibernateUtil.getSession();
			oratx=orases.beginTransaction();
			entity=orases.get(Indian_state.class, id);
			if(entity!=null) {
				System.out.println(entity);
				try {
					//mysql begin transaction

					mysqltx=mysqlses.beginTransaction();
					idval=(int) mysqlses.save(entity);
					System.out.println("Generated id="+idval);
					flag=true;
				} catch (HibernateException e) {
					e.printStackTrace();
				}
			}else {
				System.out.println("Record not found");
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				mysqltx.commit();
				System.out.println("record copied..generated id"+idval);
			}else {
				mysqltx.rollback();
				msg="record not copied";
			}
		}
		return msg;
	}
}
