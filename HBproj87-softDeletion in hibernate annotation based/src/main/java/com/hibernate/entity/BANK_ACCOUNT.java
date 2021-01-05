package com.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

@Data
@Entity
@SQLDelete(sql = "UPDATE BANK_ACCOUNT SET STATUS='closed' WHERE ACNO=?")
@Where(clause = "STATUS NOT IN('closed','blocked')")
public class BANK_ACCOUNT {
	@Id
	@GeneratedValue
	private Integer ACNO;
	private String HOLDERNAME;
	private Float BALANCE;
	private String STATUS;
}

