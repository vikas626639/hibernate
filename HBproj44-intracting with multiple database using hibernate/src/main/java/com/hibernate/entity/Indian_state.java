package com.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Indian_state implements Serializable{
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer sno;
	private String State_Name;
	private String State_language;
}
