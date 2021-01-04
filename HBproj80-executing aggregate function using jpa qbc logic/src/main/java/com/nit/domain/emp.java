package com.nit.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class emp {
	@Id
	private Integer EMPNO;
	private String ENAME;
	private String JOB;
	private Integer SAL;
	private Integer DEPTNO;
}
