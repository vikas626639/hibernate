package com.hibernate.entity;

import java.io.Serializable;

import lombok.Data;
@Data
public class Student implements Serializable{
	private Integer sid;
	private String sname;
	private float avg;
	private Address address;
}
