package com.hibernate.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
public class Person_addharDetail {
	@Id
	@GenericGenerator(name = "person_generator", strategy = "identity")
	@GeneratedValue(generator = "person_generator" )
	private Integer PERSON_ID;
	private String PERSON_NAME;
	private LocalDate PERSON_DOB;
	private Long AADHAR_NUMBER;
	@CreationTimestamp
	private Date AADHARCREATION_DATE;
	@UpdateTimestamp
	private Date LAST_MODIFY;
	@Version
	private Integer TIMES_OF_MODIFY_RECORD;
}
