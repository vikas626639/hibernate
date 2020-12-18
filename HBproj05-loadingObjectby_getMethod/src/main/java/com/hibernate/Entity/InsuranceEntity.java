package com.hibernate.Entity;

import lombok.Data;

@Data
public class InsuranceEntity {
	private Integer policyid;
	private String policyName;
	private Integer tenure;
	private String company;
	private String type;

}
