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
@Entity
public class Employee {
	@Id
	@GeneratedValue
	private Integer Emp_Id;
	private String Emp_name;
	private String JOb;
	
	/*@ElementCollection
	@CollectionTable(name="Employee_frends",
					joinColumns = @JoinColumn(name="emp_id",
					referencedColumnName = "Eno"))	
	@OrderColumn(name="Frends_NO")
	@ListIndexBase(value = 1)
	private List<String>Emp_Frends;
	
	
	@ElementCollection
	@CollectionTable(name="Employee_mob_Numbers", 
					joinColumns = @JoinColumn(name="Emp_Id",
					referencedColumnName = "Eno"))		
	private Set<Long>mobile_number;
	
	
	@ElementCollection
	@CollectionTable(name = "Employee_Bank_Accounts", 
						joinColumns = @JoinColumn(name="Emp_id",referencedColumnName = "Eno"))	
	@MapKeyColumn(name="Bank_name")
	private Map<String,String>Bank_Account;
	*/
	@ElementCollection
	@CollectionTable(joinColumns = @JoinColumn(referencedColumnName = "Emp_Id"))	
	@OrderColumn(name="Frends_NO")//will create saparated identity column of emp_frenda table    //eno,Emp_Frends,frends_no
	@ListIndexBase(value = 1)
	private List<String>Emp_Frends;
	
	
	@ElementCollection
	@CollectionTable(joinColumns = @JoinColumn(referencedColumnName = "Emp_Id"))	//eno,	Mobile_number
	private Set<Long>mobile_number;   //
	
	
	@ElementCollection
	@CollectionTable(joinColumns = @JoinColumn(referencedColumnName = "Emp_Id"))	//Eno,Bank_Account,Bank_name
	@MapKeyColumn(name="Bank_name")
	private Map<String,String>Bank_Account;
	
	}
