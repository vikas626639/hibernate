package com.hibernate.entity;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity

public class CheckPayment extends Payment {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long Check_number;
	private String Check_type;
	private LocalDate expirydate;
}
