package com.hibernate.contextListner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

import com.hibernate.utility.HibernateUtil;

//@WebListener
public class ServletContextListner implements ServletContextListener {
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		HibernateUtil.closeSessionFactory();
	}

}
