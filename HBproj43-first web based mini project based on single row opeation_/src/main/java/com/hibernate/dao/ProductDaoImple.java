package com.hibernate.dao;

import org.hibernate.Session;

import com.hibernate.entity.Product;
import com.hibernate.utility.HibernateUtil;

public class ProductDaoImple implements ProductDAO {

	@Override
	public Product getProduct(int id) {
		//get Session
		Session ses=null;
		Product entity=null;
		ses=HibernateUtil.getSession();
		//calling object of entity class
		entity=ses.get(Product.class, id);
		System.out.println(entity);
		return entity;
	}
}


