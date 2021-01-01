package com.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.Utility.HibernateUtil;

//insted of selecting and setting manually using set or get method we have hql quries that will perform all work internally
public class InsertRecordDaoImpl implements InsertRecordDAO {
	/*private static String HQl_transefer_indian_state_record="INSERT INTO com.hibernate.entity.Indian_state2(sno,State_name,State_language) "
			                                                + "	SELECT i.sno,i.State_name,i.State_language from com.hibernate.entity.Indian_state as i WHERE i.sno>=:num";
	*/
	@Override
	public void insertRecord(int minid) {
		//get Session
		Session ses=null;
		Transaction tx=null;
		Query qurey=null;
		int num=0;
		boolean condition=false;
		try {
			ses=HibernateUtil.getSession();
			tx=ses.beginTransaction();
			//prapere query
			qurey=ses.getNamedQuery("HQl_transefer_indian_state_record");
			//set param value
			qurey.setParameter("num", minid);
			num=qurey.executeUpdate();
			condition=true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			if (condition) {
				tx.commit();
				System.out.println(num+" record inserted");
			}else {
				tx.rollback();
				System.out.println("Record insertion failed....");
			}
		}
	}
}
