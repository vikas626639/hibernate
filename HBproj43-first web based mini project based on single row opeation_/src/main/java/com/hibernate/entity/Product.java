package com.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Product implements Serializable {
	@Id
	private Integer PID;
	private String PNAME;
	private Double PRICE;
	private Integer QTY;
}
