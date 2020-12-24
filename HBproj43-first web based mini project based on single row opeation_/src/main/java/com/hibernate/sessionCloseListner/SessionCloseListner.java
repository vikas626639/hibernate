package com.hibernate.sessionCloseListner;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import com.hibernate.utility.HibernateUtil;

//@WebListener
public class SessionCloseListner implements ServletRequestListener {
	
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		ServletRequestListener.super.requestInitialized(sre);
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		
		System.err.println("Session Closed...............");
		HibernateUtil.closeSession();
	}

}
