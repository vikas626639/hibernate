package com.hibernate.entity;

import lombok.Data;

@Data
public class Student extends Person {

	private static final long serialVersionUID = 1L;
	private String college;
	private String branch;
	private float avg;
	
	@Override
	public String toString() {
		return super.toString() + "Student [college=" + college + ", branch=" + branch + ", avg=" + avg 
				+  "]";
	}
	
	

}
