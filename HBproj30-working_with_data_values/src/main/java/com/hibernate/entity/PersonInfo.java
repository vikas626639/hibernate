package com.hibernate.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class PersonInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer personid;
	private String person_name;
	private String person_addrs;
	private Date dof;
	private Date doj;
	private Date dom;
}
