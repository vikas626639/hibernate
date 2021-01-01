package com.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@Entity
public class emp implements Serializable{
	@Id
	private Integer Empno;
	private String ename;
	private String job;
	private Integer sal;
	/*
	public emp() {
		System.out.println("0 param constructor");
	}*/
}
