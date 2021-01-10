package com.hibernate.entity;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class CardPayment extends Payment{
	private static final long serialVersionUID = 1L;
	private Long Card_number;
	private String Card_Type;
	private String PaymentGatWay;
}
