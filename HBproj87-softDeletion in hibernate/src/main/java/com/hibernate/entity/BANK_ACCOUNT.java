package com.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import lombok.Data;

@Data
@Entity
public class BANK_ACCOUNT {
	private Integer ACNO;
	private String HOLDERNAME;
	private Float BALANCE;
	private String STATUS;
}

