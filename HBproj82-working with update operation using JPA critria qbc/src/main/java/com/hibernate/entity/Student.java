package com.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Student {
	@Id
	private Integer SNO;
	private String SNAME;
	private String SADD;
}
