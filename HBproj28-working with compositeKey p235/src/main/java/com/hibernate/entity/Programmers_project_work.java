package com.hibernate.entity;

import java.io.Serializable;

import com.hibernate.composite.Composite;

import lombok.Data;

@Data
public class Programmers_project_work implements Serializable{
	private static final long serialVersionUID = 1L;
	//programmers_project_work has a composite primary key
	private Composite cid;
	private String pname;
	private String projName;
	private Double salary;
}
