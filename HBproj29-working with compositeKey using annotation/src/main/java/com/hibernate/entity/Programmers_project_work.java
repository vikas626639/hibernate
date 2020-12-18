package com.hibernate.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.hibernate.composite.Composite;

import lombok.Data;

@Data
@Entity
@Table(name = "Programmers_project_work1")
public class Programmers_project_work implements Serializable{
	private static final long serialVersionUID = 1L;
	//programmers_project_work has a composite primary key
	@EmbeddedId
	private Composite cid;
	private String pname;
	private String projName;
	private Double salary;
}
