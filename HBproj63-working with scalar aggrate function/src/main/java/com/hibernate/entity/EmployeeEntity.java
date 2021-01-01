package com.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class EmployeeEntity {
	@Id
	private Integer empno;
	private String ename;
	private Integer deptno;
}
