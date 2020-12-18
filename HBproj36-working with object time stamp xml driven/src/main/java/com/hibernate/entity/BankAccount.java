package com.hibernate.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BankAccount {

	private Long accno;
	private String holderName;
	private Double balance;
	private String type;
	private LocalDateTime openingDate;
	private Timestamp lastUpdate;
}
