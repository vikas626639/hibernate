package com.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import lombok.Data;


@Data
public class project implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer proid;
	private String projName;
	private Integer teamSize;
	private String company;
}
//if we define class as final though lazy = true then it will hit the database and perform egar loading 
//for this we have to develop one proxy interface