package com.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class StudentRecords {
	@Id
	@GenericGenerator(name = "vgen", strategy = "identity")
	@GeneratedValue(generator = "vgen")
	private Integer StudentId;
	private String StudentName;
	private String StudentAddress;
	private Integer StudentRollNum;
	private Long StudentMobileNum;

}
