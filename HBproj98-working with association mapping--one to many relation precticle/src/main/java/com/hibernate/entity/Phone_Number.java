package com.hibernate.entity;

import lombok.Data;

@Data
public class Phone_Number {
	private Integer regNo;
	private Long phone;
	private String type;
	private String provider;
	
	//setter and getter method 
}
