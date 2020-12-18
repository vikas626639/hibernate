package com.hibernate.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class MobileCustomer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer customer_id;
	private String customer_name;
	private Long MobileNO;
	private String callerTune;
	private Integer versionCount;
}
