package com.hibernate.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
///@Table(name="PersonInfo1")
public class PersonInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer personid;
	private String person_name;
	private String person_addrs;
	//working with java8 feature localData
	private LocalDateTime dof;
	private LocalDateTime doj;
	private LocalDate dom;
}


