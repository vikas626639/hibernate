package com.hibernate.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProductDto implements Serializable {
	private Integer PID;
	private String PNAME;
	private Double PRICE;
	private Integer QTY;
	private String catagory;
}
