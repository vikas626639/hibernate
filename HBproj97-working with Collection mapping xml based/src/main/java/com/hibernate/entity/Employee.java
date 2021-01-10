package com.hibernate.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;

import org.hibernate.annotations.ListIndexBase;

import lombok.Data;

@Data
public class Employee {
	private Integer Emp_Id;
	private String Emp_name;
	private String JOb;
	private List<String>Emp_Frends;
	private Set<Long>mobile_number;   //
	private Map<String,String>Bank_Account;
}
