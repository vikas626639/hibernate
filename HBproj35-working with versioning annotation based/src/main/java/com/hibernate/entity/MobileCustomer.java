package com.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
public class MobileCustomer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "mobile_gen", strategy = "increment")
	@GeneratedValue(generator = "mobile_gen")
	private Integer customer_id;
	private String customer_name;
	private Long MobileNO;
	private String callerTune;
	@Version
	private Integer modify;
}
