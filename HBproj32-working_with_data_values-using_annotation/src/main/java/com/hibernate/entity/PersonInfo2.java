package com.hibernate.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
public class PersonInfo2 implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "gen",strategy = "identity")
	@GeneratedValue(generator = "gen")
	private Integer personid;
	private String person_name;
	private String person_addrs;
	private Date dof;
	private Date doj;
	private Date dom;
}
