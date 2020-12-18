package com.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@DynamicUpdate
@Entity
//@Table
@Data
public class project implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Integer proid;
	private String projName;
	private Integer teamSize;
	private String company;
}
