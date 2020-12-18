package com.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;

@Entity
@Data
//@Table(name= "StudentRecords1")
public class StudentRecords {
	@Id
	@GenericGenerator(name = "vgen", strategy = "sequence",parameters=@Parameter(name="sequence_name",value = "pid_gty"))
	@GeneratedValue(generator = "vgen")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer StudentId;
	private String StudentName;
	private String StudentAddress;
	private Integer StudentRollNum;
	private Long StudentMobileNum;

}
