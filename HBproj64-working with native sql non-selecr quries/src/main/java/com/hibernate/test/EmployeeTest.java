package com.hibernate.test;
import com.hibernate.dao.EmployeeDao;
import com.hibernate.dao.EmployeeDaoImpl;
import com.hibernate.utility.HibernateUtil;
public class EmployeeTest {

	public static void main(String[] args) {
		EmployeeDao dao=null;
		dao=new EmployeeDaoImpl();
		dao.getEmployeeRecord();
		//close the session Factory object
		HibernateUtil.closeSession();
	}
}
