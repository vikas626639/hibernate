package com.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import lombok.Data;

@Data
@Entity
@FilterDef(name = "FILTER_BANK_ACCOUNT_STATUS", 
			parameters = { @ParamDef(name="accountTyp1", type = "string"),
						   @ParamDef(name="accountTyp2", type="string")
						}
		   )
@Filter(name = "FILTER_BANK_ACCOUNT_STATUS",condition ="STATUS NOT IN(:accountTyp1,:accountTyp2)")
public class BANK_ACCOUNT {
	@Id
	@GeneratedValue
	private Integer ACNO;
	private String HOLDERNAME;
	private Float BALANCE;
	private String STATUS;
}

