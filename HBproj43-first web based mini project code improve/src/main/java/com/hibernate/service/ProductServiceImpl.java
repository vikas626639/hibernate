package com.hibernate.service;

import com.hibernate.dao.ProductDAO;
import com.hibernate.dao.ProductDaoImple;
import com.hibernate.dto.ProductDto;
import com.hibernate.entity.Product;

public class ProductServiceImpl implements productService {

	//createing dao class object into service clS constructor indirectly
	//injection dao class object int service class constructor
	private ProductDAO dao=null;

	public ProductServiceImpl() {
		dao=new ProductDaoImple();
	}

	@Override
	public ProductDto fetchService(int id) {
		Product prod=null;//entity class only hold the entity class object
		ProductDto dto=null;
		prod=dao.getProduct(id);
		//now data come in here product class only 
		// convert prod data in dto class object
		if(prod!=null) {
			dto=new ProductDto();
			dto.setPID(prod.getPID());
			dto.setPNAME(prod.getPNAME().toUpperCase());
			dto.setPRICE((double) Math.round(prod.getPRICE()));
			dto.setQTY(Math.round(prod.getQTY()));
			if(dto.getPRICE()<1000)
				dto.setCatagory("affordable".toUpperCase());
			else 
				dto.setCatagory("premium".toUpperCase());
			return dto;
		}
		else {
			return null;
		}
	}
}
