package com.hibernate.entity;

import lombok.Data;

@Data
public class Employee extends Person {

	private static final long serialVersionUID = 1L;
	private String desg;
	private Float salary;
	private Integer deptno;
	@Override
	public String toString() {
		return super.toString() + "Employee [desg=" + desg + ", salary=" + salary + ", deptno=" + deptno 
				+  "]";
	}
	
	


}
